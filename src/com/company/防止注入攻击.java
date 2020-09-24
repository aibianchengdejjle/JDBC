package com.company;

import java.nio.channels.ScatteringByteChannel;
import java.sql.*;
import java.util.Scanner;

public class 防止注入攻击 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ljjsb","root","a654320a");
        Scanner sc=new Scanner(System.in);
        String user=sc.next();
        String password=sc.next();
        String sql="select *from users where username=?and password=?";
        //调用Connection接口的PreparStatement
        //方法中的参数都已问号给出
        PreparedStatement ps=c.prepareStatement(sql);
        //将用户名和密码都给出
        ps.setObject(1,user);
        ps.setObject(2,password);
        ResultSet rs=ps.executeQuery();
        while (rs.next())
        {
            System.out.println(rs.getString("username")+"   "+rs.getString("password"));
        }
        c.close();
        rs.close();
        ps.close();
    }
}
