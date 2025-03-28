package com.mycompany.home;

import javax.swing.*;
import java.awt.*;

public class Form_Home extends JPanel {
    private JLabel lblTitle; // Tiêu đề chính

    public Form_Home() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(200, 52, 1300, 860); // Điều chỉnh để phù hợp với giao diện chính
        setBackground(Color.WHITE);

        // Tiêu đề
        lblTitle = new JLabel("Form Home");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(400, 180, 400, 50); // Căn giữa phần giao diện
        add(lblTitle);
    }
}
