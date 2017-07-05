package org.java.api.string;

public class StringApi {
    
    
    //方法的调用传值  （值 和地址值）
    //传递的都是值的 副本
    public static void main(String[] args) {
        
        String  str ="hello ";
        str+=" world ";// 编译的 字节码  实现 使用   new  // class java/lang/StringBuilder
    }
    
    
   /* 
    StringApi.class
    Last modified 2017-7-5; size 760 bytes
    MD5 checksum 4471c19417e1306556a19063acce3d06
    Compiled from "StringApi.java"
  public class org.java.api.string.StringApi
    minor version: 0
    major version: 49
    flags: ACC_PUBLIC, ACC_SUPER
  Constant pool:
     #1 = Class              #2             // org/java/api/string/StringApi
     #2 = Utf8               org/java/api/string/StringApi
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
    #13 = Utf8               Lorg/java/api/string/StringApi;
    #14 = Utf8               main
    #15 = Utf8               ([Ljava/lang/String;)V
    #16 = String             #17            // hello
    #17 = Utf8               hello
    #18 = Class              #19            // java/lang/StringBuilder
    #19 = Utf8               java/lang/StringBuilder
    #20 = Methodref          #21.#23        // java/lang/String.valueOf:(Ljava/lan
  g/Object;)Ljava/lang/String;
    #21 = Class              #22            // java/lang/String
    #22 = Utf8               java/lang/String
    #23 = NameAndType        #24:#25        // valueOf:(Ljava/lang/Object;)Ljava/l
  ang/String;
    #24 = Utf8               valueOf
    #25 = Utf8               (Ljava/lang/Object;)Ljava/lang/String;
    #26 = Methodref          #18.#27        // java/lang/StringBuilder."<init>":(L
  java/lang/String;)V
    #27 = NameAndType        #5:#28         // "<init>":(Ljava/lang/String;)V
    #28 = Utf8               (Ljava/lang/String;)V
    #29 = String             #30            //  world
    #30 = Utf8                world
    #31 = Methodref          #18.#32        // java/lang/StringBuilder.append:(Lja
  va/lang/String;)Ljava/lang/StringBuilder;
    #32 = NameAndType        #33:#34        // append:(Ljava/lang/String;)Ljava/la
  ng/StringBuilder;
    #33 = Utf8               append
    #34 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
    #35 = Methodref          #18.#36        // java/lang/StringBuilder.toString:()
  Ljava/lang/String;
    #36 = NameAndType        #37:#38        // toString:()Ljava/lang/String;
    #37 = Utf8               toString
    #38 = Utf8               ()Ljava/lang/String;
    #39 = Utf8               args
    #40 = Utf8               [Ljava/lang/String;
    #41 = Utf8               str
    #42 = Utf8               Ljava/lang/String;
    #43 = Utf8               SourceFile
    #44 = Utf8               StringApi.java
  {
    public org.java.api.string.StringApi();
      descriptor: ()V
      flags: ACC_PUBLIC
      Code:
        stack=1, locals=1, args_size=1
           0: aload_0
           1: invokespecial #8                  // Method java/lang/Object."<init>
  ":()V
           4: return
        LineNumberTable:
          line 3: 0
        LocalVariableTable:
          Start  Length  Slot  Name   Signature
              0       5     0  this   Lorg/java/api/string/StringApi;

    public static void main(java.lang.String[]);
      descriptor: ([Ljava/lang/String;)V
      flags: ACC_PUBLIC, ACC_STATIC
      Code:
        stack=3, locals=2, args_size=1
           0: ldc           #16                 // String hello
           2: astore_1
           3: new           #18                 // class java/lang/StringBuilder
           6: dup
           7: aload_1
           8: invokestatic  #20                 // Method java/lang/String.valueOf
  :(Ljava/lang/Object;)Ljava/lang/String;
          11: invokespecial #26                 // Method java/lang/StringBuilder.
  "<init>":(Ljava/lang/String;)V
          14: ldc           #29                 // String  world
          16: invokevirtual #31                 // Method java/lang/StringBuilder.
  append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
          19: invokevirtual #35                 // Method java/lang/StringBuilder.
  toString:()Ljava/lang/String;
          22: astore_1
          23: return
        LineNumberTable:
          line 10: 0
          line 11: 3
          line 12: 23
        LocalVariableTable:
          Start  Length  Slot  Name   Signature
              0      24     0  args   [Ljava/lang/String;
              3      21     1   str   Ljava/lang/String;
  }
  SourceFile: "StringApi.java"*/

}
