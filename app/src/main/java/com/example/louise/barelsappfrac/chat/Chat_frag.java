package com.example.louise.barelsappfrac.chat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.louise.barselsapp.R;

import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.chat.QBChatService;
import com.quickblox.core.QBEntityCallbackImpl;
import com.quickblox.videochat.core.QBVideoChatController;

import org.jivesoftware.smack.XMPPException;

import java.util.List;

/*
*  @author William Giesmar
*  modifier : Louise Janoe
* */

public class Chat_frag extends Fragment implements View.OnClickListener {
    Button a, b;
    ProgressDialog progressDialog;
    ImageView l,w;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initChatService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        progressDialog = new ProgressDialog(getActivity());
        View web = inflater.inflate(R.layout.char_frag_layout, container, false);

        a = (Button) web.findViewById(R.id.willknappen);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSession(VideoChatApplication.william, VideoChatApplication.pass1);
            }
        });

        b = (Button) web.findViewById(R.id.louiseknappen);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSession(VideoChatApplication.louise, VideoChatApplication.pass2);

            }
        });
        // Inflate the layout for this fragment
        l = (ImageView)web.findViewById(R.id.imlulu);
        l.setOnClickListener(this);
        w = (ImageView)web.findViewById(R.id.imwil);
        w.setOnClickListener(this);


        TextView aktuelbruger = (TextView) web.findViewById(R.id.aktuelbruger);
        aktuelbruger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Chat_frag.this.getActivity(), "Ikke implementeret endnu", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(Chat_frag.this.getActivity(), ActivityVideoChat.class);
                //startActivity(intent);

            }
        });
        return web;
    }

    private void createSession(String login, final String password) {
            progressDialog.setMessage("Vent venligst\n Forbindelsen oprettes");
            progressDialog.show();
            QBAuth.createSession(login, password, new QBEntityCallbackImpl<QBSession>() {
                @Override
                public void onSuccess(QBSession qbSession, Bundle bundle) {
                    //Gem valgt bruger
                    System.out.println("bruger gemt fra øverste onSuccess");
                    VideoChatApplication app = (VideoChatApplication)getActivity().getApplication();
                    app.setCurrentUser(qbSession.getUserId(), password);

                    //Login til chatten
                    QBChatService.getInstance().login(app.getCurrentUser(), new QBEntityCallbackImpl() {
                        @Override
                        public void onSuccess() {
                            try {
                                QBVideoChatController.getInstance().initQBVideoChatMessageListener();
                            } catch (XMPPException e) {
                                e.printStackTrace();
                            }
                            //Skift til kald-aktivitet
                            System.out.println("midterste onSuccess");
                        showCallUserActivity();
                        }

                        @Override
                        public void onError(List errors) {
                            Toast.makeText(getActivity(), "Error when login", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

                @Override
                public void onSuccess() {
                    System.out.println("nederste onSuccess");
                }

                @Override
                public void onError(List<String> errors) {
                    Toast.makeText(getActivity(), "Har du trykket rigtigt?", Toast.LENGTH_SHORT).show();
                }
            });

        }




    private void initChatService() {
        QBChatService.setDebugEnabled(true);
        if (!QBChatService.isInitialized()) {
            Log.d("ActivityLogin", "InitChat");
            QBChatService.init(Chat_frag.this.getActivity());
        } else {
            Log.d("ActivityLogin", "InitChat not needed");
        }
    }

    private void showCallUserActivity() {
        progressDialog.dismiss();

        Intent intent = new Intent(Chat_frag.this.getActivity(), ActivityVideoChat.class);
        startActivity(intent);
        //nedenstående linjer er fordi vi bruger et fragment og ikke en aktivitet.
        //Chat_frag.this.getActivity().finish();
    }

    @Override
    public void onClick(View v) {
        if (v == l){
            createSession(VideoChatApplication.louise, VideoChatApplication.pass2);
        }
        else if (v == w){
            createSession(VideoChatApplication.william, VideoChatApplication.pass1);
        }
    }
}
