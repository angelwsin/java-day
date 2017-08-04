package org.java.jvm.runtime;

import org.java.jvm.memory.CHeapObj;


//See orderAccess.hpp.  We assume throughout the VM that mutex lock and
//try_lock do fence-lock-acquire, and that unlock does a release-unlock,
//*in that order*.  If their implementations change such that these
//assumptions are violated, a whole lot of code will break.

//The default length of monitor name is chosen to be 64 to avoid false sharing.
public class Monitor<mtInternal> extends CHeapObj{

}
