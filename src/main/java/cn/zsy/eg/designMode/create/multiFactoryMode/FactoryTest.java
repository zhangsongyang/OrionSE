package cn.zsy.eg.designMode.create.multiFactoryMode;


public class FactoryTest {

    public static void main(String[] args) {
        MyFactory myFactory = new MyFactory();
        MyInterface myInterface = myFactory.produceOne();
        myInterface.print();
    }

}
