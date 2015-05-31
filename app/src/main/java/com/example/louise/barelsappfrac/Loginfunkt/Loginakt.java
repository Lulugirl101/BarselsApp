package com.example.louise.barelsappfrac.Loginfunkt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.louise.barelsappfrac.Startactivity;
import com.example.louise.barelsappfrac.chat.VideoChatApplication;
import com.example.louise.barselsapp.R;
import com.quickblox.auth.QBAuth;
import com.quickblox.auth.model.QBSession;
import com.quickblox.chat.QBChatService;
import com.quickblox.core.QBEntityCallbackImpl;
import com.quickblox.core.QBSettings;
import com.quickblox.videochat.core.QBVideoChatController;

import org.jivesoftware.smack.XMPPException;

import java.util.List;

public class Loginakt extends ActionBarActivity {
EditText brugernavnfelt;
    EditText passwordfelt;
    CheckBox check;

    String qb_user;
    String qb_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       QBSettings.getInstance().fastConfigInit("21328", "2PUvNRUD-S4rUXD", "xCzzpuOUvpuFXD5");
        //System.out.println("Quickblox session aabnet");

        setContentView(R.layout.fragment_loginakt);
        initChatService();

        Button confirm = (Button) findViewById(R.id.loginknappen);
       /* check = (CheckBox)findViewById(R.id.huskmitlogin);

        qb_user= PreferenceManager.getDefaultSharedPreferences(this)
                .getString("qb_user",null);
        qb_pass= PreferenceManager.getDefaultSharedPreferences(this)
                .getString("qb_pass",null);*/



        brugernavnfelt = (EditText) findViewById(R.id.brugernavn);
        passwordfelt = (EditText) findViewById(R.id.password);

       /* if (check.isChecked()){
            if (qb_user != null && qb_pass !=null) {
                brugernavnfelt.setText(qb_user);
                passwordfelt.setText(qb_pass);
                System.out.println("Bruger fundet via SharedPreferences");
            }
        } else {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("qb_user", null)
                    .commit();
            Log.d("sharedpref", qb_user + "is deleted");

            PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putString("qb_pass",null)
                    .commit();
            Log.d("sharedpref",qb_pass + "is deleted");

        }*/

        brugernavnfelt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                brugernavnfelt.setText("");
            }
        });

        passwordfelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordfelt.setText("");
                //Clear felt, s� vi kan se der blev trykket.
            }
        });








        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String brugernavn = brugernavnfelt.getText().toString();
               final String password = passwordfelt.getText().toString();



                System.out.println("Confirm blev trykket ");
                //send intents med loginStrings til en aktivitet, s� den kan logge ind.
                //S�dan som den er lavet nu, �bner Videochatten i et fragment og S� en separat aktivitet. Den aktivitet skal s� have parametre fra fragmentet.

                createSession(brugernavn, password);


            }
        });

    }

    private void createSession(final String login, final String password) {

        QBAuth.createSession(login, password, new QBEntityCallbackImpl<QBSession>() {
            @Override
            public void onSuccess(final QBSession qbSession, Bundle bundle) {
                //Gem valgt bruger
                System.out.println("bruger gemt fra �verste onSuccess");
                VideoChatApplication app = (VideoChatApplication) getApplication();
                app.setCurrentUser(qbSession.getUserId(), password);
                //int brugerid= qbSession.getUserId();
                // System.out.print(brugerid);
                //Ovenst�ende linje er deaktiveret fordi den ikke er implementeret endnu, og udkommentering
                // f�rer til at vi ikke skifter aktivitet.
               /* qb_user = login;
                qb_pass=password;

                PreferenceManager.getDefaultSharedPreferences(Loginakt.this).edit()
                        .putString("qb_user", qb_user)
                        .commit();
                Log.d("sharedpref", qb_user + "is saved");

                PreferenceManager.getDefaultSharedPreferences(Loginakt.this).edit()
                        .putString("qb_pass",qb_pass)
                        .commit();
                Log.d("sharedpref",qb_pass + "is saved");*/


                //Login til chatten
                QBChatService.getInstance().login(app.getCurrentUser(), new QBEntityCallbackImpl() {
                    @Override
                    public void onSuccess() {
                        try {
                            QBVideoChatController.getInstance().initQBVideoChatMessageListener();
                        } catch (XMPPException e) {
                            e.printStackTrace();
                        }
                        //Skift til oprindelig aktivitet

                        System.out.println("midterste onSuccess");

                        finish();

                        //Toast.makeText(Loginakt.this, "" + qbSession.getUserId(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(List errors) {
                        Toast.makeText(Loginakt.this, "Error when login", Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onSuccess() {
                System.out.println("nederste onSuccess");
            }

            @Override
            public void onError(List<String> errors) {
                Toast.makeText(Loginakt.this, "Forkert password", Toast.LENGTH_SHORT).show();
            }
        });

    }



    private void initChatService() {
        QBChatService.setDebugEnabled(true);
        if (!QBChatService.isInitialized()) {
            Log.d("ActivityLogin", "InitChat");
            QBChatService.init(this);
        } else {
            Log.d("ActivityLogin", "InitChat not needed");
        }
    }

}
