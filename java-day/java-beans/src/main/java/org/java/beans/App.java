package org.java.beans;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.Beans;
import java.beans.Introspector;

import org.java.beans.editor.IntegerPrppertyEditor;

/**
 * The JavaBeans component API extends the Java platform's Write Once, 
 * Run Anywhere capability to reusable component development. In fact, 
 * the JavaBeans architecture takes interoperability a major step forward — your code runs on every OS 
 * and also within any application environment. A developer who creates components based on the 
 * JavaBeans architecture (beans) secures a future in the emerging network software market without 
 * losing customers that use proprietary platforms, because beans interoperate with ActiveX, OpenDoc,
 *  and LiveConnect. Long-term persistence for JavaBeans enables you to read and write a bean as a 
 *  textual representation of its property values.
 *  
 *  package
 *  java.beans.*
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        //
        BeanInfo userInfo =   Introspector.getBeanInfo(UserBean.class);
        BeanDescriptor userDesc  =userInfo.getBeanDescriptor();
        userDesc.setValue("userName", "zhangsan");
        System.out.println(userDesc.getValue("userName"));
        
        // 字符串 值  转换  类型      
        //PrppertyEditor 的使用框架 spring,logback 对配置文件的解析转换成对象属性
        UserBean user =   (UserBean) Beans.instantiate(App.class.getClassLoader(), UserBean.class.getName());
        IntegerPrppertyEditor userEditor = new IntegerPrppertyEditor(user);
        userEditor.setAsText("23");
        user.setAge((Integer)userEditor.getValue());
        
    }
}
