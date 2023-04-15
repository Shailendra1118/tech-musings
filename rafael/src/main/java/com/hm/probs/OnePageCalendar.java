package com.hm.probs;

public class OnePageCalendar {
    public static void main(String[] args) {
        int[][] calendar = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {2, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {3, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {4, 5, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                            };

        int month = 1;
        int days = calculateDays(month, calendar);
        System.out.println("Days: "+days);

    }

    private static int calculateDays(int month, int[][] calendar) {

        //find day of week for given month
        int day = calendar[1][1];
        int nextMonthDay = calendar[1][2];

        int fullWeeks = 7*4;
        int dayOfFullWeek = calendar[fullWeeks][month];
        int nextMonthFirstDay = calendar[1][month+1];
        // Thursday if month is Jan
        // 28th Thursday and Feb 1st is Monday
        int count = 0;
        while(dayOfFullWeek > nextMonthFirstDay) {
            dayOfFullWeek--;
            count++;
        }

        return fullWeeks+count;
    }
}
