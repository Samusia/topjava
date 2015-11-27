package ru.javawebinar.topjava.util;

import java.time.LocalTime;

/**
 * Created by Samusia
 * on 27.11.2015.
 */
public class TimeUtil {
    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }
}
