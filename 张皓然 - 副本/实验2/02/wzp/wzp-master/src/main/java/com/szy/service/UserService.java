package com.szy.service;

import com.szy.pojo.User;

import java.util.List;

public interface UserService{
    public int insert(User user);
    public boolean login(User user);
    public List<User> findAll();
    public int delete(Integer id);
    public User findById(Integer id);
    public int update(User user);
    public List<User>findByUser(User user);
    boolean isInsert(String name);
}