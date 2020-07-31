package com.xx.sm.framework.view;

import com.xx.sm.framework.model.dao.impl.IMisUserDAO;
import com.xx.sm.framework.model.dao.impl.IMisUserDAOImpl;
import com.xx.sm.framework.model.entity.MisUser;
import com.xx.sm.framework.model.util.DBUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

public class LoginFrame extends JFrame implements ActionListener {
    private MisUser loginUser = null;

    private JPanel bodyPanel = null;
    private JPanel buttonPanel = null;

    private JLabel titleLabel = null;
    private JLabel userNameLabel;
    private JTextField userNameField = null;
    private JLabel userPassLabel = null;
    private JPasswordField userPassField = null;

    private JButton LoginButton = null;
    private JButton CancelButton = null;

    //用户验证
    private boolean checkUser(MisUser misUser) {
        boolean flag = false;
        IMisUserDAO misUserDAO = new IMisUserDAOImpl();
        MisUser tempUser = misUserDAO.findByName(misUser.getUserName());
        if(tempUser != null && tempUser.getUserPassword().equals(misUser.getUserPassword())) {
            flag = true;
            this.loginUser = tempUser;
        }
        return flag;
    }

    private void init() {
        Container c = (JPanel)this.getContentPane();
        this.bodyPanel = new ImagPanel();
        this.bodyPanel.setLayout(new GridBagLayout());
        c.add(this.bodyPanel);


        GridBagConstraints gbc = new GridBagConstraints();

        this.titleLabel = new JLabel("用户登录");
        this.titleLabel.setFont(new Font("华文行楷", Font.BOLD, 26));
        this.titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.bodyPanel.add(this.titleLabel, gbc);

        gbc.anchor = GridBagConstraints.WEST;//设置对齐方式

        this.userNameLabel = new JLabel("用户名：");
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.bodyPanel.add(this.userNameLabel, gbc);

        this.userNameField = new JTextField(16);
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.bodyPanel.add(this.userNameField, gbc);

        this.userPassLabel = new JLabel("口    令：");
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.bodyPanel.add(this.userPassLabel, gbc);

        this.userPassField = new JPasswordField(16);
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.bodyPanel.add(this.userPassField, gbc);

        this.buttonPanel = new JPanel();
        this.buttonPanel.setOpaque(false);//设置buttonPanel底色透明
        this.LoginButton = new JButton("登录");
        this.LoginButton.addActionListener(this);
        this.CancelButton = new JButton("重置");
        this.CancelButton.addActionListener(this);
        this.buttonPanel.add(this.LoginButton);
        this.buttonPanel.add(this.CancelButton);
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.bodyPanel.add(this.buttonPanel, gbc);

        this.setTitle("登录界面");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public LoginFrame() throws HeadlessException {
        this.init();
    }

    public static void main(String[] args) {
//        Font font = new Font("Default", Font.PLAIN, 12);
////		Enumeration keys = UIManager.getDefaults().keys();
////		while(keys.hasMoreElements()){
////		        Object key = keys.nextElement();
////		        Object value = UIManager.get(key);
////		        if (value instanceof javax.swing.plaf.FontUIResource){
////		                UIManager.put(key, font);
////		        }
////		}
////		JFrame.setDefaultLookAndFeelDecorated(true);

        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        LoginFrame frame = new LoginFrame();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double x = dimension.getWidth();
        double y = dimension.getHeight();
        Double ox = new Double(x);
        Double oy = new Double(y);
        int ix = ox.intValue();
        int iy = oy.intValue();
        frame.setBounds((ix-430)/2, (iy-300)/2, 430, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       /* if(e.getSource() == this.LoginButton) {
            String userName = this.userNameField.getText();
            String userPass = new String(this.userPassField.getPassword());
            if(userName.length() <= 0 || userPass.length() <= 0) {
                JOptionPane.showMessageDialog(this, "用户名密码不能为空！");
                return;
            }
            this.loginUser = new MisUser(userName, userPass);
            if(this.checkUser(this.loginUser)) {
                JOptionPane.showMessageDialog(this, "登录成功！");
                this.dispose();
                MainFrame mainFrame = new MainFrame(this.loginUser);
                mainFrame.setBounds(100, 100, 1000, 800);
                mainFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "用户名密码错误！！");
                this.dispose();
            }
        } else if(e.getSource() == this.CancelButton) {

        }*/
        DBUtil db = new DBUtil();
        String username = userNameField.getText();
        String sql = "select * from student where Sno = "+"'"+ username+"'";
        ResultSet rs = db.query(sql);
        try {
            while (rs.next()) {
                try {
                    String sno = rs.getString("Sno");
                    if(userNameField.getText().equals(sno) && userPassField.getText().equals(sno)){
                        new MainF(sno);
                        this.dispose();
                    }
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            db.close();
        }

    }
}
