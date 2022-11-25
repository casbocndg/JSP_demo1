package com.jnu.oldimpl;

import com.jnu.dao.UserDao;
import com.jnu.domain.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public void reg(User user) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        String sql = "insert into co_users (username,password) values(?,?)";

        //2.加载驱动，mysql5之后可不用该语句
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.创建连接mysql的url，该语句不用更改；url连接本机可用String url="jdbc:mysql:///db1";
        String url="jdbc:mysql://127.0.0.1:3306/campus_office?serverTimezone=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        //连接数据库的账号
        String myuser="root";
        //连接数据库的密码
        String password="125521";
        //4.连接数据库java.sql.Connection
        conn= DriverManager.getConnection(url,myuser,password);
        //5.测试连接是否成功
        System.out.println(conn);
        try {
            conn= DriverManager.getConnection(url,myuser,password);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            int isok = stmt.executeUpdate();
            System.out.println("-----" + isok);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(User user) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        String sql = "Select * from co_users where username = ? and password = ?";
        boolean islogin = false;

        //2.加载驱动，mysql5之后可不用该语句
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.创建连接mysql的url，该语句不用更改；url连接本机可用String url="jdbc:mysql:///db1";
        String url="jdbc:mysql://127.0.0.1:3306/campus_office?serverTimezone=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        //连接数据库的账号
        String myuser="root";
        //连接数据库的密码
        String password="125521";
        //4.连接数据库java.sql.Connection
        conn= DriverManager.getConnection(url,myuser,password);
        //5.测试连接是否成功
        System.out.println(conn);
        try {
            conn= DriverManager.getConnection(url,myuser,password);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            rs = stmt.executeQuery();
            while (rs.next()) {
                islogin = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return islogin;
    }

    @Override
    public boolean select(User user) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        String sql = "Select * from co_users where username = ?";
        boolean islogin = false;

        //2.加载驱动，mysql5之后可不用该语句
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.创建连接mysql的url，该语句不用更改；url连接本机可用String url="jdbc:mysql:///db1";
        String url="jdbc:mysql://127.0.0.1:3306/campus_office?serverTimezone=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
        //连接数据库的账号
        String myuser="root";
        //连接数据库的密码
        String password="125521";
        //4.连接数据库java.sql.Connection
        conn= DriverManager.getConnection(url,myuser,password);
        //5.测试连接是否成功
        System.out.println(conn);
        try {
            conn= DriverManager.getConnection(url,myuser,password);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            rs = stmt.executeQuery();
            if (!rs.next()) {
                islogin = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return islogin;
    }
}
