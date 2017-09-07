package com.inject.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceStart {
    /*
    InternalInjectorCreator
    
    --InjectionRequestProcessor
       --Initializer
    --ProcessedBindingData

    --InjectorShell.Builder
      --Modules
      --elements
        --Binding

    --InjectorShell



   RecordingBinder Binder
     --modules
       --ModuleInfo
     --elements
     --moduleSource
       --module

    module.configure

         Binding*/
    
    
    
    public static void main(String[] args) {
        
        
         Injector inject = Guice.createInjector(new UserModule());
        
         UserService userService  = inject.getInstance(UserService.class);
         userService.say();
         
         LoginService loginService = inject.getInstance(LoginService.class);
         loginService.say();
        
         
        
    }

}
