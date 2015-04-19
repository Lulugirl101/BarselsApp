package com.example.louise.barelsappfrac;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.louise.barselsapp.R;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class List_notefragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener,AdapterView.OnItemLongClickListener {

    private ListView listViewNotes;
    ArrayList<String> mynotes = new ArrayList<String>();
    private ImageButton nyNote;
    private View.OnClickListener click;
    String itemname;
    private String[] filer =  new String[0];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            Filehandler filehandler = new Filehandler(getActivity().getFilesDir().toString());
            filer = filehandler.fileList();
            Log.d("",filer.toString());
            View v = inflater.inflate(R.layout.listnotes_frag, container, false);
            listViewNotes = (ListView) v.findViewById(R.id.listViewnotes);
            ImageButton nyNote = (ImageButton) v.findViewById(R.id.nynote);
            nyNote.setOnClickListener(this);
            ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, filer);

            // Inflate the layout for this fragment
            listViewNotes.setOnItemClickListener(this);
            listViewNotes.setOnItemLongClickListener(this);
            listViewNotes.setAdapter(adapter);

            Log.d("Notes", "Liste oprettes");
            return v;

        }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Klik på " + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        Log.d("Click","Button pressed");

        getFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragmentholder, new fragment_notes())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
       Log.d("Click", "Long click detected");
        String listtext = ((TextView)view.findViewById(android.R.id.text1)).getText().toString();
        Log.d("Item",listtext);
        showPopup(getView(), listtext);
       // mynotes.remove(position);
        //((ArrayAdapter) listViewNotes.getAdapter()).notifyDataSetChanged();
        //Toast.makeText(getActivity(), "Removed the country" + position, Toast.LENGTH_SHORT).show();
        return true;
    }

    public void updatelist(){//Todo find bedre løsning virker ikke.
        Log.d("List","Update list");
        filer = new String[0];
        Log.d("",filer.toString());
        Filehandler filehandler = new Filehandler(getActivity().getFilesDir().toString());
        filer = filehandler.fileList();
        Log.d("",filer.toString());
        ((ArrayAdapter) listViewNotes.getAdapter()).notifyDataSetChanged();
    }

    public void deleteNote(String itemn){
        Log.d("Notes","Deleting notes");
        Filehandler fileH = new Filehandler(getActivity().getFilesDir().toString());
        fileH.deletefile(itemn);
        updatelist();


    }

    public void editNote(String itmtit)
    {
        Log.d("Notes","Edit note called");
        Bundle args = new Bundle();
        args.putString("TitelFile",itmtit);
        fragment_notes d = new fragment_notes();
        d.setArguments(args);
        getFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragmentholder,d)
                .addToBackStack(null)
                .commit();
        Log.d("Fragment","fragment replacing");
    }
       //POPUP menu to delete an edit in notes TODO: fix visual errors
    private void showPopup(final View v, final String itemtit){
        Log.d("Menu","Show popups");
        PopupMenu popm = new PopupMenu(getActivity(),v);
        popm.getMenuInflater().inflate(R.menu.popupnotes,popm.getMenu());

        popm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu1:
                        Log.d("Items","Edit note selcedted");
                        editNote(itemtit);
                        Toast.makeText(getActivity(),item.toString(),Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu2:
                        Log.d("Items","Remove note selected");
                        deleteNote(itemtit);
                        Toast.makeText(getActivity(), "Remove note", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return true;
                }
            }
        });
        popm.show();
    }

  /*  @Override
    public void onResume() {
        super.onResume();
        Log.d("Notes","Notelist resume");
        ((ArrayAdapter) listViewNotes.getAdapter()).notifyDataSetChanged();
    } */

}
