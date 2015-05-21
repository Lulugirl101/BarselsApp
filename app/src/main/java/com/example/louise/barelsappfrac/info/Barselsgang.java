package com.example.louise.barelsappfrac.info;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.louise.barelsappfrac.FragmentActivityman;
import com.example.louise.barselsapp.R;

/*
* Info omkring Barselgangen op Barselopholdet.
* Kilde : Mit barsels forløb, af Nordsjællands Hospital, Gynækologisk-Obstetrisk afdeling, Region Hovedstaden
* */

public class Barselsgang extends Fragment implements View.OnClickListener {

    ImageView chat;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rod = inflater.inflate(R.layout.fragment_barselsgang, container, false);
        String[] overskrift = {"Kontakt:","Find vej:","Mad:","Medbring:","Oprydning:","Besøgstid:","Telefon:","Hotline/ Barselsambulatorium","Læs mere og se film:","Barselsophold:","Udskrivelse:","Hotline!"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listbarselitem, R.id.barselheaditem,overskrift) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);

                TextView beskrivelse = (TextView) view.findViewById(R.id.barselitemtext);
                switch (position){
                    case 0:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang0));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 1:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang1));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 2:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang2));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 3:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang3));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 4:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang4));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 5:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang5));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 6:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang6));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 7:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang7));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 8:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang8));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 9:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang9));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 10:
                        beskrivelse.setText(getActivity().getString(R.string.barselgang10));
                        beskrivelse.setTextColor(Color.parseColor("#ff2b1655"));
                        beskrivelse.setGravity(Gravity.LEFT);
                        break;
                    case 11:
                        beskrivelse.setTextColor(Color.parseColor("#ff0000"));
                        beskrivelse.setGravity(Gravity.CENTER);
                        beskrivelse.setText(getActivity().getString(R.string.barselgang11));
                        break;

                }

                return view;
            }
        };

        ListView listView = (ListView)rod.findViewById(R.id.barselganglist);
        listView.setDividerHeight(0);
        listView.setAdapter(adapter);
        chat = (ImageView)rod.findViewById(R.id.nychat);
        chat.setOnClickListener(this); //Mulighed for at åbne chat
       return rod;
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();}//Ryder back stack, så vi ikke bygger en stack af page viewers op
        Bundle args = new Bundle();
        args.putInt("Pos", 3);
        FragmentActivityman f = new FragmentActivityman();
        f.setArguments(args);
        getActivity().getSupportFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragmentindhold1, f)
                .addToBackStack(null)
                .commit();
        Log.d("Click", "Opening Chat");
    }

}
