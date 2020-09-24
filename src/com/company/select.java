package com.company;

import java.sql.*;
import java.util.Set;

public class select {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/ljjsb","root","a654320a");
        Statement st=c.createStatement();
        //执行查询语句
        String sql="select * from sort";
        //调用执行这对象的方法 获取结果集 因为他返回的是Result结果集
        ResultSet rs=st.executeQuery(sql);
        //处理结果集
        //Result 接口方法 next  返回true，有结果
        //System.out.println(rs.next());
        while(rs.next())
        {
            //获取每列数据
            System.out.println(rs.getInt("sid")+"   "+rs.getString("sname"));
        }
        rs.close();
        st.close();
        c.close();
    }
}
