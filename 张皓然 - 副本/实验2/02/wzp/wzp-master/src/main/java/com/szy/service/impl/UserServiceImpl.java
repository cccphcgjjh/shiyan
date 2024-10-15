package com.szy.service.impl;

import com.szy.dao.UserDao;
import com.szy.dao.impl.UserDaoImpl;
import com.szy.pojo.User;
import com.szy.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> findByUser(User user) {
        return userDao.findByUser(user);
    }

    @Override
    public boolean isInsert(String name) {
        User u = new User();
        u.setName(name);
        List<User> ulist = userDao.findByUser(u);
        if (ulist==null){
            return true;
        }
        else {
            return false;
        }
    }
}
