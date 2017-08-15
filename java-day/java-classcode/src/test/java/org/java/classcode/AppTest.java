package org.java.classcode;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    
    public static void main(String[] args) {
        
        new AppTest().test();
    }
    
    
    public void test(){
        int x =0;
        try {
             x = 9;
            String y = "ee"; 
        } catch (Exception e) {
           e.printStackTrace();
        }finally {
            x = 10;
        }
       
        
    }
    
    public int  re(){
        
        int x = Integer.valueOf("x");
        return x;
    }
    
}
