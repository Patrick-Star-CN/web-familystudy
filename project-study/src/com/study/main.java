package com.study;

import java.sql.Connection;
import java.util.Scanner;

/**
 * @author Patrick_Star
 * @version 1.0
 */
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        String username = sc.next();
        String password = sc.next();
        if(type == 1) {
            Connection conn = SQLconn.conn();
            System.out.println(Login.register(conn, username, password));
            SQLconn.disconn(conn);
        } else if(type == 2) {
            Connection conn = SQLconn.conn();
            System.out.println(Login.login(conn, username, password));
            SQLconn.disconn(conn);
        }
    }
}
