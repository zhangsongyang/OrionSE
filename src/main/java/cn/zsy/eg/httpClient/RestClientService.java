package cn.zsy.eg.httpClient;

import java.util.Map;

/**
 * HttpClient的工具类,基于httpclient-4.5.1.jar
 *
 * @author liujiawei
 */
public interface RestClientService {

  public ResponseBean get(String url);

  public ResponseBean get(String url, Map<String, String> headerMap);

  public ResponseBean post(String url);

  public ResponseBean post(String url, Map<String, String> headerMap);

  public ResponseBean post(String url, String requestBody);

  public ResponseBean post(String url, Map<String, String> headerMap, String requestBody);

  public ResponseBean post(String url, Map<String, String> headerMap, byte[] requestBinaryBody);

  public ResponseBean postForm(String url, Map<String, String> form);

  public ResponseBean postForm(String url, Map<String, String> headerMap, Map<String, String> form);

  public ResponseBean put(String url);

  public ResponseBean put(String url, Map<String, String> headerMap);

  public ResponseBean put(String url, String requestBody);

  public ResponseBean put(String url, Map<String, String> headerMap, String requestBody);

  public ResponseBean putForm(String url, Map<String, String> form);

  public ResponseBean putForm(String url, Map<String, String> headerMap, Map<String, String> form);

  public ResponseBean delete(String url);

  public ResponseBean delete(String url, Map<String, String> headerMap);

}
