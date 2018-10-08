package com.company.geoapp.handlers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {

    private TimeUtils() {
    }

    public static String unixTimestampToLocalDateTime(long timestamp) {
        Date date = new Date(timestamp * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }
}
