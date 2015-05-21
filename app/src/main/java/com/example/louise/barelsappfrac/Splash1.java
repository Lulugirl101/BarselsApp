package com.example.louise.barelsappfrac;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import android.widget.ImageView;

import com.example.louise.barselsapp.R;


public class Splash1 extends FragmentActivity implements Runnable {
    Handler handler = new Handler();
    static Splash1 aktivitetDerVisesNu = null;
    //Spash aktivitet. TODO: Implementer til sidst.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Splash startet", "App running");
        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.logo);
        setContentView(iv);

        // Hvis savedInstanceState ikke er null er det en aktivitet der er ved at blive genstartet
        if (savedInstanceState == null) {
            handler.postDelayed(this, 3000); // <1> Kør run() om 3 sekunder
        }
        aktivitetDerVisesNu = this;
    }

    // Appen starter op
    @Override
    public void run() {
        Log.d("Appen bliver startet","");
        startActivity(new Intent(this, Startactivity.class));
        aktivitetDerVisesNu.finish();  // <2> Luk velkomsaktiviteten
        aktivitetDerVisesNu = null;
    }

    /**
     * Kaldes hvis brugeren trykker på tilbage-knappen.
     * I så tilfælde skal vi ikke hoppe videre til næste aktivitet
     */
    @Override
    public void finish() {
        Log.d("Splash done","");
        super.finish();
        handler.removeCallbacks(this);
    }
}
