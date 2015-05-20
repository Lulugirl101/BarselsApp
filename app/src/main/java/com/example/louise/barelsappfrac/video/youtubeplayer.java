package com.example.louise.barelsappfrac.video;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.louise.barselsapp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;

import android.widget.Toast;
        import com.google.android.youtube.player.YouTubeBaseActivity;
        import com.google.android.youtube.player.YouTubeInitializationResult;
        import com.google.android.youtube.player.YouTubePlayer;
        import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
        import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
        import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
        import com.google.android.youtube.player.YouTubePlayer.Provider;
        import com.google.android.youtube.player.YouTubePlayerView;

/*
* sources for Youtube API:
* http://javatechig.com/android/youtubeplayerview-example-in-android-using-youtube-api
* https://developers.google.com/youtube/android/player/downloads/
* https://developers.google.com/youtube/registering_an_application
* https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayerFragment
*https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayerSupportFragment
* http://stackoverflow.com/questions/12214467/how-to-obtain-signing-certificate-fingerprint-sha1-for-oauth-2-0-on-android
* */

public class youtubeplayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyCFUsYwse3E8XkLOeP5uikR_Ah1Y2uOngg";

    //http://youtu.be/<VIDEO_ID>
    String videoID ="bk1F55TxHm0" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** attaching layout xml **/
        setContentView(R.layout.activity_youtubeplayer);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
           videoID = extras.getString("videoID");
            // and get whatever type user account id is
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
        player.setFullscreen(true);
        player.play();
        /** Start buffering **/
        if (!wasRestored) {
            player.cueVideo(videoID);
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
    public void onDestroy(){
        super.onDestroy();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

    }
}
