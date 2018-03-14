package org.java.tools.jar;


/*一个压缩工具:Pack200，这个工具能对普通的jar文件进行高效压缩。其  实现原理是根据Java类特有的结构，合并常数  池，去掉无用信息等来实现对java类的高效压缩。
由于是专门对Java类进行压缩的，所以对普通文件的压缩和普通压缩软件没有什么两样，但是对于Jar  
文件却能轻易达到10-40%的压缩率。这在Java应用部署中很有用，尤其对于移动Java计算，能够大大减小代码下载量。*/



public class Pack200 {
    
    
    public static void main(String[] args) {
        //Pack200.Packer localPacker = Pack200.newPacker();
    }

}
