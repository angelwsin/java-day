package org.java.jpda;

public class Agent {
    
    /**
     * Agent 的主要功能是通过一系列的在虚拟机上设置的回调（callback）函数完成的，一旦某些事件发生，Agent 所设置的回调函数就会被调用，来完成特定的需求。
     * 
     * Agent 的工作过程 启动 Agent 是在 Java 虚拟机启动之时加载的，这个加载处于虚拟机初始化的早期，在这个时间点上： 所有的 Java 类都未被初始化； 所有的对象实例都未被创建； 因而，没有任何 Java 代码被执行； 但在这个时候，我们已经可以： 操作 JVMTI 的 Capability
     * 参数； 使用系统参数； 动态库被加载之后，虚拟机会先寻找一个 Agent 入口函数： 1 JNIEXPORT jint JNICALL Agent_OnLoad(JavaVM *vm, char *options, void *reserved)
     * 
     * 
     * Agent 还可以在运行时加载 Java Instrument 模块 这个新功能事实上也是 Java Agent 的一个实现。具体说来，虚拟机会在运行时监听并接受 Agent 的加载，在这个时候，它会使用 Agent 的： JNIEXPORT jint JNICALL
     * Agent_OnAttach(JavaVM* vm, char *options, void *reserved);
     * 
     * 卸载 
     * 最后，Agent 完成任务，或者虚拟机关闭的时候，虚拟机都会调用一个类似于类析构函数的方法来完成最后的清理任务，注意这个函数和虚拟机自己的 VM_DEATH 事件是不同的。 
     * JNIEXPORT void JNICALL Agent_OnUnload(JavaVM *vm)
     * 
     * 
     * 
     * agent种类
     *  specified native agent
     * -agentlib:libname[=options] 
     * -agentpath:pathname[=options]
     * 
     * specified Java programming language agent.--java.lang.instrument
     * -javaagent:jarpath[=options]
     */

}
