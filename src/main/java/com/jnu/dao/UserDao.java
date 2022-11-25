package com.jnu.dao;

import com.jnu.domain.User;

import java.sql.SQLException;

public interface UserDao {
    //注册新用户
    public void reg(User user) throws ClassNotFoundException, SQLException;
    //查询是否存在已注册用户
    public boolean login(User user) throws ClassNotFoundException, SQLException;
    //查询已注册用户是否有相同用户名
    public boolean select(User user) throws ClassNotFoundException, SQLException;
}
