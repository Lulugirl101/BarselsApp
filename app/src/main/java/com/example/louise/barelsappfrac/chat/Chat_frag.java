package com.example.louise.barelsappfrac.chat;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.example.louise.barselsapp.R;

/**Chat Fragment
 * På nuværnde tidpunkt indeholder den kun et webview, der skal udvides med en chat service QuikBox
 * TODO: QuikBox**/

 public class Chat_frag extends Fragment {

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
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://javabog.dk");

        // Inflate the layout for this fragment
        return web;
    }








}
