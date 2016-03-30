package org.wlz.normal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lizhe on 2016/3/30.
 * Proxy,InvocationHandler动态代理处理创建对象，是spring事务等处理的AOP的基础
 */
interface Person {
    void walk();

    void sayHello(String name);
}

class MyInocationHandler implements InvocationHandler {
    // 自定义动态代理处理类，需要实现相应的invoke方法
    // 并且执行动态代理对象的所有方法时，都会被替换成执行处理类实例对象中的invoke方法
    /*
    参数：proxy：代表动态代理对象
    method：代表正在执行的方法
    args：代表调用目标方法时传入的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("-----正在执行的方法" + method);
        if (args != null) {
            // 处理参数
            System.out.println("下面是执行该方法时传入的参数");
            for (Object o : args) {
                System.out.println(o);
            }
        } else {
            System.out.println("该方法没有实参");
        }
        return null;
    }

}

public class ProxyExample {
    public static void main(String[] args) throws Exception {
        MyInocationHandler myIH = new MyInocationHandler();
        // Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, myIH);
        // person.walk();
        // person.sayHello("代理测试");
        // 使用getProxyClass来创建动态代理对象
        Class personClazz = Proxy.getProxyClass(Person.class.getClassLoader(), new Class[]{Person.class});
        Constructor ctor = personClazz.getConstructor(new Class[]{InvocationHandler.class});
        Person person = (Person) ctor.newInstance(new Object[]{myIH});
        person.walk();
        person.sayHello("测试使用动态代理");

    }
}
