package cn.zsy.eg.dubbo.dubboConsumer;

import java.util.HashMap;
import java.util.Map;

public class NotifyImpl implements Notify {

  public Map<String, String> ret = new HashMap<String, String>();
  public Map<String, Throwable> errors = new HashMap<String, Throwable>();

  public void onreturn(String id, String msg) {
    System.out.println("onreturn:" + msg);
    ret.put(id, msg);
  }

  public void onthrow(Throwable ex, String id) {
    System.out.println("onThrow........");
    errors.put(id, ex);
  }

}
