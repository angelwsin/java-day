package org.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // DataSource
        //connection
        //stmt
        
       //传统的jdbc
        
        /*try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        
        /* DriverManager.registerDriver(new Driver());
         Connection conn  =  DriverManager.getConnection(url, user, password);
         conn.setAutoCommit(false);
         Statement  stat = conn.createStatement();
         ResultSet result = stat.executeQuery(sql);
         conn.commit();*/
        DataSource  dataSource = new DruidDataSource();
    }
}
