package org.java.maven.Plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;


// maven 插件开发   继承AbstractMojo 实现execute方法

//http://maven.apache.org/plugin-developers/index.html
//What is a Mojo? A mojo is a Maven plain Old Java Object. Each mojo is an executable goal in Maven, and a plugin is a distribution of one or more related mojos
//每一个Mojo称为 executable goal
public class MyMvnPlugin extends AbstractMojo{

    public void execute() throws MojoExecutionException, MojoFailureException {
        // TODO Auto-generated method stub
        
    }

}
