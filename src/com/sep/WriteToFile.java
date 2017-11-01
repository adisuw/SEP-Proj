/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sep;

import com.sep.ui.RegisterClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ema
 */
public class WriteToFile {

    private Formatter output;

    public void openFile() {
        try {
            output = new Formatter("clients.txt"); // open the file
        } // end try
        catch (SecurityException securityException) {
            JOptionPane.showMessageDialog(null,"You do not have write access to this file.");
            System.exit(1); // terminate the program
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Exception caught: " + ex);
        }

    }

    public void addRecords() {

        Client record = new Client();
        RegisterClient reg = new RegisterClient();

        try {

            record.setFirstName(reg.getTxtFname());
            record.setLastName(reg.getTxtLname());
            record.setSsn(reg.getTxtPrNum());
            String a = reg.getTxtAge();
            String i = reg.getTxtRecordID();
            //record.setAge(Integer.parseInt(a));
            //record.setId(Integer.parseInt(i));
            
            output.format("%s %s %s %d %d\n", record.getFirstName(), record.getLastName(),
                    record.getSsn(), 123, 21);
            JOptionPane.showMessageDialog(null, record.getFirstName());
        } catch (FormatterClosedException formatterClosedException) {
            JOptionPane.showMessageDialog(null,"Error writing to file.");
        } // end catch
        catch (NoSuchElementException elementException) {
            JOptionPane.showMessageDialog(null,"Invalid input. Please try again.");

        }
    }
    public void closeFile(){
        if(output != null){
            output.close();
        }
    }
    public static void readRecords(){
        try {
            Scanner scan = new Scanner(new File("clients.txt"));
            Client cl = new Client();
            System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "First Name","Last Name", "Pr. Num", "Age", "ID");
            while(scan.hasNext()){
                cl.setFirstName(scan.next());
                cl.setLastName(scan.next());
                cl.setSsn(scan.next());
                cl.setAge(scan.nextInt());
                cl.setId(scan.nextInt());
                System.out.printf("%-10s %-10s %-10s %-10d %-10d\n", cl.getFirstName(),cl.getLastName(),
                        cl.getSsn(), cl.getAge(), cl.getId());
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
