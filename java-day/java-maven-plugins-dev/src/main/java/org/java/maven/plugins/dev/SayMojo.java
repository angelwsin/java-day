package org.java.maven.plugins.dev;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

public class SayMojo extends AbstractMojo{
    
    //http://maven.apache.org/guides/plugin/guide-java-plugin-development.html
    //属性的配置见pom.xml 的 <plugin> <configuration>
    
    //<name>Welcome</name>  String
    @Parameter( property = "sayhi.greeting", defaultValue = "Hello World!" )
    private String name;
    
    

    public void execute() throws MojoExecutionException, MojoFailureException {
        // TODO Auto-generated method stub
        
    }

}


// mvn groupId:artifactId:version:goal -Dsayhi.greeting=hello 




/*<project>
...
<build>
  <plugins>
    <plugin>
      <artifactId>maven-myquery-plugin</artifactId>
      <version>1.0</version>
      <executions>
        <execution>
          <id>execution1</id>
          <phase>test</phase>
          <configuration>
            <url>http://www.foo.com/query</url>
            <timeout>10</timeout>
            <options>
              <option>one</option>
              <option>two</option>
              <option>three</option>
            </options>
          </configuration>
          <goals>
            <goal>query</goal>
          </goals>
        </execution>
        <execution>
          <id>execution2</id>
          <configuration>
            <url>http://www.bar.com/query</url>
            <timeout>15</timeout>
            <options>
              <option>four</option>
              <option>five</option>
              <option>six</option>
            </options>
          </configuration>
          <goals>
            <goal>query</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
...
</project>*/