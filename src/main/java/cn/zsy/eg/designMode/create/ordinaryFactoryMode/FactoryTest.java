package cn.zsy.eg.designMode.create.ordinaryFactoryMode;

/**
 * 普通工厂模式
 */
public class FactoryTest {


    public static void main(String[] args) {
        MyFactory myFactory = new MyFactory();
        MyInterface myInterface = myFactory.produce("Two");
        myInterface.print();
    }

}
