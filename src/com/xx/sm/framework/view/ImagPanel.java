package com.xx.sm.framework.view;

import javax.swing.*;
import java.awt.*;

public class ImagPanel extends JPanel {
    private ImageIcon icon = null;

    public ImagPanel() {
        this.icon = new ImageIcon("./images/welcome.jpg");
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
