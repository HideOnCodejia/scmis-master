package com.xx.sm.framework.view;

import com.xx.sm.framework.model.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainF extends JFrame {

    public MainF(String sno){
        setBounds(100,100,300,600);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton j1 = new JButton("学生信息");
        JButton j2 = new JButton("学生信息修改");
        JButton j3 = new JButton("惩罚信息");
        JButton j4 = new JButton("奖励信息");
        JButton j5 = new JButton("学籍变动管理");
        JButton j6 = new JButton("插入");
        c.add(j1);
        c.add(j2);
        c.add(j3);
        c.add(j4);
        c.add(j5);
        c.add(j6);
        setVisible(true);
        DBUtil db = new DBUtil();
        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from student where Sno = "+"'"+ sno+"'";
                ResultSet rs = db.query(sql);
                new showF(rs);
            }
        });
        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from student where Sno = "+"'"+ sno+"'";
                ResultSet rs = db.query(sql);
                new showF(rs);
            }
        });
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from student where Sno = "+"'"+ sno+"'";
                ResultSet rs = db.query(sql);
                new xjbdF(sno);
            }
        });
        j4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from student where Sno = "+"'"+ sno+"'";
                ResultSet rs = db.query(sql);
                new jcxx(sno);
            }
        });
        j5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from student where Sno = "+"'"+ sno+"'";
                ResultSet rs = db.query(sql);
                new xjF(sno);
            }
        });
        j6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new insert();
            }
        });
    }

    public static void main(String[] args) {

    }
}
