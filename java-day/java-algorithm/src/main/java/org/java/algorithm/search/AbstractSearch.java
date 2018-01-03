package org.java.algorithm.search;

import java.util.ArrayList;
import java.util.List;


public class AbstractSearch {
    
    
    protected static List<Node>  arrays = new ArrayList<Node>();
    
    static{
       
        for(int i=0;i<1000;i++){
            arrays.add(new Node(i));
        }
        
    }
    

}
