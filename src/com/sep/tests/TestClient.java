/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sep.tests;

/**
 *
 * @author ema
 */
import com.sep.Client;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
public class TestClient {
    
    public void registerClient(){
        
         Client client = new Client( "Abebe", "Zegeye","1234-44", 27,1);
         
         assertEquals(1, client.getId());
         assertEquals("Abebe", client.getFirstName());
         assertEquals(27, client.getAge());
         assertEquals("1234-44", client.getSsn());
         
    }
     public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
     } catch (ParseException e) {
         return null;
     }
  }
    public static void main(String[] a){
       TestClient test = new TestClient();
       test.registerClient();
       String from = "2017-10-17";
       Date date = new Date(17,10,17);
       System.out.println("The date is: "+ TestClient.parseDate(from));
       System.out.println("The date is: "+ date);
       
       // System.err.println("The date is : "+date.getYear()+"-"+date.getMonth()+"-"+date.getDate());
    }
    
}
