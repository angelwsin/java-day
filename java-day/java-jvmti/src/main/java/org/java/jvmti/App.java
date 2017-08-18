package org.java.jvmti;

import java.util.Arrays;

/**
 * What is the JVM Tool Interface?
 * 
 * The JVMTM Tool Interface (JVM TI) is a programming interface used by development and monitoring tools. It provides both a way to inspect the state and to
 * control the execution of applications running in the JavaTM virtual machine (VM). JVM TI is intended to provide a VM interface for the full breadth of tools
 * that need access to VM state, including but not limited to: profiling, debugging, monitoring, thread analysis, and coverage analysis tools. JVM TI may not be
 * available in all implementations of the JavaTM virtual machine. JVM TI is a two-way interface. A client of JVM TI, hereafter called an agent, can be notified
 * of interesting occurrences through events. JVM TI can query and control the application through many functions, either in response to events or independent
 * of them. Agents run in the same process with and communicate directly with the virtual machine executing the application being examined. This communication
 * is through a native interface (JVM TI). The native in-process interface allows maximal control with minimal intrusion on the part of a tool. Typically,
 * agents are relatively compact. They can be controlled by a separate process which implements the bulk of a tool's function without interfering with the
 * target application's normal execution.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        
        //jvmti
        
        /**
         * 几个关键的数据结构
         * 
         * typedef struct jvmtiInterface_1_
         * 
         * struct _jvmtiEnv {
                    const struct jvmtiInterface_1_ *functions;
                    
         * see  hotspot
         * jvmti.h                     
         * jvmti 是基于事件机制的Event
         * Event Definitions   定义不同事件的处理方法
         * 
         *  Event Callback Structure 
         *  
         *  see  eventHandler.c
         * 
         * 
         * 
         * 
         * 启动 JvmtiAgentThread 线程处理 jvmti 请求
         * 
         * 实现方式  线程 处理 commandQueue 命令队列中的请求 命令中根据不同事件调用不同的处理方法
                                 回调 Event Callback
         * 
         * 
         * 
         * 
         * 基于 jvmti 实现的有jpda (JDWP)
         * 涉及到的 (dll)
         * jdwp.dll,npt.dll
         * 
         * -agentlib:jdwp=transport=dt_socket,server=y,address=8000
         * 
         * 根据端口启动一个 JvmtiAgent 
         * acceptThread 线程处理连接
         * spawnNewThread 创建事件处理线程
         */
        
        
        Arrays.sort(a);
    }
}
