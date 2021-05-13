package site.muzhi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lichuang
 * @date 2021/05/13
 * @description 日期格式类
 */
public class DateUtil {

    /**
     * 日期时间格式
     */
    public final static String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式
     */
    public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String d = dateFormat.format(date);
        return d;
    }

    public static String format(Date date) {
        return format(date, DEFAULT_DATE_TIME_PATTERN);
    }

    public static Date parse(String date, String pattern) throws ParseException {
        if (date == null || "".equals(date)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date d = dateFormat.parse(date);
        return d;
    }

    public static Date parse(String date) throws ParseException {
        return parse(date, DEFAULT_DATE_TIME_PATTERN);
    }
}
