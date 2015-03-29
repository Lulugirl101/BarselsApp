package com.example.louise.barelsappfrac;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.louise.barselsapp.R;



// Note fragment, hvor brugeren skal være istand til at tage noter, gemme og editere i dem.
// TODO: make file format for note

public class fragment_notes extends Fragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private Button addnote;
    private EditText note_editor;
    private TextView shownotes;
    private String[] noter;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rod = i.inflate(R.layout.fragment_fragment_notes, container, false);
        addnote = (Button)rod.findViewById(R.id.addnotebut);
        note_editor = (EditText) rod.findViewById(R.id.noteediter);
        shownotes =(TextView)rod.findViewById(R.id.shownote);

        addnote.setOnClickListener(this);

        return  rod;


    }


    @Override
    public void onClick(View v) {
        //Add bottom
        String note = note_editor.getText().toString();
        note_editor.setText("");
        shownotes.setText(note);

    }

   
    

}
