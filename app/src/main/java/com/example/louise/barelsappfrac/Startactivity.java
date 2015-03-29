package com.example.louise.barelsappfrac;


import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.louise.barselsapp.R;

public class Startactivity extends FragmentActivity {
    //Start aktivitet der indeholder det pladsen til fragmentet.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_start_layout);
        Log.d("","Open start activity");

        if (savedInstanceState == null) {
            mainlist_fragment fragment = new mainlist_fragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentindhold1, fragment) // tom container i layout
                    .commit();
        }

    }



}
