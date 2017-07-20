package org.java.thread;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       /*
        * java 线程模型
        * 
        * java 层
        * 
        *  new thread    
        * 
        * jvm 层
        *  new JavaThread
        * 
        * os  层
        *   new OSThread
        *   
        *   
        *   
        *   
        *   
        *   
        *   new thread  
        *     初始化信息 如栈 
        *     创建jvm  JavaThread 关联到 thread
        *     创建osThread  绑定到JavaThread上
        *     创建 内核线程   挂起  参数 thread  和线程回调方法
        *     
        *     thread.start()   把挂起的线程恢复就绪
        * 
        *   
        *   
        *    引入不同层次的thread  便于管理thread 
        *    java  thread
        *    jni   thread
        *    jvm   javaThread
        *    os     osThread
        *    内核            thread
        *   
        *   
        *   
        *   
        *   
        *   
        *   
        *   
        *   
        *   
        *   线程状态
        *   
        *    // Java Thread Status for JVMTI and M&M use.
  // This thread status info is saved in threadStatus field of
  // java.lang.Thread java class.
  enum ThreadStatus {
    NEW                      = 0,
    RUNNABLE                 = JVMTI_THREAD_STATE_ALIVE +          // runnable / running
                               JVMTI_THREAD_STATE_RUNNABLE,
    SLEEPING                 = JVMTI_THREAD_STATE_ALIVE +          // Thread.sleep()
                               JVMTI_THREAD_STATE_WAITING +
                               JVMTI_THREAD_STATE_WAITING_WITH_TIMEOUT +
                               JVMTI_THREAD_STATE_SLEEPING,
    IN_OBJECT_WAIT           = JVMTI_THREAD_STATE_ALIVE +          // Object.wait()
                               JVMTI_THREAD_STATE_WAITING +
                               JVMTI_THREAD_STATE_WAITING_INDEFINITELY +
                               JVMTI_THREAD_STATE_IN_OBJECT_WAIT,
    IN_OBJECT_WAIT_TIMED     = JVMTI_THREAD_STATE_ALIVE +          // Object.wait(long)
                               JVMTI_THREAD_STATE_WAITING +
                               JVMTI_THREAD_STATE_WAITING_WITH_TIMEOUT +
                               JVMTI_THREAD_STATE_IN_OBJECT_WAIT,
    PARKED                   = JVMTI_THREAD_STATE_ALIVE +          // LockSupport.park()
                               JVMTI_THREAD_STATE_WAITING +
                               JVMTI_THREAD_STATE_WAITING_INDEFINITELY +
                               JVMTI_THREAD_STATE_PARKED,
    PARKED_TIMED             = JVMTI_THREAD_STATE_ALIVE +          // LockSupport.park(long)
                               JVMTI_THREAD_STATE_WAITING +
                               JVMTI_THREAD_STATE_WAITING_WITH_TIMEOUT +
                               JVMTI_THREAD_STATE_PARKED,
    BLOCKED_ON_MONITOR_ENTER = JVMTI_THREAD_STATE_ALIVE +          // (re-)entering a synchronization block
                               JVMTI_THREAD_STATE_BLOCKED_ON_MONITOR_ENTER,
    TERMINATED               = JVMTI_THREAD_STATE_TERMINATED
  };
        */
    }
}
