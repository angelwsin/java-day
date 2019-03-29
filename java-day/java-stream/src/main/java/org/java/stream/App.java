package org.java.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8 stream 流的概念
 *
 * 管道
 * an intermediate or terminal stream operation
 *
 * Stream pipelines may execute either sequentially or in parallel
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<User> list  = new ArrayList<>();
    	for(int i=0;i<10;i++){
    		User user = new User();
    		user.setAge(i+1);
    		user.setUserName("zhsngs"+i);
    		list.add(user);
    	}
    	
    	//list.stream().collect(Collectors.groupingBy(classifier))

		list.stream().filter(user -> user.getAge()==1).count();
    	
    }
}
