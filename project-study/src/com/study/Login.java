package com.study;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public class Login {
    public static String register(Connection conn, String username, String password) {
        PreparedStatement psql = null;
        ResultSet re = null;
        PreparedStatement psqlUpdate = null;
        try {
            String sql = "select * from userdata where username = ?";
            psql = conn.prepareStatement(sql);
            psql.setString(1, username);
            re = psql.executeQuery();
            if(re.isBeforeFirst()) {
                return "wrong username";
            }
            String sqlUpdate = "insert into userdata (username, password)" + "values(?, ?)";
            psqlUpdate = conn.prepareStatement(sqlUpdate);
            psqlUpdate.setString(1, username);
            psqlUpdate.setString(2, password);
            psqlUpdate.executeUpdate();
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        } finally {
            if(psqlUpdate != null) {
                try {
                    psqlUpdate.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            close(psql, re);
        }
    }

    public static String login(Connection conn, String username, String password) {
        PreparedStatement psql = null;
        ResultSet re = null;
        try {
            String sql = "select * from userdata where username = ?";
            psql = conn.prepareStatement(sql);
            psql.setString(1, username);
            re = psql.executeQuery();
            if(!re.isBeforeFirst()) {
                return "wrong username";
            }
            re.next();
            String passwordInTable = re.getString("password");
            if(!passwordInTable.equals(password)) {
                return "wrong password";
            } else {
                return "success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        } finally {
            close(psql, re);
        }
    }

    private static void close(PreparedStatement psql, ResultSet re) {
        if(re != null) {
            try {
                re.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(psql != null) {
            try {
                psql.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Login() {

    }
}
