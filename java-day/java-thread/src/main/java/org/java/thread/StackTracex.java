package org.java.thread;

import sun.jvm.hotspot.StackTrace;

public class StackTracex {


    public static void main(String[] args) {

        //得到当前线程的堆栈信息
        Throwable t = new Throwable();
        System.out.println(t.getStackTrace()[0].getMethodName());
    }
}
