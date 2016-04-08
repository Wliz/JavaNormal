package org.wlz.normal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by lizhe on 2016/4/7.
 * 自定义序列化
 */
public class TransientTest {
    public static void main(String[] args) {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transient.txt"));
            Person p = new Person(500, "孙悟空");
            oos.writeObject(p);
            Person op = (Person)ois.readObject();
            System.out.println(op.getName());
        } catch(Exception e) {
            // jdk1.7后，try块会自动管理流操作
            e.printStackTrace();
        }
    }
}
