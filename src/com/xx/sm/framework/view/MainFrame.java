package com.xx.sm.framework.view;

import com.xx.sm.framework.control.listener.MenuListener;
import com.xx.sm.framework.model.dao.impl.IMenuDAO;
import com.xx.sm.framework.model.dao.impl.IMenuDAOImpl;
import com.xx.sm.framework.model.entity.MenuBean;
import com.xx.sm.framework.model.entity.MisUser;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {

    private MisUser loginUser = null;

    private JPanel bodyPanel = null;

    private JMenuBar menuBar = null;
    private JMenu helpMenu = null;
    private JMenuItem helpContentItem = null;
    private JMenuItem helpAboutItem = null;

    private JToolBar infoToolBar = null;
    private JLabel userNameLabel = null;
    private JLabel userNameTextLabel = null;
    private JButton exitButton = null;
    private JButton reLogoButton = null;

    private JPanel welcomePanel = null;

    private JLabel stateLabel = null;


    public MainFrame() {
        this.init();

    }

    public MainFrame(MisUser misUser) {
        this.loginUser = misUser;
        this.init();
    }

    private void createMenu() {//动态挂载菜单
        IMenuDAO menuDao = new IMenuDAOImpl();
        String sql1 = "select * from menu where menuId like '__'";
        List<MenuBean> list1 = menuDao.queryBySql(sql1);
        for(int i = 0; i < list1.size(); i++) {
            MenuBean tempBean1 = list1.get(i);
            JMenu menu = new JMenu();
            menu.setActionCommand(tempBean1.getMenuId());
            menu.setText(tempBean1.getMenuName());
            menu.setToolTipText(tempBean1.getMenuMemo());//提示

            String sql2 = "select * from menu where menuId like '"+ tempBean1.getMenuId() +"__'";
            List<MenuBean> list2 = menuDao.queryBySql(sql2);
            for(int j = 0; j < list2.size(); j++) {
                MenuBean tempBean2 = list2.get(j);
                JMenuItem menuItem = new JMenuItem();
                menuItem.setActionCommand(tempBean2.getMenuId());
                menuItem.setText(tempBean2.getMenuName());
                menuItem.setToolTipText(tempBean2.getMenuMemo());//提示
                menuItem.addActionListener(new MenuListener(this.loginUser, this));

                menu.add(menuItem);
            }
            this.menuBar.add(menu);
        }
    }

    private void init() {
        this.menuBar = new JMenuBar();
        this.helpMenu = new JMenu("帮助");
        this.helpAboutItem = new JMenuItem("关于");
        this.helpContentItem = new JMenuItem("内容");
        this.helpMenu.add(this.helpAboutItem);
        this.helpMenu.add(this.helpContentItem);
        this.createMenu();//动态加载菜单
        this.menuBar.add(this.helpMenu);
        this.setJMenuBar(this.menuBar);

        this.bodyPanel = (JPanel)this.getContentPane();
        this.bodyPanel.setLayout(new BorderLayout());

        this.infoToolBar = new JToolBar();
        this.infoToolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.infoToolBar.setFloatable(false);

        this.userNameLabel = new JLabel("登陆用户：");
        this.userNameTextLabel = new JLabel(this.loginUser.getUserName());
        this.reLogoButton = new JButton("重新登陆");
        this.exitButton = new JButton("退出");
        this.infoToolBar.add(this.userNameLabel);
        this.infoToolBar.add(this.userNameTextLabel);
        this.infoToolBar.add(this.reLogoButton);
        this.infoToolBar.add(this.exitButton);
        this.bodyPanel.add(this.infoToolBar, BorderLayout.NORTH);

        this.welcomePanel = new ImagPanel();
        this.welcomePanel.setBackground(Color.PINK);
        this.welcomePanel.setBorder(BorderFactory.createMatteBorder(2, 0, 1, 0, Color.RED));//加边框
        this.bodyPanel.add(this.welcomePanel, BorderLayout.CENTER);

        this.stateLabel = new JLabel("版本号：V1.0");
        this.stateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.bodyPanel.add(this.stateLabel, BorderLayout.SOUTH);

        this.setTitle("学籍管理系统");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
