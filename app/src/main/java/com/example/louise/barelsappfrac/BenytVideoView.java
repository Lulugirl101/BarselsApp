package com.example.louise.barelsappfrac;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

//import dk.nordfalk.android.elementer.R;

import com.example.louise.barselsapp.R;

/**
 * @author Jacob Nordfalk
 * Modified: Louise Janø
 * Source :dk.nordfalk.android.elementer
 */
public class BenytVideoView extends Fragment implements OnClickListener {

  //private String url = "rtsp://v3.cache3.c.youtube_videoview.com/CigLENy73wIaHwnMkA0Ndzke5BMYESARFEgGUgx1c2VyX3VwbG9hZHMM/0/0/0/video.3gp";
  //private String videoUrl = "file:///sdcard/DCIM/100MEDIA/VIDEO0025.3gp";
  private String videoUrl = "http://javabog.dk/billeder/AK2008/15022008012.mp4";
  private String link = "http://javabog.dk";
  private VideoView videoView;
  private TextView overskrift;
  private TextView beskrivelse;
  ImageButton imbutinfo;

  String vTitel,vBesriv, vurl, vlink;

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);

  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("View", "Setting up Video wiev");
        View w = inflater.inflate(R.layout.youtube_videoview,container,false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        videoView = (VideoView) w.findViewById(R.id.youtube_videoView);
        overskrift = (TextView) w.findViewById(R.id.youtube_overskrift);
        beskrivelse = (TextView) w.findViewById(R.id.youtube_beskrivelse);
        imbutinfo = (ImageButton)w.findViewById(R.id.youtube_infoknap);
        imbutinfo.setOnClickListener(this);
        if (getArguments()!=null){
            vTitel = getArguments().getString("titel");
            vBesriv = getArguments().getString("beskrivelse");
            vurl = getArguments().getString("videourl");
            vlink = getArguments().getString("link");
            overskrift.setText(vTitel);
            beskrivelse.setText(vBesriv);
        }
        else {
            overskrift.setText("Mangler data");
            beskrivelse.setText("Send et intent med med hvad der skal afspilles");
        }
        System.out.println("url = " + vurl);

        videoView.setVideoURI(Uri.parse(vurl));
        videoView.setMediaController(new MediaController(getActivity()));
        videoView.requestFocus();
        int rotation = getActivity().getWindowManager().getDefaultDisplay()
                .getRotation();

        videoView.start();





        // Inflate the layout for this fragment
        return w;
    }
  /**
   * For at få videoen til at spille jævnt håndterer vi selv vending af skærmen
   * Se evt http://stackoverflow.com/questions/4434027/android-videoview-orientation-change-with-buffered-video
   *
   * @param newConfig
   */
  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    System.out.println("newConfig = " + newConfig);
    boolean fuldskærm = (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE);

    beskrivelse.setVisibility(fuldskærm ? View.GONE : View.VISIBLE);
    overskrift.setVisibility(fuldskærm ? View.GONE : View.VISIBLE);
    imbutinfo.setVisibility(fuldskærm ? View.GONE : View.VISIBLE);
    videoView.getParent().requestLayout();
  }

  public void onClick(View arg0) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(vlink));
    startActivity(intent);
  }

 @Override
  public void onPause(){
     super.onPause();
     videoView.stopPlayback();
 }

}
