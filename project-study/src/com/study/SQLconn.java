package com.study;

import java.sql.*;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public class SQLconn {
    public static Connection conn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/study";
        String user = "root";
        String password = "cxcxcx4,";
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return conn;
        }
    }

    public static void disconn(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SQLconn() {

    }
}
