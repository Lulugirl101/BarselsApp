package com.example.louise.barelsappfrac;


import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.louise.barselsapp.R;

import com.example.louise.barelsappfrac.Loginfunkt.Loginakt;

/*
*  @author Louise Janø og William Giesmar
* */

public class mainlist_fragment extends Fragment implements AdapterView.OnItemClickListener {

//Første Fragment ,der indeholder mainlist, start menuen
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Sætter listview op
        Log.d("","Inside list fragmetent");
        String[] muligheder = {"FAQ", "Video Guides", "Mit forløb: Barsel", "Chat", "Noter","Login"};
         final String[] beskrivelser = {"Spørgsmål og svar", "Video guides og information videor", "Nytig information delt ved emner fra mit forløb mappen", "Snak med en af vores læger", "Lav dine egne noter"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.listeelement, R.id.listeelem_overskrift, muligheder) {
            //udvider listview
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);
                TextView beskrivelse = (TextView) view.findViewById(R.id.listeelem_beskrivelse);
                ImageView billede = (ImageView) view.findViewById(R.id.listeelem_billede);
                if (position == 0) {
                    beskrivelse.setText(beskrivelser[0]);
                    billede.setImageResource(R.drawable.faq_mark);
                } else if (position == 1) {
                    beskrivelse.setText(beskrivelser[1]);
                    billede.setImageResource(R.drawable.hospital);
                } else if (position == 2) {
                    beskrivelse.setText(beskrivelser[2]);
                    billede.setImageResource(R.drawable.babyogsoester);
                } else if (position == 3) {
                    beskrivelse.setText(beskrivelser[3]);
                    billede.setImageResource(R.drawable.chat);
                } else if (position == 4) {
                    beskrivelse.setText(beskrivelser[4]);
                } else if (position == 5) {
                        beskrivelse.setText("Login til app");
                        billede.setImageResource(R.drawable.key);
                } else {
                    Log.d("", "NO discription");
                }


                return view;


            }


        };
        ListView listView = new ListView(getActivity());
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        Log.d("Layout", "The list wiev have been set up");

        return listView;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Henter de forskellgie fragmenter afhængig af brugerens valg.
        if (position==0){
            //FAQ fragment er valgt
            Bundle args = new Bundle();
            args.putInt("Pos",0);
            FragmentActivityman f = new FragmentActivityman();
            f.setArguments(args);
            //fragment_activityman_lay.setArguments(args);
            getFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentindhold1,f )
                    .addToBackStack(null)
                    .commit();
            Log.d("Click","Opening FAQ");
        }

        else if (position == 1){
            // Video guides er valgt
            Bundle args = new Bundle();
            args.putInt("Pos",1);
            FragmentActivityman f = new FragmentActivityman();
            f.setArguments(args);
            //fragment_activityman_lay.setArguments(args);
            getFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentindhold1,f )
                    .addToBackStack(null)
                    .commit();
            Log.d("Click","Opening Videoguide");
        }
        else if (position == 2){
            //Informations fragment.
            Bundle args = new Bundle();
            args.putInt("Pos",2);
            FragmentActivityman f = new FragmentActivityman();
            f.setArguments(args);
            //fragment_activityman_lay.setArguments(args);
            getFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentindhold1,f )
                    .addToBackStack(null)
                    .commit();
            Log.d("Click","Opening Information");
        }

        else if (position == 3){
            //Chat fragmentet bruger internet og video chat, og derfor undersøger vi om der er wifi.
            ConnectivityManager connManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

            if (mWifi.isConnected()) { //Hvis der er wifi åbnes fragmentet uden viddere
                Log.d("Wifi", "WIFI is connected");
                Toast.makeText(getActivity(), "WIFI connected", Toast.LENGTH_SHORT).show();
                Bundle args = new Bundle();
                args.putInt("Pos",3);
                FragmentActivityman f = new FragmentActivityman();
                f.setArguments(args);
                //fragment_activityman_lay.setArguments(args);
                getFragmentManager().beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .replace(R.id.fragmentindhold1, f)
                        .addToBackStack(null)
                        .commit();
                Log.d("Click","Opening Chat");
            }

            else { // Hvis ikke der er wifi , bliver brugeren bedt om at forsætte selvom der ikke er tilsluttet wifi.
                AlertDialog.Builder internetconect = new AlertDialog.Builder(getActivity());
                internetconect.setTitle("Internet forbindelse");
                internetconect.setMessage("Denne aktivitet kræver internet. Vi foreslår en sikker WiFi conection.\nEr du tilsluttet en internet forbindelse?");
                internetconect.setPositiveButton("Ja, jeg har internet",new AlertDialog.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getActivity(), "Network connected", Toast.LENGTH_SHORT).show();
                        Bundle args = new Bundle();
                        args.putInt("Pos",3);
                        FragmentActivityman f = new FragmentActivityman();
                        f.setArguments(args);
                        //fragment_activityman_lay.setArguments(args);
                        getFragmentManager().beginTransaction()
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .replace(R.id.fragmentindhold1, f)
                                .addToBackStack(null)
                                .commit();
                        Log.d("Click","Opening Chat");
                    }
                });
                internetconect.setNegativeButton("Nej, jeg har ikke internet", new AlertDialog.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(getActivity(), "Du har ikke internetforbindelse.\nPrøv igen når du har forbindelse", Toast.LENGTH_LONG).show();
                    }
                });
                internetconect.show();
            }

        }

        else if (position == 4){ //Note fragment
            Bundle args = new Bundle();
            args.putInt("Pos",4);
            FragmentActivityman f = new FragmentActivityman();
            f.setArguments(args);
            //fragment_activityman_lay.setArguments(args);
            getFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentindhold1,f )
                    .addToBackStack(null)
                    .commit();
            Log.d("Click","Opening Notes");
        } else if (position == 5) { //login AlertDialog)
            Intent i = new Intent(mainlist_fragment.this.getActivity(),Loginakt.class);
            startActivity(i);
            System.out.println("Åbner loginaktivitet");
        }

        else {

            Toast.makeText(getActivity(), "There is no activity for this position yet", Toast.LENGTH_SHORT).show();
        }
    }

}
