package com.company;

import java.sql.*;

/*
*   如何被别人注入攻击
*
*
* */
public class 注入攻击 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ljjsb","root","a654320a");
        Statement st= c.createStatement();
        //执行sql语句 运用Resultset 对象判断是否为真
        String sql="SELECT *FROM users WHERE username='b' AND `password`=1 or 1=1";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            System.out.println(rs.getString("username")+"   "+rs.getString("password"));
        }
        //必须要关闭
        c.close();
        rs.close();
        st.close();
    }
}
