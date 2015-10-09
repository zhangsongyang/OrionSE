package cn.zsy.eg.scheduledExecutor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestTask {
	
	
	/** 
	 * 每天晚上8点执行一次
	 * 每天定时安排任务进行执行 
	 */  
	public static void executeEightAtNightPerDay() {  
	    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);  
	    long oneDay = 24 * 60 * 60 * 1000;  
	    long initDelay  = getTimeMillis("14:00:00") - System.currentTimeMillis();  
	    initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;  
	  
	    executor.scheduleAtFixedRate(  
	            new EchoServer(),  
	            initDelay,  
	            oneDay,  
	            TimeUnit.MILLISECONDS);  
	}  
	
	
	/** 
	 * 以固定周期频率执行任务
	 */  
	public static void executeFixedRate() {  
	    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);  
	    executor.scheduleAtFixedRate(  
	            new EchoServer(),  
	            0,  
	            5000,  
	            TimeUnit.MILLISECONDS);  
	}  
	
	
	public static void main(String[] args) {
//		executeEightAtNightPerDay();
		executeFixedRate();
	}
	
	
	
	/** 
	 * 获取指定时间对应的毫秒数 
	 * @param time "HH:mm:ss" 
	 * @return 
	 */  
	private static long getTimeMillis(String time) {  
	    try {  
	        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");  
	        DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");  
	        Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);  
	        return curDate.getTime();  
	    } catch (ParseException e) {  
	        e.printStackTrace();  
	    }  
	    return 0;  
	}  

	

}
