package org.java.jpda;

public class JPDA {
    
    /**
     * Java 的调试体系—— JPDA
     * 
     * java 程序都是运行在 Java 虚拟机上的，我们要调试 Java 程序，
     * 事实上就需要向 Java 虚拟机请求当前运行态的状态，并对虚拟机发出一定的指令，设置一些回调等等，那么 Java 的调试体系，就是虚拟机的一整套用于调试的工具和接口。
     *  JVMTI（Java Virtual Machine Tool Interface），都是 Java 平台调试体系（Java Platform Debugger Architecture，JPDA）的重要组成部分
     *  
     *  
     *  JPDA 组成模块
     *  JPDA 定义了一个完整独立的体系，它由三个相对独立的层次共同组成，而且规定了它们三者之间的交互方式，或者说定义了它们通信的接口。
     *  这三个层次由低到高分别是 Java 虚拟机工具接口（JVMTI），Java 调试线协议（JDWP）以及 Java 调试接口（JDI）。
     *  这三个模块把调试过程分解成几个很自然的概念：调试者（debugger）和被调试者（debuggee），以及他们中间的通信器
     *  
     *  http://docs.oracle.com/javase/7/docs/technotes/guides/jpda/architecture.html
     */

}
