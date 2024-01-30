package org.masonord.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMinutes = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMinutes, TimeUnit.MILLISECONDS);
    }

    public static Date parseStringToDate(String strDate, String strTime) throws ParseException {
        Date date = formatter.parse(
                buildValidDate(strDate) + " " + strTime + ":00"
        );
        return date;
    }

    private static String buildValidDate(String strDate) {
        StringBuilder result = new StringBuilder();
        int doteCount = 0;
        for (char c : strDate.toCharArray()) {
            if (c == '.') {
                doteCount++;
                result.append('-');
                continue;
            }
            if (doteCount == 2) {
                result.append("20");
                doteCount = -1;
            }

            result.append(c);
        }

        return result.toString();
    }
}
