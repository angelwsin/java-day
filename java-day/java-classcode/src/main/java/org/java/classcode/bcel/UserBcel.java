package org.java.classcode.bcel;

import java.io.File;
import java.net.URLClassLoader;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.MethodGen;
import org.java.user.User;

/**
 * Apache Byte Code Engineering Library,BCEL 每项内容操作在JVM汇编语言的级别
 * @author wu.qiang
 *
 */
public class UserBcel {
	
	
	public static void main(String[] args)throws Exception {
		JavaClass javaClass = Repository.lookupClass(User.class);
		ClassGen classGen = new ClassGen(javaClass);
		ConstantPoolGen constantPoll = classGen.getConstantPool();
		int outIndex = constantPoll.addMethodref("java.lang.System", "currentTimeMillis", "()J");
		Method say = classGen.getMethods()[1];
		MethodGen sayGen = new MethodGen(say, User.class.getName(), constantPoll);
		sayGen.getInstructionList().insert(new INVOKESTATIC(outIndex));
		classGen.replaceMethod(say, sayGen.getMethod());
		JavaClass cGen = classGen.getJavaClass();
		
	}

}
