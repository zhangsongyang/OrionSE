package cn.zsy.eg.designMode.create.multiFactoryMode;


public class MyFactory {

    public MyInterface produceOne() {
        return new MyClassOne();
    }

    public MyInterface produceTwo() {
        return new MyClassTwo();
    }

}
