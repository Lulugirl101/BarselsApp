package com.example.louise.barelsappfrac.info;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.louise.barselsapp.R;

/*
*  @author Louise Janø
*
* Info omkring Barnets ernæring.
* Kilde : Mit barsels forløb, af Nordsjællands Hospital, Gynækologisk-Obstetrisk afdeling, Region Hovedstaden
* */

public class Ernearing extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ernearing, container, false);
    }


}
