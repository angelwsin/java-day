package com.jvm.Run_Time_Data_Areas;

public class Stacks {
    
    
  /*  Each Java Virtual Machine thread has a private Java Virtual Machine stack, created
    at the same time as the thread. A Java Virtual Machine stack stores frames (§2.6).
    A Java Virtual Machine stack is analogous to the stack of a conventional language
    such as C: it holds local variables and partial results, and plays a part in method
    invocation and return. Because the Java Virtual Machine stack is never manipulated
    directly except to push and pop frames, frames may be heap allocated. The memory
    for a Java Virtual Machine stack does not need to be contiguous.*/
    
    
    
    
    
    
    
    
    
    
    class Frames{
        
        /*A frame is used to store data and partial results, as well as to perform dynamic
        linking, return values for methods, and dispatch exceptions.
        A new frame is created each time a method is invoked. A frame is destroyed when
        its method invocation completes, whether that completion is normal or abrupt (it
        throws an uncaught exception). Frames are allocated from the Java Virtual Machine
        stack (§2.5.2) of the thread creating the frame. Each frame has its own array of
        local variables (§2.6.1), its own operand stack (§2.6.2), and a reference to the runtime
        constant pool (§2.5.5) of the class of the current method*/
        
        //. Operations on local variables and the operand stack are typically
       // with reference to the current frame.
        
        
        class LocalVariables{
          /*  
            Each frame (§2.6) contains an array of variables known as its local variables. The
            length of the local variable array of a frame is determined at compile-time and
            supplied in the binary representation of a class or interface along with the code for
            the method associated with the frame (§4.7.3).
            A single local variable can hold a value of type boolean, byte, char, short, int,
            float, reference, or returnAddress. A pair of local variables can hold a value
            of type long or double.*/

        }
        
        class OperandStacks{
            
          /*  Each frame (§2.6) contains a last-in-first-out (LIFO) stack known as its operand
            stack. The maximum depth of the operand stack of a frame is determined at
            compile-time and is supplied along with the code for the method associated with
            the frame (§4.7.3).*/
        }
        
        
        class DynamicLinking{
            
            /*Each frame (§2.6) contains a reference to the run-time constant pool (§2.5.5) for
            the type of the current method to support dynamic linking of the method code.
            The class file code for a method refers to methods to be invoked and variables
            to be accessed via symbolic references. Dynamic linking translates these symbolic
            method references into concrete method references, loading classes as necessary to
            resolve as-yet-undefined symbols, and translates variable accesses into appropriate
            offsets in storage structures associated with the run-time location of these variables.
            This late binding of the methods and variables makes changes in other classes that
            a method uses less likely to break this code*/
        }

    }
    

}
