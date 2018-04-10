package cn.zsy.eg.dubbo.dubboProvider;


import cn.zsy.eg.dubbo.dubboApi.DemoService;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

public class DemoServiceImpl implements DemoService {

  @Override
  public String sayHello(String name) {
    long start = System.currentTimeMillis();
    System.out.println("**********************************************" + name);
//    String index = RpcContext.getContext().getAttachment("index");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();

//    System.out.println(index);
    System.out.println("**********************************************" + name + " time" + (end - start));
    return "Service Hello " + name;
  }

}