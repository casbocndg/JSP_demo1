package com.jnu.dao.impl;

import com.jnu.domain.User;

import java.sql.*;

public class BaseDao {
    private Connection conn = null;

    public BaseDao() {
        initConn();
    }

    private void initConn() {
        //加载数据库驱动
        String url = "jdbc:mysql://localhost:3306/test";
        try {
            //ClassLoader加载驱动类的Class文件
            new com.mysql.jdbc.Driver();
//            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "125521");
        }catch (SQLException e) {
            System.out.println("Connection is error.");
            e.printStackTrace();
            //error("connection is error.")
        }
    }

    public User querUserByName(String userName) {
        User user = null;
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet userSet = stat.executeQuery("select * from t_users where userName = '" + userName + "'");
            user = new User();
            while (userSet.next()) {
                user.setUsername(userSet.getString(2));
                user.setPassword(userSet.getString(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    protected User addUser(String userName, String password) {
        return null;
    }

//    public User addUser(String userName, String password) {
//        User user = null;
//        Statement stat = null;
//        try {
//            stat = conn.createStatement();
//            ResultSet userSet = stat.executeQuery("insert into t_users(userName, password) values ('""')");
//        }
//    }
}
