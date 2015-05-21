package com.example.louise.barelsappfrac.info;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.louise.barselsapp.R;


/*
* Info omkring  Barnets trivsel.
* Kilde : Mit barsels forløb, af Nordsjællands Hospital, Gynækologisk-Obstetrisk afdeling, Region Hovedstaden
* */

public class Barnets_trvisel extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_barnets_trvisel, container, false);

        String[] barnet_trivsel = {"Afføring:","Navlen:","Babyvask og hårvask:","Gulsot:","Sundhedsplejersken:","Vitaminer:","Hælblodprøve(PKU):","Hørescreening","Læs mere..."};
        ArrayAdapter adapter2 = new ArrayAdapter(getActivity(), R.layout.listbarselitem, R.id.barselheaditem,barnet_trivsel) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);

                TextView beskrivelse = (TextView) view.findViewById(R.id.barselitemtext);
                switch (position){
                    case 0:
                        beskrivelse.setText(getActivity().getString(R.string.trivsel0));
                        break;
                    case 1:
                        beskrivelse.setText(getActivity().getString(R.string.trivsel1));
                        break;
                    case 2:
                        beskrivelse.setText(getActivity().getString(R.string.trivsel2));
                        break;
                    case 3:
                        beskrivelse.setText(getActivity().getString(R.string.trivsel3));
                        break;
                    case 4:
                        beskrivelse.setText(getActivity().getString(R.string.trivsel4));
                        break;
                    case 5:
                        beskrivelse.setText(getActivity().getString(R.string.trvisel5));
                        break;
                    case 6:
                        beskrivelse.setText(getActivity().getString(R.string.trivsel6));
                        break;
                    case 7:
                        beskrivelse.setText(getActivity().getString(R.string.trvisel7));
                        break;
                    case 8:
                        beskrivelse.setText(getActivity().getString(R.string.trivsel8));
                        break;
                }

                return view;
            }
        };

        ListView listViewtrivsel = (ListView)v.findViewById(R.id.trivselslist);
        listViewtrivsel.setDividerHeight(0);
        listViewtrivsel.setAdapter(adapter2);
        return v;
    }


}
