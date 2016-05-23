package cn.zsy.eg.designMode.dynamicProxy;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object proxys;

    public InvocationHandlerImpl(Object proxy) {
        this.proxys = proxy;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy: " + proxy.getClass() + "\nmethod: " + method + "\nobjects: " + args);
        if (null != args) {
            for (Object arg : args) {
                System.out.println("args: " + arg);
            }
        }
        return method.invoke(proxys, args);
    }

}
