package com.example.louise.barelsappfrac.chat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;


import com.example.louise.barselsapp.R;
import com.quickblox.users.model.QBUser;
import com.quickblox.videochat.core.QBVideoChatController;
import com.quickblox.videochat.model.listeners.OnQBVideoChatListener;
import com.quickblox.videochat.model.objects.CallState;
import com.quickblox.videochat.model.objects.CallType;
import com.quickblox.videochat.model.objects.VideoChatConfig;
import com.example.louise.barelsappfrac.*;
import com.example.louise.barelsappfrac.chat.Chat_frag;

import org.jivesoftware.smack.XMPPException;

public class ActivityVideoChat extends ActionBarActivity {


    private OwnSurfaceView egetView;
    private OpponentSurfaceView andensview;
    private Button switchCameraButton;
    private Button ringop;
    private VideoChatConfig videoChatConfig;
    private AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.opkaldsakt_layout);
        //app = (VideoChatApplication) getApplication();
        initViews();
    }


    private void initViews() {

        final VideoChatApplication app = (VideoChatApplication) getApplication();
        videoChatConfig = getIntent().getParcelableExtra(VideoChatConfig.class.getCanonicalName());

        //settings

        //UI
        egetView = (OwnSurfaceView) findViewById(R.id.eget);
        andensview = (OpponentSurfaceView) findViewById(R.id.modstanders);

        egetView.setCameraDataListener(new OwnSurfaceView.CameraDataListener() {
            @Override
            public void onCameraDataReceive(byte[] data) {
                if (videoChatConfig != null && videoChatConfig.getCallType() != CallType.VIDEO_AUDIO) {
                    return;
                }
                QBVideoChatController.getInstance().sendVideo(data);
            }
        });
        System.out.println((app.getCurrentUser().getId() == VideoChatApplication.WID ? "1st user" : "2nd user"));
        Toast.makeText(this, (app.getCurrentUser().getId() == VideoChatApplication.WID ? "1st user" : "2nd user"), Toast.LENGTH_SHORT).show();
        ringop = (Button) findViewById(R.id.ringop);

        ringop.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Button ringop = (Button) v;
                //Denne knap bruges til at kontrollere om vi starter eller slukker
                //Ring op
                if (ringop.getText().equals("ring")) {
                    QBUser opponentUser = new QBUser();
                    opponentUser.setId((app.getCurrentUser().getId() == VideoChatApplication.WID ? VideoChatApplication.LID : VideoChatApplication.WID));
                    videoChatConfig = QBVideoChatController.getInstance().callFriend(opponentUser, CallType.VIDEO_AUDIO, null);

//Stop opkald
                } else {
                    ringop.setText("ring");
                    QBVideoChatController.getInstance().finishVideoChat(videoChatConfig);

                    andensview.clear();

                }
                System.out.println(videoChatConfig + "HEY! VIDEOCHATCONFIG");

            }
        });

        Button kamera = (Button) findViewById(R.id.switch_camera_button);
        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Function not yet implmented", Toast.LENGTH_SHORT).show();
            }
        });

        // Set video chat listener
        //

        try {
            QBVideoChatController.getInstance().setQBVideoChatListener(app.getCurrentUser(), qbVideoChatListener);
        } catch (XMPPException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        egetView.reuseCamera();
    }

    @Override
    protected void onPause() {
        egetView.closeCamera();
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (videoChatConfig!=null){
            QBVideoChatController.getInstance().finishVideoChat(videoChatConfig);
        }

        super.onStop();
    }

    OnQBVideoChatListener qbVideoChatListener = new OnQBVideoChatListener() {

        @Override
        public void onCameraDataReceive(byte[] videoData) {
            //
        }

        @Override
        public void onMicrophoneDataReceive(byte[] audioData) {
            QBVideoChatController.getInstance().sendAudio(audioData);
        }

        @Override
        public void onOpponentVideoDataReceive(final byte[] videoData) {
            andensview.render(videoData);
        }

        @Override
        public void onOpponentAudioDataReceive(byte[] audioData) {
            QBVideoChatController.getInstance().playAudio(audioData);
        }

        @Override
        public void onProgress(boolean progress) {
//            progressBar.setVisibility(progress ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onVideoChatStateChange(CallState callState, VideoChatConfig receivedVideoChatConfig) {
            videoChatConfig = receivedVideoChatConfig;

            switch (callState) {
                case ON_CALL_START:
                    Toast.makeText(getBaseContext(), "ON_CALL_START", Toast.LENGTH_SHORT).show();


                    break;
                case ON_CANCELED_CALL:
                    Toast.makeText(getBaseContext(), "ON_CANCELED_CALL", Toast.LENGTH_SHORT).show();

                    videoChatConfig = null;
                    if (alertDialog != null && alertDialog.isShowing()) {
                        alertDialog.dismiss();
                    }
                    autoCancelHandler.removeCallbacks(autoCancelTask);

                    break;
                case ON_CALL_END:
                    Toast.makeText(getBaseContext(), "ON_CALL_END", Toast.LENGTH_SHORT).show();

                    // clear opponent view
                    andensview.clear();
                    ringop.setText("ring");
                    break;
                case ACCEPT:
                    Toast.makeText(getBaseContext(), "ACCEPT", Toast.LENGTH_SHORT).show();

                    showIncomingCallDialog();
                    break;
                case ON_ACCEPT_BY_USER:
                    Toast.makeText(getBaseContext(), "ON_ACCEPT_BY_USER", Toast.LENGTH_SHORT).show();

                    QBVideoChatController.getInstance().onAcceptFriendCall(videoChatConfig, null);
                    break;
                case ON_REJECTED_BY_USER:
                    Toast.makeText(getBaseContext(), "ON_REJECTED_BY_USER", Toast.LENGTH_SHORT).show();


                    break;
                case ON_CONNECTED:
                    Toast.makeText(getBaseContext(), "ON_CONNECTED", Toast.LENGTH_SHORT).show();
                    ringop.setText("Hung up");

                    break;
                case ON_START_CONNECTING:
                    Toast.makeText(getBaseContext(), "ON_START_CONNECTING", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };


    private Handler autoCancelHandler = new Handler(Looper.getMainLooper());
    private Runnable autoCancelTask = new Runnable() {
        @Override
        public void run() {
            if (alertDialog != null && alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
        }
    };

    private void showIncomingCallDialog() {
        alertDialog = DialogHelper.showCallDialog(this, new OnCallDialogListener() {
            @Override
            public void onAcceptCallClick() {

                QBVideoChatController.getInstance().acceptCallByFriend(videoChatConfig, null);

                autoCancelHandler.removeCallbacks(autoCancelTask);
            }

            @Override
            public void onRejectCallClick() {
                QBVideoChatController.getInstance().rejectCall(videoChatConfig);

                autoCancelHandler.removeCallbacks(autoCancelTask);
            }
        });

        autoCancelHandler.postDelayed(autoCancelTask, 30000);
    }
    @Override
    public void onDestroy() {
        //QBVideoChatController.getInstance().finishVideoChat(videoChatConfig);
        super.onDestroy();


    }

    }