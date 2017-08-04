package org.java.jvm.runtime;

import org.java.jvm.memory.StackObj;

//A JavaCallWrapper is constructed before each JavaCall and destructed after the call.
//Its purpose is to allocate/deallocate a new handle block and to save/restore the last
//Java fp/sp. A pointer to the JavaCallWrapper is stored on the stack.
public class JavaCallWrapper extends StackObj{

}
