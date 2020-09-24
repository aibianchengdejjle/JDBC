package com.company;
/*
* jdbc 开发步骤
*   1.注册驱动
*      告知jvm使用的是哪一个数据库的驱动
*   2.获得链接
*       使得jdbc的类 完成对mysql数据库的链接
*   3. 获得语句执行平台
*        执行结果
*   4. 执行sql语句
*           进行my语句 获取得到数据库执行的结果
*   5. 处理结果
*   6. 释放资源
*
* */
import jdk.jshell.spi.ExecutionControl;
import java.net.DatagramPacket;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动最好是运用反射机制
        Class.forName("com.mysql.jdbc.Driver");
        //获得数据库链接
        String url="jdbc:mysql://localhost:3306/ljjsb";
        String username="root";
        String password="a654320a";
        //返回的是一个接口的类  打印出来的是返回的类名 com.mysql.jdbc.JDBC4Connection@1b0375b3
        Connection c= DriverManager.getConnection(url,username,password);
        //System.out.println(c);
        //3  获得sql语句执行平台 c 对象调用的方法
        //createStatement()来获取Statement 将sql语句发送到数据库
        Statement st= c.createStatement();
       //执行sql 语句  运用executeUpdate 执行sql语句 只能执行 insert delete updata 因为只能返回int
        //返回的执行语句 改变表多少行的行数
       int row= st.executeUpdate("insert into sort values (null ,'ljj3'),(null,'jjl')");
        System.out.println(row);
        st.close();
        c.close();
    }
}
