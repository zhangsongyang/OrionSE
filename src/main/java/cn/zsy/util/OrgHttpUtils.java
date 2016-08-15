package cn.zsy.util;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

public class OrgHttpUtils {
static final String DEFAULT_CHARSET = "UTF-8";

	static MultiThreadedHttpConnectionManager mhconnectionpool;

	static {
		mhconnectionpool = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams httpConnManagerParams = mhconnectionpool.getParams();
		httpConnManagerParams.setDefaultMaxConnectionsPerHost(80);
		httpConnManagerParams.setMaxTotalConnections(5000);
		httpConnManagerParams.setConnectionTimeout(10000);
		httpConnManagerParams.setSoTimeout(40000);
		httpConnManagerParams.setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

	}

	public static String post(String url, Map<String, String> params) {
		HttpClient client = new HttpClient(mhconnectionpool);
		PostMethod method = new PostMethod(url);
		if (params != null && params.size() > 0) {
			Set<String> keys = params.keySet();
			for (String name : keys) {
				method.setParameter(name, params.get(name));
			}
		}
		method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,DEFAULT_CHARSET);
		try {
			int statusCode = client.executeMethod(method);
			if(statusCode != HttpStatus.SC_OK)
				return null;
			byte[] responseBody = method.getResponseBody();
			return new String(responseBody,DEFAULT_CHARSET);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return null;
	}
	
	public static String post(String url, String body){
		HttpClient client = new HttpClient(mhconnectionpool);
		PostMethod method = new PostMethod(url);
		try {
			StringRequestEntity requestEntity = new StringRequestEntity(body,"application/json",DEFAULT_CHARSET);
			method.setRequestEntity(requestEntity);
			int statusCode = client.executeMethod(method);
			if(statusCode != HttpStatus.SC_OK)
				return null;
			InputStream in = method.getResponseBodyAsStream();
			return IOUtils.toString(in,DEFAULT_CHARSET);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
		return null;
	}
}

