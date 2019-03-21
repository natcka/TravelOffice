package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return this.day + "-" + this.month + "-" + this.year;
    }

    public static java.util.Date dateOf(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Character c = null;
        if (date.charAt(2) == date.charAt(5)) {
            c = date.charAt(2);
        }
        String[] split = date.split(c.toString());

        if (Long.valueOf(split[1]) > 12 || Long.valueOf(split[1]) < 1) {
          //  throw new IllegalFormatException();
        }

        sdf.applyPattern("dd"+c.toString()+"MM"+c.toString()+"yyyy");
        java.util.Date newDate = null;
        try {
            newDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
