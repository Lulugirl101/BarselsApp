package com.example.louise.barelsappfrac.video;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.louise.barselsapp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;

import android.widget.Toast;
        import com.google.android.youtube.player.YouTubeInitializationResult;
        import com.google.android.youtube.player.YouTubePlayer;
        import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
        import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
        import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
        import com.google.android.youtube.player.YouTubePlayer.Provider;
        import com.google.android.youtube.player.YouTubePlayerView;

/*
*  @author Louise Janø
*
* sources for Youtube API:
* Tutorial :        http://javatechig.com/android/youtubeplayerview-example-in-android-using-youtube-api
* API download :    https://developers.google.com/youtube/android/player/downloads/
* Google devolpers: https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayer
*                   https://developers.google.com/youtube/registering_an_application
*                   https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayerFragment
*                   https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayerSupportFragment
*  finding SHA1:    http://stackoverflow.com/questions/12214467/how-to-obtain-signing-certificate-fingerprint-sha1-for-oauth-2-0-on-android
* */

public class Youtubeplayer1 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyCFUsYwse3E8XkLOeP5uikR_Ah1Y2uOngg"; //Key optaind in devolpers guide

    //http://youtu.be/<VIDEO_ID>
    String videoID ;
    Boolean playlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** attaching layout xml **/
        setContentView(R.layout.activity_youtubeplayer);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //Set orientation to landscape
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
           videoID = extras.getString("videoID");
            // and get whatever type user account id is
            //shall we show the playlist
            playlist = extras.getBoolean("playlist");
        }

        /** Initializing YouTube player view **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY, this);


    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {

        /** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
        player.setFullscreen(true); //Set videomode to fulscreen
        player.play();
        /** Start buffering **/
        if (!wasRestored) {
            if (playlist == true){
                player.cuePlaylist("PLqRbra_4rkOBtoBvXhLUu9iCnU1OaHZ-S"); //Barselsapp playlist
            }
            else {
                player.cueVideo(videoID); //Specific vidoes
            }

        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {

        @Override
        public void onBuffering(boolean arg0) {
        }

        @Override
        public void onPaused() {
        }

        @Override
        public void onPlaying() {


        }

        @Override
        public void onSeekTo(int arg0) {
        }

        @Override
        public void onStopped() {
        }

    };

    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {

        @Override
        public void onAdStarted() {
        }

        @Override
        public void onError(ErrorReason arg0) {
        }

        @Override
        public void onLoaded(String arg0) {
        }

        @Override
        public void onLoading() {
        }

        @Override
        public void onVideoEnded() {
        }

        @Override
        public void onVideoStarted() {
        }
    };



    @Override
    public void onDestroy(){ //Når activiteten er færdig, set orientering til at følge telefonens sensor.
        super.onDestroy();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

    }
}
