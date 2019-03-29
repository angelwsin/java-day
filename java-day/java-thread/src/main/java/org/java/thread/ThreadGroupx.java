package org.java.thread;

public class ThreadGroupx {


    public static void main(String[] args) {

        for(ThreadGroup tg = Thread.currentThread().getThreadGroup();tg!=null;tg = tg.getParent()){
            Thread[] t = new Thread[tg.activeCount()];
            tg.enumerate(t);
            for(Thread td : t){
                System.out.println(td.getStackTrace());;
            }
        }

    }

}
