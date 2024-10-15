package com.szy.dao;

import java.sql.*;

public class BaseDao{
    public  final  static  String  DRIVER  ="com.mysql.jdbc.Driver";
    public  final  static  String  URL    ="jdbc:mysql://localhost:3306/db_crud";
    public  final  static  String  DBNAME ="root";
    public  final  static  String  DBPASS ="123456";
    public Connection getConn() throws ClassNotFoundException,SQLException{
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL,DBNAME,DBPASS);
        return conn;
    }
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(pstmt!=null){
            try{
                pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public int executeSQL(String preparedSql,String[] param)
    {
        Connection conn=null;
        PreparedStatement pstmt=null;
        int num=0;
        try{
            conn=getConn();
            pstmt=conn.prepareStatement(preparedSql);
            if(param!=null){
                for(int i=0;i<param.length;i++){
                    pstmt.setString(i+1,param[i]);
                }
            }
            num=pstmt.executeUpdate();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            closeAll(conn,pstmt,null);
        }
        return num;
    }
    public ResultSet executeQuery(String preparedSql){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConn();
            pstmt=conn.prepareStatement(preparedSql);
            rs=pstmt.executeQuery();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //closeAll(conn,petmt,null);
        }
        return rs;
    }
    public ResultSet executeQuery(String preparedSql,String[] param){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            conn=getConn();
            pstmt=conn.prepareStatement(preparedSql);
            if(param!=null){
                for(int i=0;i<param.length;i++){
                    pstmt.setString(i+1,param[i]);
                }
            }
            rs=pstmt.executeQuery();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            //closeAll(conn,pstmt,null);
        }
        return rs;
    }

}