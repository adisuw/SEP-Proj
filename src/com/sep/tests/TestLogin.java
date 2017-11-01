/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sep.tests;

import com.sep.Login;
import java.util.Scanner;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author ema
 */
public class TestLogin {

    public static void testLogin(String user, String pass, String role) {
        Login log = new Login(user, pass, role);
        assertEquals(true, log.authenticat("adis", "123", "cs"));
    }

    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        String user, pass, role;
        System.out.print("Enter user name: ");
        user = scan.next();
        System.out.print("Enter user pass: ");
        pass = scan.next();
        System.out.print("Enter user role: ");
        role = scan.next();
        TestLogin.testLogin(user, pass, role);
        
    }
}
