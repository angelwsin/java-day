package org.java.thread;

public class ThreadLocalx {

//
//       原理
//
//    线程共享变量缓存如下：
//
//    Thread.ThreadLocalMap<ThreadLocal, Object>;
//
// 1、Thread: 当前线程，可以通过Thread.currentThread()获取。
//
//            2、ThreadLocal：我们的static ThreadLocal变量。
//
//            3、Object: 当前线程共享变量。
//
//    我们调用ThreadLocal.get方法时，实际上是从当前线程中获取ThreadLocalMap<ThreadLocal, Object>，然后根据当前ThreadLocal获取当前线程共享变量Object。
//
//    ThreadLocal.set，ThreadLocal.remove实际上是同样的道理。
//
//
//
//    这种存储结构的好处：
//
//            1、线程死去的时候，线程共享变量ThreadLocalMap则销毁。
//
//            2、ThreadLocalMap键值对数量为ThreadLocal的数量，一般来说ThreadLocal数量很少，相比在ThreadLocal中用MapMap<Thread, Object>键值对存储线程共享变量（Thread数量一般来说比ThreadLocal数量多），性能提高很多。
//
//
//
//    关于ThreadLocalMap<ThreadLocal, Object>弱引用问题：
//
//    当线程没有结束，但是ThreadLocal已经被回收，则可能导致线程中存在ThreadLocalMap<null, Object>的键值对，造成内存泄露。（ThreadLocal被回收，ThreadLocal关联的线程共享变量还存在）。
//
//    虽然ThreadLocal的get，set方法可以清除ThreadLocalMap中key为null的value，但是get，set方法在内存泄露后并不会必然调用，所以为了防止此类情况的出现，我们有两种手段。
//
//            1、使用完线程共享变量后，显示调用ThreadLocalMap.remove方法清除线程共享变量；
//
//            2、JDK建议ThreadLocal定义为private static，这样ThreadLocal的弱引用问题则不存在了。


    public static void main(String[] args) {
         Thread.currentThread();//ThreadLocal.ThreadLocalMap
    }
}
