package org.java.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8 stream 流的概念
 * 
 * map reduce
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
    	
    }
}
