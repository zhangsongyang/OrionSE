package cn.zsy.eg.dubbo.dubboConsumer;

import cn.zsy.eg.dubbo.dubboApi.DemoService;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Consumer {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-consumer.xml"});
    context.start();
    DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
    long start = System.currentTimeMillis();
//    RpcContext.getContext().setAttachment("index", "qqqqqqqqqqqqq");
    String hello = demoService.sayHello("张松杨"); // 执行远程方法
    long end = System.currentTimeMillis();
    System.out.println("---Comsumer " + hello + " time:" + (end - start)); // 显示调用结果
    // 本端是否为消费端，这里会返回true
//    boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
//    System.out.println("Comsumer " + isConsumerSide);
    // 获取最后一次调用的提供方IP地址
//    String serverIP = RpcContext.getContext().getRemoteHost();
//    System.out.println("Comsumer " + serverIP);
    // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
//    String application = RpcContext.getContext().getUrl().getParameter("application");
//    System.out.println("Comsumer " + application);
//    System.out.println("Comsumer " + hello); // 显示调用结果
  }
}
