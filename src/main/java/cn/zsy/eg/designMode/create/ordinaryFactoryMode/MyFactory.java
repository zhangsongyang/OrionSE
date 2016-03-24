package cn.zsy.eg.designMode.create.ordinaryFactoryMode;


public class MyFactory {

    public MyInterface produce(String type) {
        if ("One".equals(type)) {
            return new MyClassOne();
        } else if ("Two".equals(type)) {
            return new MyClassTwo();
        } else {
            System.out.println("没有要找的类型....");
            return null;
        }
    }

}
