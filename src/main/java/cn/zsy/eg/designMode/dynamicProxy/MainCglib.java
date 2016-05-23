package cn.zsy.eg.designMode.dynamicProxy;


import net.sf.cglib.proxy.Proxy;


public class MainCglib {

    public static void main(String[] args) {
        ArithmeticComputation target = new ArithmeticComputationImpl();
        ArithmeticComputation o = buildProxyService(ArithmeticComputation.class, target);
        System.out.println(o.add(1, 2));
    }

    public static <T> T buildProxyService(Class<T> clazz, Object target) {
        T service = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandlerImpl(target));
        return service;
    }

}
