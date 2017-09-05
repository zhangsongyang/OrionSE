package cn.zsy.eg.httpClient;

import java.util.concurrent.TimeUnit;

public class TestRetryUtils {

    public static void main(String[] args) throws TpClientServiceException {
        RetryUtil.retry(4, 4L, TimeUnit.SECONDS, true,
            new RetryUtil.ExecuteFunction() {
            @Override
            public void execute() throws TpClientServiceException {
                NullPointerException ex = new NullPointerException();
                System.out.println("retryTest.....");
                throw new TpClientServiceException(ex);
            }
        });

    }

}
