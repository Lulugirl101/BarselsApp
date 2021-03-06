package com.example.louise.barelsappfrac;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.louise.barelsappfrac.FAQ.FQA_fragment;
import com.example.louise.barelsappfrac.chat.Chat_frag;
import com.example.louise.barelsappfrac.info.Infomation_frag;
import com.example.louise.barelsappfrac.notes.List_notefragment;
import com.example.louise.barelsappfrac.video.Video_fragment;

/*
*  @author Louise Janø
* */
public class FragmentAdapter extends FragmentPagerAdapter {
    private Fragment[] fragmenter = new Fragment[7];

    // Fragments adapter der håndtere de forskelige fragmenter i viewpageren.

    public FragmentAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position)
    {
        // Sætter de forskellige fragmener op i rækkefølge
        Fragment fragment = null;// fragmenter[position];
        if (fragment!=null) return fragment;
        switch(position){
            case 0:
                fragment = new FQA_fragment();
                break;
            case 1:
                fragment = new Video_fragment();
                break;
            case 2:
                fragment = new Infomation_frag();
                break;
            case 3:
                fragment = new Chat_frag();
                break;
            case 4:
                fragment = new List_notefragment();
                break;
        }
        fragmenter[position] = fragment;
        return fragment;
    }

    @Override
    public int getCount() {
        // Retunere nr af fragmenter.
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position){
        //Sætter Tabs titler
        String title = "";
        switch(position){
            case 0:
                title = "FAQ";
                break;
            case 1:
                title = "Videos";
                break;
            case 2:
                title = "INFO";
                break;
            case 3:
                title = "Chat";
                break;
            case 4:
                title = "Noter";
                break;
        }
        return title;
    }

}
