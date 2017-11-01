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
public class Client {

    private String firstName;
    private String lastName;
    private String ssn;
    private int id;
    private int age;

    public Client() {
    }

    public Client(String name, int id) {
        setFirstName(name);
        setId(id);
    }

    public Client(String firstName, String lastName, String ssn, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
        this.ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

}
