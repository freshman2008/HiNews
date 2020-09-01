package com.example.commonlib.utils;

import java.util.Date;

public class DatetimeUtils {
    public static String getDateInfo(String str) {
        Date date = new Date(str);
        return date.toString();

//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = sdf.parse(str);
//            return date.toString();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return "";
    }
}
