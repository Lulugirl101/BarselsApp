package com.example.louise.barelsappfrac.notes;

import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import com.example.louise.barselsapp.R;

import java.util.ArrayList;

/**
 * Created by Louise on 24-04-2015.
 * Rediger og lav nye noter som dialog
 *  kilde: http://developer.android.com/reference/android/app/DialogFragment.html#AlertDialog
 */
public class New_edit_note extends DialogFragment {


    private EditText note_editor, titel_editor;
    private TextView fragtitel;
    private ArrayList<String> notes = new ArrayList<String>();
    String ititel, inote;
    Filehandler fileH;

   static New_edit_note newInstance(String title) { //Henter argumenterne der bliver brugt.
        New_edit_note frag = new New_edit_note();
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
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Log.d("New_edit_note","in use");
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        LayoutInflater i = getActivity().getLayoutInflater();
                View v = i.inflate(R.layout.fragment_fragment_notes, null);
                fileH = new Filehandler(getActivity().getFilesDir().toString());
                note_editor = (EditText) v.findViewById(R.id.noteediter);
                titel_editor = (EditText) v.findViewById(R.id.titeleditor);
                fragtitel =(TextView)v.findViewById(R.id.fragtitel);
                Log.d("dialog", "dialog shown");
                Log.d("notes", notes.toString());

                if (getArguments() != null) { //Sætter titel og inhold hvis det er Editnote
                    ititel = getArguments().getString("TitelFile");
                    Log.d("arg", ititel);
                    titel_editor.setText(ititel);
                    Filehandler fileH = new Filehandler(getActivity().getFilesDir().toString());
                    inote = fileH.read(ititel);
                    note_editor.setText(inote);
                    fragtitel.setText("Edit notes");

                } else {
                    Log.d("arg", "No argumetns");
                }
                adb.setPositiveButton("Save",  //Gemmer noten
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getActivity(), "Save", Toast.LENGTH_SHORT).show();
                                String titel = titel_editor.getText().toString();
                                String note = note_editor.getText().toString();
                                fileH.write(titel, note);
                                for (Runnable r : List_notefragment.barselsNotesObservers) r.run();
                                //observer add. Informere observeren at listen er ændret


                            }
                        }
                )
                .setNegativeButton("Cancel", //Cancel ny/ænderign af note
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getActivity(), "Cancel", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        }
                );


        adb.setView(v);
        return adb.create();
    }



}
