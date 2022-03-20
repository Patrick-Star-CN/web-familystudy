package com.study;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        ObjectMapper OM = new ObjectMapper();
        LoginBean jsonIn = OM.readValue(JSONReader.receivePost(req), LoginBean.class);
        ServletOutputStream out = resp.getOutputStream();

        String username = jsonIn.getUsername();
        String password = jsonIn.getPassword();

        Connection conn = SQLconn.conn();
        String res = Login.login(conn, username, password);
        Cookie cookie = new Cookie("name", username);
        resp.addCookie(cookie);

        SQLconn.disconn(conn);

        MessageBean jsonOut = new MessageBean(res);
        out.print(OM.writeValueAsString(jsonOut));
    }

    public LoginServlet() {

    }
}
