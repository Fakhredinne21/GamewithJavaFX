package fakhredinne.puissanceapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static MyConnection myConnection;
    private Connection conn;

    private MyConnection() throws ClassNotFoundException {
        try {
            String serverDB = "jdbc:mysql://localhost:3306/connect4?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(serverDB, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() throws ClassNotFoundException {
        if (myConnection == null) {
            myConnection = new MyConnection();
        }
        return myConnection.conn;
    }



}