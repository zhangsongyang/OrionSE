package cn.zsy.eg.designMode.create.staticFactoryMode;


public class MyFactory {

    public static MyInterface produceOne() {
        return new MyClassOne();
    }

    public static MyInterface produceTwo() {
        return new MyClassTwo();
    }

}
