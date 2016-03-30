package org.wlz.normal.dymanicProxy;

/**
 * Created by lizhe on 2016/3/30.
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
         // 创建原始的Dog对象，作为目标代理对象
        Dog target = new GunDog();
        Dog dog = (Dog) MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
