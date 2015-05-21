package com.example.louise.barelsappfrac.info;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.louise.barselsapp.R;

/*
* Info omkring Efterfødslen fødsel.
* Kilde : Mit barsels forløb, af Nordsjællands Hospital, Gynækologisk-Obstetrisk afdeling, Region Hovedstaden
* */

 public class Efterfodsel extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_efterfodsel, container, false);
    }


}
