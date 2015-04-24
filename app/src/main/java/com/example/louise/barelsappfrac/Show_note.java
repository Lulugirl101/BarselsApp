package com.example.louise.barelsappfrac;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.louise.barselsapp.R;

/**
 * Created by Louise on 24-04-2015.
 */
public class Show_note extends DialogFragment {
    TextView titelshow,noteshow;
    String notetitel,notecon;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container,
                             Bundle savedInstanceState) {
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
