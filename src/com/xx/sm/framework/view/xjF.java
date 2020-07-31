package com.xx.sm.framework.view;

import com.xx.sm.framework.model.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xjF extends JFrame {
    public xjF(String sno) {
        DBUtil dbUtil = new DBUtil();

        JLabel xuehao = new JLabel("学号");
        JLabel name = new JLabel("变动类型");
        JLabel ssex = new JLabel("变动日期");
        JLabel brithday = new JLabel("变动原因");


        JTextField j1 = new JTextField("学号");
        JTextField j2 = new JTextField("变动类型");
        JTextField j3 = new JTextField("变动日期");
        JTextField j4 = new JTextField("变动原因");
        JButton jb = new JButton("修改");
        xuehao.setBounds(0,0,100,40);j1.setBounds(50,0,300,40);
        name.setBounds(0,50,100,40);j2.setBounds(50,50,300,40);
        ssex.setBounds(0,100,100,40);j3.setBounds(50,100,300,40);
        brithday.setBounds(0,150,100,40);j4.setBounds(50,150,300,40);

            setBounds(100,100,500,500);
            setVisible(true);
            Container c = getContentPane();
            c.setLayout(null);
        c.add(j1); c.add(j2); c.add(j3); c.add(j4);
        c.add(jb);c.add(xuehao);c.add(name);c.add(ssex);c.add(brithday);
        jb.setBounds(0,200,300,40);
            String sql = "select * from Changee where sno = "+"'"+sno+"'";
            ResultSet rs2 = dbUtil.query(sql);
            try {
                while (rs2.next()) {
                    j1.setText(rs2.getString("sno"));
                    j2.setText(rs2.getString("Changenotes"));
                    j3.setText(rs2.getString("Changetime"));
                    j4.setText(rs2.getString("Changemeno"));
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
}
