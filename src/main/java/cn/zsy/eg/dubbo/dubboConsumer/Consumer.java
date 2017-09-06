package cn.zsy.eg.dubbo.dubboConsumer;

import cn.zsy.eg.dubbo.dubboApi.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Consumer {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-demo-consumer.xml"});
    context.start();

    DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
    String hello = demoService.sayHello("张松杨"); // 执行远程方法

    System.out.println(hello); // 显示调用结果
  }
}
