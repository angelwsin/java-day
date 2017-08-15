package org.java.hotspot;

public class CreateVm {
    
    
    //Threads::create_vm 创建 jvm
    
    
    /**
     * 
     * jvm 启动的大致步骤
     * 
     *  
     */
    
    
    
/*
 * 1)-agentlib:  -agentpath:  and converted -Xrun 参数解析 并  Invokes Agent_OnLoad
 * 
 * 如windows 平台  instrument.dll(支持 java.lang.instrument),jawt.dll(支持 jpda)
 *  // Create agents for -agentlib:  -agentpath:  and converted -Xrun
 // Invokes Agent_OnLoad
 // Called very early -- before JavaThreads exist
*/
    
    
/**
 * 初始化
 * 如  jmx   Management::init();ThreadService::init();RuntimeService::init();ClassLoadingService::init();
 */
    
    
/**
 * 启动 VMThread 线程 单例模式
 * 
 * 在 VMThread 中维护者一个 VM operation queue（_vm_queue)
 * 
 * 处理 VM operation 操作
 * 具体的操作 见 VM_Operation 的子类的evaluate方法
 * 
 *使用  VMThread::execute(&VM_Operation) 提交操作
 */
    
    
    
  /*
   * Attach Listener 线程 处理  AttachOperation 请求
   * 
   *  实现维护一个 AttachOperation的队列
   * 
   *   
   *   
   */
    
    
    
    
    
    
}
