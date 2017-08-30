package cn.zsy.eg.httpClient;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * HttpClient的工具类,基于httpclient-4.5.1.jar
 *
 * @author liujiawei
 */
public class HttpClientUtils implements RestClientService {

  /**
   * 日志
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

  /**
   * 超时时间为8秒
   */
  private static final int TIME_OUT = 30000;

  /**
   * 设置请求的超时时间
   */
  private static final RequestConfig REQUEST_CONFIG = RequestConfig.custom()
      .setSocketTimeout(TIME_OUT).setConnectTimeout(TIME_OUT).setConnectionRequestTimeout(TIME_OUT)
      .build();

  /**
   * 统一用"UTF-8"进行字符集编码
   */
  private static final String CHARSET_UTF8 = "UTF-8";

  public ResponseBean get(String url) {
    return executeBody(new HttpGet(), url, null, null);
  }

  public ResponseBean get(String url, Map<String, String> headerMap) {
    return executeBody(new HttpGet(), url, headerMap, null);
  }

  public ResponseBean post(String url) {
    return executeBody(new HttpPost(), url, null, null);
  }

  public ResponseBean post(String url, Map<String, String> headerMap) {
    return executeBody(new HttpPost(), url, headerMap, null);
  }

  public ResponseBean post(String url, String requestBody) {
    return executeBody(new HttpPost(), url, null, requestBody);
  }

  public ResponseBean post(String url, Map<String, String> headerMap, String requestBody) {
    return executeBody(new HttpPost(), url, headerMap, requestBody);
  }

  public ResponseBean post(String url, Map<String, String> headerMap, byte[] requestBinaryBody) {
    return executeBinaryBody(new HttpPost(), url, headerMap, requestBinaryBody);
  }

  public ResponseBean postForm(String url, Map<String, String> form) {
    return executeForm(new HttpPost(), url, null, form);
  }

  public ResponseBean postForm(String url, Map<String, String> headerMap, Map<String, String> form) {
    return executeForm(new HttpPost(), url, headerMap, form);
  }

  public ResponseBean put(String url) {
    return executeBody(new HttpPut(), url, null, null);
  }

  public ResponseBean put(String url, Map<String, String> headerMap) {
    return executeBody(new HttpPut(), url, headerMap, null);
  }

  public ResponseBean put(String url, String requestBody) {
    return executeBody(new HttpPut(), url, null, requestBody);
  }

  public ResponseBean put(String url, Map<String, String> headerMap, String requestBody) {
    return executeBody(new HttpPut(), url, headerMap, requestBody);
  }

  public ResponseBean putForm(String url, Map<String, String> form) {
    return executeForm(new HttpPut(), url, null, form);
  }

  public ResponseBean putForm(String url, Map<String, String> headerMap, Map<String, String> form) {
    return executeForm(new HttpPut(), url, headerMap, form);
  }

  public ResponseBean delete(String url) {
    return executeBody(new HttpDelete(), url, null, null);
  }

  public ResponseBean delete(String url, Map<String, String> headerMap) {
    return executeBody(new HttpDelete(), url, headerMap, null);
  }

  /**
   * 创建一个SSL的链接工厂,该工厂对重写了verify方法,使得该方法永远返回true.
   *
   * @return
   */
  private SSLConnectionSocketFactory createSSLConnSocketFactory() {
    SSLConnectionSocketFactory sslFactory = null;
    try {
      SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
        public boolean isTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
          return true;
        }
      }).build();
      sslFactory = new SSLConnectionSocketFactory(sslContext, new HostnameVerifier() {
        @Override
        public boolean verify(String arg0, SSLSession arg1) {
          return true;
        }
      });
    } catch (GeneralSecurityException e) {
      LOGGER.error("RestUtils.createSSLConnSocketFactory has error:", e);
    }
    return sslFactory;
  }

  private CloseableHttpClient createHttpClient(String url) {
    if (url == null || url.trim().isEmpty()) {
      throw new RuntimeException("url was null.");
    }
    CloseableHttpClient httpClient = null;
    if (url.startsWith("https")) {
      httpClient = HttpClients.custom().setSSLSocketFactory(createSSLConnSocketFactory()).build();
    } else {
      httpClient = HttpClients.createDefault();
    }
    return httpClient;
  }

  /**
   * Rest的最终实现方法,所有的其他方法均通过调用该方法实现.
   * httpClient 主要分http和https两种Client
   *
   * @param method    get,post,put,delete等
   * @param url       请求的URL
   * @param headerMap 头信息
   * @param form
   * @return 返回信息
   */
  private ResponseBean executeForm(HttpRequestBase method, String url,
                                   Map<String, String> headerMap, Map<String, String> form) {
    long startTime = System.currentTimeMillis();
    CloseableHttpClient httpClient = createHttpClient(url);
    CloseableHttpResponse httpResponse = null;
    ResponseBean responseBean = null;
    try {
      method.setConfig(REQUEST_CONFIG);
      method.setURI(new URI(url));
      if (form != null && !form.isEmpty()) {// 只有当method为HttpPost,HttpPut和HttpPatch时才需要设置form
        List<BasicNameValuePair> formList = new ArrayList<BasicNameValuePair>();
        for (Entry<String, String> entry : form.entrySet()) {
          formList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        if (method instanceof HttpPost) {
          ((HttpPost) method).setEntity(new UrlEncodedFormEntity(formList, CHARSET_UTF8));
        } else if (method instanceof HttpPut) {
          ((HttpPut) method).setEntity(new UrlEncodedFormEntity(formList, CHARSET_UTF8));
        } else if (method instanceof HttpPatch) {
          ((HttpPatch) method).setEntity(new UrlEncodedFormEntity(formList, CHARSET_UTF8));
        }
      }
      if (headerMap != null && !headerMap.isEmpty()) {
        for (Entry<String, String> entry : headerMap.entrySet()) {
          method.setHeader(entry.getKey(), entry.getValue());
        }
      }
      httpResponse = httpClient.execute(method);
      responseBean = new ResponseBean(httpResponse);
    } catch (Exception e) {
      LOGGER.error("executeForm has Exception:", e);
    } finally {
      try {
        if (httpResponse != null) {
          httpResponse.close();
        }
        if (httpClient != null) {
          httpClient.close();
        }
      } catch (IOException e) {
        LOGGER.error("executeForm close() has IOException:", e);
      }
      long endTime = System.currentTimeMillis();
      LOGGER
          .info(
              "executeForm method={}, url={}, headerMap={}, requestForm={}, responseBean={}, used time {}ms",
              method.getMethod(), url, JSON.toJSONString(headerMap), JSON.toJSONString(form),
              JSON.toJSONString(responseBean), (endTime - startTime));
    }
    return responseBean;
  }

  /**
   * Rest的最终实现方法,所有的其他方法均通过调用该方法实现.
   * 主要分http和https两种Client
   *
   * @param method      get,post,put,delete等
   * @param url         请求的URL
   * @param headerMap   头信息
   * @param requestBody 请求体
   * @return 返回信息
   */
  private ResponseBean executeBody(HttpRequestBase method, String url,
                                   Map<String, String> headerMap, String requestBody) {
    long startTime = System.currentTimeMillis();
    CloseableHttpClient httpClient = createHttpClient(url);
    CloseableHttpResponse httpResponse = null;
    ResponseBean responseBean = null;
    try {
      method.setConfig(REQUEST_CONFIG);
      method.setURI(new URI(url));
      if (requestBody != null && !requestBody.trim().isEmpty()) {// 只有当method为HttpPost,HttpPut和HttpPatch时才需要设置requestBody
        if (method instanceof HttpPost) {
          ((HttpPost) method).setEntity(new StringEntity(requestBody, CHARSET_UTF8));
        } else if (method instanceof HttpPut) {
          ((HttpPut) method).setEntity(new StringEntity(requestBody, CHARSET_UTF8));
        } else if (method instanceof HttpPatch) {
          ((HttpPatch) method).setEntity(new StringEntity(requestBody, CHARSET_UTF8));
        }
      }
      if (headerMap != null && !headerMap.isEmpty()) {
        for (Entry<String, String> entry : headerMap.entrySet()) {
          method.setHeader(entry.getKey(), entry.getValue());
        }
      }
      httpResponse = httpClient.execute(method);
      responseBean = new ResponseBean(httpResponse);
    } catch (Exception e) {
      LOGGER.error("executeBody has Exception:", e);
    } finally {
      try {
        if (httpResponse != null) {
          httpResponse.close();
        }
        if (httpClient != null) {
          httpClient.close();
        }
      } catch (IOException e) {
        LOGGER.error("executeBody close() has IOException:", e);
      }
      long endTime = System.currentTimeMillis();
      LOGGER
          .info(
              "executeBody method={}, url={}, headerMap={}, requestBody={}, responseBean={}, used time {}ms",
              method.getMethod(), url, JSON.toJSONString(headerMap), requestBody,
              JSON.toJSONString(responseBean), (endTime - startTime));
    }
    return responseBean;
  }

  private ResponseBean executeBinaryBody(HttpRequestBase method, String url,
                                         Map<String, String> headerMap, byte[] requestBinaryBody) {
    long startTime = System.currentTimeMillis();
    CloseableHttpClient httpClient = createHttpClient(url);
    CloseableHttpResponse httpResponse = null;
    ResponseBean responseBean = null;
    try {
      method.setConfig(RequestConfig.custom()
          .setSocketTimeout(TIME_OUT).setConnectTimeout(TIME_OUT).setConnectionRequestTimeout(TIME_OUT)
          .build());
      method.setURI(new URI(url));
      if (requestBinaryBody != null) {
        if (method instanceof HttpPost) {
          ((HttpPost) method).setEntity(new ByteArrayEntity(requestBinaryBody));
        }
      }
      if (headerMap != null && !headerMap.isEmpty()) {
        for (Entry<String, String> entry : headerMap.entrySet()) {
          method.setHeader(entry.getKey(), entry.getValue());
        }
      }
      httpResponse = httpClient.execute(method);
      responseBean = new ResponseBean(httpResponse);
    } catch (Exception e) {
      LOGGER.error("executeBinaryBody has Exception:", e);
    } finally {
      try {
        if (httpResponse != null) {
          httpResponse.close();
        }
        if (httpClient != null) {
          httpClient.close();
        }
      } catch (IOException e) {
        LOGGER.error("executeBinaryBody close() has IOException:", e);
      }
      long endTime = System.currentTimeMillis();
      LOGGER
          .info(
              "executeBinaryBody method={}, url={}, headerMap={}, responseBean={}, used time {}ms",
              method.getMethod(), url, JSON.toJSONString(headerMap),
              JSON.toJSONString(responseBean), (endTime - startTime));
    }
    return responseBean;
  }

}
