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
/* private Client client;
    private String eventType;
    private Date from;
    private Date to;
    private int atendee;
    private String preference;
    private float budget;
    private String detail;*/
import com.sep.Client;
import static junit.framework.Assert.assertEquals;
import com.sep.Event;
import com.sep.Login;
import java.util.Scanner;

public class TestEvent {

    public static void testEvent() {
         Client client = new Client( "Abebe", "Zegeye","1234-44", 27,1);
        int cId = client.getId();
        String name = client.getFirstName();
        Event event = new Event(client, "Party", "2017-10-7", "2017-10-9", 200, 2000.00, "In the deco i don't want...");

        assertEquals(1, client.getId());
        assertEquals("Abebe", client.getFirstName());
        assertEquals("Party", event.getEventType());
        //assertEquals("2017-10-7", event.getFrom());
        //assertEquals("2017-10-9", event.getTo());
        assertEquals(200, event.getAtendee());
        assertEquals(2000.00, event.getBudget());
        assertEquals("In the deco i don't want...", event.getDetail());
    }

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        String user, pass;
        boolean val = true;
        while (val) {
            System.out.println("Enter user name: ");
            user = scan.next();
            System.out.println("Enter user password: ");
            pass = scan.next();
            Client client = new Client();
            Login log = new Login(user, pass, "cs");
            if (log.authenticat("adis", "123", "cs")) {
                System.out.println("Welcome Customer Service");
                System.out.println("Register Client here...");
                System.out.println("Enter client name: ");
                client.setFirstName(scan.next());
                val = false;
            } else {
                System.out.println("invalid credential");
            }

        }

        TestEvent.testEvent();
    }

}
