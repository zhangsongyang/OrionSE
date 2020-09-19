package cn.zsy.eg.javaBean;

import cn.zsy.vo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Java 内省(Introspector)
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        User user = new User();
        Stream.of(beanInfo.getPropertyDescriptors()).forEach((propertyDescriptor) -> {
            System.out.println(propertyDescriptor.toString());
            String name = propertyDescriptor.getName();
            Class<?> type = propertyDescriptor.getPropertyType();
            if ("name".equals(name)) {
                Method methodSetName = propertyDescriptor.getWriteMethod();
                System.out.println(methodSetName);
                try {
                    methodSetName.invoke(user, "alan");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println("set userName:" + user.getName());

                Method methodGetName = propertyDescriptor.getReadMethod();
                System.out.println(methodGetName);
                Object objUserName = null;
                try {
                    objUserName = methodGetName.invoke(user);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println("get userName:" + objUserName.toString());

            }

        });

        BeanUtils.setProperty(user, "name", "zhang");
        System.out.println("-->" + BeanUtils.getProperty(user, "name"));


    }
}
