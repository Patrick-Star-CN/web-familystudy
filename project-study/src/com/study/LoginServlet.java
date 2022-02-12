package com.study;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        JSONObject jsonIn = JSONReader.receivePost(req);
        JSONObject jsonOut = new JSONObject();
        ServletOutputStream out = resp.getOutputStream();

        String username = jsonIn.getString("username");
        String password = jsonIn.getString("password");

        Connection conn = SQLconn.conn();
        String res = Login.login(conn, username, password);
        SQLconn.disconn(conn);

        jsonOut.put("message", res);
        out.print(jsonOut.toString());
    }

    public LoginServlet() {

    }
}
