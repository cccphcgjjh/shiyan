package com.szy.pojo;

public class User{
    private Integer id;
    private String name;
    private String pwd;
    private String sex;
    private String age;
    private String phone;

    @Override
    public String toString(){
        return "User [id="+id+",name="+name+",pwd="+pwd+",sex="+sex+",age="+age+",phone="+phone+"]";
    }

    public int getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPwd(){
        return pwd;
    }
    public void setPwd(String pwd){
        this.pwd=pwd;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age=age;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
}