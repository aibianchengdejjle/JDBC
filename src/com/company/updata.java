package com.company;
/*
*   用PreparedStatement来进行更新操作
*
*
* */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class updata {
    public static void main(String[] args)  throws  Exception{
        Connection c=JDBCUtils.getConnection();
        //写修改的sql 语句都用占位来进行
        String sql="update sort set sname=? where  sid=?";
        PreparedStatement ps=c.prepareStatement(sql);
        //第一句话是sname 第二句话是sid 意思就是搜索 sid=1 将他的sname改成hh
       ps.setObject(1,"hh");
       ps.setObject(2,1);
       //调用更新的算法
       ps.executeUpdate();
       ps.close();
       c.close();
    }
}
