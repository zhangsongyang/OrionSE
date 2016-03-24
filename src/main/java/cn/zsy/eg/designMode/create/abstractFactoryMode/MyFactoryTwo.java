package cn.zsy.eg.designMode.create.abstractFactoryMode;


public class MyFactoryTwo implements Provider {

    @Override
    public MyInterface produce() {
        return new MyClassTwo();
    }

}
