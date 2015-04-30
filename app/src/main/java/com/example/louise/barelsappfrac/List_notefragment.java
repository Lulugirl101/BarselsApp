package com.example.louise.barelsappfrac;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.louise.barselsapp.R;

import java.util.ArrayList;



public class List_notefragment extends Fragment implements AdapterView.OnItemClickListener,View.OnClickListener,AdapterView.OnItemLongClickListener, Runnable {

    private ListView listViewNotes;
    ArrayList<String> mynotes,files = new ArrayList<String>();
    private ImageButton nyNote;
    private View.OnClickListener click;
    String itemname;
    static ArrayList<Runnable> barselsNotesObservers = new ArrayList<>();

    private String[] filer =  new String[0];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.listnotes_frag, container, false);
            listViewNotes = (ListView) v.findViewById(R.id.listViewnotes);
            ImageButton nyNote = (ImageButton) v.findViewById(R.id.nynote);
            nyNote.setOnClickListener(this);

            // Inflate the layout for this fragment
            listViewNotes.setOnItemClickListener(this);
            listViewNotes.setOnItemLongClickListener(this);
        barselsNotesObservers.add(this);
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, files);
        listViewNotes.setAdapter(adapter);
            run();

            Log.d("Notes", "Liste oprettes");
            return v;

        }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        barselsNotesObservers.remove(this);
    }

    @Override
    public void run() {
        updatelist();
    }

    public void updatelist(){//Todo find bedre løsning virker ikke.
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String notename = ((TextView)view.findViewById(android.R.id.text1)).getText().toString();
        Log.d("Item",notename);
        Show_note sn = Show_note.newInstance(
                notename);
        sn.show(getFragmentManager(), "dialog");
        /*Bundle args = new Bundle();
        args.putString("TitelFile",notename);
        Shownotes_frag d = new Shownotes_frag();
        d.setArguments(args);
        getFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragmentholder,d)
                .addToBackStack(null)
                .commit();*/
        Log.d("Fragment","fragment replacing");



    }

    @Override
    public void onClick(View v) {
        Log.d("Click","Button pressed");

        new New_edit_note().show(getFragmentManager(), "dialog");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
       Log.d("Click", "Long click detected");
        final String listtext = ((TextView)view.findViewById(android.R.id.text1)).getText().toString();
        Log.d("Item",listtext);
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
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

       // showPopup(getView(), listtext);
       // mynotes.remove(position);
        //((ArrayAdapter) listViewNotes.getAdapter()).notifyDataSetChanged();
        //Toast.makeText(getActivity(), "Removed the country" + position, Toast.LENGTH_SHORT).show();
        return true;
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
         New_edit_note new_edit = New_edit_note.newInstance(
                itmtit);
        new_edit.show(getFragmentManager(), "dialog");
       /* Bundle args = new Bundle();
        args.putString("TitelFile",itmtit);
        fragment_notes d = new fragment_notes();
        d.setArguments(args);
        getFragmentManager().beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.fragmentholder,d)
                .addToBackStack(null)
                .commit();*/
        Log.d("Fragment","fragment replacing");
    }

       //POPUP menu to delete an edit in notes TODO: fix visual errors
 /*   private void showPopup(final View v, final String itemtit){
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
                        Toast.makeText(getActivity(),"Edit "+ item.toString(),Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu2:
                        Log.d("Items","Remove note selected");
                        deleteNote(itemtit);
                        Toast.makeText(getActivity(), "Removing note"+ itemtit, Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return true;
                }
            }
        });
        popm.show();
    }*/

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Notes","Notelist resume");
        ((ArrayAdapter) listViewNotes.getAdapter()).notifyDataSetChanged();
    }

}
