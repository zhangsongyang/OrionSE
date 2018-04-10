package cn.zsy.eg.dubbo.dubboProvider;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.RegistryFactory;

public class DegradationServer {

  public static void main(String[] args) {
    RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
    Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://52.41.86.234:2181"));
    registry.register(URL.valueOf("override://192.168.70.176/cn.zsy.eg.dubbo.dubboApi.DemoService?category=configurators&dynamic=false&application=demo-provider&mock=force:return+null"));
  }

}
