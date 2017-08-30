package com.inject.guice;

import com.google.inject.Inject;

public class LoginService {
    
    
    private UserService userService;
    
    
    @Inject
     public LoginService(UserService userService) {
         this.userService = userService;
    }
    
    
    
    public void say(){
         this.userService.say();
    }

}
