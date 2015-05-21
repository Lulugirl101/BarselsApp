package com.example.louise.barelsappfrac.info;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.louise.barelsappfrac.FragmentActivityman;
import com.example.louise.barselsapp.R;

 /*
*  @author Louise Janø
*
* Info omkring Ambualnt fødsel.
* Kilde : Mit barsels forløb, af Nordsjællands Hospital, Gynækologisk-Obstetrisk afdeling, Region Hovedstaden
* */


public class Ambulantfoedsel extends Fragment implements View.OnClickListener {
    ImageView chat;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ambulantfoedsel, container, false);
        chat = (ImageView)v.findViewById(R.id.nychat);
        chat.setOnClickListener(this); //Mulighed for at åbnechat
        return v;
    }


    @Override
    public void onClick(View v) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();} //Ryder back stack, så vi ikke bygger en stack af page viewers op
            Bundle args = new Bundle();
            args.putInt("Pos", 3);
            FragmentActivityman f = new FragmentActivityman();
            f.setArguments(args);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fragmentindhold1, f)
                    .addToBackStack(null)
                    .commit();
            Log.d("Click", "Opening Chat");
        }

}
