package org.java.maven.Run;

import org.apache.maven.cli.MavenCli;
import org.codehaus.plexus.classworlds.launcher.Launcher;

public class Mvn {
    
    
    /*
     * 
     * 
     * mvn [options] [<goal(s)>] [<phase(s)>]
     * 
     * The built in life cycles and their phases are in order are:
     *
     * 1. clean - pre-clean, clean, post-clean

       2.default - validate, initialize, generate-sources, process-sources, generate-resources, process-resources, compile,
        process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, 
        test-compile, process-test-classes, test, prepare-package, package, pre-integration-test, integration-test, 
        post-integration-test, verify, install, deploy

       3. site - pre-site, site, post-site, site-deploy
     */
    
    
    
    /**
     * Plexus是什么？它是一个IoC容器，由codehaus在管理的一个开源项目。和Spring框架不同，它并不是一个完整的，拥有各种组件的大型框架，仅仅是一个纯粹的IoC容器。
     * 
     * mvn的 命令
     * 
     * mvn [options] [<goal(s)>] [<phase(s)>]
     * 
     * [<goal(s)>] goalPrefix:goal(mojo)
     */
    
    
    public static void main(String[] args) {
        //mvn  命令
        Launcher.main(args);
        //
        MavenCli.main(args);
    }

}
