package org.wlz.normal;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhe on 2016/3/29.
 */
public class StringDemo {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i =0; i < urls.length; i ++) {
            System.out.println(urls[i].toExternalForm());
        }
        List<String> handler = new ArrayList<String>();
        for (int i = 0; i < 1000; i ++) {
            HugStr h = new HugStr();
            ImprovedSubString iss = new ImprovedSubString();
            handler.add(h.getSubString(1, 5));
            handler.add(iss.getSubString(1, 5));
        }
    }

    static class HugStr {
        private String str = new String(new char[800000]);

        public String getSubString(int begin, int end) {
            return str.substring(begin, end);
        }
    }

    static class ImprovedSubString {
        private String str = new String(new char[10000000]);

        public String getSubString(int begin, int end) {
            return new String(str.substring(begin, end));
        }
    }

}
