package com.inject.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceStart {
    
    
    
    public static void main(String[] args) {
        
        
         Injector inject = Guice.createInjector(new UserModule());
        
         UserService userService  = inject.getInstance(UserService.class);
         userService.say();
    }

}
