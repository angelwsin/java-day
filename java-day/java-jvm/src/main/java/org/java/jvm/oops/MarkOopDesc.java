package org.java.jvm.oops;


//The markOop describes the header of an object.
//
//Note that the mark is not a real oop but just a word.
//It is placed in the oop hierarchy for historical reasons.
//
//Bit-format of an object header (most significant first, big endian layout below):
//
//32 bits:
//--------
//          hash:25 ------------>| age:4    biased_lock:1 lock:2 (normal object)
//          JavaThread*:23 epoch:2 age:4    biased_lock:1 lock:2 (biased object)
//          size:32 ------------------------------------------>| (CMS free block)
//          PromotedObject*:29 ---------->| promo_bits:3 ----->| (CMS promoted object)
//
//64 bits:
//--------
//unused:25 hash:31 -->| unused:1   age:4    biased_lock:1 lock:2 (normal object)
//JavaThread*:54 epoch:2 unused:1   age:4    biased_lock:1 lock:2 (biased object)
//PromotedObject*:61 --------------------->| promo_bits:3 ----->| (CMS promoted object)
//size:64 ----------------------------------------------------->| (CMS free block)
//
//unused:25 hash:31 -->| cms_free:1 age:4    biased_lock:1 lock:2 (COOPs && normal object)
//JavaThread*:54 epoch:2 cms_free:1 age:4    biased_lock:1 lock:2 (COOPs && biased object)
//narrowOop:32 unused:24 cms_free:1 unused:4 promo_bits:3 ----->| (COOPs && CMS promoted object)
//unused:21 size:35 -->| cms_free:1 unused:7 ------------------>| (COOPs && CMS free block)
//
//- hash contains the identity hash value: largest value is
// 31 bits, see os::random().  Also, 64-bit vm's require
// a hash value no bigger than 32 bits because they will not
// properly generate a mask larger than that: see library_call.cpp
// and c1_CodePatterns_sparc.cpp.
//
//- the biased lock pattern is used to bias a lock toward a given
// thread. When this pattern is set in the low three bits, the lock
// is either biased toward a given thread or "anonymously" biased,
// indicating that it is possible for it to be biased. When the
// lock is biased toward a given thread, locking and unlocking can
// be performed by that thread without using atomic operations.
// When a lock's bias is revoked, it reverts back to the normal
// locking scheme described below.
//
// Note that we are overloading the meaning of the "unlocked" state
// of the header. Because we steal a bit from the age we can
// guarantee that the bias pattern will never be seen for a truly
// unlocked object.
//
// Note also that the biased state contains the age bits normally
// contained in the object header. Large increases in scavenge
// times were seen when these bits were absent and an arbitrary age
// assigned to all biased objects, because they tended to consume a
// significant fraction of the eden semispaces and were not
// promoted promptly, causing an increase in the amount of copying
// performed. The runtime system aligns all JavaThread* pointers to
// a very large value (currently 128 bytes (32bVM) or 256 bytes (64bVM))
// to make room for the age bits & the epoch bits (used in support of
// biased locking), and for the CMS "freeness" bit in the 64bVM (+COOPs).
//
// [JavaThread* | epoch | age | 1 | 01]       lock is biased toward given thread
// [0           | epoch | age | 1 | 01]       lock is anonymously biased
//
//- the two lock bits are used to describe three states: locked/unlocked and monitor.
//
// [ptr             | 00]  locked             ptr points to real header on stack
// [header      | 0 | 01]  unlocked           regular object header
// [ptr             | 10]  monitor            inflated lock (header is wapped out)
// [ptr             | 11]  marked             used by markSweep to mark an object
//                                            not valid at any other time
//
// We assume that stack/thread pointers have the lowest two bits cleared.

//  描述对象头mark word
public class MarkOopDesc  extends OopDesc {

}
