/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.scrapping.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Prajwal
 */
public class Grabber {

    public URLConnection connect(String link) throws IOException {
        URL url = new URL(link);
        return url.openConnection();
    }

    public String getBody(String link) throws IOException {

        URLConnection conn = connect(link);

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        StringBuilder content = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            content.append(line+"\r\n");
            reader.close();
        }
        return content.toString();
    }
    public void downloader(String path, String filename) throws IOException{
        URLConnection conn = connect(path);
        InputStream is = conn.getInputStream();
        FileOutputStream os = new   FileOutputStream(filename);
        byte[] data = new byte[1024];
         int i=0;
         while((i=is.read(data))!=-1){
             os.write(data, 0, i);
         }
  is.close();
  os.close();
}
}