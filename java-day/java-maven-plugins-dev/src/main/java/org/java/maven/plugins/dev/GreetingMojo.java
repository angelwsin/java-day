package org.java.maven.plugins.dev;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

//maven 插件开发   继承AbstractMojo 实现execute方法

//http://maven.apache.org/plugin-developers/index.html
//What is a Mojo? A mojo is a Maven plain Old Java Object. Each mojo is an executable goal in Maven, and a plugin is a distribution of one or more related mojos
//每一个Mojo称为 executable goal

/**
 * goal is greeting
 * @author Administrator
 *
 */
@Mojo(name="greeting",defaultPhase=LifecyclePhase.COMPILE)
public class GreetingMojo extends AbstractMojo{

    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info( "Hello, world." );
        
    }

}


//mvn groupId:artifactId:version:goal 