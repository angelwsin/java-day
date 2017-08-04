package org.java.jvmti;

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
        
    }
}
