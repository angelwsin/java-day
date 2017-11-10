package org.java.beans;

import java.beans.BeanDescriptor;
import java.beans.BeanInfo;
import java.beans.Beans;
import java.beans.Expression;
import java.beans.IndexedPropertyDescriptor;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.ParameterDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.Statement;
import java.lang.reflect.Method;

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
        
        
        
        //java beans  描述desc  动作    属性动态编辑PropertyEditor
        
        //desc 描述
        BeanDescriptor  userBeanDesc = new BeanDescriptor(UserBean.class);
        // PropertyDescriptor  userBeanProp = new PropertyDescriptor("userName", UserBean.class);
        ParameterDescriptor userParamDesc = new ParameterDescriptor();
        //带索引的set,get
        IndexedPropertyDescriptor index = new IndexedPropertyDescriptor("args", UserBean.class);
        Method method = UserBean.class.getDeclaredMethod("setUserName", String.class);
        MethodDescriptor    userMethodDesc = new MethodDescriptor(method);
        
        System.out.println(method.getGenericParameterTypes().length);
        //动作
        UserBean target =  new UserBean();
        Statement  sta = new Statement(target, "setUserName", new Object[]{"zhagnsanx"});
        //没有返回值
        sta.execute();
        
        Expression exp = new Expression( target, "getUserName", null);
        exp.execute();
        //返回值
        System.out.println(exp.getValue());
        
        //beans  辅助类
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Beans.instantiate(classLoader, UserBean.class.getName());
        
        BeanInfo userInfox =   Introspector.getBeanInfo(UserBean.class);
        
        
        //动态编辑
        // 字符串 值  转换  类型      
        //PrppertyEditor 的使用框架 spring,logback 对配置文件的解析转换成对象属性
        UserBean user =   (UserBean) Beans.instantiate(App.class.getClassLoader(), UserBean.class.getName());
        IntegerPrppertyEditor userEditor = new IntegerPrppertyEditor(user);
        userEditor.setAsText("23");
        user.setAge((Integer)userEditor.getValue());
        
        
        // beans的事件和监听
        //PropertyChangeEvent
        //PropertyChangeListener  属性修改监听
        //VetoableChangeListener  有能力拒绝属性修改监听 
        
        //具体使用 看 MyBean 
        
    }
}
