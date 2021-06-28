package com.sangeng.dao;

import com.sangeng.domain.User;

import java.util.List;

public interface UserDao {
    User findById(Integer id);

    List<User> findAll();

    void insertUser(User user);

    void updateUser(User user);
}

    
