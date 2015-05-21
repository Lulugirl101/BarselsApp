package com.example.louise.barelsappfrac;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.example.louise.barselsapp.R;

/*
 *  @author Louise Janø
 *
 *
 * Kilde: https://github.com/astuetz/PagerSlidingTabStrip
 *
 * Fragment derindeholder fragmentadapteren så man kan slide imellem de forskellige fragmenter.
 * Indeholder overblik med de forskellige aktiviter.
 */


public class FragmentActivityman extends Fragment {

    FragmentAdapter mAdapter;
    ViewPager mPager;


    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container,Bundle savedInstanceState) {
        //Implemnts the fragment adapter og sætter de rigtige fragmenter fra efter forige aktivitet.
        View rod = i.inflate(R.layout.fragment_activityman_lay, container, false);

        mAdapter = new FragmentAdapter(getChildFragmentManager());

        mPager = (ViewPager)rod.findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) rod.findViewById(R.id.tabs);
        tabs.setViewPager(mPager);

        Integer acknr = getArguments().getInt("Pos");

         if (acknr.equals(0)) {
            mPager.setCurrentItem(0);
        }
        else  if (acknr.equals(1)){
             mPager.setCurrentItem(1);
         }
         else  if (acknr.equals(2)){
             mPager.setCurrentItem(2);
         }
         else  if (acknr.equals(3)){
             mPager.setCurrentItem(3);
         }
         else  if (acknr.equals(4)){
             mPager.setCurrentItem(4);
         }
        return  rod;


    }


}
