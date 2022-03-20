package com.study;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public class TestCookieServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        ObjectMapper OM = new ObjectMapper();
        ServletOutputStream out = resp.getOutputStream();
        CookieBean jsonOut = new CookieBean();

        if(cookies != null) {
            if("name".equals(cookies[1].getName())) {
                    jsonOut.setUsername(cookies[1].getValue());
                    jsonOut.setMessage("success");
            } else {
                jsonOut.setMessage("wrong");
            }
        }

        out.print(OM.writeValueAsString(jsonOut));
    }
}
