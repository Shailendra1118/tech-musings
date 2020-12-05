package com.sports.rafael;
/*You want to calculate estimated shipping date. It takes 5 days to prepare for the order.
    There can be multiple holidays coming between today (order date) and 5 days from now. Calculate shipping date for the order.

        Assumption:
        Saturdays and Sundays are holidays.
        List of holidays are predefined.
        Input:
        a. Order date today
        b. List<Date> public holidays
        c. Number of days from start date.

public Date getShippingDate(Date today, List<Date> holidays, int orderPreparationDays) {

        }
        1. Follow the coding standards.
        2. Optimize the code.
        3. write unit tests for the different scenarios.

 */


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Epam {

    public static void main(String[] args) {

    }

    public Date getShippingDate(LocalDate today, List<LocalDate> holidays, long orderPreparationDays) {

        //total number of estimated from today
        LocalDate estimated = today.plusDays(orderPreparationDays); // 5



        //count the applicable holidays from today's date to estimated date

        // find sat/sun from today to estimated date
        // if ith date is contained by holidays || if(isWeekend)
        // count++;

        // return the estimated date.plus(count)


        //

        return null;

    }
}
