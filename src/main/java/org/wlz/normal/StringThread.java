package org.wlz.normal;

/**
 * Created by lizhe on 2016/3/29.
 * StringBuffer,StringBuild效率差距（多线程操作）
 */
public class StringThread {
    private StringBuffer sbf = new StringBuffer();
    private StringBuilder sbl = new StringBuilder();

    public void log(String message) {
        for (int i = 0; i < 10; i++) {
            sbf.append(i);
            //sbf.append("\n");
            sbl.append(i);
            //sbl.append("\n");
        }
    }

    public void getContents() {
        System.out.println("StringBuffer start");
        System.out.println(sbf);
        System.out.println("StringBuffer end");
    }

    public void getContents1() {
        System.out.println("StringBuilder start");
        System.out.println(sbl);
        System.out.println("StringBuilder end");
    }

    public static void main(String[] args) {
        StringThread st = new StringThread();
        StrThread st1 = new StrThread(st, "love");
        StrThread st2 = new StrThread(st, "apple");
        StrThread st3 = new StrThread(st, "egg");

        st1.start();
        st2.start();
        st3.start();
        try {
            st1.join();
            st2.join();
            st3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
// 多线程操作（进而判断StringBuffer线程安全，但效率较低；StringBuilder非线程同步，效率较高）
class StrThread extends Thread {
    String message;
    StringThread st;

    public StrThread(StringThread st, String message) {
        this.message = message;
        this.st = st;
    }
    // 多线程必须重写方法
    public void run() {
        st.log(message);
        st.getContents1();
        try {
            sleep(500000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
