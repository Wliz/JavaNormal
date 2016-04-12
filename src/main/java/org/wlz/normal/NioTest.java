package org.wlz.normal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by lizhe on 2016/4/8.
 * nio的buffer使用理解
 */
public class NioTest {
    public static void main(String[] args) {
        /*// create buffer
        CharBuffer charBuffer = CharBuffer.allocate(8);     // capacity=8
        System.out.println("capacity: " + charBuffer.capacity());
        System.out.println("limit: " + charBuffer.limit());
        System.out.println("position: " + charBuffer.position());
        // put element into charBuffer
        charBuffer.put('a');
        charBuffer.put('b');
        charBuffer.put('c');
        System.out.println("添加元素后，position向后移动为：" + charBuffer.position());
        // 调用flip（），开始取数据阶段
        charBuffer.flip();
        System.out.println("执行flip方法后，position：" + charBuffer.position());
        System.out.println("limit: " + charBuffer.limit());
        System.out.println("capacity: " + charBuffer.capacity());
        // 执行clear方法，不清楚buffer中数据，只是改变标记
        charBuffer.clear();
        System.out.println("执行clear方法后，position：" + charBuffer.position());
        System.out.println("limit: " + charBuffer.limit());
        System.out.println("capacity: " + charBuffer.capacity());
        // 绝对操作
        System.out.println("第三个元素为：" + charBuffer.get(3));      // 从0开始，为null，无异常
        System.out.println("第三个元素为：" + charBuffer.get(2));*/

       /* File file = new File("E:/IdeaProject/ProjectExercise/JavaNormal/src/main/java/org/wlz/normal/TestOutputStream.txt");
        // FileInputStream、FileOutputStream
        try{
            FileChannel fci = new FileInputStream(file).getChannel();
            FileChannel fco = new FileOutputStream("E:/IdeaProject/ProjectExercise/JavaNormal/src/main/java/org/wlz/normal/TestOutputStream2.txt").getChannel();
            MappedByteBuffer mbb = fci.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            System.out.println(mbb.toString());     // 字节操作
            // 字符解码器
            Charset charset = Charset.forName("utf8");
            fco.write(mbb);     // 通过通道写入到文件中
            mbb.clear();        // 回去写入数据标记
            // 创建解码器
            CharsetDecoder cd = charset.newDecoder() ;
            CharBuffer cb = cd.decode(mbb);
            System.out.println(cb);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // CharSet字符集编码解码
        Charset charset = Charset.forName("utf-8");
        CharBuffer cb = CharBuffer.allocate(10);        // capacity=10
        cb.put("王");
        cb.put("里");
        cb.put("好");
        cb.put("不");

        cb.flip();
        System.out.println(cb);
        ByteBuffer bb = charset.encode(cb);
        for (int i = 0; i < bb.limit(); i ++) {
            System.out.print(bb.get(i) + "  ");
        }
        System.out.println();
        System.out.println(charset.decode(bb));

    }
}
