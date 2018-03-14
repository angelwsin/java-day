package org.java.jdbc.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mybatis {
    
    
    public static void main(String[] args) {
        
        
         SqlSessionFactoryBuilder  builder = new SqlSessionFactoryBuilder();
        // SqlSessionFactory sqlSession = builder.build(config);
         
         //SqlSession session = sqlSession.openSession(autoCommit)
         
                 
         
         //session.
                 
         //解析mapper.xml
                 
         //select delete update insert
          //不同的xml元素解析成不同的 SqlNode 解析成  SqlSource         
          //整个 select delete update insert xml元素  解析成 MappedStatement  namespace.id 唯一标示
                 
           
                 
                 //session.getMapper(type)   getMapper 动态生成Mapper借口的代理对象 
                
                 //调用 接口的方法是   实际调用代理对象的 的方法  通过  class.method  查找到 MappedStatement
                
                 // 通过 方法的parameter + MappedStatement   -> 最终的BoundSql 
                 
                 
             /*                
              * 
              * 
              * 
              * 
              *   SqlSessionFactory
              *                |
              *                |
              *                |
              *                |
              *               Configuration
              *                     |
              *                     |__settings/properties (属性)
              *                     |
              *                     |__typeAliases(类型别名)
              *                     |
              *                     |__plugins(拦截器 如拦截sql执行handler)
              *                     |
              *                     |__objectFactory(mapper接口生成代理对象工厂)
              *                     |
              *                     |__objectWrapperFactory(对象包装工厂)
              *                     |
              *                     |__reflectionFactory(对象反射工厂)
              *                     |
              *                     |__environment
              *                     |      |
              *                     |      |__transactionManager(事务管理器)
              *                     |      |
              *                     |      |__dataSource(数据源)
              *                     |
              *                     |__typeHandlers(类型转换处理)
              *                     |
              *                     |__mappers(sqlMapper.xml映射文件)
              *                           |
              *                           |__MappedStatement(mapper文件中的每条sql解析成) 
              *                                    |
              *                                    |__SqlSource(承载不同的sql片段总和  DynamicSqlSource(sql中包含${}),ProviderSqlSource(注解),RawSqlSource(静态#{}),StaticSqlSource)
              *                                          |
              *                                          |__SqlNode(不同的sql片段 如 if等标签)               
              *                     调用Mapper接口方法                     |
              *                      --------------------|__BoundSql(最终的sql 替换参数)                                          
              *     
              *     
              *     
              *     
              *     
              *     
              *     
              *     
              *     
              */
         
         
       //使用ongl表达式
         MetaObject metaStatementHandler = SystemMetaObject.forObject(new User());
         List<String>  str  = new ArrayList<String>();
         str.add("xiaoming");
         metaStatementHandler.setValue("str", str);
         System.out.println(metaStatementHandler.getValue("str"));
         
         MetaClass userMeta =   MetaClass.forClass(User.class, new DefaultReflectorFactory());
         //userMeta.getGetInvoker("").
         
         
    }

}
