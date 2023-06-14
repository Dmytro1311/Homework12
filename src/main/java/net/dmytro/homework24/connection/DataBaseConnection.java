package net.dmytro.homework24.connection;

import java.sql.*;

public class DataBaseConnection {

   private static final String url = "jdbc:mysql://localhost:3306/homework23";
   private static final String user = "root";
   private static final String password = "Dima131197";


    public static Connection  getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Connection connect) throws SQLException {
        if (connect != null){
            connect.close();
        }
    }
}
