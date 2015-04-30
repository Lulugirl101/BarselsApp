package com.example.louise.barelsappfrac;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.louise.barselsapp.R;

// Video guides fragment,
// TODO: implemnter smat videovisning.Fileparsing?

public class Video_fragment extends Fragment {

    Button but;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.video_fragment_layout, container, false);
        but = (Button)v.findViewById(R.id.button);
        but.setOnClickListener(this);
        return v;


    }*/


   /* @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragmentindhold1, new YoutubeRssParsning())
                .addToBackStack(null)
                .commit();
    }*/
}
