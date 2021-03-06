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

/*
*  @author Louise Janø
*  Infomation framgent, der skal indeholde det udleverede marteriale. lige pt pdf.
* Giver oversigt over de forskellgie emner, og åbner en ny viewpager med de forskellgie emner.
* TODO: Find måde at implementere fra backend , det udleverede Hospital marteriale.*/

public class Infomation_frag extends Fragment implements View.OnClickListener {

    ImageView efterfød,barselgang,ambulant, kvinde_krop,barnetstrivsel,ernæring_barn,amning,udmalk;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Info","OnCreate");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Info","OnCreateView");
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
       //Åbner ny pageviewer gafhænning af det valgte Imageview.

       if (v == efterfød){
           Bundle args = new Bundle();
           args.putInt("Pos",0);
           Infopageviewer1 i = new Infopageviewer1();
           i.setArguments(args);
           getActivity().getSupportFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click", "Opening Efterfødsel");

       }
        else if(v == barselgang){
           Bundle args = new Bundle();
           args.putInt("Pos",1);
           Infopageviewer1 i = new Infopageviewer1();
           i.setArguments(args);
          getActivity().getSupportFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening Barselgang");

       }
       else if(v == ambulant){
           Bundle args = new Bundle();
           args.putInt("Pos",2);
           Infopageviewer1 i = new Infopageviewer1();
           i.setArguments(args);
           getActivity().getSupportFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening Ambulant");

       }
       else if(v == kvinde_krop){
           Bundle args = new Bundle();
           args.putInt("Pos",3);
           Infopageviewer1 i = new Infopageviewer1();
           i.setArguments(args);
           getActivity().getSupportFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening kvinde_krop");

       }
       else if(v == barnetstrivsel){
           Bundle args = new Bundle();
           args.putInt("Pos",4);
           Infopageviewer1 i = new Infopageviewer1();
           i.setArguments(args);
           getActivity().getSupportFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening FAQ");

       }
       else if(v == ernæring_barn){
           Bundle args = new Bundle();
           args.putInt("Pos",5);
           Infopageviewer1 i = new Infopageviewer1();
           i.setArguments(args);
           getActivity().getSupportFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening FAQ");

       }
       else if(v == amning ){
           Bundle args = new Bundle();
           args.putInt("Pos",6);
           Infopageviewer1 i = new Infopageviewer1();
           i.setArguments(args);
           getActivity().getSupportFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening FAQ");

       }
       else if(v ==udmalk ){
           Bundle args = new Bundle();
           args.putInt("Pos",7);
           Infopageviewer1 i = new Infopageviewer1();
           i.setArguments(args);
           getActivity().getSupportFragmentManager().beginTransaction()
                   .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                   .replace(R.id.fragmentindhold1,i )
                   .addToBackStack(null)
                   .commit();
           Log.d("Click","Opening FAQ");

       }

    }

    public void onStart()
    { Log.d("Info","onStart()");
        super.onStart(); }
    public void onAttach(){
        super.onAttach(getActivity());
    }
    public void onResume()
    { Log.d("Info","onResume()");
        super.onResume(); }
    public void onPause()
    { Log.d("Info","onPause()"); super.onPause(); }
    public void onStop()
    { Log.d("Info","onStop()"); super.onStop(); }
    public void onDestroy()
    { Log.d("Info","onDestroy()"); super.onDestroy(); }
}
