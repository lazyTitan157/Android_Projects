package com.example.hong_inseon.projectlouvre.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by samsung on 2016-12-03.
 */

public class JDBCUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://35.161.181.60:3306/louvre", "nullteam", "null");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //select안하는경우
    public static void close(PreparedStatement stmt, Connection conn) {
        try {
            if(stmt != null)
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }
        try {
            if(conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    //select 하는 경우 : result set을 받음.
    public static void close(ResultSet rst, PreparedStatement stmt, Connection conn) {
        try {
            if(rst != null)
                rst.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rst = null;
        }
        try {
            if(stmt != null)
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }
        try {
            if(conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

}
