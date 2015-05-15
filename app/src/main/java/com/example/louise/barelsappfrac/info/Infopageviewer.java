package com.example.louise.barelsappfrac.info;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.example.louise.barelsappfrac.FragmentAdapter;
import com.example.louise.barselsapp.R;


public class Infopageviewer extends Fragment {

    Infopageadapter infoAdapter;
    ViewPager infoPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.fragment_infopageviewer, container, false);

        infoAdapter = new Infopageadapter(getFragmentManager());


        infoPager = (ViewPager)rod.findViewById(R.id.infopager);
        infoPager.setAdapter(infoAdapter);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) rod.findViewById(R.id.infotabs);
        tabs.setViewPager(infoPager);

        Integer acknr = getArguments().getInt("Pos");

        if (acknr.equals(0)) {
            infoPager.setCurrentItem(0);
        }
        else  if (acknr.equals(1)){
            infoPager.setCurrentItem(1);
        }
        else  if (acknr.equals(2)){
            infoPager.setCurrentItem(2);
        }
        else  if (acknr.equals(3)){
            infoPager.setCurrentItem(3);
        }
        else  if (acknr.equals(4)){
            infoPager.setCurrentItem(4);
        }
        return  rod;


    }


}
