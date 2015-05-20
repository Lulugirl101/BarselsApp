package com.example.louise.barelsappfrac.info;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.louise.barelsappfrac.FragmentActivityman;
import com.example.louise.barselsapp.R;


public class Amning extends Fragment implements View.OnClickListener{
    ImageView chat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View am =inflater.inflate(R.layout.fragment_amning, container, false);

        String[] amning = {"Brug af sut:","Suttebrik:","Ammeråd fup eller fakta","Alkohol og rygning:","Forebyggelse af brystbetændelse:","Sår og revner på brystvorterne:"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listbarselitem, R.id.barselheaditem,amning) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);

                TextView beskrivelse = (TextView) view.findViewById(R.id.barselitemtext);
                switch (position){
                    case 0:
                        beskrivelse.setText(getActivity().getString(R.string.amning_9));
                        break;
                    case 1:
                        beskrivelse.setText(getActivity().getString(R.string.amning_11));
                        break;
                    case 2:
                        beskrivelse.setText(getActivity().getString(R.string.amning_12));
                        break;
                    case 3:
                        beskrivelse.setText(getActivity().getString(R.string.amning_13));
                        break;
                    case 4:
                        beskrivelse.setText(getActivity().getString(R.string.amning_14));
                        break;
                    case 5:
                        beskrivelse.setText(getActivity().getString(R.string.amning_15));
                        break;
                    
                }

                return view;
            }
        };

        ListView listViewamning = (ListView)am.findViewById(R.id.amning_list);
        listViewamning.setDividerHeight(0);
        listViewamning.setAdapter(adapter);
        chat = (ImageView)am.findViewById(R.id.nychat);
        chat.setOnClickListener(this);
        return am;
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();}
        Bundle args = new Bundle();
        args.putInt("Pos", 3);
        FragmentActivityman f = new FragmentActivityman();
        f.setArguments(args);
        getFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragmentindhold1, f)
                .addToBackStack(null)
                .commit();
        Log.d("Click", "Opening Chat");
    }
}
