package cn.zsy.eg.spring.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("sprint-annotation.xml");
        BaseController baseController = ac.getBean("baseController", BaseController.class);
        baseController.saveController();
    }

}
