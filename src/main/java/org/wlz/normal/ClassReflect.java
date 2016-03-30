package org.wlz.normal;

/**
 * Created by lizhe on 2016/3/29.
 * 类反射相关操作以及判断
 */

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * 注解操作
 */
@Repeatable(Annos.class)
@interface Anno{}
@Retention(value= RetentionPolicy.RUNTIME)
@interface Annos{
    Anno[] value();
}

/**
 * 使用三个注解修饰该类
 */
@SuppressWarnings(value = "unchecked")
@Deprecated
@Anno
public class ClassReflect {
    private ClassReflect(){}        // 私有构造器
    public ClassReflect(String name) {
        System.out.println("执行包含参数的构造器");
    }
    public void info(){}
    public void info(String str) {
        System.out.println("执行有参数的info方法，其参数值为：" + str);
    }
    // 顶一个测试使用的内部类
    class Inner{}
    public static void main(String[] args) {
        // 利用反射获取ClassReflect对应的class对象
        Class<ClassReflect> clazz = ClassReflect.class;
        // 获取该类对应的所有构造器
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("该类所对应的全部构造器为：");
        for (Constructor c : ctors) {
            System.out.println(c);
        }
        // 获取全部对应的public构造器
        Constructor[] pubCtors = clazz.getConstructors();
        System.out.println("该类对应的所有公共构造器：");
        for (Constructor c : pubCtors) {
            System.out.println(c);
        }

        // 获取注解
        Annotation[] anns = clazz.getAnnotations();
        System.out.println("该类对应的注解为：");
        for (Annotation a : anns) {
            System.out.println(a);
        }

        System.out.println("该类上对应的@SuppressWarnings注解为：" + Arrays.toString(clazz.getAnnotationsByType(SuppressWarnings.class)));

        // 获取内部类的两种方法
        Class<?>[] inners = clazz.getDeclaredClasses();
        System.out.println("该类中的全部内部类Wie：");
        for (Class c : inners) {
            System.out.println(c);
        }

        // 使用Class.forName()来反射加载对应的类
        try {
            Class iClazz = Class.forName("org.wlz.normal.ClassReflect$Inner");
            System.out.println("该内部类对应的外部类是：" + iClazz.getDeclaringClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
