package com.inject.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;


/*Module依赖注册
Guice提供依赖配置类，需要继承至AbstractModule，实现configure方法。在configure方法中我们可以用Binder配置依赖。

Binder利用链式形成一套独具语义的DSL，如：

基本配置：binder.bind(serviceClass).to(implClass).in(Scopes.[SINGLETON | NO_SCOPE]);
无base类、接口配置：binder.bind(implClass).in(Scopes.[SINGLETON | NO_SCOPE]);
service实例配置：binder.bind(serviceClass).toInstance(servieInstance).in(Scopes.[SINGLETON | NO_SCOPE]);
多个实例按名注入：binder.bind(serviceClass).annotatedWith(Names.named(“name”)).to(implClass).in(Scopes.[SINGLETON | NO_SCOPE]);
运行时注入：利用@Provides标注注入方法，相当于spring的@Bean。
@ImplementedBy：或者在实现接口之上标注@ImplementedBy指定其实现类。这种方式有点反OO设计，抽象不该知道其实现类。*/
public class UserModule extends AbstractModule{

    @Override
    protected void configure() {
        
        //依赖注入 类似spring
       bind(UserService.class).to(UserServiceImpl.class).in(Scopes.SINGLETON);
       //bind(UserService.class).toProvider(providerType)
       bind(LoginService.class).in(Scopes.SINGLETON);
       
    }

}
