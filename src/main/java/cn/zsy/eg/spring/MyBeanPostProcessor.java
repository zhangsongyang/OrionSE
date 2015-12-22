package cn.zsy.eg.spring;


import cn.zsy.eg.spring.beans.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person){
            System.out.println(bean + "----postProcessBeforeInitialization----" + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person){
            System.out.println(bean + "----postProcessAfterInitialization----" + beanName);
            ((Person) bean).setName("www3333");
        }
        return bean;
    }

}
