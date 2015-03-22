package com.example.louise.barelsappfrac;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


import com.example.louise.barselsapp.R;


public class Chat_frag extends Fragment {
     private String curentURL;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("View","Setting up web wiev");
        View web = inflater.inflate(R.layout.char_frag_layout,container,false);
        WebView wv = (WebView) web.findViewById(R.id.webViewchat);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("\"http://javabog.dk\"");

        // Inflate the layout for this fragment
        return web;
    }








}
