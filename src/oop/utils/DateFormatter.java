/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.utils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author kucik
 */
class DateFormatter {

    private static final DateTimeFormatter formatter;

    static {
        formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
    }

    private DateFormatter() {
    }

    protected static String dateToString(LocalDate date) {
        return formatter.format(date);
    }

    protected static LocalDate textToDate(String dateText) {
        return LocalDate.parse(dateText);
    }
    
    protected static String createCurrentTime(){
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        return DateFormat.getInstance().format(date);
    }

}
