package org.java.security;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class UserLoginModule implements LoginModule{

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean login() throws LoginException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean abort() throws LoginException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        // TODO Auto-generated method stub
        return false;
    }

}
