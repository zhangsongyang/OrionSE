package cn.zsy.eg.designMode.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticComputationLoggingProxy {

    //要代理的对象
    private ArithmeticComputation target;

    public ArithmeticComputationLoggingProxy(ArithmeticComputation target) {
        this.target = target;
    }

    public ArithmeticComputation getLoggingProxy() {
        ArithmeticComputation proxy = null;
        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有那些方法
        Class[] interfaces = new Class[]{ArithmeticComputation.class};
        //当调用代理对象其中的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //日志
                System.out.println("The method " + methodName +  " begin with " + Arrays.asList(args));
                //执行方法
                Object result = method.invoke(target, args);
                //日志
                System.out.println("The method " + methodName + " ends with " + result);
                return result;
            }
        };
        proxy = (ArithmeticComputation) Proxy.newProxyInstance(loader, interfaces, h);
        return proxy;
    }


}
