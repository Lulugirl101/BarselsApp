package com.example.louise.barelsappfrac.info;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.louise.barelsappfrac.FragmentActivityman;
import com.example.louise.barselsapp.R;


public class Ambulantfoedsel extends Fragment implements View.OnClickListener {
    ImageView chat;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ambulantfoedsel, container, false);
        chat = (ImageView)v.findViewById(R.id.nychat);
        chat.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();}
            Bundle args = new Bundle();
            args.putInt("Pos", 3);
            FragmentActivityman f = new FragmentActivityman();
            f.setArguments(args);
            getFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentindhold1, f)
                    .addToBackStack(null)
                    .commit();
            Log.d("Click", "Opening Chat");
        }

}
