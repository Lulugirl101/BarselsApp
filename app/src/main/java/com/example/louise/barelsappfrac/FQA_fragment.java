package com.example.louise.barelsappfrac;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.louise.barselsapp.R;

// Frequentlt asked questions. Skal indeholde en liste med mest stillede spørgsmål
// TODO: Make list with questions, That exspand.
public class FQA_fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fqa_fragment, container, false);
    }








}
