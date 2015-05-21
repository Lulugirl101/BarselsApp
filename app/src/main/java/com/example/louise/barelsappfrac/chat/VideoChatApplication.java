package com.example.louise.barelsappfrac.chat;



import android.app.Application;
import android.util.Log;

import com.quickblox.auth.QBAuth;
import com.quickblox.core.QBCallbackImpl;
import com.quickblox.core.QBSettings;
import com.quickblox.core.result.Result;
import com.quickblox.users.QBUsers;
import com.quickblox.users.model.QBUser;
import com.quickblox.users.result.QBUserResult;

public class VideoChatApplication extends Application {

    public static final String william = "WilliamG";
    public static final String louise = "Louise";

    public static final int WID = 3113146;
    public static final int LID = 2908666;

    public static final String pass2 = "Lulugirl101";
    public static final String pass1 = "Testfest";

    private QBUser currentUser;

    @Override
    public void onCreate() {
        super.onCreate();

        // Set QuickBlox credentials here
        //
        QBSettings.getInstance().fastConfigInit("21328", "2PUvNRUD-S4rUXD", "xCzzpuOUvpuFXD5");

    }

    public void setCurrentUser(int userId, String userPassword) {

        this.currentUser = new QBUser(userId);
        this.currentUser.setPassword(userPassword);
        System.out.println("setCurrentUser sat til:"+currentUser);
    }

    public QBUser getCurrentUser() {
        System.out.println("getCurrentUser sat til:"+currentUser);

        return currentUser;
    }
}


