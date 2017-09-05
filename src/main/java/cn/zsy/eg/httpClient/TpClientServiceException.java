package cn.zsy.eg.httpClient;

/**
 * 系统服务异常
 */
public class TpClientServiceException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
    private Object[] parameter;

    public TpClientServiceException(Throwable ex) {
        super(ex);
    }

    public TpClientServiceException(int errorCode) {
        this.errorCode = String.valueOf(errorCode);
    }

    public TpClientServiceException(String errorCode) {
        this.errorCode = errorCode;
    }

    public TpClientServiceException(int errorCode, String msg) {
        super(msg);
        this.errorMessage = msg;
        this.errorCode = String.valueOf(errorCode);
    }

    public TpClientServiceException(String errorCode, String msg) {
        super(msg);
        this.errorMessage = msg;
        this.errorCode = errorCode;
    }

    public TpClientServiceException(String errorCode, String msg, Object... parameter) {
        super(msg);
        this.errorMessage = msg;
        this.errorCode = errorCode;
        this.parameter = parameter;
    }

    public TpClientServiceException(String errorCode, Object... parameter) {
        this.errorCode = errorCode;
        this.parameter = parameter;
    }

    public TpClientServiceException(int errorCode, Throwable ex) {
        super(ex);
        this.errorCode = String.valueOf(errorCode);
    }

    public TpClientServiceException(String errorCode, Throwable ex) {
        super(ex);
        this.errorCode = errorCode;
    }

    public TpClientServiceException(int errorCode, String msg, Throwable ex) {
        super(msg, ex);
        this.errorMessage = msg;
        this.errorCode = String.valueOf(errorCode);
    }

    public String getCode() {
        return errorCode;
    }

    public String getErrorCodeStr() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = String.valueOf(errorCode);
    }

    public final Object[] getParameter() {
        return parameter;
    }

    public final void setParameter(Object... parameter) {
        this.parameter = parameter;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
