package cn.zsy.eg.spring.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-aop.xml");
        ArithmeticCalculator arithmeticCalculator = applicationContext.getBean("arithmeticCalculator", ArithmeticCalculator.class);
        System.out.println(arithmeticCalculator.getClass().getName());

        int result = arithmeticCalculator.add(1, 2);
        System.out.println("result:" + result);

        result = arithmeticCalculator.div(1000, 10);
        System.out.println("result:" + result);

    }

}
