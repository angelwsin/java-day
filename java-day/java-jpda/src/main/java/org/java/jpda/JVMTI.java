package org.java.jpda;

public class JVMTI {
    
    /**
     * 
     * 
     * Java 虚拟机工具接口（JVMTI） JVMTI（Java Virtual Machine Tool Interface）即指 Java 虚拟机工具接口，它是一套由虚拟机直接提供的 native 接口， 
     * 它处于整个 JPDA 体系的最底层，所有调试功能本质上都需要通过 JVMTI
     * 来提供。通过这些接口，开发人员不仅调试在该虚拟机上运行的 Java 程序， 还能查看它们运行的状态，设置回调函数，控制某些环境变量，
     * 从而优化程序性能。我们知道，JVMTI 的前身是 JVMDI 和 JVMPI， 它们原来分别被用于提供调试 Java 程序以及 Java 程序调节性能的功能。在 J2SE 5.0
     *  之后 JDK 取代了 JVMDI 和 JVMPI 这两套接口， JVMDI 在最新的 Java SE 6 中已经不提供支持，而 JVMPI 也计划在 Java SE 7 后被彻底取代。
     */

}
