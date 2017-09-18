package org.java.security;

import java.security.AccessControlContext;
import java.security.AccessController;

import javax.security.auth.Subject;

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
    }

}
