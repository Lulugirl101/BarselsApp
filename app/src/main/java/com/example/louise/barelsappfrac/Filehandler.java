package com.example.louise.barelsappfrac;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Louise on 01-04-2015.
 * source : http://www.learn2crack.com/2014/04/android-read-write-file.html
 */
public class Filehandler {

    String dirpath;
    File mappe;

    public Filehandler(String dir) {
            mappe = new File(dir,"BarselsNotes");
            mappe.mkdirs();
            Log.d("Filepath", Arrays.toString(mappe.list()));

    }

    public String[] fileList(){
            return mappe.list();
    }

    public void deletefile(String filename){
        String fpath = filename;
        File file = new File(mappe,fpath);
        file.delete();
        Log.d("Filehanlder","Delete fiele");
    }

    public File getMappe() {
        return mappe;
    }

    public Boolean write(String fname, String fcontent){
        try {
            String fpath =fname;
            Log.d("Filepath",fpath);
            File file = new File(mappe,fpath);

            // If file does not exists, then create it
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            Log.d("","So far so good");
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
        Log.d("file","Reading file");
        BufferedReader br = null;
        String response = null;
        try {
            StringBuffer output = new StringBuffer();
            String fpath = mappe+"/"+fname;
            br = new BufferedReader(new FileReader(fpath));
            String line = "";
            while ((line = br.readLine()) != null) {
                output.append(line +"\n");
            }
            response = output.toString();
            br.close();
            Log.d("Suceess", "Sucess");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }
}
