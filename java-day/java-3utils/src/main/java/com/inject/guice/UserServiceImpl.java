package com.inject.guice;

import com.google.inject.Inject;

public class UserServiceImpl implements UserService{

    
    @Inject
    private Person person;
    public void say() {
        
        System.out.println("say ");
        System.out.println(person);
    }

}
