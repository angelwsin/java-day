package com.jvm.Run_Time_Data_Areas;

public class PCRegister {
    
    
   /* The Java Virtual Machine can support many threads of execution at once (JLS
            §17). Each Java Virtual Machine thread has its own pc (program counter) register.
            At any point, each Java Virtual Machine thread is executing the code of a single
            method, namely the current method (§2.6) for that thread. If that method is not
            native, the pc register contains the address of the Java Virtual Machine instruction
            currently being executed. If the method currently being executed by the thread is
            native, the value of the Java Virtual Machine's pc register is undefined. The Java
            Virtual Machine's pc register is wide enough to hold a returnAddress or a native
            pointer on the specific platform.
*/
    
    
    /**
     * jvm 同一时间支持多线程并行的执行，jvm每一个线程都有自己的pc
     * 
     * 非native   the pc register contains the address of the Java Virtual Machine instruction currently being executed
     * native  pc未定义
     */

}
