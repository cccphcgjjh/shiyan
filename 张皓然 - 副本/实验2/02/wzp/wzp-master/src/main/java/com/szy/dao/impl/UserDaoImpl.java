package com.szy.dao.impl;

import com.szy.dao.BaseDao;
import com.szy.dao.UserDao;
import com.szy.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    BaseDao bd=new BaseDao();

    @Override
    public int insert(User user){
        String sql = "insert into tb_user(name,pwd,sex,age,phone) values(?,?,?,?,?)";
        String[] param = new String[]{
                user.getName(),
                user.getPwd(),
                user.getSex(),
                user.getAge(),
                user.getPhone()
        };
        return bd.executeSQL(sql, param);
    }
    @Override
    public boolean login(User user){
        String sql="select * from tb_user where name=? and pwd=?";
        String[] param=new String[]{
                user.getName(),
                user.getPwd()
        };
        ResultSet rs=bd.executeQuery(sql,param);
        try{
            if(rs.next()){
                return true;
            }
            return false;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findAll(){
        List<User> list=new ArrayList<User>();
        String sql="select * from tb_user";
        ResultSet rs=bd.executeQuery(sql);
        try{
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getString("age"));
                user.setPhone(rs.getString("phone"));
                list.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public int delete(Integer id){
        String sql="delete from tb_user where id=?";
        String[] param=new String[]{String.valueOf(id)};
        return bd.executeSQL(sql,param);
    }
    @Override
    public User findById(Integer id){
        String sql="select*from tb_user where id=?";
        String[] param=new String[]{String.valueOf(id)};
        ResultSet rs=bd.executeQuery(sql,param);
        User user=null;
        try{
            ((ResultSet) rs).next();
            user=new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPwd(rs.getString("pwd"));
            user.setSex(rs.getString("sex"));
            user.setAge(rs.getString("age"));
            user.setPhone(rs.getString("phone"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public int update(User user){
        String sql="update tb_user set name=?,pwd=?,sex=?,age=?,phone=? where id=?" ;
        String[] param=new String[]{
                user.getName(),
                user.getPwd(),
                user.getSex(),
                user.getAge(),
                user.getPhone(),
                String.valueOf(user.getId())
        };
        return bd.executeSQL(sql,param);
    }
    @Override
    public List<User> findByUser(User user){
        List<User> list=new ArrayList<User>();
        String sql="select * from tb_user where 1=1 ";

        if(!"".equals(user.getName())&&user.getName()!=null){
            sql+=" and name like '%"+user.getName()+"%'";
        }
        if(!"".equals(user.getSex())&&user.getSex()!=null){
            sql+=" and sex like '%"+user.getSex()+"%'";
        }
        if(!"".equals(user.getAge())&&user.getAge()!=null){
            sql+=" and age like '%"+user.getAge()+"%'";
        }
        if(!"".equals(user.getPhone())&&user.getPhone()!=null){
            sql+=" and phone like '%"+user.getPhone()+"%'";
        }
        ResultSet rs=bd.executeQuery(sql);
        try{
            while(rs.next()){
                User user1=new User();
                user1.setId(rs.getInt(1));
                user1.setName(rs.getString(2));
                user1.setPwd(rs.getString(3));
                user1.setSex(rs.getString(4));
                user1.setAge(rs.getString(5));
                user1.setPhone(rs.getString(6));
                list.add(user1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
