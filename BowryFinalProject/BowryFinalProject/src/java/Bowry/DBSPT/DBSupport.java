/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bowry.DBSPT;

/**
 *
 * @author travi
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author travi
 */
public class DBSupport {
    
      public static Connection establishConnection() throws SQLException, ClassNotFoundException{
        //Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        Properties connectProp = new Properties();
        connectProp.put("dbms","mysql");
        connectProp.put("user","root");
        connectProp.put("password","root");
        connectProp.put("useSSL","false");         
        String P1 = "jdbc:mysql://localhost:3306/SportsDB";
        conn = DriverManager.getConnection(P1,connectProp);
        return conn;
    }
    
    public static void executeQuery(String q) throws SQLException, ClassNotFoundException{        
        Connection conn = establishConnection();
        Statement useStatement = conn.createStatement();
        useStatement.execute("USE SportsDB");
        Statement queryStatement = conn.createStatement();
        queryStatement.execute(q); 
        conn.close();                
    }
    
    public static ResultSet executeResultsQuery(String q) throws SQLException, ClassNotFoundException{        
        Connection conn = establishConnection();
        Statement useStatement = conn.createStatement();
        useStatement.execute("USE SportsDB");      
              
        Statement queryStatement = conn.createStatement();
        ResultSet R = queryStatement.executeQuery(q);        
        return R;                
    }
    
}
