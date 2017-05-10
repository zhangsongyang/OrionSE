package cn.zsy.eg.spring.controller;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static final String SPRINT_ANNOTATION_XML = "sprint-annotation.xml";

    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext(SPRINT_ANNOTATION_XML);
        BaseController baseController = ac.getBean("baseController", BaseController.class);
        baseController.saveController();
    }

}
