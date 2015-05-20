package com.example.louise.barelsappfrac.info;

import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.louise.barselsapp.R;

// Infomation framgent, der skal indeholde det udleverede marteriale. lige pt pdf.
//TODO: Find måde at implementere fra backend , det udleverede Hospital marteriale.

public class Infomation_frag extends Fragment implements View.OnClickListener {

    ImageView efterfød,barselgang,ambulant, kvinde_krop,barnetstrivsel,ernæring_barn,amning,udmalk;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View table = inflater.inflate(R.layout.info_frag_layout, container, false);
        efterfød = (ImageView)table.findViewById(R.id.efterfødsels);
        barselgang=(ImageView)table.findViewById(R.id.barselgang);
        ambulant = (ImageView)table.findViewById(R.id.ambulant);
        kvinde_krop = (ImageView)table.findViewById(R.id.krop);
        barnetstrivsel = (ImageView)table.findViewById(R.id.b_trivsel);
        ernæring_barn=(ImageView)table.findViewById(R.id.ernæring);
        amning=(ImageView)table.findViewById(R.id.amning);
        udmalk=(ImageView)table.findViewById(R.id.udmalk);


        efterfød.setOnClickListener(this);
        barselgang.setOnClickListener(this);
        ambulant.setOnClickListener(this);
        kvinde_krop.setOnClickListener(this);
        ernæring_barn.setOnClickListener(this);
        barnetstrivsel.setOnClickListener(this);
        amning.setOnClickListener(this);
        udmalk.setOnClickListener(this);

        return table;

    }

    @Override
    public void onClick(View v) {
       if (v == efterfød){
           Bundle args = new Bundle();
           args.putInt("Pos",0);
           Infopageviewer i = new Infopageviewer();
           i.setArguments(args);
           //fragment_activityman_lay.setArguments(args);
           getFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click", "Opening Efterfødsel");

       }
        else if(v == barselgang){
           Bundle args = new Bundle();
           args.putInt("Pos",1);
           Infopageviewer i = new Infopageviewer();
           i.setArguments(args);
           //fragment_activityman_lay.setArguments(args);
           getFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening Barselgang");

       }
       else if(v == ambulant){
           Bundle args = new Bundle();
           args.putInt("Pos",2);
           Infopageviewer i = new Infopageviewer();
           i.setArguments(args);
           //fragment_activityman_lay.setArguments(args);
           getFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening Ambulant");

       }
       else if(v == kvinde_krop){
           Bundle args = new Bundle();
           args.putInt("Pos",3);
           Infopageviewer i = new Infopageviewer();
           i.setArguments(args);
           //fragment_activityman_lay.setArguments(args);
           getFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening kvinde_krop");

       }
       else if(v == barnetstrivsel){
           Bundle args = new Bundle();
           args.putInt("Pos",4);
           Infopageviewer i = new Infopageviewer();
           i.setArguments(args);
           //fragment_activityman_lay.setArguments(args);
           getFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening FAQ");

       }
       else if(v == ernæring_barn){
           Bundle args = new Bundle();
           args.putInt("Pos",5);
           Infopageviewer i = new Infopageviewer();
           i.setArguments(args);
           //fragment_activityman_lay.setArguments(args);
           getFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening FAQ");

       }
       else if(v == amning ){
           Bundle args = new Bundle();
           args.putInt("Pos",6);
           Infopageviewer i = new Infopageviewer();
           i.setArguments(args);
           //fragment_activityman_lay.setArguments(args);
           getFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening FAQ");

       }
       else if(v ==udmalk ){
           Bundle args = new Bundle();
           args.putInt("Pos",7);
           Infopageviewer i = new Infopageviewer();
           i.setArguments(args);
           //fragment_activityman_lay.setArguments(args);
           getFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening FAQ");

       }

    }
}
