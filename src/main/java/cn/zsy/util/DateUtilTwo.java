package cn.zsy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 日期转换函数
 * 
 * @author Ethan.Lam 2011-7-24
 * 
 */
public class DateUtilTwo {

	public static final String Formater_yyyy_MM_dd = "yyyy-MM-dd";
	public static final String Formater_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String Formater_yyyy_MM_dd_HH_mm_ss_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String Formater_yyyyMMddHHmmss = "yyyyMMddHHmmss";

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		str = str != null ? str.trim() : str;
		return str == null || "".equals(str) ? true : false;
	}

	/**
	 * 
	 * 获取当前的时间戳
	 * 
	 * @return
	 */
	public static String getCurrentTimestamp() {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
		return formater.format(today);
	}

	/**
	 * 
	 * Date 对象转换成对应格式的 字符串
	 * 
	 * @param date
	 * @param format
	 *            如："yyyy-MM-dd HH:mm:ss"，默认："yyyy-MM-dd HH:mm:ss"
	 * @return
	 * 
	 */
	public static String dateToString(Date date, String format) {
		if (date == null)
			return "";
		SimpleDateFormat formater = new SimpleDateFormat(isNull(format) ? "yyyy-MM-dd HH:mm:ss" : format.trim());
		return formater.format(date);
	}

	/**
	 * 
	 * Date 对象转换成对应格式的 字符串
	 * 
	 * @param date
	 *            默认："yyyy-MM-dd HH:mm:ss"
	 * @return
	 * 
	 */
	public static String dateToString(Date date) {
		if (date == null)
			return "";
		return dateToString(date, null);
	}

	/**
	 * 
	 * Date 对象转换成对应格式的 字符串
	 * 
	 * @param dateSource
	 * @param format
	 *            如："yyyy-MM-dd HH:mm:ss"，默认："yyyy-MM-dd HH:mm:ss"
	 * @return
	 * 
	 */
	public static Date timeStrToDate(String dateSource, String format) {
		if (isNull(dateSource))
			return null;
		SimpleDateFormat formater = new SimpleDateFormat(isNull(format) ? "yyyy-MM-dd HH:mm:ss" : format.trim().replace(".", "-").replace("/", "-"));
		try {
			return formater.parse(dateSource);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * Date 对象转换成对应格式的 字符串
	 * 
	 * @param dateSource
	 *            默认："yyyy-MM-dd HH:mm:ss"
	 * @return
	 * 
	 */
	public static Date timeStrToDate(String dateSource) {
		if (isNull(dateSource))
			return null;
		return timeStrToDate(dateSource, null);
	}

	/**
	 * 得到系统日期
	 * 
	 * @return
	 */
	public static String getDate() {
		Calendar calendar = Calendar.getInstance();
		String year = calendar.get(Calendar.YEAR) + "";
		String month = calendar.get(Calendar.MONTH) + 1 + "";
		String day = calendar.get(Calendar.DAY_OF_MONTH) + "";
		if (month.length() == 1)
			month = "0" + month;
		if (day.length() == 1)
			day = "0" + day;

		return year + "-" + month + "-" + day;
	}

	/**
	 * 得到系统日期 “XXXX年XX月XX日”
	 * 
	 * @return
	 */
	public static String getDateCN() {
		Calendar calendar = Calendar.getInstance();
		String year = calendar.get(Calendar.YEAR) + "";
		String month = calendar.get(Calendar.MONTH) + 1 + "";
		String day = calendar.get(Calendar.DAY_OF_MONTH) + "";
		return year + "年" + month + "月" + day + "日";
	}

	/**
	 * 得到系统日期,xx月xx日 xx xx:xx
	 * 
	 * @return
	 */
	public static String getWapDate() {
		Calendar calendar = Calendar.getInstance();
		String month = calendar.get(Calendar.MONTH) + 1 + "";
		String day = calendar.get(Calendar.DAY_OF_MONTH) + "";
		String hour = calendar.get(Calendar.HOUR_OF_DAY) + "";
		String minute = calendar.get(Calendar.MINUTE) + "";

		if (month.length() == 1)
			month = "0" + month;

		return month + "月" + day + "日 " + hour + ":" + minute;
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 * 
	 * @param nowdate
	 * @param delay
	 * @return
	 */
	public static String getNextDay(String nowdate, int delay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String mdate = "";
			Date d = timeStrToDate(nowdate);
			long myTime = (d.getTime() / 1000) + delay * 24 * 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 * 
	 * @param nowdate
	 * @param delay
	 *            小于 0，过去多小天，大于0 未来多小天
	 * @param dateFormat
	 * @return
	 */
	public static String getNextDay(String nowdate, int delay, String dateFormat) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String mdate = "";
			Date d = timeStrToDate(nowdate, dateFormat);
			long myTime = (d.getTime() / 1000) + delay * 24 * 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数时间
	 * 
	 * @param nowdate
	 * @param delay
	 *            小于 0，过去多小天，大于0 未来多小天
	 * @param dateFormat
	 * @return
	 */
	public static String getNextDayByFormat(String nowdate, int delay, String dateFormat) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			String mdate = "";
			Date d = timeStrToDate(nowdate, dateFormat);
			long myTime = (d.getTime() / 1000) + delay * 24 * 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 返回今天的时间段
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String[] getTodayPeriods() {
		String today = dateToString(new Date(), Formater_yyyy_MM_dd);
		return new String[] { today + " 00:00:00", today + " 23:59:59" };
	}

	/**
	 * 返回昨天的时间段
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String[] getYesterdayPeriods() {
		String today = dateToString(new Date(), Formater_yyyy_MM_dd);
		String beforeDay = getNextDay(today, -1, Formater_yyyy_MM_dd);
		return new String[] { beforeDay + " 00:00:00", beforeDay + " 23:59:59" };
	}

	/**
	 * 返回一个星期(7天前)的时间段(含今天)
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String[] getWeekPeriods() {
		String today = dateToString(new Date(), Formater_yyyy_MM_dd);
		String beforeDay = getNextDay(today, -6, Formater_yyyy_MM_dd);
		return new String[] { beforeDay + " 00:00:00", today + " 23:59:59" };
	}

	/**
	 * 返回的一个月时间段(含今天)
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String[] getMonthDayPeriods(int difMonths) {
		difMonths = difMonths == 0 ? 1 : difMonths;
		String today = dateToString(new Date(), Formater_yyyy_MM_dd);
		String beforeDay = getNextDay(today, -7 * 4 * difMonths - 1, Formater_yyyy_MM_dd);
		return new String[] { beforeDay + " 00:00:00", today + " 23:59:59" };
	}

	/**
	 * 得到系统当前的时间
	 * 
	 * @return
	 */
	public static String getSysDateTime() {
		return dateToString(new Date(), DateUtilTwo.Formater_yyyy_MM_dd_HH_mm_ss);
	}

	public static String formatDate(Date date, String format) {
		return dateToString(date, format);
	}

	public static String formatDate(Date date) {
		return dateToString(date, DateUtilTwo.Formater_yyyy_MM_dd_HH_mm_ss);
	}

	/**
	 * 将calendar的星期几转化为我们习惯的（1-星期一，7-星期日）
	 * 
	 * @param dayOfWeek
	 * @return
	 */
	public static long toChineseWeek(long dayOfWeek) {
		return dayOfWeek - 1 == 0 ? 7 : dayOfWeek - 1;
	}

	/**
	 * 验证字符串是否是合法的日期
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static boolean isValidDate(String dateStr, String format) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			dateFormat.setLenient(false);
			dateFormat.parse(dateStr);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 返回当月的起始 日期 2011-01-01 : 2011-01-31
	 * 
	 * @return
	 */
	public static String[] getMonthPeriods(int month) {
		Calendar c1 = Calendar.getInstance();
		int year = c1.get(Calendar.YEAR);
		c1.set(year, month - 1, 1);
		return new String[] { year + "-" + month + "-01", year + "-" + month + "-" + c1.getActualMaximum(Calendar.DATE) };
	}

	/**
	 * @author linjinyu
	 * @param time
	 * @return
	 */
	public static String getTimeAgoInWords(String time) {

		Date date = timeStrToDate(time);

		String shortstring = null;

		shortstring = getTimeAgoInWords(date);

		return shortstring;
	}

	/**
	 * 
	 * @param dateSource
	 * @return
	 */
	public static long toTime(String dateSource) {
		Date date = timeStrToDate(dateSource);
		if (date == null)
			return 0;
		return date.getTime();
	}

	public static String getTimeAgoInWords(Date date) {

		String shortstring = null;

		long now = Calendar.getInstance().getTimeInMillis();

		if (date == null)
			return shortstring;

		long deltime = (now - date.getTime()) / 1000;

		if (deltime > 365 * 24 * 60 * 60) {
			// shortstring = (int)(deltime/(365*24*60*60)) + "年前";
			shortstring = DateUtilTwo.dateToString(date, Formater_yyyy_MM_dd);
		} else if (deltime > 24 * 60 * 60) {
			// shortstring = (int)(deltime/(24*60*60)) + "天前";
			shortstring = DateUtilTwo.dateToString(date, "MM-dd HH:mm");
		} else if (deltime > 60 * 60) {
			shortstring = (int) (deltime / (60 * 60)) + "小时前";
		} else if (deltime > 60) {
			shortstring = (int) (deltime / (60)) + "分前";
		} else if (deltime > 1) {
			shortstring = deltime + "秒前";
		} else {
			shortstring = "1秒前";
		}

		return shortstring;
	}

	/**
	 * 返回一个时间
	 * 
	 * @param date
	 *            yyyy-MM-dd hh:mm:ss
	 * @return 今天则显示 今天 hh:mm;昨天显示 昨天：hh:mm;今年显示：MM-dd hh:mm；其余显示：yyyy-MM-dd
	 */
	public static String getAppFormatDate(String date) {
		if (null == date || "".equals(date)) {
			return "";
		}

		date = date.trim();
		if (date.length() < 19) {
			return date;
		}

		Calendar c1 = Calendar.getInstance();
		// c1.setTime(timeStrToDate("2013-06-01 00:00:00")) ;
		int currYear = c1.get(Calendar.YEAR);
		int currMonth = c1.get(Calendar.MONTH) + 1;
		int currDay = c1.get(Calendar.DAY_OF_MONTH);
		int days = c1.getActualMaximum(Calendar.DAY_OF_MONTH);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(timeStrToDate(date));
		int year = c2.get(Calendar.YEAR);
		int month = c2.get(Calendar.MONTH) + 1;
		int day = c2.get(Calendar.DAY_OF_MONTH);

		if (year == currYear - 1 && currMonth == 1 && month == 12 && currDay == 1 && day == days) {
			// 今天是一月一号、需要转换的日期是去年12月31号
			return "昨天 " + date.substring(11, 16);
		}

		if (year < currYear) {
			return date.substring(0, 10);
		}

		if (month == currMonth - 1 && currDay == 1 && day == days) {
			// 今天是一号，需要转换的日期是上个月月末
			return "昨天 " + date.substring(11, 16);
		}

		if (month < currMonth) {
			return date.substring(5, 16);
		}

		if (day < currDay - 1) {
			return date.substring(5, 16);
		}
		if (day == currDay - 1) {
			return "昨天 " + date.substring(11, 16);
		}
		if (day == currDay) {
			return "今天 " + date.substring(11, 16);
		}
		return date.substring(0, 16);
	}

	final static String MONTHS[] = { "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" };

	/**
	 * 取本周七天的日期
	 * 
	 * @return
	 */
	public static int[] getCurrentDays() {

		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		int min = calendar.get(Calendar.DAY_OF_MONTH);
		int[] days = new int[7];
		for (int i = 0; i < 7; i++) {
			calendar.set(Calendar.DAY_OF_MONTH, min + i);
			days[i] = calendar.get(Calendar.DAY_OF_MONTH);
		}
		return days;
	}

	public static String getCNMonth(int month) {
		return MONTHS[month];
	}

	/**
	 * 得到两日期相差几个月
	 *
	 * @return
	 */
	public static int monthDiff(String startDate, String endDate) {
		int monthday;
		Date startDate1 = timeStrToDate(startDate, "yyyy-MM-d");

		Calendar starCal = Calendar.getInstance();
		starCal.setTime(startDate1);

		int sYear = starCal.get(Calendar.YEAR);
		int sMonth = starCal.get(Calendar.MONTH);
		int sDay = starCal.get(Calendar.DAY_OF_MONTH);

		Date endDate1 = timeStrToDate(endDate, "yyyy-MM-d");
		;
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate1);
		int eYear = endCal.get(Calendar.YEAR);
		int eMonth = endCal.get(Calendar.MONTH);
		int eDay = endCal.get(Calendar.DAY_OF_MONTH);

		monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));

		// 这里计算零头的情况，根据实际确定是否要加1 还是要减1
		if (sDay < eDay) {
			monthday = monthday + 1;
		}
		return monthday;
	}

	/**
	 * 返回具体的时间字符串
	 * 
	 * @param dt
	 * @return
	 */
	public static String getDateTime(long dt) {

		Date date = null;

		if (dt == 0) {
			date = new Date();
		} else {
			date = new Date(dt);
		}

		return dateToString(date);
	}

	/**
	 * 计算相差天数
	 * 
	 * @param smdate
	 * @param emdate
	 * @return
	 */
	public static int daysBetween(Date smdate, Date emdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int rs = 0;
		try {
			smdate = sdf.parse(sdf.format(smdate));
			emdate = sdf.parse(sdf.format(emdate));

			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long stime = cal.getTimeInMillis();
			cal.setTime(emdate);
			long etime = cal.getTimeInMillis();
			long betweendays = (etime - stime) / (1000 * 3600 * 24);
			rs = Integer.valueOf(String.valueOf(betweendays));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}
}
