/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Thuan
 */
public class JDBCConnection {
    public static Connection getJDBCConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl= "jdbc:sqlserver://localhost:1433;databaseName=QuanLySinhVien";
            String username="thuan";
            String password="123";
            return (Connection) DriverManager.getConnection(dbUrl,username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Connection connection= getJDBCConnection();
        if(connection != null)
                System.out.println("Thanh Cong");
        else
               System.out.println("That Bai");
    }        

        
}
