package com.example.louise.barelsappfrac.video;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.louise.barselsapp.R;

/*
*  @author Louise Janø
*  Video guides fragment.
*  Laver en liste over video. Videoer fundet på youtube, og kan findes på denne playliste : https://www.youtube.com/playlist?list=PLqRbra_4rkOBtoBvXhLUu9iCnU1OaHZ-S
*   TODO: implemnter smart with youtupe playlist instead of hardcoding
*/

public class Video_fragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView videolist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.video_fragment_layout, container, false);

        String[] videotit = {getActivity().getString(R.string.video1), getActivity().getString(R.string.video2), getActivity().getString(R.string.video3),getActivity().getString(R.string.video4), getActivity().getString(R.string.video5),getActivity().getString(R.string.video6) ,
                getActivity().getString(R.string.video7),getActivity().getString(R.string.video8),getActivity().getString(R.string.video9),getActivity().getString(R.string.video10)};
        final String[] beskrivelser = {getActivity().getString(R.string.video1_beskriv), getActivity().getString(R.string.video2beskriv), getActivity().getString(R.string.video3_beskriv),getActivity().getString(R.string.video4_beskriv),getActivity().getString(R.string.video5_beskriv),getActivity().getString(R.string.video6_beskriv),
                getActivity().getString(R.string.video7_beskriv),getActivity().getString(R.string.video8_beskriv),getActivity().getString(R.string.video9_beskriv),getActivity().getString(R.string.video10_beskriv)};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listeelement, R.id.listeelem_overskrift, videotit) {
            //udvider listview
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);
                Log.d("Layout", "video set up");
                TextView beskrivelse = (TextView) view.findViewById(R.id.listeelem_beskrivelse);
                ImageView billede = (ImageView) view.findViewById(R.id.listeelem_billede);
                billede.setScaleType(ImageView.ScaleType.CENTER_CROP);

                //TODO optimize list view insted of hardcoding
                if (position == 0) {
                    beskrivelse.setText(beskrivelser[0]);
                    billede.setImageResource(R.drawable.video1);
                } else if (position == 1) {
                    beskrivelse.setText(beskrivelser[1]);
                    billede.setImageResource(R.drawable.video2);
                } else if (position == 2) {
                    beskrivelse.setText(beskrivelser[2]);
                    billede.setImageResource(R.drawable.video3a);
                } else if (position == 3) {
                    beskrivelse.setText(beskrivelser[3]);
                    billede.setImageResource(R.drawable.video4);
                }else if (position == 4) {
                    beskrivelse.setText(beskrivelser[4]);
                    billede.setImageResource(R.drawable.video5);
                }else if (position == 5) {
                    beskrivelse.setText(beskrivelser[5]);
                    billede.setImageResource(R.drawable.video6);
                } else if (position == 6) {
                    beskrivelse.setText(beskrivelser[6]);
                    billede.setImageResource(R.drawable.video7);
                }else if (position == 7) {
                    beskrivelse.setText(beskrivelser[7]);
                    billede.setImageResource(R.drawable.video8);
                }else if (position == 8) {
                    beskrivelse.setText(beskrivelser[8]);
                    billede.setImageResource(R.drawable.video9);
                }else if (position == 9) {
                    beskrivelse.setText(beskrivelser[9]);
                    billede.setImageResource(R.drawable.video10);
                }else {
                    Log.d("", "NO discription");
                }
                Log.d("Layout", "The list wiev have been set up");

                return view;


            }


        };
        videolist = (ListView)v.findViewById(R.id.videolist);
        videolist.setOnItemClickListener(this);
        videolist.setAdapter(adapter);

        return v;


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intet =new Intent(Video_fragment.this.getActivity(),Youtubeplayer1.class);

        //Sender vidoens ID ud som extra. Youtubeplayerview kræver at den baseres i en Youtubeplayerbase activity, og der skriftes derfor til en activity.

        if (position == 0){
            intet.putExtra("videoID", getActivity().getString(R.string.video1ID));
        }
        else if (position == 1){
            intet.putExtra("videoID", getActivity().getString(R.string.video2ID));
        }
        else if (position == 2 ){
            intet.putExtra("videoID", getActivity().getString(R.string.video3ID));
        }
        else if (position == 3){
            intet.putExtra("videoID", getActivity().getString(R.string.video4ID));
        }
        else if (position == 4){
            intet.putExtra("videoID", getActivity().getString(R.string.video5ID));
        }
        else if (position == 5){
            intet.putExtra("videoID", getActivity().getString(R.string.video6_ID));
        }
        else if (position == 6){
            intet.putExtra("videoID", getActivity().getString(R.string.video7ID));
        }
        else if (position == 7){
            intet.putExtra("videoID", getActivity().getString(R.string.video8ID));
        }
        else if (position == 8){
            intet.putExtra("videoID", getActivity().getString(R.string.video9ID));
        }
        else if (position == 9){
            intet.putExtra("videoID", getActivity().getString(R.string.video10ID));
        }


        startActivity(intet); //Youtubeplayer activity åbnes


        Log.d("Click", "Opening videoplayer");

    }
}
