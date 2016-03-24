package cn.zsy.eg.designMode.create.staticFactoryMode;


public class FactoryTest {

    public static void main(String[] args) {
        MyInterface myi = MyFactory.produceOne();
        myi.print();
    }

}
