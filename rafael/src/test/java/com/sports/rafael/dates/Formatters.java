package com.sports.rafael.dates;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Formatters {

    @Test
    public void testDiffDates() throws ParseException {
        String str = "01-10-2022";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(str);
        System.out.println(date);

        LocalDateTime dateTime = LocalDateTime.parse("2022-10-22T12:00:00");
        System.out.println("localDate: "+dateTime.getMonth()+" "+dateTime.getYear()+" "+dateTime.getDayOfMonth());
        System.out.println("localTime: "+dateTime.getHour()+" "+dateTime.getMinute()+" "+dateTime.getSecond());

        String dateInString = "19590709";
        LocalDate date1 = LocalDate.parse(dateInString, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("date1: "+date1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-05-05 12:10:00 GMT", formatter);
        System.out.println("zonedDateTime: "+zonedDateTime);
    }
}
