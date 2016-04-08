package org.wlz.normal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by lizhe on 2016/4/7.
 */
public class Person implements Serializable {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Person(){}

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.writeObject(new StringBuffer(name).reverse());
        oos.writeInt(age);
    }

    private void readObject(ObjectInputStream ois) throws Exception{
        this.name = ((StringBuffer)ois.readObject()).reverse().toString();
        this.age = ois.readInt();
    }


}
