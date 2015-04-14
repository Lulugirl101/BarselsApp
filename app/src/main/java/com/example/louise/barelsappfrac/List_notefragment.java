package com.example.louise.barelsappfrac;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
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
import android.widget.Toast;

import com.example.louise.barselsapp.R;

import java.util.ArrayList;

public class List_notefragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView listViewNotes;
    ArrayList<String> mynotes;
    private ImageButton nyNote;
    private View.OnClickListener click;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            String[] lande = {"Danmark", "Norge", "Sverige", "Finland",
                    "Holland", "Italien", "Tyskland", "Frankrig", "Spanien", "Portugal",
                    "Nepal", "Indien", "Kina", "Japan", "Thailand"};

            View v = inflater.inflate(R.layout.listnotes_frag, container, false);
            ListView listViewNotes = (ListView) v.findViewById(R.id.listViewnotes);
            ImageButton nyNote = (ImageButton) v.findViewById(R.id.nynote);
            nyNote.setOnClickListener(this); //TODO: findløsning og set function

            ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, lande);

            // Inflate the layout for this fragment
            listViewNotes.setOnItemClickListener(this);
            listViewNotes.setOnItemLongClickListener(this); //Todo find løsning
            listViewNotes.setAdapter(adapter);

            Log.d("Notes", "Liste oprettes");
            return v;

        }


        /*@Override
        public void onClick(View v) {
            Log.d("Click","Button pressed");

            getFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentholder, new fragment_notes())
                    .addToBackStack(null)
                    .commit();

        }*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Klik på " + position, Toast.LENGTH_SHORT).show();

    }
        /** @Override
        public void onItemLongClick(AdapterView<?> listView, View v, int position, long id) {
        //lande.remove(this);
        Log.d("Notes", "Remove" + position);
        Toast.makeText(getActivity(), "Removed the country" + position, Toast.LENGTH_SHORT).show();
        }*/


}
