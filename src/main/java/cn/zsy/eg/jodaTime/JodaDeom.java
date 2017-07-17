package cn.zsy.eg.jodaTime;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.Calendar;
import java.util.Date;

public class JodaDeom {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateTime dateTime = new DateTime(2017, 07, 17, 15, 02 ,0, 0);
        System.out.println(dateTime.toString("E MM/dd/yyyy HH:mm:ss.SSS"));
        //向某一个瞬间加上 15 天并输出结果
        System.out.println(dateTime.plusDays(15).toString("E MM/dd/yyyy HH:mm:ss.SSS"));
        //距离 Y2K 45 天之后的某天在下一个月的当前周的最后一天的日期。
        System.out.println(dateTime.plusDays(45).plusMonths(1).dayOfWeek()
            .withMaximumValue().toString("E MM/dd/yyyy HH:mm:ss.SSS"));
        calendar.setTime(dateTime.toDate()); //将 Joda 计算结果插入到 JDK 对象中
        System.out.println(calendar.getTime().toString());
        System.out.println(dateTime.toString(ISODateTimeFormat.basicDateTime()));
        System.out.println(dateTime.toString(ISODateTimeFormat.basicDateTimeNoMillis()));
        System.out.println(dateTime.toString(ISODateTimeFormat.basicOrdinalDateTime()));
        System.out.println(dateTime.toString(ISODateTimeFormat.basicWeekDateTime()));
        System.out.println("========================================");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.minusMonths(1).dayOfMonth().withMaximumValue());  //计算上一个月的最后一天

        //解析文本格式时间
        System.out.println("----------------解析文本格式时间---------------");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTimeC = DateTime.parse("2017-07-21 23:22:45", format);
        System.out.println(dateTimeC.toString("yyyy/MM/dd HH:mm:ss EE"));

        //在某个日期上加上90天并输出结果
        System.out.println("-------------在某个日期上加上90天并输出结果--------------");
        DateTime dateTimeD = new DateTime(2016, 1, 1, 0, 0, 0, 0);
        System.out.println(dateTimeD.plusDays(90).toString("E MM/dd/yyyy HH:mm:ss.SSS"));

        //到新年还有多少天
        System.out.println("-----------------------到新年还有多少天-----------------------");
        System.out.println(daysToNewYear(new LocalDate()).getDays());

        //与JDK日期对象的转换
        System.out.println("----------------------------与JDK日期对象的转换----------------------------");
        DateTime dt = new DateTime();
        //转换成java.util.Date对象
        Date d1 = new Date(dt.getMillis());
        Date d2 = dt.toDate();
        System.out.println("dt: " + dt.toString("E MM/dd/yyyy HH:mm:ss.SSS"));
        System.out.println("d1: " + d1.toString());
        System.out.println("d2: " + d2.toString());

        //时区
        //默认设置为日本时间
        System.out.println("-------------时区--------------");
        DateTimeZone.setDefault(DateTimeZone.forID("Asia/Tokyo"));
        DateTime dt1 = new DateTime();
        System.out.println(dt1.toString("yyyy-MM-dd HH:mm:ss"));
        //伦敦时间
        DateTime dt2 = new DateTime(DateTimeZone.forID("Europe/London"));
        System.out.println(dt2.toString("yyyy-MM-dd HH:mm:ss"));
        //中国时间
        DateTimeZone.setDefault(DateTimeZone.forID("Asia/Shanghai"));
        DateTime dt3 = new DateTime();
        System.out.println(dt3.toString("yyyy-MM-dd HH:mm:ss"));
        //计算间隔和区间
        System.out.println("-------------计算间隔和区间--------------");
        DateTime begin = new DateTime("2015-02-01");
        DateTime end = new DateTime("2015-02-02");
        //计算区间毫秒数
        Duration d = new Duration(begin, end);
        long millis = d.getMillis();
        System.out.println("millis: " + millis);
        //计算区间天数
        Period p = new Period(begin, end, PeriodType.days());
        int days = p.getDays();
        System.out.println("days: " + days);
        //计算特定日期是否在该区间内
        Interval interval = new Interval(begin, end);
        boolean contained = interval.contains(new DateTime("2017-03-01"));
        System.out.println("contained: " + contained);

        //日期比较
        System.out.println("-----------日期比较-------------");
        DateTime dd2 = new DateTime("2015-10-01");
        DateTime ddd2 = new DateTime("2016-02-01");
        //和系统时间比
        boolean b1 = dd2.isAfterNow();
        boolean b2 = dd2.isBeforeNow();
        boolean b3 = dd2.isEqualNow();
        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);
        System.out.println("b3: " + b3);
        //和其他日期比
        boolean f1 = dd2.isAfter(ddd2);
        boolean f2 = dd2.isBefore(ddd2);
        boolean f3 = dd2.isEqual(ddd2);
        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
        System.out.println("f3: " + f3);

    }

    public static Days daysToNewYear(LocalDate fromDate) {
        LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
        System.out.println(newYear.toString());
        return Days.daysBetween(fromDate, newYear);
    }


}
