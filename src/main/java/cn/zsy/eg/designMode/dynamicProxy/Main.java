package cn.zsy.eg.designMode.dynamicProxy;


public class Main {

    public static void main(String[] args) {
//        ArithmeticComputation arithmeticComputation = new ArithmeticComputationImpl();
//        int resultsum = arithmeticComputation.add(1, 2);
//        System.out.println(resultsum);

        ArithmeticComputation target = new ArithmeticComputationImpl();
        ArithmeticComputation proxy = new ArithmeticComputationLoggingProxy(target).getLoggingProxy(); //动态代理
        int resultsum_p = proxy.add(1, 2);
        System.out.println(resultsum_p);

    }

}
