package com.join.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static final String PATTERN_FORMAT = "yyyy-MM-dd";
    public static final String DETAILED_PATTERN_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String instantToString(Instant date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());
        return formatter.format(date);
    }

    public static String instantToStringDetailed(Instant date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DETAILED_PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());
        return formatter.format(date);
    }
}
