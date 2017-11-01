/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ema
 */
public class ReadWriteFile {
    Scanner scan;
    Formatter output;
    String file;
    public ReadWriteFile(String file){
        this.file = file;
    }
    public void openForReading(){
        try {
            scan = new Scanner(new File(file));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Unable to open the file! "+ex);
        }
    }
    public void openForWriting(){
        try {
            output = new Formatter(file);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Unable to open the file! "+ex);
        }
    }
    public void readRecords(){
        
    }
    public void writeEvents(){
        
    }
    public void writeRecords(int id, String fn, String event, String from, String to, int atend, double bud, String pref, String s){
        openForWriting();
        output.format("%-5d %-5s %-5s %-5s %-5s %-5d %-5.2f %-5s %-5s\n", id, fn, event, from, to, atend, bud, pref, s);
        closeWriting();
    }
     public void closeFile(){
         if(scan != null){
             scan.close();
         }
     }
     public void closeWriting(){
         if(output != null){
             output.close();
         }
     }
}
