package org.wlz.normal;

import javax.imageio.stream.FileImageInputStream;
import java.io.*;

/**
 * Created by lizhe on 2016/4/7.
 * File类的基本方法
 */
public class FileTest1 {
    public static void main(String[] args) throws IOException {
       /* // 使用当前路径来创建一个File对象“”空字符串代表当前路径
        // File对象代表文件或者目录
        File file = new File(".");
        // 获取文件名
        System.out.println(file.getName());     // 返回当前目录名.
        System.out.println(file.getParent());       // 相对路径不能得到父路径，相对找不到，返回null
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());     // 返回file对象
        System.out.println(file.getAbsoluteFile().getParent());
        // 当前目录创建临时文件createTempFile
        File newFile = File.createTempFile("aaa", ".txt", file);
        newFile.deleteOnExit();     // JVM结束时删除临时文件
        // 创建文件
        File timeFile = new File(System.currentTimeMillis() + "");      // 以当前时间在当前路径创建文件
        timeFile.deleteOnExit();
        System.out.println(timeFile.exists());
        timeFile.createNewFile();
        System.out.println(timeFile.mkdir());
        // 显示当前路径以及当前路径下的所有文件的目录
        String[] fileList = file.list();
        for(String str : fileList) {
            System.out.println(str);
        }
        // 磁盘根目录
        File[] files = File.listRoots();
        for (File fi : files) {
            System.out.println(fi);
        }


        // 使用文件过滤器进行文件过滤
        // Lammber表达式不可用
        //String[] fileNames = file.list((dir, name) -> name.endsWith(".java") || new File(name).isDirectory());
        String[] fileNames = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java") || new File(name).isDirectory();
            }
        });
        for (String name : fileNames) {
            System.out.println(name);
        }

        // 字符流操作
        FileReader fr = new FileReader("E:\\IdeaProject\\ProjectExercise\\JavaNormal\\src\\main\\java\\org\\wlz\\normal\\TestFile.txt");
        char[] chBuf = new char[32];
        int hasRead = 0;
        while((hasRead = fr.read(chBuf)) > 0) {
            System.out.println(new String(chBuf, 0, hasRead));
        }
        fr.close();*/

        // FileOutputStream
       /* FileInputStream fis = new FileInputStream("E:\\IdeaProject\\ProjectExercise\\JavaNormal\\src\\main\\java\\org\\wlz\\normal\\TestFile.txt");
        FileOutputStream fos = new FileOutputStream("E:\\IdeaProject\\ProjectExercise\\JavaNormal\\src\\main\\java\\org\\wlz\\normal\\TestOutputStream.txt");
        byte[] buff = new byte[1024];
        int hasRead = 0;
        while((hasRead = fis.read(buff)) > 0) {
            fos.write(buff, 0, hasRead);
        }
        fos.close();
        fis.close();*/

       /* FileReader fr = new FileReader("E:/IdeaProject/ProjectExercise/JavaNormal/src/main/java/org/wlz/normal/TestFile.txt");
        FileWriter fw = new FileWriter("E:/IdeaProject/ProjectExercise/JavaNormal/src/main/java/org/wlz/normal/TestOutputStream.txt");

        char[] chBuf = new char[32];
        int hasRead = 0;
        while((hasRead = fr.read(chBuf)) > 0) {
            fw.write(chBuf, 0, hasRead);
        }
        fw.close();
        fr.close();*/

        // 单独写入
        FileWriter fw = new FileWriter("E:/IdeaProject/ProjectExercise/JavaNormal/src/main/java/org/wlz/normal/TestOutputStream.txt");
        fw.write("我是yizhixiaoxiaoya");
        fw.append("wagshi");
        fw.close();

    }

}
