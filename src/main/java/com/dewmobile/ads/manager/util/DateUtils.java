package com.dewmobile.ads.manager.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateUtils {
    public static String defaultStartTime() {
        return LocalDate.now().minusDays(10).toString();
    }

    public static String defaultEndTime() {
        return LocalDate.now().toString();
    }
}
