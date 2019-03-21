//package travelOffice.models;
//
//import javafx.util.converter.LocalDateTimeStringConverter;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.IllegalFormatException;
//
//public class Date {
//
//    private int year;
//    private int month;
//    private int day;
//
//    public Date(int year, int month, int day) {
//        this.year = year;
//        this.month = month;
//        this.day = day;
//    }
//
//    public int getDay() {
//        return day;
//    }
//
//    public void setDay(int day) {
//        this.day = day;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public int getMonth() {
//        return month;
//    }
//
//    public void setMonth(int month) {
//        this.month = month;
//    }
//
//    @Override
//    public String toString() {
//        return this.day + "-" + this.month + "-" + this.year;
//    }
//
//    public static java.util.Date dateOf(String date) {
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        Character c = null;
//        if (date.charAt(2) == date.charAt(5)) {
//            c = date.charAt(2);
//        }
//        String[] split = date.split(c.toString());
//
//        sdf.applyPattern("dd"+c.toString()+"MM"+c.toString()+"yyyy");
//        java.util.Date newDate = null;
//        try {
//            newDate = sdf.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return newDate;
//    }
//
//    public static void validateDateString(String date) {
//        java.util.Date now = new java.util.Date();
//        Character c = null;
//        if (date.charAt(2) == date.charAt(5)) {
//            c = date.charAt(2);
//        }
//        String[] split = date.split(c.toString());
//        Long day = Long.valueOf(split[0]);
//        Long month = Long.valueOf(split[1]);
//        Long year = Long.valueOf(split[2]);
//
//        if (month < 1L || month > 12) {
//            throw new IllegalArgumentException("Błedna data - nie ma miesiąca " + month);
//        }
//    //    if (year < now.)
//    }
//}
