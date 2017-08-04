package org.java.tools.javac;

import com.sun.tools.javac.Main;

/**
 * tool javac  命令
 * @author Administrator
 *
 */
public class JavaC {

    public static void main(String[] args) {
          try {
              
            Main.main(new String[]{"D:\\git\\java-day\\java-day\\java-tools\\src\\test\\java\\org\\java\\tools\\Hello.java"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
