package com.xx.sm.framework.view;

import com.xx.sm.framework.model.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class showF extends JFrame{

    JLabel xuehao = new JLabel("学号");
    JLabel name = new JLabel("姓名");
    JLabel ssex = new JLabel("性别");
    JLabel brithday = new JLabel("出生日期");
    JLabel shometown = new JLabel("生源地");
    JLabel slocaltion = new JLabel("所在地");
    JLabel cno = new JLabel("班级");
    JLabel dno = new JLabel("院系号");
    JTextField j1 = new JTextField("学号");
    JTextField j2 = new JTextField("姓名");
    JTextField j3 = new JTextField("学号");
    JTextField j4 = new JTextField("出生日期");
    JTextField j5 = new JTextField("DNO");
    JTextField j6 = new JTextField("slocaltion");
    JTextField j7 = new JTextField("Shomehown");
    JTextField j8 = new JTextField("CNO");
    JButton jb = new JButton("修改");
    DBUtil dbUtil = new DBUtil();
  /*  JTextField j5 = new JTextField("学号");
    JTextField j6 = new JTextField("学号");*/
    public showF(ResultSet rs){
        setBounds(100,100,300,200);
        setVisible(true);
        Container c = getContentPane();
        c.setLayout(null);
        c.add(j1); c.add(j2); c.add(j3); c.add(j4);c.add(j6);c.add(j5);c.add(j7);c.add(j8);
        c.add(jb);c.add(xuehao);c.add(name);c.add(ssex);c.add(brithday);c.add(shometown);c.add(slocaltion);c.add(cno);c.add(dno);

        xuehao.setBounds(0,0,100,40);j1.setBounds(50,0,300,40);
        name.setBounds(0,50,100,40);j2.setBounds(50,50,300,40);
        ssex.setBounds(0,100,100,40);j3.setBounds(50,100,300,40);
        brithday.setBounds(0,150,100,40);j4.setBounds(50,150,300,40);
        shometown.setBounds(0,200,100,40);j5.setBounds(50,200,300,40);
        slocaltion.setBounds(0,250,100,40);j6.setBounds(50,250,300,40);
        dno.setBounds(0,300,100,40);j7.setBounds(50,300,300,40);
        cno.setBounds(0,350,100,40);j8.setBounds(50,350,300,40);
        jb.setBounds(0,400,150,50);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "update student set sname = "+"'"+j2.getText()+"' , ssex= '"+j3.getText()+"' ,sbirth='"+j4.getText()+"' , shometown='"+j5.getText()+ "' ,slocation='"+j6.getText()+"' where Sno = "+"'"+j1.getText()+"'";
                dbUtil.update(sql);
            }
        });
        try {
            while (rs.next()) {
                j1.setText(rs.getString("Sno"));
                j2.setText(rs.getString("sname"));
                j3.setText(rs.getString("ssex"));
                j4.setText(rs.getString("sbirth"));
                j5.setText(rs.getString("shometown"));
                j6.setText(rs.getString("slocation"));
                j7.setText(rs.getString("Dno"));
                j8.setText(rs.getString("Cno"));
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}
