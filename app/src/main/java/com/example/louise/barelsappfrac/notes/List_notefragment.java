package com.example.louise.barelsappfrac.notes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.louise.barselsapp.R;

import java.util.ArrayList;


/*
*  @author Louise Janø
*
*  List med ens egne noter.
* */

public class List_notefragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener,AdapterView.OnItemLongClickListener, Runnable {

    private ListView listViewNotes;
    ArrayList<String> files = new ArrayList<String>();
    static ArrayList<Runnable> barselsNotesObservers = new ArrayList<>(); //set runable

    private String[] filer =  new String[0];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Info","Oncreate");

    }

    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        Log.d("Info","Oncreateview");
        Log.d("List_notefragment","in use");
        View v = inflater.inflate(R.layout.listnotes_frag, container, false);
            listViewNotes = (ListView) v.findViewById(R.id.listViewnotes);
            ImageButton nyNote = (ImageButton) v.findViewById(R.id.nynote); //laver ny note
            nyNote.setOnClickListener(this);

            // Inflate the layout for this fragment
            listViewNotes.setOnItemClickListener(this);
            listViewNotes.setOnItemLongClickListener(this);
            barselsNotesObservers.add(this);        //adds observer
            ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, files);
            listViewNotes.setAdapter(adapter);
            run(); //updater list med noter

            Log.d("Notes", "Liste oprettes");
            return v;

        }

    @Override
    public void onDestroyView() { //fjerner observeren igen
        super.onDestroyView();
        barselsNotesObservers.remove(this);
    }

    @Override
    public void run() {
        updatelist();
    }

    public void updatelist(){ //Henter listen fra filhandleren og til føljer til den arraylist der bruges af adapteren
        Log.d("List","Update list");
        Filehandler filehandler = new Filehandler(getActivity().getFilesDir().toString());
        filer =filehandler.fileList();
        files.clear();
        for(int i = 0; i< filer.length; i++)
        {
            files.add(filer[i]);
        }

        Log.d("",filer.toString());
        ((ArrayAdapter) listViewNotes.getAdapter()).notifyDataSetChanged();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //viser noten, med Show_note dialog
        String notename = ((TextView)view.findViewById(android.R.id.text1)).getText().toString();
        Log.d("Item",notename);
        Show_note sn = Show_note.newInstance(
                notename);
        sn.show(getFragmentManager(), "dialog");
        Log.d("Fragment","fragment replacing");



    }

    @Override
    public void onClick(View v) {
        Log.d("Click","Button pressed");

        new New_edit_note().show(getFragmentManager(), "dialog");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) { //Slet eller dit din note ved longclick
       Log.d("Click", "Long click detected");
        final String listtext = ((TextView)view.findViewById(android.R.id.text1)).getText().toString();
        Log.d("Item",listtext);
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setCancelable(true);
        dialog.setTitle(listtext);
        dialog.setPositiveButton("Edit", new AlertDialog.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                editNote(listtext);
            }
        });
        dialog.setNegativeButton("Delete", new AlertDialog.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                deleteNote(listtext);
            }
        });
        dialog.show();

            return true;
    }


    public void deleteNote(String itemn){ //Slet fil
        Log.d("Notes","Deleting notes");
        Filehandler fileH = new Filehandler(getActivity().getFilesDir().toString());
        fileH.deletefile(itemn);
        updatelist();


    }

    public void editNote(String itmtit) //Edit fil
    {
        Log.d("Notes","Edit note called");
         New_edit_note new_edit = New_edit_note.newInstance(
                itmtit);
        new_edit.show(getFragmentManager(), "dialog");
        Log.d("Fragment","fragment replacing");
    }



    @Override
    public void onResume() { //Datasæt ændret
        super.onResume();
        Log.d("Notes","Notelist resume");
        Log.d("Notes","onResume()");
        ((ArrayAdapter) listViewNotes.getAdapter()).notifyDataSetChanged();
    }

    public void onStart()
    { Log.d("Notes","onStart()");
        super.onStart(); }
    public void onAttach(){
        super.onAttach(getActivity());
    }

    public void onPause()
    { Log.d("Notes","onPause()"); super.onPause(); }
    public void onStop()
    { Log.d("Notes","onStop()"); super.onStop(); }
    public void onDestroy()
    { Log.d("Notes","onDestroy()"); super.onDestroy(); }

}
