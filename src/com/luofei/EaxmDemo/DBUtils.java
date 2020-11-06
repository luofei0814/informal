package com.luofei.EaxmDemo;

import java.sql.*;

public class DBUtils {
    private static final String DriverName="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/school";
    private static final String user="root";
    private static final String password="123456";

    static {
        try {
            Class.forName(DriverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static void closeConnection(PreparedStatement statement, ResultSet resultSet){

    }
}
