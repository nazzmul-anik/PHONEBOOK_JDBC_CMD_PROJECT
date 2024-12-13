package org.anik.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static Connection connection;
    public static Connection getConnection(){

        try{
            if(connection == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbUrl = "jdbc:mysql://localhost:3306/phonebook";
                String dbUser = "root";
                String dbPassword = "root";
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
