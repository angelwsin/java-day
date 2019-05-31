package modify;

import java.util.function.Consumer;


//https://www.cnblogs.com/dolphin0520/p/3811445.html
//javap -v class
public class Final {



    public static void main(String[] args) {




    }


    public void  xxx(){

        final String xx  = "modify final";
        //1)局部变量生命周期的问题
        //当xxx方法执行完毕之后，变量xx的生命周期就结束了，而此时Thread对象的生命周期很可能还没有结束，
        // 那么在Thread的run方法中继续访问变量xx就变成不可能了，但是又要实现这样的效果，怎么办呢？Java采用了 复制  的手段来解决这个问题
        //如果这个变量的值在编译期间可以确定，则编译器默认会在匿名内部类（局部内部类）的常量池中添加一个内容相等的字面量或直接将相应的字节码
        //嵌入到执行字节码中。这样一来，匿名内部类使用的变量是另一个局部变量，只不过值和方法中局部变量的值相等，因此和方法中的局部变量完全独立开。
        //也就说如果局部变量的值在编译期间就可以确定，则直接在匿名内部里面创建一个拷贝。如果局部变量的值无法在编译期间确定，
        // 则通过构造器传参的方式来对拷贝进行初始化赋值。
        //对，会造成数据不一致性，这样就达不到原本的意图和要求
        //为了解决这个问题，java编译器就限定必须将变量xx限制为final变量，
        // 不允许对变量xx进行更改（对于引用类型的变量，是不允许指向新的对象），这样数据不一致性的问题就得以解决了。
        //2)可以访问外部类的属性的实现
        //定义的内部类的构造器是无参构造器，编译器还是会默认添加一个参数，该参数的类型为指向外部类对象的一个引用，
        //所以成员内部类中的Outter this&0 指针便指向了外部类对象，因此可以在成员内部类中随意访问外部类的成员。
        //从这里也间接说明了成员内部类是依赖于外部类的，如果没有创建外部类的对象，则无法对Outter this&0引用进行初始化赋值，也就无法创建成员内部类的对象了。




        new Thread(){
            @Override
            public void run() {
                System.out.println(xx);
            }
        }.start();

    }


}