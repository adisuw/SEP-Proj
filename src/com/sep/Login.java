/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sep;

/**
 *
 * @author ema
 */
public class Login {

    private String username = null;
    private String password = null;
    private String role = null;

    public Login(String user, String pass, String role) {
        username = user;
        password = pass;
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean authenticat(String user, String pass, String role) {

        if (this.username.equals(user) && this.password.equals(pass) && this.role.equals(role)) {
            return true;
        } else {
            return false;
        }
    }
}
