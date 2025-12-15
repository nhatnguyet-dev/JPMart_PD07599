package com.example.jpmart_pd07599_v1.middleware;

import android.widget.DatePicker;

public class DatePickerFormat {
    public static String getDateFromPicker(DatePicker dp) {
        int day = dp.getDayOfMonth();
        int month = dp.getMonth() + 1;
        int year = dp.getYear();

        return year + "-"
                + String.format("%02d", month) + "-"
                + String.format("%02d", day);
    }
}
