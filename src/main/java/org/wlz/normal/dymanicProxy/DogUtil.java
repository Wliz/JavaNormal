package org.wlz.normal.dymanicProxy;

/**
 * Created by lizhe on 2016/3/30.
 * dynamic proxy中添加的通用方法，在调用目标对象方法前后的通用操作
 */
public class DogUtil {
    public void method1() {
        System.out.println("========模拟的第一个通用方法");
    }

    public void method2() {
        System.out.println("++++++++++++++++==模拟的第二个通用方法");
    }


}
