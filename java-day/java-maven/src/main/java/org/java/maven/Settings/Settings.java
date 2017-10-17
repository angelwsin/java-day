package org.java.maven.Settings;

//http://maven.apache.org/settings.html
public class Settings {
    
    
    
    /*
     * maven settings 分全局的setting 和用户的setting
     * 
     * 当执行时  setting会合并 ，用户的setting 会覆盖全局的setting
     * 
     * 
     * 
     * 
     * 
     * 
     */
    
    /*<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                                https://maven.apache.org/xsd/settings-1.0.0.xsd">
            <localRepository/>
            <interactiveMode/>
            <usePluginRegistry/>
            <offline/>
            <pluginGroups/>
            <servers/>
            <mirrors/>
            <proxies/>
            <profiles/>
            <activeProfiles/>
          </settings>*/
    
    
    /**
     * Settings Details
     * 1)Simple Values
     * <localRepository>${user.home}/.m2/repository</localRepository>   本地仓库
     * <interactiveMode>true</interactiveMode>  用户交互输入
     * <usePluginRegistry>false</usePluginRegistry>  使用${user.home}/.m2/plugin-registry.xml 进行插件管理
     * <offline>false</offline>                         离线模式
     * 
     * 2)Plugin Groups
     *   pluginGroup包含一个groupId,自动包含 org.apache.maven.plugins and org.codehaus.mojo.
     *   The list is searched when a plugin is used and the groupId is not provided in the command line
     *  <pluginGroups>
     *     <pluginGroup>org.mortbay.jetty</pluginGroup>
     *  </pluginGroups>
     *  例如:mvn jetty:run
     * 3)Servers
     * 
     * The repositories for download and deployment are defined by the repositories and distributionManagement elements of the POM. However,
     *  certain settings such as username and password should not be distributed along with the pom.xml. 
     * This type of information should exist on the build server in the settings.xml
     * 
     * 
     * 4)Mirrors(own custom repositories)
     * 
     * With Repositories you specify from which locations you want to download certain artifacts, 
     * such as dependencies and maven-plugins. Repositories can be declared inside a project, which means that 
     * if you have your own custom repositories, those sharing your project easily get the right settings out of the box. However,
     *  you may want to use an alternative mirror for a particular 
     * repository without changing the project files.
     * 
     *<mirrors>
     * <mirror>
     * <id>planetmirror.com</id>
     * <name>PlanetMirror Australia</name>
     * <url>http://downloads.planetmirror.com/pub/maven2</url>
     * <mirrorOf>central</mirrorOf>  匹配要代理的Servers
     * </mirror>
     * </mirrors>
     * 5)Proxies  (proxy代理)
     * 
     * 6)Profiles profile可以让我们定义一系列的配置信息，然后指定其激活条件   http://elim.iteye.com/blog/1900568
     * 
     * 7)Active Profiles  激活Profiles
     * 
     * 
     * 
     * 
     * 
     */

}
