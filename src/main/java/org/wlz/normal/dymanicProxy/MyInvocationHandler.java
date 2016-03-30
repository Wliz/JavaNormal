package org.wlz.normal.dymanicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by lizhe on 2016/3/30.
 * dynamic proxy中handler，implements InvocationHandler
 */
public class MyInvocationHandler implements InvocationHandler {
    // 回调的目标对象方法
    private Object target;

    // setter方法
    public void setTarget(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
        DogUtil dogUtil = new DogUtil();
        dogUtil.method1();
        // 回调目标对象的方法
        Object result  = method.invoke(target, args);
        dogUtil.method2();
        return result;
    }
}
