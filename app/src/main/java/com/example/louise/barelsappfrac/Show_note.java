package com.example.louise.barelsappfrac;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.example.louise.barselsapp.R;

/**
 * Created by Louise on 24-04-2015.
 */
public class Show_note extends DialogFragment {
    TextView titelshow,noteshow;
    String notetitel,notecon;

    static Show_note newInstance(String title) {
        Show_note frag = new Show_note();
        Bundle args = new Bundle();
        args.putString("TitelFile", title);
        frag.setArguments(args);
        return frag;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container,
                             Bundle savedInstanceState) {
        Dialog dialog = getDialog();


        if (dialog != null) { // Hvis fragmentet bruges som dialog, så sæt titlen
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
        }
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
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return rod;
    }
}
