package com.example.louise.barelsappfrac.notes;

import android.app.AlertDialog;
import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import com.example.louise.barselsapp.R;

import java.util.ArrayList;

/**
 * Created by Louise on 24-04-2015.
 * // kilde: http://developer.android.com/reference/android/app/DialogFragment.html#AlertDialog
 */
public class New_edit_note extends DialogFragment {

    private Button addnote, mynotes;
    private EditText note_editor, titel_editor;
    private TextView shownotes, fragtitel;
    private ArrayList<String> notes = new ArrayList<String>();
    String ititel, inote;
    Filehandler fileH;

   static New_edit_note newInstance(String title) {
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


        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        LayoutInflater i = getActivity().getLayoutInflater();
                View v = i.inflate(R.layout.fragment_fragment_notes, null);
                fileH = new Filehandler(getActivity().getFilesDir().toString());
                note_editor = (EditText) v.findViewById(R.id.noteediter);
                titel_editor = (EditText) v.findViewById(R.id.titeleditor);
                fragtitel =(TextView)v.findViewById(R.id.fragtitel);
                Log.d("dialog", "dialog shown");
                Log.d("notes", notes.toString());

                if (getArguments() != null) {
                    ititel = getArguments().getString("TitelFile");
                    Log.d("arg", ititel);
                    titel_editor.setText(ititel);
                    Filehandler fileH = new Filehandler(getActivity().getFilesDir().toString());
                    inote = fileH.read(ititel);
                    note_editor.setText(inote);
                    fragtitel.setText("Edit notes");
                    adb.setTitle("Edit noter");
                } else {
                    Log.d("arg", "No argumetns");
                }
                adb.setPositiveButton("Save",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getActivity(), "Save", Toast.LENGTH_SHORT).show();
                                String titel = titel_editor.getText().toString();
                                String note = note_editor.getText().toString();
                                fileH.write(titel, note);
                                for (Runnable r : List_notefragment.barselsNotesObservers) r.run();
                                //observer addd


                            }
                        }
                )
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getActivity(), "Canel", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        }
                );


        adb.setView(v);
        return adb.create();
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Dialog dialog = getDialog();


        if (dialog != null) { // Hvis fragmentet bruges som dialog, så sæt titlen
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setTitle("Ny note");

            // Se http://developer.android.com/reference/android/app/DialogFragment.html#AlertDialog
            // for flere muligheder for at tilrette dialogers udseende
        }


        //addnote = (Button)v.findViewById(R.id.addnotebut);





    /*@Override
    public void onClick(View v) {
        Log.d("Yay","Yay click");

    }*/



}
