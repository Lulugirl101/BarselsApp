package com.example.louise.barelsappfrac;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Louise on 01-04-2015.
 * source : http://www.learn2crack.com/2014/04/android-read-write-file.html
 */
public class Filehandler {
    public Filehandler() {
    }
    public Boolean write(String fname, String fcontent, String dir){
        try {
            String fpath = dir+fname+".txt";
            Log.d("Filepath",fpath);
            File file = new File(fpath);
            // If file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fcontent);
            bw.close();
            Log.d("Suceess", "Sucess");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public String read(String fname){
        BufferedReader br = null;
        String response = null;
        try {
            StringBuffer output = new StringBuffer();
            String fpath = "/sdcard/"+fname+".txt";
            br = new BufferedReader(new FileReader(fpath));
            String line = "";
            while ((line = br.readLine()) != null) {
                output.append(line +"\n");
            }
            response = output.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }
}
