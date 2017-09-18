package org.java.security;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

//http://docs.oracle.com/javase/8/docs/technotes/guides/security/jaas/JAASRefGuide.html
public class JAAS_JavaAuthenticationAndAuthorizationService {

    
    /*
    JAAS can be used for two purposes:

        for authentication of users, to reliably and securely determine who is currently executing Java code, regardless of whether the code is running as an application, an applet, a bean, or a servlet; and
        for authorization of users to ensure they have the access control rights (permissions) required to do the actions performed.
        JAAS implements a Java version of the standard Pluggable Authentication Module (PAM) framework. */
    
    
    //例子  可以参考 hadoop的应用
    public static void main(String[] args) {
        try {
            // Configuration 组装 登录验证的需要的 LoginModule 和 配置
            // LoginContext init 时 创建一个moduleStack的验证
            LoginContext  loginContext = new LoginContext("appName", new Subject(), null, new LoginConfiguration());
            //调用LoginModule  login方法进行登录验证
            // 会把Subject CallbackHandler 配置等传递给LoginModule
            //验证成功  把成功者加入到 Subject.principals
            loginContext.login();
            System.out.println(loginContext.getSubject().getPrincipals().iterator().next());
        } catch (LoginException e) {
            e.printStackTrace();
        } 
    }
     
}
