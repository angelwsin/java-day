package org.java.jvm.share;

import org.java.jvm.memory.StackObj;

//Thread iterator
public abstract class ThreadClosure extends  StackObj{
    
   public  abstract void  do_thread(Thread thread);

}
