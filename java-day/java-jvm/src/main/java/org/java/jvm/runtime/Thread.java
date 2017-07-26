package org.java.jvm.runtime;

import org.java.jvm.utilities.ThreadShadow;

//Class hierarchy
//- Thread
//- NamedThread
//  - VMThread
//  - ConcurrentGCThread
//  - WorkerThread
//    - GangWorker
//    - GCTaskThread
//- JavaThread
//- WatcherThread
public class Thread extends ThreadShadow{

}




// threads

enum ThreadType {
  vm_thread,
  cgc_thread,        // Concurrent GC thread
  pgc_thread,        // Parallel GC thread
  java_thread,
  compiler_thread,
  watcher_thread,
  os_thread
};