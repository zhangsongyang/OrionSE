package cn.zsy.eg.httpClient;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResponseBean implements Serializable {

    private static final long serialVersionUID = -7261979112398295428L;

    private static final String CHARSET_UTF8 = "UTF-8";

    private int statusCode;

    private Map<String, String> responseHeader;

    private String responseBody;

    public ResponseBean() {
        super();
    }

    public ResponseBean(int statusCode, Map<String, String> responseHeader, String responseBody) {
        super();
        this.statusCode = statusCode;
        this.responseHeader = responseHeader;
        this.responseBody = responseBody;
    }

    public ResponseBean(HttpResponse httpResponse) {
        super();
        if (httpResponse == null) {
            throw new NullPointerException("httpResponse was null.");
        }
        this.statusCode = httpResponse.getStatusLine().getStatusCode();
        Header[] headers = httpResponse.getAllHeaders();
        this.responseHeader = new HashMap<String, String>();
        for (Header header : headers) {
            responseHeader.put(header.getName(), header.getValue());
        }
        try {
            this.responseBody = EntityUtils.toString(httpResponse.getEntity(), CHARSET_UTF8);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(Map<String, String> responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

}
