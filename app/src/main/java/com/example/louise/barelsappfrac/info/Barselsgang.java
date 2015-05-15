package com.example.louise.barelsappfrac.info;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.louise.barselsapp.R;


public class Barselsgang extends Fragment {


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
       return rod;
    }



}
