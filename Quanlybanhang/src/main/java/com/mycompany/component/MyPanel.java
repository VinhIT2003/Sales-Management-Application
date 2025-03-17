
package com.mycompany.component;


import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private Color colorStart = Color.decode("#1CB5E0"); // Màu bắt đầu mặc định
    private Color colorEnd = Color.decode("#000046");   // Màu kết thúc mặc định

    // Constructor mặc định
    public MyPanel() {}

    // Constructor có màu tùy chỉnh
    public MyPanel(Color start, Color end) {
        this.colorStart = start;
        this.colorEnd = end;
    }

    // Setter để thay đổi màu gradient
    public void setGradientColors(Color start, Color end) {
        this.colorStart = start;
        this.colorEnd = end;
        repaint(); // Vẽ lại giao diện khi đổi màu
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Hiệu ứng Gradient với màu động
        GradientPaint gradient = new GradientPaint(0, 0, colorStart, 0, getHeight(), colorEnd);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
