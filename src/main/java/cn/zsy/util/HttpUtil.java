package cn.zsy.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;


public class HttpUtil {

	private static Log log = LogFactory.getLog(HttpUtil.class);
	
	/**
	 * @param urlStr
	 * @param encoding
	 * @param isPost
	 * @param postBody
	 * @param timeout 超时时间 默认为系统默认的超时时间（毫秒）
	 * @return
	 */
	public static String getHttpUrlContent(String urlStr, String encoding, boolean isPost, String postBody, int timeout) {
		return getHttpUrlContent(urlStr, encoding, isPost, postBody, null, timeout);
	}

	public static String getHttpUrlContent(String urlStr, String encoding) {
		return getHttpUrlContent(urlStr, encoding, false, null, null, null, 0);
	}
	
	public static String getHttpUrlContent(String urlStr, String encoding, boolean isPost, String postBody, Map requestProperty, int timeout) {
		return getHttpUrlContent(urlStr, encoding, isPost, postBody, requestProperty, null, timeout);
	}
	
	public static String getHttpUrlContent(String urlStr, String encoding, boolean isPost, String postBody, Map requestProperty, String logFlag, int timeout) {
		int conTimeout = Config.BK_SOCKET_CONNECT_TIMEOUT;
		int readTimeout = Config.BK_SOCKET_READ_TIMEOUT;
		if(timeout > 0){
			conTimeout = timeout;
			readTimeout = timeout;
		}
		
		BufferedReader breader = null;
		URL url = null;
		HttpURLConnection conn = null;
		long startTime = System.currentTimeMillis();
		try {
			url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			// 设置request header
			if (requestProperty != null) {
				for (Iterator it = requestProperty.keySet().iterator(); it.hasNext();) {
					String key = (String) it.next();
					conn.setRequestProperty(key, (String) requestProperty.get(key));
				}
			}
			if (isPost) {
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			// 设置连接超时和读取超时两个时间，防止被后台憋死
			conn.setConnectTimeout(conTimeout);
			conn.setReadTimeout(readTimeout);
			// 建立连接
			conn.connect();
			if (isPost) {
				OutputStream out = conn.getOutputStream();
				out.write(postBody.getBytes(encoding));
				out.flush();
				out.close();
			}
			InputStream is = null;
			is = conn.getInputStream();
			breader = new BufferedReader(new InputStreamReader(is, encoding));
			char[] c_buf = new char[8192];
			StringBuffer buf = new StringBuffer("");
			int len = breader.read(c_buf, 0, 8192);
			while (len > 0) {
				buf.append(c_buf, 0, len);
				c_buf = new char[8192];
				len = breader.read(c_buf, 0, 8192);
			}
			breader.close();
			return buf.toString();
		} catch (Exception e) {
			log.error("error in getHttpUrlContent " + urlStr, e);
		} finally {
			if(breader != null) {
				try {
					breader.close();
				} catch (IOException e) {
					log.error(e, e);
				}
			}
			url = null;
			if (conn != null) {
				conn.disconnect();
			}
			long t = System.currentTimeMillis() - startTime;
			if (t > 300)
				log.warn(urlStr + " cost " + t);
		}
		return "";
	}

}
