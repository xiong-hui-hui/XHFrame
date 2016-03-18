package com.xiong.tuan.utils;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by bingbing.tu
 * 2015/8/14.
 */
public class DateUtils {

    public static String[] weekName = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

    public static int getMonthDays(int year, int month) {
        if (month > 12) {
            month = 1;
            year += 1;
        } else if (month < 1) {
            month = 12;
            year -= 1;
        }
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            arr[1] = 29; // 闰年2月29天
        }

        try {
            days = arr[month - 1];
        } catch (Exception e) {
            e.getStackTrace();
        }

        return days;
    }

    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public static int getCurrentMonthDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static int getWeekDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }

    public static int getHour() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }

    public static int[] getWeekSunday(int year, int month, int day, int pervious) {
        int[] time = new int[3];
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.add(Calendar.DAY_OF_MONTH, pervious);
        time[0] = c.get(Calendar.YEAR);
        time[1] = c.get(Calendar.MONTH) + 1;
        time[2] = c.get(Calendar.DAY_OF_MONTH);
        return time;

    }

    public static int getWeekDayFromDate(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDateFromString(year, month));
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return week_index;
    }

    public static Date getDateFromString(int year, int month) {
        String dateString = year + "-" + (month > 9 ? month : ("0" + month))
                + "-01";
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return sdf.format(date);
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        return sdf.format(date);
    }

    public static String formatDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return sdf.format(c.getTime());
    }

    public static Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.CHINA);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, String> getHolidaysOfMonth(int year, int month) {
        Map<String, String> holidayMap = new HashMap<>();
        int lastDay = getMonthDays(year, month);
        Calendar c = Calendar.getInstance();
        for (int day = 1; day <= lastDay; day++) {
            c.set(year, month - 1, day);
            String holiday = Lunar.getHoliday(c.getTime());
            if (holiday != null)
                holidayMap.put(formatDate(c.getTime()), holiday);
        }
        return holidayMap;
    }

    public static List<String> getUpDownYears(int delay) {
        List<String> years = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);

        for (int up = delay; up > 0; up--) {
            years.add(String.format("%d年", cYear - up));
        }
        years.add(String.format("%d年", cYear));

        for (int down = 1; down <= delay; down++) {
            years.add(String.format("%d年", cYear + down));
        }
        return years;
    }

    public static List<String> getUpYears(int delay) {
        List<String> years = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);

        for (int up = delay; up > 0; up--) {
            years.add(String.format("%d年", cYear - up));
        }
        years.add(String.format("%d年", cYear));
        return years;
    }

    public static List<String> getDownYears(int delay) {

        List<String> years = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);
        years.add(String.format("%d年", cYear));
        for (int down = 1; down <= delay; down++) {
            years.add(String.format("%d年", cYear + down));
        }
        return years;
    }

    public static List<String> getMonths() {
        List<String> months = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            months.add(String.format("%d月", month));
        }
        return months;
    }

    public static List<String> getDayList(int year, int month) {
        int days = getMonthDays(year, month);
        List<String> dayList = new ArrayList<>();
        for (int day = 1; day <= days; day++) {
            dayList.add(String.format("%d日", day));
        }
        return dayList;
    }

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getAge(String birthday) {
        try {
            if (TextUtils.isEmpty(birthday))
                return 0;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            Date birthdayDate = sdf.parse(birthday);
            String currTimeStr = sdf.format(new Date());
            Date currDate = sdf.parse(currTimeStr);
            if (birthdayDate.getTime() > currDate.getTime()) {
                return 0;
            }
            long age = (currDate.getTime() - birthdayDate.getTime())
                    / (24 * 60 * 60 * 1000) + 1;
            String year = new DecimalFormat("0.00").format(age / 365f);
            if (TextUtils.isEmpty(year))
                return 0;
            return new Double(year).intValue() + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public static int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static String daysBetween(String smdate, String bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        Calendar cal = Calendar.getInstance();
        long between_days = 0;
        try {
            cal.setTime(sdf.parse(smdate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(bdate));
            long time2 = cal.getTimeInMillis();
            between_days = (time2 - time1) / (1000 * 3600 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(between_days + 1);
    }

    public static boolean isBeforeCurrentMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        int cYear = c.get(Calendar.YEAR);
        int cMonth = c.get(Calendar.MONTH);
        if(cYear > year) return true;
        if(cYear < year) return false;
        if(cYear == year){
            if(cMonth < month) return false;
            if(cMonth > month) return true;
        }
        return false;
    }
}
