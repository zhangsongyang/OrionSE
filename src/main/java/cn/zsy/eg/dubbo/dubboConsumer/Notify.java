package cn.zsy.eg.dubbo.dubboConsumer;

public interface Notify {

  public void onreturn(String msg, String id);

  public void onthrow(Throwable ex, String id);

}
