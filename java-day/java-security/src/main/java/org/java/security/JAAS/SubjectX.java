package org.java.security.JAAS;

import java.security.AccessControlContext;
import java.security.AccessController;

import javax.security.auth.Subject;


/*
 * Subject可能有多个身份。 每个身份在主题中都被表示为一个Principal。 Principals只需将名称绑定到主题。 
 * 例如，碰巧是一个人Alice的Subject可能有两个Principal：一个将“Alice Bar”（她的驾驶执照上的名字）绑定到Subject，另一个绑定“999-99-9999”  ，
 * 她的学生证上的号码到Subject。 Both Principals refer to the same Subject even though each has a different name
 * 主体也可以拥有与安全有关的属性，这些属性被称为凭证。 需要特殊保护的敏感凭证（如私人密码钥匙）存储在专用凭证集内。 
 * 意图共享的证书（如公钥证书或Kerberos服务器票证）存储在公共证书集内。 访问和修改不同的凭证集需要不同的权限。
 */
public class SubjectX {
    
    
    public static void main(String[] args) {
        AccessControlContext context = AccessController.getContext();
        Subject subject = Subject.getSubject(context);
        System.out.println(subject);
       /* if (subject == null || subject.getPrincipals(User.class).isEmpty()) {
          return getLoginUser();
        } else {
          return new UserGroupInformation(subject);
        }*/
        
        subject.getPrincipals();
        subject.getPrivateCredentials();
        subject.getPublicCredentials();
    }

}
