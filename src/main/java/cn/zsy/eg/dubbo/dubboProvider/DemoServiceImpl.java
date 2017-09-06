package cn.zsy.eg.dubbo.dubboProvider;


import cn.zsy.eg.dubbo.dubboApi.DemoService;

public class DemoServiceImpl implements DemoService {

  public String sayHello(String name) {
    return "Hello " + name;
  }

}