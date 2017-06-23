package org.java.jmx.mbean;

public class Print implements PrintMBean{

    public void print(String ct) {
        
        System.out.println(ct);
        
    }

}
