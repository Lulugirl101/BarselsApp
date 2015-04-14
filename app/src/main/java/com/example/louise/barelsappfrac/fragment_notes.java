package com.example.louise.barelsappfrac;

import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.louise.barselsapp.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


// Note fragment, hvor brugeren skal være istand til at tage noter, gemme og editere i dem.
// TODO: make file format for note

public class fragment_notes extends Fragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private Button addnote,mynotes;
    private EditText note_editor,titel_editor;
    private TextView shownotes;
    private ArrayList<String> notes = new ArrayList<String>();
    public Boolean frag_my_notes;
    int i, j;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int size = PreferenceManager.getDefaultSharedPreferences(getActivity())
                .getInt("size",0);
        View rod = i.inflate(R.layout.fragment_fragment_notes, container, false);
        addnote = (Button)rod.findViewById(R.id.addnotebut);
        note_editor = (EditText) rod.findViewById(R.id.noteediter);
        titel_editor = (EditText)rod.findViewById(R.id.titeleditor);
        mynotes =(Button)rod.findViewById(R.id.my_notes_but);

        //ArrayList notes = new ArrayList<String>();
        //notes.add("First entry");
        Log.d("notes",notes.toString());
        //Tilføjer de to knapper.
        addnote.setOnClickListener(this);
        mynotes.setOnClickListener(this);

        return  rod;


    }



    @Override
    public void onClick(View v) {
        if(v == addnote) {
            //Add bottom
            Log.d("Noter", "Adding note");
            String note = note_editor.getText().toString();
            String filename = titel_editor.getText().toString();
            Log.d("Noter", note);
            String dir = getActivity().getFilesDir().toString();
            Log.d("Noter", dir.toString());
            Filehandler fileH = new Filehandler();
            fileH.write(filename, note, dir);
            if (fileH.write(filename, note, dir)) {
                Toast.makeText(getActivity(), filename + ".txt created", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "I/O error", Toast.LENGTH_SHORT).show();
            }
            //notes.add(filename);
            note_editor.setText("");
            titel_editor.setText("");

           /* if (notes == null){
                ArrayList notes = new ArrayList<String>();
                notes.add(filename);

            }
            else {
                notes.add(filename);

            }*/
            notes.add(filename);
            Log.d("Notelist",notes.toString());

            SharedPreferences sPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
            SharedPreferences.Editor sEdit = sPref.edit();

            for (int i=0;i<notes.size();i++ );
            {
                sEdit.putString("Note"+i,notes.get(i));
            }
            sEdit.putInt("size",notes.size());
            sEdit.commit();

        }
        if (v == mynotes){
            Log.d("Notes","Showing my notes");

            getFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentholder, new List_notefragment())
                    .addToBackStack(null)
                    .commit();









        }

    }

   
    

}
