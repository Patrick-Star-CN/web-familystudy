package com.study;

import jakarta.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public class JSONReader {
    public static JSONObject receivePost(HttpServletRequest request) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while((line = br.readLine()) != null) {
            sb.append(line);
        }
        JSONObject json = JSONObject.fromObject(sb.toString());
        return json;
    }

    private JSONReader() {

    }
}