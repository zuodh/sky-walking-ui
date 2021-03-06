package org.skywalking.apm.ui.tools;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * @author pengys5
 */
public class TimeTools {
    public static final String Minute = "minute";
    public static final String Hour = "hour";
    public static final String Day = "day";

    public static String format(long milliseconds) {
        Instant instant = Instant.ofEpochMilli(milliseconds);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, TimeZone.getDefault().toZoneId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss SSS");
        return dateTime.format(formatter);
    }

    public static long buildFullTime(String sliceType, long time) {
        if (Minute.equals(sliceType)) {
            return 0;
        } else if (Hour.equals(sliceType)) {
            return 0;
        } else if (Day.equals(sliceType)) {
            return 0;
        } else {
            throw new IllegalArgumentException("slice type error");
        }
    }

    public static String buildXAxis(String timeSliceType, String timeSlice) {
        if (Minute.equals(timeSliceType)) {
            String hourValue = timeSlice.substring(8, 10);
            String minuteValue = timeSlice.substring(10, 12);
            return hourValue + ":" + minuteValue;
        } else if (Hour.equals(timeSliceType)) {
            String dayValue = timeSlice.substring(6, 8);
            String hourValue = timeSlice.substring(8, 10);
            return dayValue + " " + hourValue;
        } else {
            String monthValue = timeSlice.substring(4, 6);
            String dayValue = timeSlice.substring(6, 8);
            return monthValue + "-" + dayValue;
        }
    }
}
