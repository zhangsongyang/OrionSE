package cn.zsy.eg.spring;

import cn.zsy.eg.spring.beans.UserBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserBean userBean = context.getBean("userBean", UserBean.class);
        String user = userBean.toString();
        System.out.println(user);
        UserBean userBean1 = context.getBean("userBean1", userBean.getClass());
        System.out.println(userBean1.toString());

    }


}
