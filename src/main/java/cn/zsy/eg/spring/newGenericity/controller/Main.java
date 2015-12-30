package cn.zsy.eg.spring.newGenericity.controller;


import cn.zsy.eg.spring.newGenericity.entity.User;
import cn.zsy.eg.spring.newGenericity.service.UserServiceT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("sprint-annotation.xml");
        UserServiceT baseController = ac.getBean("userServiceT", UserServiceT.class);
        User user = new User();
        baseController.saveService(user);
    }

}
