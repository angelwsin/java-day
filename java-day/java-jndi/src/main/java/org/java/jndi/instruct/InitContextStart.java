package org.java.jndi.instruct;

import javax.naming.InitialContext;

public class InitContextStart {
    
    
    public static void main(String[] args)throws Exception {
        
        InitialContext context = new InitialContext();
        
        context.lookup("name");
        
        //一种  基于Scheme 协议   比如  rmi dns  dap 等
        //第二种 没有 Scheme  根据配置 java.naming.factory.initial 生成InitialContextFactory 工厂对象 创建 context  比如 mq 中的实现
        
        
    }

}
