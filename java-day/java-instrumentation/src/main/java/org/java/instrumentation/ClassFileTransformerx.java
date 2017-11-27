package org.java.instrumentation;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/*如果实现方法确定不需要转换，则应该返回null。 否则，它应该创建一个新的byte 数组，将输入的classfileBuffer复制到它，以及所有所需的转换，并返回新的数组。 输入的classfileBuffer不能被修改。
如果ClassFileTransformer引发一个异常（它没有捕获到），后续的ClassFileTransformer仍然会被调用，负载，重新定义或转换仍将被尝试。 因此，引发异常与返回null的效果相同。
为了防止在ClassFileTransformer代码中生成未经检查的异常时的意外行为，变压器可以捕获Throwable。 如果转换器认为classFileBuffer不代表有效格式的类文件，
则应该抛出IllegalClassFormatException; 而这与返回null的效果相同。 它有助于记录或调试格式损坏。*/
public class ClassFileTransformerx implements ClassFileTransformer{

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)
            throws IllegalClassFormatException {
        // TODO Auto-generated method stub
        return classfileBuffer;
    }

}
