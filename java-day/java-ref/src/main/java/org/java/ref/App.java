package org.java.ref;

//Provides reference-object classes, which support a limited degree of interaction with the garbage collector.
public class App 
{
    public static void main( String[] args )
    {
        
        //强  new 
        
        //软 SoftReference
        
        //弱 WeakReference
        
        
        //虚 PhantomReference
    	
    	
    	//class 是Type的实现
    	
    	Class<?> clazz = App.class;
    	
    	clazz.isArray();
    	clazz.isAnnotation();
    	//原始类型  八种原始类型加 void类型
    	clazz.isPrimitive();
    	clazz.isEnum();
    	clazz.isInterface();
    	//Member 保护 Field,构造函数，函数
    	clazz.isMemberClass();
    	
    	
        System.out.println(getClassSignature(clazz));
    }
    
    private static String getClassSignature(Class<?> cl) {
        StringBuilder sbuf = new StringBuilder();
        while (cl.isArray()) {
            sbuf.append('[');
            cl = cl.getComponentType();
        }
        if (cl.isPrimitive()) {
            if (cl == Integer.TYPE) {
                sbuf.append('I');
            } else if (cl == Byte.TYPE) {
                sbuf.append('B');
            } else if (cl == Long.TYPE) {
                sbuf.append('J');
            } else if (cl == Float.TYPE) {
                sbuf.append('F');
            } else if (cl == Double.TYPE) {
                sbuf.append('D');
            } else if (cl == Short.TYPE) {
                sbuf.append('S');
            } else if (cl == Character.TYPE) {
                sbuf.append('C');
            } else if (cl == Boolean.TYPE) {
                sbuf.append('Z');
            } else if (cl == Void.TYPE) {
                sbuf.append('V');
            } else {
                throw new InternalError();
            }
        } else {
            sbuf.append('L' + cl.getName().replace('.', '/') + ';');
        }
        return sbuf.toString();
    }
}
