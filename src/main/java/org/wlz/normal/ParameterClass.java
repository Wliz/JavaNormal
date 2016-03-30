package org.wlz.normal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lizhe on 2016/3/30.
 * 泛型与反射的结合测试
 */
public class ParameterClass {

    public static <T> T getInstance(Class<T> clazz) {
        try {

            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Date date = ParameterClass.getInstance(Date.class);
        // 定义一个数组
        /*Integer[] ia = new Integer[5];
        Number[] nb = ia;
        nb[0] = 0.5;*/

        // ？泛型的使用，不能再集合中添加元素
        /*List<?> c = new ArrayList();
        c.add(new Object());*/
    }
}
