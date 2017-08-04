package org.java.jvm.runtime;

import org.java.jvm.memory.CHeapObj;

public class VM_Operation<mtInternal> extends CHeapObj{

    enum Priorities {
        SafepointPriority, // Highest priority (operation executed at a safepoint)
        MediumPriority,    // Medium priority
        nof_priorities
     };
    
   // VM_Operation _queue       [nof_priorities];
}




/*
#define VM_OP_ENUM(type)   VMOp_##type,

//Note: When new VM_XXX comes up, add 'XXX' to the template table.
#define VM_OPS_DO(template)                       \
template(Dummy)                                 \
template(ThreadStop)                            \
template(ThreadDump)                            \
template(PrintThreads)                          \
template(FindDeadlocks)                         \
template(ForceSafepoint)                        \
template(ForceAsyncSafepoint)                   \
template(Deoptimize)                            \
template(DeoptimizeFrame)                       \
template(DeoptimizeAll)                         \
template(ZombieAll)                             \
template(UnlinkSymbols)                         \
template(Verify)                                \
template(PrintJNI)                              \
template(HeapDumper)                            \
template(DeoptimizeTheWorld)                    \
template(CollectForMetadataAllocation)          \
template(GC_HeapInspection)                     \
template(GenCollectFull)                        \
template(GenCollectFullConcurrent)              \
template(GenCollectForAllocation)               \
template(ParallelGCFailedAllocation)            \
template(ParallelGCSystemGC)                    \
template(CGC_Operation)                         \
template(CMS_Initial_Mark)                      \
template(CMS_Final_Remark)                      \
template(G1CollectFull)                         \
template(G1CollectForAllocation)                \
template(G1IncCollectionPause)                  \
template(DestroyAllocationContext)              \
template(EnableBiasedLocking)                   \
template(RevokeBias)                            \
template(BulkRevokeBias)                        \
template(PopulateDumpSharedSpace)               \
template(JNIFunctionTableCopier)                \
template(RedefineClasses)                       \
template(GetOwnedMonitorInfo)                   \
template(GetObjectMonitorUsage)                 \
template(GetCurrentContendedMonitor)            \
template(GetStackTrace)                         \
template(GetMultipleStackTraces)                \
template(GetAllStackTraces)                     \
template(GetThreadListStackTraces)              \
template(GetFrameCount)                         \
template(GetFrameLocation)                      \
template(ChangeBreakpoints)                     \
template(GetOrSetLocal)                         \
template(GetCurrentLocation)                    \
template(EnterInterpOnlyMode)                   \
template(ChangeSingleStep)                      \
template(HeapWalkOperation)                     \
template(HeapIterateOperation)                  \
template(ReportJavaOutOfMemory)                 \
template(JFRCheckpoint)                         \
template(Exit)                                  \
template(LinuxDllLoad)                          \
template(RotateGCLog)                           \
template(WhiteBoxOperation)                     \
*/