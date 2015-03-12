package com.example.louise.barselsapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity_Start extends ListActivity {
    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main_activity_start_layout);

        String[] muligheder = {"FAQ","Video Guides","Informationer","Chat"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, muligheder);

        setListAdapter(adapter);
        Log.d("","The list is started");
    }


    @Override
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

    public void onListItemClick(ListView s, View v, int position, long id) {
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
