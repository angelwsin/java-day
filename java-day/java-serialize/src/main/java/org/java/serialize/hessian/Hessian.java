package org.java.serialize.hessian;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * http://hessian.caucho.com/doc/hessian-overview.xtp
 * 官方文档
 */
public class Hessian {
	
	//hessian序列化时，一定要注意子类和父类不能有同名字段  
	
	//枚举对象的序列化/反序列化
	
	
	
	//hessian 序列化过程
	/**
	 * 
	 * @author wu.qiang
	 * out
	 * 
	 * 
	 * input
	 */
	
	enum  x {
		
		y,
		z;
		
		
	
		
	}
	
	public static void main(String[] args) {
		  
		  //enum  类型 继承 Enum 类  
		
		  try {
			Method method = x.class.getMethod("valueOf", Class.class,String.class);
			  try {
				Object o  = method.invoke(null,  x.class,"z");
				System.out.println(o);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		 try {
			Method m =   x.class.getMethod("values");
			try {
				Object[]  o = (Object[]) m.invoke(null);
				
				System.out.println(o[0]);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		  
	}

}
