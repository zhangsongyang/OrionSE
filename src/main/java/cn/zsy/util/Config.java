package cn.zsy.util;


public class Config {

	/**
	 * 连接超时设置为3.2s,可以自动重连
	 */
	public static int BK_SOCKET_CONNECT_TIMEOUT = 3210;

	/**
	 * 后台服务socket读数据超时时间，毫秒数
	 */
	public static int BK_SOCKET_READ_TIMEOUT = 3000;
	
	//发送短信相关配置
	public static String MSG_CPID = "010001000228";
	public static String MSG_MID =  "0";
	public static String MSG_PORT = "170898";
	public static String MSG_GATEWAY = "http://api.10690909.com/newmt";

}