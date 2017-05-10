package cn.zsy.eg.Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarDemo {


    private static SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {

        //获取calendar实例;
        Calendar calendar = Calendar.getInstance();

        //判断calendar是不是GregorianCalendar类的实例;
        if (calendar instanceof GregorianCalendar) {
            System.out.println("属于GregorianCalendar类的实例!");
        }

        //从calendar对象中获得date对象，当前时间;
        Date dates = calendar.getTime();

        //格式化时间;
        String date_str = date_format.format(dates);
        System.out.println(date_str);

        //设置月份05；代表日历的月份6月，因为月份从0开始。
        calendar.set(Calendar.MONTH, 05);

        int months = calendar.get(Calendar.MONTH);
        System.out.println(months);  //输出05;

        //设置日期为2011-07-24 09：59:50
        calendar.set(2011, 06, 24, 9, 59, 50);
        String getDate = date_format.format(calendar.getTime());
        System.out.println(getDate);   //输出2011-07-24 09:59:50;

        //比较日前大小;
        if (new Date().getTime() > calendar.getTimeInMillis()) {
            System.out.println("当前日期在后!");
        } else {
            System.out.println("当前日期在前!");
        }

        //设置当前时间为:2011-07-24 11:06:00
        calendar.setTime(new Date());
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  //获取当月的月末
        int minDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);  //获取当月的月初
        int year = calendar.get(Calendar.YEAR);   //获取年;
        int month = calendar.get(Calendar.MONTH);  //获取月;
        int date = calendar.get(Calendar.DATE);   //获取天;
        int hour = calendar.get(Calendar.HOUR);   //获取小时;
        int minute = calendar.get(Calendar.MINUTE); //获取分钟;
        int second = calendar.get(Calendar.SECOND); //获取秒钟;
        int hour_of_day = calendar.get(Calendar.HOUR_OF_DAY);    //第几个小时，
        int day_of_month = calendar.get(Calendar.DAY_OF_MONTH); //这天，在一个月内是第几天.
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);    //这天，在一周内，是第几天.
        int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);    //这天，在一年内，是第几天。
        int week_of_year = calendar.get(Calendar.WEEK_OF_YEAR);  //这周，在一年内是第几周;
        int week_of_month = calendar.get(Calendar.WEEK_OF_MONTH);//这周，在这个月是第几周;以以星为标准；
        int zone_offset = calendar.get(Calendar.ZONE_OFFSET);    //获取时区;
        int day_of_week_in_month = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);  //某月中第几周，按这个月1号算，1号起就是第1周，8号起就是第2周。以月份天数为标准
        int r = calendar.get(Calendar.AM_PM);
        if (r == calendar.AM) {
            System.out.println("现在是上午");
        }

        if (r == calendar.PM) {
            System.out.println("现在是下午");
        }
        System.out.println("==================================================");
        System.out.println(maxDay);
        System.out.println(minDay);
        System.out.println(year);
        System.out.println(month);
        System.out.println(date);
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
        System.out.println(hour_of_day);
        System.out.println(day_of_month);
        System.out.println(day_of_week);
        System.out.println(day_of_year);
        System.out.println(week_of_year);
        System.out.println(week_of_month);
        System.out.println(zone_offset);
        System.out.println(day_of_week_in_month);
    }

}
