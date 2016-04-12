package org.wlz.normal;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by lizhe on 2016/4/10.
 */
public class CallableFuture {
    public static void main(String[] args) {
        // 创建线程Callable和Future
        // 一、使用lambda表达式
        CallableFuture callableFuture = new CallableFuture();
        // 使用FutureTask包装callable对象（使用lambda表达式代替callable实现类）
        // 使用lambda表达式需要修改项目语言级别支持
       /* FutureTask<Integer> futureTask = new FutureTask<Integer>((Callable<Integer>)()->{
            int i = 0;
            for (; i < 50; i ++) {
                System.out.println(Thread.currentThread().getName() + " 的循环变量的值为：" + i);
            }
            Thread.sleep(2000);
            // call方法可以有返回值和抛出异常
            return i;
        });*/

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableImplement());

        for (int i = 0; i < 100; i ++){
            System.out.println(Thread.currentThread().getName() + " 的循环变量的值为：" + i);
            if (i == 20) {
                new Thread(futureTask, "CallableFuture").start();
            }
        }
         try {
             // 获取线程返回值get方法会调用call方法导致主线程阻塞
             System.out.println("子线程的返回值:  " + futureTask.get());
         } catch (Exception e) {
             e.printStackTrace();
         }
        System.out.println("lsjdf");
    }
}
