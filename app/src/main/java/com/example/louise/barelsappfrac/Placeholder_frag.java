package com.example.louise.barelsappfrac;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.louise.barselsapp.R;


public class Placeholder_frag extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState==null) {
            getFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentholder, new List_notefragment())
                    .commit();

        }
        Log.d("layout","Holder sat up "+this+savedInstanceState);

        return inflater.inflate(R.layout.placeholder_frag_layout, container, false);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("jek",42);
        Log.d("layout","Holder sat up "+this+outState);
        super.onSaveInstanceState(outState);
    }
}
