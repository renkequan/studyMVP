package com.example.studyproject.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ren on 2017/6/20.
 * 日期时间工具类
 */

@SuppressWarnings({"unused", "WeakerAccess","SimpleDateFormat"})
public class DateUtil {

    public static int YEAR;
    public static int MONTH;
    public static int DAY;
    public static int HOUR;
    public static int MINUTE;
    public static int SECOND;
    public static int MILLISECOND;
    private static final DateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    public static int getDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static int getMinute() {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }

    public static int getHour() {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }

    public static int getSecond() {
        return Calendar.getInstance().get(Calendar.SECOND);
    }

    public static int getMilliSecond() {
        return Calendar.getInstance().get(Calendar.MILLISECOND);
    }

    public static int getYearFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonthFromDte(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDayFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMinuteFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getHourFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getSecondFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }


    private final static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    private final static SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");

    private final static SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");

    private final static SimpleDateFormat sdfDaymd = new SimpleDateFormat("MM-dd");

    private final static SimpleDateFormat sdfDayss = new SimpleDateFormat("yyyy-MM");

    private final static SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");

    private final static SimpleDateFormat sdfDayPot = new SimpleDateFormat("yyyy.MM.dd");

    private final static SimpleDateFormat sdfDaySlash = new SimpleDateFormat("yyyy/MM/dd");

    private final static SimpleDateFormat sdfDayCHS = new SimpleDateFormat("yyyy年MM月dd日");

    private final static SimpleDateFormat sdfHourTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurDate() {
        return (new StringBuilder().append(getYear()).append("-")
                .append((getMonth()) < 10 ? 0 : "")
                .append((getMonth()))
                .append("-")
                .append((getDay() < 10) ? 0 : "")
                .append((getDay()))).toString();

    }

    /**
     * 获取当前时间Date对象
     */
    public static Date getDate() {
        return new Date();
    }

    public static String getCurDateEndMonth() {
        return (new StringBuilder().append(getYear()).append("-")
                .append((getMonth()) < 10 ? 0 : "")
                .append(getMonth())).toString();
    }


    public static String getCurTime() { //获取当前具体时间 2017-08-29 12:32:23
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param millis 毫秒时间戳
     * @return 时间字符串
     */
    public static String millis2String(final long millis) {
        return millis2String(millis, DEFAULT_FORMAT);
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为format</p>
     *
     * @param millis 毫秒时间戳
     * @param format 时间格式
     * @return 时间字符串
     */
    public static String millis2String(final long millis, final DateFormat format) {
        return format.format(new Date(millis));
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 毫秒时间戳
     */
    public static long string2Millis(final String time) {
        return string2Millis(time, DEFAULT_FORMAT);
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 毫秒时间戳
     */
    public static long string2Millis(final String time, final DateFormat format) {
        try {
            return format.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 获取当前毫秒时间戳
     *
     * @return 毫秒时间戳
     */
    public static long getNowMills() {
        return System.currentTimeMillis();
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    public static long compare2Time(String day) {
        String time = new StringBuilder().append(String.valueOf(getYear())).append("-").append(String.valueOf((getMonth()) < 10 ? 0 : ""))
                .append(String.valueOf(getMonth())).append("-").append(day).append(" 00:00:00").toString();
        return (getNowMills() - string2Millis(time));
    }

    //获取当前月日期
    public static String getNowMonth() {
        String currentTime = millis2String(getNowMills());
        String[] mTime = currentTime.split(" ")[0].split("-");
        return (mTime[0] + "-" + mTime[1]);
    }

    //获取下月日期
    public static String getNextMonth() {
        String currentTime = millis2String(getNowMills());
        String[] mTime = currentTime.split(" ")[0].split("-");
        return (mTime[0] + "-" + String.valueOf(Integer.parseInt(mTime[1]) + 1));
    }

    /**
     * 返回指定时间【yyyyMMdd】字符串日格式
     */
    public static String getDayWithoutSymbol(Date date) {
        if (date == null) {
            return null;
        }
        return sdfDays.format(date);
    }

    /**
     * 返回指定时间【yyyy-MM】字符串日格式
     */
    public static String getYearAndMonth(Date date) {
        if (date == null) {
            return null;
        }
        return sdfDayss.format(date);
    }

    /**
     * 返回指定时间【yyyy-MM-dd】字符串日格式
     */
    public static String getYearAndMonthAndDay(Date date) {
        if (date == null) {
            return null;
        }
        return sdfDay.format(date);
    }

    /**
     * 返回指定时间【yyyy-MM-dd HH:MM】字符串日格式
     */
    public static String getYearAndMonthAndDayAndHourAndMin(Date date) {
        if (date == null) {
            return null;
        }
        return sdfHourTime.format(date);
    }

    /**
     * 返回指定时间【MM-dd】字符串日格式
     */
    public static String getMonthAndDay(Date date) {
        if (date == null) {
            return null;
        }
        return sdfDaymd.format(date);
    }

    /**
     * 功能：获取本周的开始时间
     */
    public static String startOfThisWeek() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return format.format(cal.getTime());
    }

    /**
     * 功能：获取输入时间的本周的开始时间
     */
    public static Date startOfThisWeekToDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * 功能：获取本周的结束时间
     */
    public static String endOfThisWeek() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        cal.add(Calendar.DATE, 6);
        return format.format(cal.getTime());
    }

    /**
     * 功能：获取输入时间的本周的结束时间
     */
    public static Date endOfThisWeekToDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        cal.add(Calendar.DATE, 6);
        return cal.getTime();
    }

    /**
     * 功能：获取当前月份的第一天
     */
    public static String startOfThisMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return format.format(c.getTime());
    }

    /**
     * 功能：获取当前月份的最后一天
     */
    public static String endOfThisMonth() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(ca.getTime());
    }

    /**
     * 当前日期的n天之后的日期【yyyy-MM-dd】字符串格式
     *
     * @param days
     * @return
     */
    public static String getAfterDayDate(int days) {
        // 获取当前时间
        Calendar canlendar = Calendar.getInstance();
        // 日期减 如果不够减会将月变动
        canlendar.add(Calendar.DATE, days);
        Date date = canlendar.getTime();
        return sdfDay.format(date);
    }

    /**
     * 得到n天之后的指定日期【yyyy-MM-dd】日期格式
     *
     * @param beginDate
     * @param days
     * @return 日期型
     */
    public static Date getAfterDayDate(Date beginDate, int days) {
        try {
            // 获取指定日期的n天之后的日期
            String dateStr = getAfterDayDateStr(beginDate, days);
            return sdfDay.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 得到指定日期的n天之后日期【yyyy-MM-dd】字符串格式
     *
     * @param beginDate
     * @param days
     * @return 字符型
     */
    public static String getAfterDayDateStr(Date beginDate, int days) {
        // 获取当前时间
        Calendar canlendar = Calendar.getInstance();
        // 设置指定日期
        canlendar.setTime(beginDate);
        canlendar.add(Calendar.DATE, days);
        Date date = canlendar.getTime();
        return sdfDay.format(date);
    }

    /**
     * 得到指定日期的n月之后的日期【yyyy-MM-dd HH:mm:ss】日期格式
     *
     * @param beginDate
     * @param months
     * @return 日期型
     */
    public static Date getAfterMonthDate(Date beginDate, int months) {
        try {
            Calendar canlendar = Calendar.getInstance();
            canlendar.setTime(beginDate);
            canlendar.add(Calendar.MONTH, months);
            Date date = canlendar.getTime();
            return sdfTime.parse(sdfTime.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 得到n天之后是周几
     *
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
        int daysInt = Integer.parseInt(days);
        Calendar canlendar = Calendar.getInstance(); // java.util包
        canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
        Date date = canlendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        return sdf.format(date);
    }

    /**
     * 两个日期相差月份
     *
     * @param d1 起始日期
     * @param d2 结束日期
     * @return
     */
    public static int getDateSpanMonth(Date d1, Date d2) {
        Calendar c = Calendar.getInstance();

        Date new_d2 = getAfterDayDate(d2, 1);
        c.setTime(new_d2);
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH);

        c.setTime(d1);
        int year2 = c.get(Calendar.YEAR);
        int month2 = c.get(Calendar.MONTH);

        int result;
        if (year1 == year2) {
            result = month1 - month2;
        } else {
            result = 12 * (year1 - year2) + month1 - month2;
        }
        return result;
    }

    /**
     * 两个日期比较大小（包含小时）
     *
     * @param d1 d2 d3,判断d3是否在d1和d2之间
     *           -1 值不合法为空，1 在d1和d2之间，0不在范围之间
     */
    public static int compareDateTime(Date d1, Date d2) {
        try {
            if (d1 == null || d2 == null) {
                return -1;
            }
            if (d1.getTime() <= d2.getTime()) {
                return 1;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 两个日期比较大小（忽略小时，只比较日期）
     *
     * @param d1
     * @param d2
     * @return -1:d1在d2前；0:等于；1:d1在d2后
     */
    public static int compareDate(Date d1, Date d2) {
        try {
            int dt1 = Integer.parseInt(getDayWithoutSymbol(d1));
            int dt2 = Integer.parseInt(getDayWithoutSymbol(d2));
            if (dt1 < dt2) {
                return -1;
            } else if (dt1 > dt2) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * 返回指定日期Date格式【yyyy-MM-dd】字符串格式
     */
    public static Date fomatDate(String date) {
        try {
            return sdfDay.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回指定日期Date格式【yyyy-MM】字符串格式
     */
    public static Date fomatDateEndMonth(String date) {
        try {
            return sdfDayss.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回当前时间【yyyyMMdd】字符串格式
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    public static void main(String[] args) {
        int i = compareDate(fomatDate("2016-06-01 00:00"), fomatDate("2016-06-02 00:00"));
        Date d = getAfterMonthDate(new Date("2016/08/31"), 6);
        System.out.println(getDays());
        System.out.println(getAfterDayWeek("3"));
    }

    public static String dateToStamp(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(time);
        long ts = date.getTime();
        return String.valueOf(ts);
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(long timeMillis) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timeMillis);
        return simpleDateFormat.format(date);
    }


    /**
     * <li>功能描述：时间相减得到天数
     *
     * @param beginDateStr
     * @param endDateStr
     * @return long
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr, String endDateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * <li>功能描述：时间相减得到天数
     *
     * @param beginDate
     * @param endDate
     * @return long
     * @author Administrator
     */
    public static long getDaySub(Date beginDate, Date endDate) {
        return (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = sdfHourTime.parse(strDate, pos);
        return strtodate;
    }
}
