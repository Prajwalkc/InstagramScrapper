/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lfa.scrapping;

import edu.lfa.scrapping.util.Grabber;
import java.io.File;

import java.io.IOException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Prajwal
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
try{
        String baseUrl = "http://instagram.com/";
        System.out.println("Enter the name you want to search");
    Scanner input= new Scanner(System.in);
    String name = input.nextLine();
     Grabber grab = new Grabber();
  String regEx = "http://(.*?).jpg";
    Pattern pattern = Pattern.compile(regEx);
    Matcher matcher= pattern.matcher(grab.getBody(baseUrl+name));
    while(matcher.find()){
        String imgpath = matcher.group(0);
        String path = (imgpath);
        String[] tokens =path.split("/");
        File file = new File("e://instapics");
        if(!file.isDirectory())
        {
            file.mkdir();
        }
        
        File file1 = new File("e://instapics/"+name);
        if(!file1.isDirectory()){
            file1.mkdir();
        }
        System.out.println("Downloadinggg............."+name);
    grab.downloader(path, "e://instapics"+name+"/"+tokens[tokens.length-1]);
    }
}catch(IOException ioe){
        System.out.println(ioe.getMessage());
    }
    
}
}