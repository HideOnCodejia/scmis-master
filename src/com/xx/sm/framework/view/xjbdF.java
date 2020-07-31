package com.xx.sm.framework.view;

import com.xx.sm.framework.model.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class xjbdF extends JFrame{

    DBUtil dbUtil = new DBUtil();
    /*  JTextField j5 = new JTextField("学号");
      JTextField j6 = new JTextField("学号");*/
   /* JLabel jb1 = new JLabel("学号");
    JLabel jb2 = new JLabel("姓名");
    JLabel jb3 = new JLabel("惩罚等级");
    JLabel jb4 = new JLabel("惩罚时间");*/
    public xjbdF(String sno){
        JLabel xuehao = new JLabel("学号");
        JLabel name = new JLabel("惩罚等级");
        JLabel ssex = new JLabel("惩罚时间");
        JLabel brithday = new JLabel("惩罚内容");

        JTextField j1 = new JTextField("学号");
        JTextField j2 = new JTextField("变动类型");
        JTextField j3 = new JTextField("变动日期");
        JTextField j4 = new JTextField("变动原因");
        setBounds(100,100,500,500);
        setVisible(true);
        Container c = getContentPane();
        c.setLayout(null);
        JTextArea jt = new JTextArea();
        c.add(jt);/*c.add(jb1);c.add(jb2);c.add(jb3);c.add(jb4);*/
        String sql =  "select * from Punishments where sno = "+"'"+sno+"'";
        ResultSet rs2 = dbUtil.query(sql);


        c.add(j1); c.add(j2); c.add(j3); c.add(j4);
       c.add(xuehao);c.add(name);c.add(ssex);c.add(brithday);
        xuehao.setBounds(0,0,100,40);j1.setBounds(50,0,300,40);
        name.setBounds(0,50,100,40);j2.setBounds(50,50,300,40);
        ssex.setBounds(0,100,100,40);j3.setBounds(50,100,300,40);
        brithday.setBounds(0,150,100,40);j4.setBounds(50,150,300,40);
        JButton jb = new JButton("修改");c.add(jb);jb.setBounds(0,200,300,40);
        try {
            while (rs2.next()) {
                j1.setText(rs2.getString("sno"));
                j2.setText(rs2.getString("Plevel"));
                j3.setText(rs2.getString("Ptime"));
                j4.setText(rs2.getString("Pmeno"));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
