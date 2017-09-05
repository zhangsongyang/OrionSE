package cn.zsy.eg.httpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class RetryUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(RetryUtil.class);

  public interface ExecuteFunction {
    void execute() throws TpClientServiceException;
  }

  /**
   * 重试执行
   *
   * @param retryCount
   * @param interval
   * @param timeUnit
   * @param throwIfFail
   * @param function
   * @throws Exception
   */
  public static void retry(int retryCount, long interval, TimeUnit timeUnit, boolean throwIfFail, ExecuteFunction function) throws TpClientServiceException {
    if (function == null) {
      return;
    }
    for (int i = 0; i < retryCount; i++) {
      try {
        LOGGER.info("try the " + (i + 1) + " times.");
        function.execute();
        break;
      } catch (TpClientServiceException e) {
        if (i == retryCount - 1) {
          if (throwIfFail) {
            throw e;
          } else {
            break;
          }
        } else {
          if (timeUnit != null && interval > 0L) {
            try {
              timeUnit.sleep(interval);
            } catch (InterruptedException e1) {
              LOGGER.error(e1.getMessage(), e1);
            }
          }
        }
      }
    }
  }

  /**
   * 有间隔的重试
   *
   * @param retryCount
   * @param interval
   * @param timeUnit
   * @param handler
   * @throws Exception
   */
  public static void retry(int retryCount, long interval, TimeUnit timeUnit, ExecuteFunction handler) throws Exception {
    retry(retryCount, interval, timeUnit, false, handler);
  }

  /**
   * 不间隔重试
   *
   * @param retryCount
   * @param function
   * @throws Exception
   */
  public static void retry(int retryCount, ExecuteFunction function) throws Exception {
    retry(retryCount, -1, null, function);
  }
}