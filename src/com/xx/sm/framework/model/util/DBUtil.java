package com.xx.sm.framework.model.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    private List<Connection> list = null;
    private Connection conn = null;
    private Statement sta = null;
    private ResultSet rs = null;

    public DBUtil() {
        this.list = new ArrayList<Connection>();
        for(int i = 0; i < 5; i++) {
            this.list.add(this.getConnection());
        }
        this.conn = this.list.get(0);
        //System.out.println(this.conn);
    }



    public Connection getConnection() {
        Connection myConn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu", "root", "root");
            //System.out.println("数据库连接成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myConn;
    }

    public int update(String sql) {
        int n = -1;
        try {
            this.sta = this.conn.createStatement();
            n = this.sta.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public ResultSet query(String sql) {
        try {
            this.sta = this.conn.createStatement();
            this.rs = this.sta.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.rs;
    }

    public void close() {
        try {
            if(this.rs != null) {
                this.rs.close();
                this.rs = null;
            }
            if(this.sta != null) {
                this.sta.close();
                this.sta = null;
            }
            if(this.conn != null) {
                this.conn.close();
                this.conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
