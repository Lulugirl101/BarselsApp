package com.example.louise.barelsappfrac;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.louise.barselsapp.R;

public class Startactivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_start_layout);
        Log.d("","Open start activity");

        if (savedInstanceState == null) {
            mainlist_fragment fragment = new mainlist_fragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.fragmentindhold1, fragment) // tom container i layout
                    .commit();
        }

    }



}
