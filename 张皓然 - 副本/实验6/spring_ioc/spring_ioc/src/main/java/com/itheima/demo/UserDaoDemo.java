package com.itheima.demo;

import com.itheima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:UserDaoDemo
 * Package:com.itheima.demo
 * Description:
 *
 * @Author 张皓然
 * @Create 2024/10/14 18:37
 * @Version 1.0
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
