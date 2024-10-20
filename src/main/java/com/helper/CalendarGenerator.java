package com.helper;

import java.util.Calendar;

public class CalendarGenerator {
    public static String[][] generateCalendar(int year) {
        String[][] calendar = new String[12][7]; // 12 months, 7 days a week

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_MONTH, 1); // Set to the first day of the year

        int month = 0;
        while (month < 12) {
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1 for Sunday, 2 for Monday, ..., 7 for Saturday
            int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

            calendar[month][dayOfWeek - 1] = String.valueOf(dayOfMonth);

            cal.add(Calendar.DAY_OF_MONTH, 1); // Move to the next day
            if (cal.get(Calendar.MONTH) > month) {
                month++;
            }
        }

        return calendar;
    }
}
