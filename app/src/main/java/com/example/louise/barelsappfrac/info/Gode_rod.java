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
* Info: Gode råd om kvindens krop.
* Kilde : Mit barsels forløb, af Nordsjællands Hospital, Gynækologisk-Obstetrisk afdeling, Region Hovedstaden
* */

public class Gode_rod extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gode_rod, container, false);
        String[] overskrifter = {"Blødning:","Tråde:","I form efter fødslen:"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listbarselitem, R.id.barselheaditem,overskrifter) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);

                TextView beskrivelse = (TextView) view.findViewById(R.id.barselitemtext);
                switch (position){
                    case 0:
                        beskrivelse.setText(getActivity().getString(R.string.kvindenskrop1));
                        break;
                    case 1:
                        beskrivelse.setText(getActivity().getString(R.string.kvindeskrop2));
                        break;
                    case 2:
                        beskrivelse.setText(getActivity().getString(R.string.kvindenkrop3));
                        break;
                }

                return view;
            }
        };


        ListView listViewkrop = (ListView)v.findViewById(R.id.kroplist);
        listViewkrop.setDividerHeight(0);
        listViewkrop.setAdapter(adapter);



        return v;
    }


}
