package cn.zsy.eg.designMode.create.abstractFactoryMode;


public class MyFactoryOne implements Provider {


    @Override
    public MyInterface produce() {
        return new MyClassOne();
    }
}
