/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ema
 */
public class Event {

    private Client client;
    private String eventType;
    private Date from;
    private Date to;
    private int atendee;
    private List<String> preference = new ArrayList<>();
    private String pre;
    private double budget;
    private String detail;

    public Event() {
        ;
    }

    public Event(Client client, String eventType, String from, String to, int atendee, double budget, String detail) {
        this.client = client;
        this.eventType = eventType;
        this.from = parseDate(from);
        this.to = parseDate(to);
        this.atendee = atendee;
        this.budget = budget;
        this.detail = detail;
    }

    public String getPre() {
        
        return pre;
    }

    public Client getClient() {
        return client;
    }

    public String getEventType() {
        return eventType;
    }

    public String getFrom() {
        return parseString(from);
    }

    public String getTo() {
        return parseString(to);
    }

    public int getAtendee() {
        return atendee;
    }

    public List<String> getPreference() {
        return preference;
    }

    public double getBudget() {
        return budget;
    }

    public String getDetail() {
        return detail;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setFrom(String from) {
        this.from = parseDate(from);
    }

    public void setTo(String to) {
        this.to = parseDate(to);
    }

    public void setAtendee(int atendee) {
        this.atendee = atendee;
    }

    public void setPreference(ArrayList<String> preference) {
        this.preference = preference;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String parseString(Date date) {

        Date dat = date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dat);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String convDate = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day);

        return convDate;
    }
}
