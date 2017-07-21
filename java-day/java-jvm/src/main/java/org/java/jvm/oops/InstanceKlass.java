package org.java.jvm.oops;

import org.java.jvm.oops.klass.Klass;
import org.java.jvm.oops.metadata.Method;


//An InstanceKlass is the VM level representation of a Java class.
//It contains all information needed for at class at execution runtime.

//InstanceKlass layout:
// [C++ vtbl pointer           ] Klass
// [subtype cache              ] Klass
// [instance size              ] Klass
// [java mirror                ] Klass
// [super                      ] Klass
// [access_flags               ] Klass
// [name                       ] Klass
// [first subklass             ] Klass
// [next sibling               ] Klass
// [array klasses              ]
// [methods                    ]
// [local interfaces           ]
// [transitive interfaces      ]
// [fields                     ]
// [constants                  ]
// [class loader               ]
// [source file name           ]
// [inner classes              ]
// [static field size          ]
// [nonstatic field size       ]
// [static oop fields size     ]
// [nonstatic oop maps size    ]
// [has finalize method        ]
// [deoptimization mark bit    ]
// [initialization state       ]
// [initializing thread        ]
// [Java vtable length         ]
// [oop map cache (stack maps) ]
// [EMBEDDED Java vtable             ] size in words = vtable_len
// [EMBEDDED nonstatic oop-map blocks] size in words = nonstatic_oop_map_size
//   The embedded nonstatic oop-map blocks are short pairs (offset, length)
//   indicating where oops are located in instances of this klass.
// [EMBEDDED implementor of the interface] only exist for interface
// [EMBEDDED host klass        ] only exist for an anonymous class (JSR 292 enabled)
//已加载的java类 创建一个 instanceKlass对象
public class InstanceKlass extends Klass{

	
	 int             _nonstatic_oop_map_size;// size in words of nonstatic oop map blocks
	 
	 //实例数据的排列顺序
	 //longs/doubles  ints shorts/chars bytes/booleans oops  相同宽度的字段分配到一起
	 
	 
	 //java 中的方法
	 Method[] methods;
}




//ValueObjs embedded in klass. Describes where oops are located in instances of
//this klass.

//java对象的实例域
class OopMapBlock{
	
	
}

/**
 * class 字节码
 * 
 *   魔术
 *   主版本
 *   次版本
 *   常量池
 *   访问限制
 *   this
 *   super class
 *   super interface
 *   field
 *   method
 *   属性
 */



  /**
   * .class     加载                 验证，准备（静态属性分配默认值）,链接（符号引用转换为直接引用)         初始化阶段
   * 
   * 
   * 跟踪类的加载
   * +TraceClassLoading
   */
