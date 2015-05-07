package com.example.louise.barelsappfrac.info;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.louise.barselsapp.R;

// Infomation framgent, der skal indeholde det udleverede marteriale. lige pt pdf.
//TODO: Find måde at implementere , det udleverede Hospital marteriale.

public class Infomation_frag extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.info_frag_layout, container, false);
    }








}
