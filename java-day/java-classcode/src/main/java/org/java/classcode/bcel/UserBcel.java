package org.java.classcode.bcel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.bcel.Const;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LocalVariableTypeTable;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.InstructionFactory;
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
 *https://www.ibm.com/developerworks/cn/java/j-dyn0414/index.html
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
	
	/*public static  byte[]  becl(Class<?> classBeingRedefined,String className) {
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
					out.append(new LLOAD(localV.getIndex()));
					out.append(new LSUB());
					InstructionHandle locEnd = out.append(new INVOKEVIRTUAL(mIndex));
					localV.setEnd(locEnd);
					li.insert(end.getInstruction(), out);
					sayGen.setMaxLocals();
					sayGen.setMaxStack();
					classGen.replaceMethod(method, sayGen.getMethod());
					li.dispose();
				}
				
				
			});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(ByteArrayOutputStream bytes = new ByteArrayOutputStream();) {
			//classGenx.getJavaClass().dump(bytes);
			System.out.println(classGenx.getJavaClass().getConstantPool().toString());
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
		
	}*/
	
	public static byte[]  becl(Class<?> classBeingRedefined,String className) {
		StatisticsTime statisticsTime= classBeingRedefined.getAnnotation(StatisticsTime.class);
		String[] mds = null;
		if(Objects.isNull(statisticsTime)||Objects.isNull((mds=statisticsTime.value()))||mds.length==0) {
			return null;
		}
		//去重方法
		Set<String> includeMds = new HashSet<>();
		for(String s : mds) {
			includeMds.add(s);
		}
		ClassGen  classGen = null;
		try {
			JavaClass javaClass = Repository.lookupClass(classBeingRedefined);
			classGen = new ClassGen(javaClass);
			InstructionFactory ifact = new InstructionFactory(classGen);
			ConstantPoolGen constPool = classGen.getConstantPool();
			for(Method method : classGen.getMethods()) {
				if(!includeMds.contains(method.getName())) {
					  continue ;
				}  
				//代理方法
				String proxyMdName = method.getName()+"$Imp";
				MethodGen methodGen = new MethodGen(method, className, constPool);
				MethodGen proxyMethod = new MethodGen(method, className, constPool);
				classGen.removeMethod(methodGen.getMethod());
				methodGen.setName(proxyMdName);
				classGen.addMethod(methodGen.getMethod());
				Type returnType = methodGen.getReturnType();
				//参数
				proxyMethod.removeLocalVariables();
				if(!proxyMethod.isStatic())
					proxyMethod.addLocalVariable("this", Type.getType(classBeingRedefined), null, null);
				for(int i=0;i<proxyMethod.getArgumentTypes().length;i++) {
					String name = proxyMethod.getArgumentName(i);
					Type type = proxyMethod.getArgumentType(i);
					proxyMethod.addLocalVariable(name, type, null, null);
				}
				//时间统计
				InstructionList instructionProxy = new InstructionList();
				instructionProxy.append(ifact.createInvoke("java.lang.System",
			            "currentTimeMillis", Type.LONG, Type.NO_ARGS, 
			            Const.INVOKESTATIC));
				LocalVariableGen localV = proxyMethod.addLocalVariable("start", Type.getType(long.class),null, null);
				InstructionHandle locStart = instructionProxy.append(new LSTORE(localV.getIndex()));
				localV.setStart(locStart);
				//调用原始方法
				short inovke =  Const.INVOKESTATIC;
				if(!methodGen.isStatic()) {
					inovke = Const.INVOKEVIRTUAL;
					instructionProxy.append(new ALOAD(0));
				}
				instructionProxy.append(ifact.createInvoke(className,
						proxyMdName, returnType, methodGen.getArgumentTypes(), 
						inovke));
				LocalVariableGen ret = null;
				if(returnType!=Type.VOID) {
				  ret = proxyMethod.addLocalVariable("result", returnType,null, null);
				 InstructionHandle retStart = instructionProxy.append(InstructionFactory.createStore(returnType, ret.getIndex()));
				 ret.setStart(retStart);
				}
				instructionProxy.append(ifact.createFieldAccess("java.lang.System",
			            "out",  new ObjectType("java.io.PrintStream"),
			            Const.GETSTATIC));
				instructionProxy.append(ifact.createInvoke("java.lang.System",
			            "currentTimeMillis", Type.LONG, Type.NO_ARGS, 
			            Const.INVOKESTATIC));
				instructionProxy.append(new LLOAD(localV.getIndex()));
				instructionProxy.append(new LSUB());
				InstructionHandle locEnd = instructionProxy.append(ifact.createInvoke("java.io.PrintStream",
			            "print", Type.VOID, new Type[] { Type.LONG },
			            Const.INVOKEVIRTUAL));
				localV.setEnd(locEnd);
				if(Objects.nonNull(ret)) {
					instructionProxy.append(InstructionFactory.createLoad(returnType, ret.getIndex()));
				}
				instructionProxy.append(InstructionFactory.createReturn(returnType));
				proxyMethod.setInstructionList(instructionProxy);
				proxyMethod.setMaxLocals();
				proxyMethod.setMaxStack();
				classGen.addMethod(proxyMethod.getMethod());
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(ByteArrayOutputStream bytes = new ByteArrayOutputStream();) {
			classGen.getJavaClass().dump(bytes);
			
			Arrays.asList(classGen.getJavaClass().getMethods()).forEach(e->{
				Code code = e.getCode();
				System.out.println(code);
			});
			classGen.getJavaClass().dump(new File(String.format("C:\\java\\%s.class", className.replace('.', '/'))));
			return bytes.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public void  insert() {
		
	}

}
