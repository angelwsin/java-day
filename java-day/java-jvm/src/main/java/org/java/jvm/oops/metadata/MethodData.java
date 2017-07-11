package org.java.jvm.oops.metadata;

//MethodData*
//
//A MethodData* holds information which has been collected about
//a method.  Its layout looks like this:
//
//-----------------------------
//| header                    |
//| klass                     |
//-----------------------------
//| method                    |
//| size of the MethodData* |
//-----------------------------
//| Data entries...           |
//|   (variable size)         |
//|                           |
//.                           .
//.                           .
//.                           .
//|                           |
//-----------------------------
//
//The data entry area is a heterogeneous array of DataLayouts. Each
//DataLayout in the array corresponds to a specific bytecode in the
//method.  The entries in the array are sorted by the corresponding
//bytecode.  Access to the data is via resource-allocated ProfileData,
//which point to the underlying blocks of DataLayout structures.
//
//During interpretation, if profiling in enabled, the interpreter
//maintains a method data pointer (mdp), which points at the entry
//in the array corresponding to the current bci.  In the course of
//intepretation, when a bytecode is encountered that has profile data
//associated with it, the entry pointed to by mdp is updated, then the
//mdp is adjusted to point to the next appropriate DataLayout.  If mdp
//is NULL to begin with, the interpreter assumes that the current method
//is not (yet) being profiled.
//
//In MethodData* parlance, "dp" is a "data pointer", the actual address
//of a DataLayout element.  A "di" is a "data index", the offset in bytes
//from the base of the data entry array.  A "displacement" is the byte offset
//in certain ProfileData objects that indicate the amount the mdp must be
//adjusted in the event of a change in control flow.
//
public class MethodData extends Metadata {

}
