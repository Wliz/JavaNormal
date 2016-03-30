package org.wlz.normal.dymanicProxy;

/**
 * Created by lizhe on 2016/3/30.
 * 动态代理目标对象实例实现
 */
public class GunDog implements Dog {

    /**
     * 详细信息：detailed infomation
     */
    public void info() {
        System.out.println("猎狗详细信息");
    }

    /**
     * 实现run方法(被回调的目标对象方法)
     */
    public void run() {
        System.out.println("猎狗奔跑迅速");
    }
}
