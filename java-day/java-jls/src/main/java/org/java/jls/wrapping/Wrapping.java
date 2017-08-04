package org.java.jls.wrapping;

public class Wrapping {
	
	
	
	public void wrapping(){
		int x = 7;
		//装箱
		Integer  i = x; //编译器 自动 Integer.valueOf(x)
		//拆箱
		Integer it = new Integer(6);
		int  y =  it;//Integer.intValue()  it.intValue()
		
		// conversions and numeric promotions. 数据类型的强制转换
		short sx = 6;
		int   iy = sx;
	}
	
	
	
	/*
	minor version: 0
	  major version: 49
	  flags: ACC_PUBLIC, ACC_SUPER
	Constant pool:
	   #1 = Class              #2             // org/java/jls/wrapping/Wrapping
	   #2 = Utf8               org/java/jls/wrapping/Wrapping
	   #3 = Class              #4             // java/lang/Object
	   #4 = Utf8               java/lang/Object
	   #5 = Utf8               <init>
	   #6 = Utf8               ()V
	   #7 = Utf8               Code
	   #8 = Methodref          #3.#9          // java/lang/Object."<init>":()V
	   #9 = NameAndType        #5:#6          // "<init>":()V
	  #10 = Utf8               LineNumberTable
	  #11 = Utf8               LocalVariableTable
	  #12 = Utf8               this
	  #13 = Utf8               Lorg/java/jls/wrapping/Wrapping;
	  #14 = Utf8               wrapping
	  #15 = Methodref          #16.#18        // java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
	  #16 = Class              #17            // java/lang/Integer
	  #17 = Utf8               java/lang/Integer
	  #18 = NameAndType        #19:#20        // valueOf:(I)Ljava/lang/Integer;
	  #19 = Utf8               valueOf
	  #20 = Utf8               (I)Ljava/lang/Integer;
	  #21 = Methodref          #16.#22        // java/lang/Integer."<init>":(I)V
	  #22 = NameAndType        #5:#23         // "<init>":(I)V
	  #23 = Utf8               (I)V
	  #24 = Methodref          #16.#25        // java/lang/Integer.intValue:()I
	  #25 = NameAndType        #26:#27        // intValue:()I
	  #26 = Utf8               intValue
	  #27 = Utf8               ()I
	  #28 = Utf8               x
	  #29 = Utf8               I
	  #30 = Utf8               i
	  #31 = Utf8               Ljava/lang/Integer;
	  #32 = Utf8               it
	  #33 = Utf8               y
	  #34 = Utf8               SourceFile
	  #35 = Utf8               Wrapping.java
	{
	  public org.java.jls.wrapping.Wrapping();
	    descriptor: ()V
	    flags: ACC_PUBLIC
	    Code:
	      stack=1, locals=1, args_size=1
	         0: aload_0
	         1: invokespecial #8                  // Method java/lang/Object."<init>":()V
	         4: return
	      LineNumberTable:
	        line 3: 0
	      LocalVariableTable:
	        Start  Length  Slot  Name   Signature
	            0       5     0  this   Lorg/java/jls/wrapping/Wrapping;

	  public void wrapping();
	    descriptor: ()V
	    flags: ACC_PUBLIC
	    Code:
	      stack=3, locals=5, args_size=1
	         0: bipush        7
	         2: istore_1
	         3: iload_1
	         4: invokestatic  #15                 // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
	         7: astore_2
	         8: new           #16                 // class java/lang/Integer
	        11: dup
	        12: bipush        6
	        14: invokespecial #21                 // Method java/lang/Integer."<init>":(I)V
	        17: astore_3
	        18: aload_3
	        19: invokevirtual #24                 // Method java/lang/Integer.intValue:()I
	        22: istore        4
	        24: return
	      LineNumberTable:
	        line 8: 0
	        line 10: 3
	        line 12: 8
	        line 13: 18
	        line 14: 24
	      LocalVariableTable:
	        Start  Length  Slot  Name   Signature
	            0      25     0  this   Lorg/java/jls/wrapping/Wrapping;
	            3      22     1     x   I
	            8      17     2     i   Ljava/lang/Integer;
	           18       7     3    it   Ljava/lang/Integer;
	           24       1     4     y   I*/

}
