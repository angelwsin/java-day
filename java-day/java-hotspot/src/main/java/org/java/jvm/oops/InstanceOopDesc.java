package org.java.jvm.oops;


//An instanceOop is an instance of a Java Class
//Evaluating "new HashTable()" will create an instanceOop.

public class InstanceOopDesc extends OopDesc{

}



/*
    stack    obj          heap  
                          
                          instanceOopDesc                                     
                                                                实例数据

                                                    
                                                                                                                             方法区
                                                  instanceKlass                                                                                                                      
*/