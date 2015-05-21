package com.example.louise.barelsappfrac.info;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/*
 *
 *  @author Louise Janø
 * Infopageadpater.
 */
public class Infopageadapter1 extends FragmentPagerAdapter {
    private Fragment[] fragmenter = new Fragment[7];

    // Fragments adapter der håndtere de forskelige fragmenter for infoviewpageren.

    public Infopageadapter1(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position)
    {
        // Sætter de forskellige infofragmener op i rækkefølge
        Fragment fragment = null;// fragmenter[position];
        if (fragment!=null) return fragment;
        switch(position){
            case 0:
                fragment = new Efterfodsel();
                break;
            case 1:
                fragment = new Barselsgang() ;
                break;
            case 2:
                fragment = new Ambulantfoedsel();
                break;
            case 3:
                fragment = new Gode_rod();
                break;
            case 4:
                fragment = new Barnets_trvisel();
                break;
            case 5:
                fragment = new Ernearing();
                break;
            case 6:
                fragment = new Amning();
                break;
            case 7:
                fragment = new Udpumpning();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        // Retunere nr af fragmenter.
        return 8;
    }

    @Override
    public CharSequence getPageTitle(int position){
        //Sætter Tabs titler
        String title = "";
        switch(position){
            case 0:
                title = "Efter fødsel";
                break;
            case 1:
                title = "Barselsgang";
                break;
            case 2:
                title = "Ambulant";
                break;
            case 3:
                title = "Kvindens krop";
                break;
            case 4:
                title = "Barnets trivsel";
                break;
            case 5:
                title = "Ernæring";
                break;
            case 6:
                title = "Amning";
                break;
            case 7:
                title = "Udmalkning";
                break;

        }
        return title;
    }
}
