package org.java.security.JAAS;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;
import javax.security.auth.login.Configuration;

public class LoginConfiguration extends Configuration{
    private static final Map<String, String> BASIC_JAAS_OPTIONS =
            new HashMap<String,String>();

    private static final AppConfigurationEntry OS_SPECIFIC_LOGIN =
            new AppConfigurationEntry("com.sun.security.auth.module.NTLoginModule",
                    LoginModuleControlFlag.REQUIRED,
                                      BASIC_JAAS_OPTIONS);
    
    //指定LoginModule
    @Override
    public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
        // TODO Auto-generated method stub
        return new AppConfigurationEntry[]{OS_SPECIFIC_LOGIN};
    }

}
