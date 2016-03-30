package org.wlz.normal.dymanicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by lizhe on 2016/3/30.
 * 动态代理对象生成工厂
 */
public class MyProxyFactory {
    public static Object getProxy(Object target) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.setTarget(target);
        // 创建并返回一个proxy动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), myInvocationHandler);
    }
}
