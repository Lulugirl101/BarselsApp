package com.example.louise.barselsapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity_Start extends Activity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main_activity_start_layout);

        String[] muligheder = {"FAQ", "Video Guides", "Informationer", "Chat"};
        final String[] beskrivelser = {"Spørgsmål og svar", "Video guides og information videor", "Nytig information delt ved emner", "Snak med en af vores læger"};
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listeelement, R.id.listeelem_overskrift, muligheder) {

            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);

                TextView beskrivelse = (TextView) view.findViewById(R.id.listeelem_beskrivelse);
                ImageView billede = (ImageView) view.findViewById(R.id.listeelem_billede);
                if (position== 0){
                    beskrivelse.setText(beskrivelser[0]);
                    billede.setImageResource(R.drawable.faq_mark);
                }
                else if(position == 1){
                    beskrivelse.setText(beskrivelser[1]);
                    billede.setImageResource(R.drawable.hospital);
                }

                else if(position == 2){
                    beskrivelse.setText(beskrivelser[2]);
                    billede.setImageResource(R.drawable.babyogsoester);
                }
                else if(position == 3){
                    beskrivelse.setText(beskrivelser[3]);
                }

                else { Log.d("","NO discription");}

                return view;

            }


        };
        ListView listView = new ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        setContentView(listView);
    }
        //setListAdapter(adapter);
        //ArrayAdapter adapter1 = new ArrayAdapter(this, R.layout.listeelement, R.id.listeelem_beskrivelse,beskrivelser);
        //setListAdapter(adapter1);
        //Log.d("","The list is started");
        //if (view == null){
          //  Log.d("","view is empty");
        //}
        //TextView beskrivelse = (TextView) view.findViewById(R.id.listeelem_beskrivelse);
        //beskrivelse.setText("Position nummer ");

    /**@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity__start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
**/
  /** public void onListItemClick(ListView s, View v, int position, long id) {
        if (position==0){
            Intent i = new Intent(this, FAQ.class);
            startActivity(i);
            Log.d("Click","Opening FAQ");
        }

        else if (position == 1){
            Intent i = new Intent(this, Videoguides.class);
            startActivity(i);
            Log.d("Click","Opening Videoguides");
        }
        else if (position == 2){
            Intent i = new Intent(this, Information.class);
            startActivity(i);
            Log.d("Click","Opening Information");
        }

        else if (position == 3){
            Intent i = new Intent(this, Chat.class);
            startActivity(i);
            Log.d("Click","Opening Chat");
        }

        else {

            Toast.makeText(this, "There is no activity for this position yet", Toast.LENGTH_SHORT).show();
        }


    } **/


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position==0){
            Intent i = new Intent(this, FAQ.class);
            startActivity(i);
            Log.d("Click","Opening FAQ");
        }

        else if (position == 1){
            Intent i = new Intent(this, Videoguides.class);
            startActivity(i);
            Log.d("Click","Opening Videoguides");
        }
        else if (position == 2){
            Intent i = new Intent(this, Information.class);
            startActivity(i);
            Log.d("Click","Opening Information");
        }

        else if (position == 3){
            Intent i = new Intent(this, Chat.class);
            startActivity(i);
            Log.d("Click","Opening Chat");
        }

        else {

            Toast.makeText(this, "There is no activity for this position yet", Toast.LENGTH_SHORT).show();
        }
    }
}
