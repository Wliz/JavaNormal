package org.wlz.normal;

import java.util.concurrent.Callable;

/**
 * Created by lizhe on 2016/4/10.
 */
public class CallableImplement implements Callable {
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 100; i ++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量的值为：" + i);
        }
        return i;
    }
}
