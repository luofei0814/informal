package com.luofei.EaxmDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Dao {
    public static ArrayList<User> selectUser(){
        ArrayList<User> userlist=new ArrayList<>();
        try {
            Connection connection=DBUtils.getConnection();
            String sql="select*from ofo_user";
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                float balance=resultSet.getFloat("balance");
                float mileage=resultSet.getFloat("mileage");
                User userDemo=new User(id,name,balance,mileage);
                userlist.add(userDemo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  userlist;
    }

    public static boolean updateUser( int id, String name, float balance, float mileage) {
        try {
            Connection connection=DBUtils.getConnection();
            String sql="update ofo_user set name=?,balance=?,mileage=? where id=?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2, String.valueOf(balance));
            statement.setString(3,String.valueOf(mileage));
            statement.setString(  4,String.valueOf(id));
            int n= statement.executeUpdate();
         if (n>0){
             return  true;
         }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
