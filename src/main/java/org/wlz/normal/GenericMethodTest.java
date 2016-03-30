package org.wlz.normal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by lizhe on 2016/3/30.
 * 泛型方法定义声明：修饰符 <形参类型声明T, E....> 返回值类型 methodName(形参) {method body}
 */
public class GenericMethodTest {
    /*
    在静态方法，静态代码块以及静态变量的声明和初始化中不能使用类型形参
     */
    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T i : a) {
            c.add(i);
        }
    }

    public static void main(String[] args) {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<Object>();
        fromArrayToCollection(oa, co);
        String[] sa = new String[100];
        Collection<String> cs = new ArrayList();
        fromArrayToCollection(sa, cs);
        List<Object> il = new ArrayList();

       /* Collection<Integer> cl = new ArrayList();
        cl.add(4);
        copy(il, cl);*/
    }

    public static <T> void copy(List<T> dest,List<? extends T> src) {
        System.out.println(src.get(0));
    }
}
