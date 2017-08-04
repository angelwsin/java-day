package org.java.jvm.runtime;


//Normally we'd expect Monitor to extend Mutex in the sense that a monitor
//constructed from pthreads primitives might extend a mutex by adding
//a condvar and some extra metadata.  In fact this was the case until J2SE7.
//
//Currently, however, the base object is a monitor.  Monitor contains all the
//logic for wait(), notify(), etc.   Mutex extends monitor and restricts the
//visiblity of wait(), notify(), and notify_all().
//
//Another viable alternative would have been to have Monitor extend Mutex and
//implement all the normal mutex and wait()-notify() logic in Mutex base class.
//The wait()-notify() facility would be exposed via special protected member functions
//(e.g., _Wait() and _Notify()) in Mutex.  Monitor would extend Mutex and expose wait()
//as a call to _Wait().  That is, the public wait() would be a wrapper for the protected
//_Wait().
//
//An even better alternative is to simply eliminate Mutex:: and use Monitor:: instead.
//After all, monitors are sufficient for Java-level synchronization.   At one point in time
//there may have been some benefit to having distinct mutexes and monitors, but that time
//has past.
//
//The Mutex/Monitor design parallels that of Java-monitors, being based on
//thread-specific park-unpark platform-specific primitives.

public class Mutex extends Monitor{

}
