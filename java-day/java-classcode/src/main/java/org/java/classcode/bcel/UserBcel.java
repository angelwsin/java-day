package org.java.classcode.bcel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Arrays;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.GETSTATIC;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.LLOAD;
import org.apache.bcel.generic.LSTORE;
import org.apache.bcel.generic.LSUB;
import org.apache.bcel.generic.LocalVariableGen;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.Type;
import org.java.user.User;

/**
 * Apache Byte Code Engineering Library,BCEL 每项内容操作在JVM汇编语言的级别
 * @author wu.qiang
 *
 */
public class UserBcel {
	
	
	public static void main(String[] args)throws Exception {
		becl(User.class,User.class.getName());
		
	}
	
	
	public void en() throws Exception{
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
	
	public static  byte[]  becl(Class<?> classBeingRedefined,String className) {
		ClassGen  classGenx = null;
		try {
			JavaClass javaClass = Repository.lookupClass(classBeingRedefined);
			ClassGen classGen = new ClassGen(javaClass);
			classGenx = classGen;
			ConstantPoolGen constPool = classGen.getConstantPool();
			int tIndex = constPool.addMethodref("java/lang/System", "currentTimeMillis", "()J");
			int index = constPool.addFieldref("java/lang/System", "out", "Ljava/io/PrintStream;");
			int mIndex = constPool.addMethodref("java/io/PrintStream", "println", "(J)V");
			constPool.addUtf8("start");
			Arrays.asList(classGen.getMethods()).forEach(method->{
				if("say".equals(method.getName())) {
					MethodGen sayGen = new MethodGen(method, className, constPool);
					InstructionList li = sayGen.getInstructionList();
					InstructionHandle s = li.getStart();
					InstructionList start = new InstructionList();
					start.append(new INVOKESTATIC(tIndex));
					LocalVariableGen localV = sayGen.addLocalVariable("start", Type.LONG,null, null);
					InstructionHandle locStart = start.append(new LSTORE(localV.getIndex()));
					localV.setStart(locStart);
					li.insert(s.getInstruction(), start);
					InstructionHandle end = li.getEnd();
					InstructionList out = new InstructionList();
					out.append(new GETSTATIC(index));
					out.append(new INVOKESTATIC(tIndex));
					out.append(new LLOAD(1));
					out.append(new LSUB());
					InstructionHandle locEnd = out.append(new INVOKEVIRTUAL(mIndex));
					localV.setEnd(locEnd);
					li.insert(end.getInstruction(), out);
					sayGen.setMaxStack();
					classGen.replaceMethod(method, sayGen.getMethod());
				}
				
				
			});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(ByteArrayOutputStream bytes = new ByteArrayOutputStream();) {
			//classGenx.getJavaClass().dump(bytes);
			
			Arrays.asList(classGenx.getJavaClass().getMethods()).forEach(e->{
				Code code = e.getCode();
				System.out.println(code);
			});
			classGenx.getJavaClass().dump(new File(String.format("C:\\java\\%s.class", className.replace('.', '/'))));
			return bytes.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public void  insert() {
		
	}

}
