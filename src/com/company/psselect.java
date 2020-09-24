package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class psselect {
    public  psselect(){

    }
    public static void main(String[] args) throws SQLException {
        Connection con = JDBCUtils.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT * FROM product");
        ResultSet rs = pst.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString("pname")+"  "+rs.getString("price"));
        }

        JDBCUtils.close(con, pst, rs);

    }
}
