/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author User
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    //dotplan @ DotPlan (web name) that is also name for database
    //private static final String URL = "jdbc:mysql://localhost:3306/DotPlan"; 
    //private static final String USER = "root";
    //private static final String PASSWORD = "admin"; // MySQL password

    // Register dalam environment based on catalina.start
    private static final String JDBC_URL = System.getenv("DB_URL"); 
    private static final String JDBC_USER = System.getenv("DB_USER");
    private static final String JDBC_PASS = System.getenv("DB_PASS");

    
    
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        // Return the connection
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
}
