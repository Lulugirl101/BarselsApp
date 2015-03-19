package com.example.louise.barelsappfrac;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.louise.barselsapp.Chat;
import com.example.louise.barselsapp.FAQ;
import com.example.louise.barselsapp.Information;
import com.example.louise.barselsapp.R;
import com.example.louise.barselsapp.Videoguides;

import static com.example.louise.barselsapp.R.layout.listeelement;


public class mainlist_fragment extends Fragment implements AdapterView.OnItemClickListener {

    Context context;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] muligheder = {"FAQ", "Video Guides", "Informationer", "Chat", "Noter"};
         final String[] beskrivelser = {"Spørgsmål og svar", "Video guides og information videor", "Nytig information delt ved emner", "Snak med en af vores læger", "Lav dine egne noter"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listeelement, R.id.listeelem_overskrift, muligheder) {

            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);
                Log.d("Layout", "List layout is beagin set up");
                TextView beskrivelse = (TextView) view.findViewById(R.id.listeelem_beskrivelse);
                ImageView billede = (ImageView) view.findViewById(R.id.listeelem_billede);
                if (position == 0) {
                    beskrivelse.setText(beskrivelser[0]);
                    billede.setImageResource(R.drawable.faq_mark);
                } else if (position == 1) {
                    beskrivelse.setText(beskrivelser[1]);
                    billede.setImageResource(R.drawable.hospital);
                } else if (position == 2) {
                    beskrivelse.setText(beskrivelser[2]);
                    billede.setImageResource(R.drawable.babyogsoester);
                } else if (position == 3) {
                    beskrivelse.setText(beskrivelser[3]);
                    billede.setImageResource(R.drawable.chat);
                } else if (position == 4) {
                    beskrivelse.setText(beskrivelser[4]);
                } else {
                    Log.d("", "NO discription");
                }
                Log.d("Layout", "The list wiev have been set up");
                return view;


            }


        };
        ListView listView = new ListView(context);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);


        return inflater.inflate(R.layout.fragment_mainlist_fragment, container, false);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position==0){
            Toast.makeText(context, "There is no activity for this position yet", Toast.LENGTH_SHORT).show();
            Log.d("Click","Opening FAQ");
        }

        else if (position == 1){
            Toast.makeText(context, "There is no activity for this position yet", Toast.LENGTH_SHORT).show();
            Log.d("Click","Opening Videoguides");
        }
        else if (position == 2){
            Toast.makeText(context, "There is no activity for this position yet", Toast.LENGTH_SHORT).show();
            Log.d("Click","Opening Information");
        }

        else if (position == 3){
            Toast.makeText(context, "There is no activity for this position yet", Toast.LENGTH_SHORT).show();
            Log.d("Click","Opening Chat");
        }

        else if (position == 4){
            getFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentindhold1, new fragment_notes())
                    .addToBackStack(null)
                    .commit();
        }

        else {

            Toast.makeText(context, "There is no activity for this position yet", Toast.LENGTH_SHORT).show();
        }
    }

}
