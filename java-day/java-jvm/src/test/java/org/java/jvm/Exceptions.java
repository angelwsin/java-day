package org.java.jvm;

public class Exceptions {
    
    
    public void parsInt(){
        
        try {
            Integer.parseInt("7");   
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
    
    
    public void spin(){
        
        int i;
        for(i=0;i<100;i++){
            ;
        }
       /* public void spin();
        flags: ACC_PUBLIC
        Code:
          stack=2, locals=2, args_size=1
             0: iconst_0
             1: istore_1
             2: goto          8
             5: iinc          1, 1
             8: iload_1
             9: bipush        100
            11: if_icmplt     5
            14: return
          LineNumberTable:
            line 20: 0
            line 24: 14
          LocalVariableTable:
            Start  Length  Slot  Name   Signature
                   0      15     0  this   Lorg/java/jvm/Exceptions;
                   2      13     1     i   I*/
     
    }
    
    
    
    /*minor version: 0
    major version: 49
    flags: ACC_PUBLIC, ACC_SUPER
    nstant pool:
     #1 = Class              #2             //  org/java/jvm/Exceptions
     #2 = Utf8               org/java/jvm/Exceptions
     #3 = Class              #4             //  java/lang/Object
     #4 = Utf8               java/lang/Object
     #5 = Utf8               <init>
     #6 = Utf8               ()V
     #7 = Utf8               Code
     #8 = Methodref          #3.#9          //  java/lang/Object."<init>":()V
     #9 = NameAndType        #5:#6          //  "<init>":()V
    #10 = Utf8               LineNumberTable
    #11 = Utf8               LocalVariableTable
    #12 = Utf8               this
    #13 = Utf8               Lorg/java/jvm/Exceptions;
    #14 = Utf8               parsInt
    #15 = String             #16            //  7
    #16 = Utf8               7
    #17 = Methodref          #18.#20        //  java/lang/Integer.parseInt:(Ljava/lang/String;)I
    #18 = Class              #19            //  java/lang/Integer
    #19 = Utf8               java/lang/Integer
    #20 = NameAndType        #21:#22        //  parseInt:(Ljava/lang/String;)I
    #21 = Utf8               parseInt
    #22 = Utf8               (Ljava/lang/String;)I
    #23 = Methodref          #24.#26        //  java/lang/Exception.printStackTrace:()V
    #24 = Class              #25            //  java/lang/Exception
    #25 = Utf8               java/lang/Exception
    #26 = NameAndType        #27:#6         //  printStackTrace:()V
    #27 = Utf8               printStackTrace
    #28 = Utf8               e
    #29 = Utf8               Ljava/lang/Exception;
    #30 = Utf8               SourceFile
    #31 = Utf8               Exceptions.java

    public org.java.jvm.Exceptions();
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
                 0       5     0  this   Lorg/java/jvm/Exceptions;

    public void parsInt();
      flags: ACC_PUBLIC
      Code:
        stack=1, locals=2, args_size=1
           0: ldc           #15                 // String 7
           2: invokestatic  #17                 // Method java/lang/Integer.parseInt:(Ljava/lang/Strin
    )I
           5: pop
           6: goto          14
           9: astore_1
          10: aload_1
          11: invokevirtual #23                 // Method java/lang/Exception.printStackTrace:()V
          14: return
        Exception table:
           from    to  target type
               0     6     9   Class java/lang/Exception
        LineNumberTable:
          line 9: 0
          line 10: 6
          line 11: 10
          line 14: 14
        LocalVariableTable:
          Start  Length  Slot  Name   Signature
                 0      15     0  this   Lorg/java/jvm/Exceptions;
                10       4     1     e   Ljava/lang/Exception;*/

}
