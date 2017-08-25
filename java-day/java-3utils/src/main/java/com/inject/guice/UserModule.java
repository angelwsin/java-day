package com.inject.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class UserModule extends AbstractModule{

    @Override
    protected void configure() {
        
        //依赖注入 类似spring
       bind(UserService.class).to(UserServiceImpl.class).in(Scopes.SINGLETON);
       
    }

}
