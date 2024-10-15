package com.szy.dao;

import com.szy.pojo.User;

import java.util.List;

public interface UserDao {
    public int insert(User user);

    public boolean login(User user);

    public List<User> findAll();

    public int delete(Integer id);

    public User findById(Integer id);

    public int update(User user);

    public List<User> findByUser(User user);
}

