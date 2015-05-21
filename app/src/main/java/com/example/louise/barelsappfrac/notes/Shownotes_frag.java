package com.example.louise.barelsappfrac.notes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.example.louise.barselsapp.R;


public class Shownotes_frag extends Fragment {
  TextView titelshow,noteshow;
    String notetitel,notecon;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("Shownotes_frag","in use");
        View rod = i.inflate(R.layout.shownotes_frag_layout, container, false);
        titelshow = (TextView)rod.findViewById(R.id.titelShow);
        noteshow = (TextView)rod.findViewById(R.id.noteShow);

        if (getArguments()!=null){
            notetitel = getArguments().getString("TitelFile");
            Log.d("arg", notetitel);
            titelshow.setText(notetitel);
            Filehandler fileH = new Filehandler(getActivity().getFilesDir().toString());
            notecon = fileH.read(notetitel);
            noteshow.setText(notecon);
        }
        else
        {Log.d("arg","No argumetns");
        }

        return rod;
    }



}
