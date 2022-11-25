package com.jnu.dao.impl;

import com.jnu.dao.IUserDao;
import com.jnu.domain.User;
import org.springframework.stereotype.Repository;

import java.sql.*;

//@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {
//    @Override
    public User queryUserByName(String userName) {
        return super.querUserByName(userName);
    }

    @Override
    public User addUser(String userName, String password) {
        return super.addUser(userName, password);
    }
}
