package cn.zsy.eg.designMode.create.abstractFactoryMode;


public class FactoryTest {

    public static void main(String[] args) {
        Provider provider = new MyFactoryOne();
        MyInterface myi = provider.produce();
        myi.print();
    }

}
