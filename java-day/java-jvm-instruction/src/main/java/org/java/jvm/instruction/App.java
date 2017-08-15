package org.java.jvm.instruction;

/**
 * http://blog.csdn.net/sum_rain/article/details/39892219
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        
        /**
         * cup执行指令 有专门的pc寄存器来保存
         * 
         * jvm 模拟 pc寄存器 也有类似的概念
         * 
         * pc java代码 存在下一次执行的指令 当执行native代码 此为不确定值 native代码由 pc机器pc寄存器保存
         * 
         * 
         * 
         * 
         * 
         * jvm 指令 零地址 操作数 存放在 局部变量表中 使用零地址 为了更好的夸平台 不同的机器提供的寄存器不同
         * 
         * c/c++ 汇编指令 三地址
         * 
         * 
         * 
         * 
         * 栈帧
         * 
         * A frame is used to store data and partial results, as well as to perform dynamic linking, return values for methods, and dispatch exceptions.
         * 
         * JVM为每个方法调用创建一个新的栈帧并推到每个方法调用的栈顶。当方法正常返回或者遇到了未捕获的异常，这个栈帧将被移除。想要了解更多的关于异常处理的可以看下面的“异常表”部分。
         * 
         * 每个栈帧包含了：
         * 
         * 局部变量表 返回值 操作数栈 当前方法所在的类的运行时常量池引用 局部变量表
         * 
         * 局部变量表包含了这个方法执行期间所有用到的变量，包括this引用，所有方法参数以及其他的局部声明变量。对于类方法(比如静态方法)来说，所有方法参数下标都是从0开始，然而，对于实例方法来说这个0是留给this的。
         * 
         * 一个局部变量可以是：
         * 
         * boolean byte char long short int float double reference returnAddress 在局部变量表里，除了long和double，所有类型都是占了一个槽位，它们占了2个连续槽位，因为他们是64位宽度。
         * 
         * 操作数栈
         * 
         * 操作数栈用于字节码指令执行期间，就像通用寄存器在CPU里使用一样。大部分JVM的字节码各自操作出栈，入栈，复制，交换，或者执行操作，使其生产和消费各种数据。因此，在字节码里，指令把值在局部变量表和操作数栈之间频繁移动。比如，一个简单的变量初始化导致两个字节码在操作数栈里交互影响。
         * 
         * int i;
         * 
         * 编译后得到下面字节码:
         * 
         * 0: iconst_0 // 将 0 入栈到操作数栈的顶端。
         * 
         * 1: istore_1 // 从操作数栈顶端弹出并保存到局部变量
         * 
         * 想要了解更多关于局部变量表和操作数栈，运行时常量池之间的交互，请看下面的“class文件结构”。
         * 
         * 动态链接
         * 
         * 每个栈帧都包含了运行时常量池的引用。这个引用指向了这个栈帧正在执行的方法所在的类的常量池，它对动态链接提供了支持。
         * 
         * 
         * 方法异常调用
         * 没有 handled exception   执行 athrow instruction  当前方法没有 caught 返回值被终端  调用 永远没有返回值
         * 
         */
        
        
    }
}
