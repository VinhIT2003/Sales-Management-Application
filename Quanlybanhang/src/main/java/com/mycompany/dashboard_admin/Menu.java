package com.mycompany.dashboard_admin;


import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.*; // Import đầy đủ các sự kiện
import com.mycompany.component.CustomDialog;

public class Menu extends JPanel {
    
    private JLabel lblTitle, lblHome, lblCustomer, lblOrder, lblCategory, lblProduct, lblExport, lblStatistics, lblMessage, lblExit, lblMenu, lblImport, lblStock, lblInsurance;
    private JPanel menuPanel; // Panel chứa tất cả label
    private JLabel lastHoveredLabel = null; // Lưu label được hover trước đó
     private boolean isMenuExpanded = false;
    public Dashboard_ad parentFrame;
    public CustomDialog cs;
      // Biến lưu label đang được hover


    public Menu(Dashboard_ad parentFrame) {
        this.parentFrame=parentFrame;
        initComponents();
        init(); 
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setLayout(null); // Dùng null layout để tự thiết lập vị trí các thành phần
    }

  
    private void init() {
     try {
        // Tạo panel chứa menu
        menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuPanel.setOpaque(false); // Giữ panel trong suốt
        menuPanel.setBounds(0, 0, 300, 1000); // Điều chỉnh theo UI của bạn
        
        
        // Label Menu (bấm vào để mở/đóng)
        lblMenu = createLabel("Menu", "menu.png",100);
 
        lblMenu.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    toggleMenu();
                }
            });

        // Đọc ảnh từ đường dẫn tuyệt đối
        lblTitle = createLabelWithIcon("Sales Management<br><p style='margin-left: 20px;'>Application</p>",
                "Title_icon.png", 20, 20, 260, 55, true);

        lblHome = createLabel("Home", "home.png", 145);
        lblCustomer = createLabel("Customer", "customer.png", 195);
        lblOrder = createLabel("Order", "order.png", 245);
        lblCategory = createLabel("Category", "category.png", 295);
        lblProduct= createLabel("Product", "product.png", 350);
        lblImport= createLabel("Import", "import.png", 410);
        lblExport= createLabel("Export", "export.png", 470);
        lblStock= createLabel("Stock", "stock.png", 525);
        lblInsurance= createLabel("Insurance", "insurance.png", 580);
        lblStatistics= createLabel("Statistics", "statistics.png", 645);
        lblMessage= createLabel("Message", "message.png", 710);
        lblExit= createLabel("Exit", "exit.png", 780);
        
        
        // Thêm hiệu ứng hover
        addHoverEffect(lblMenu);
        addHoverEffect(lblHome);
        addHoverEffect(lblCustomer);
        addHoverEffect(lblOrder);
        addHoverEffect(lblCategory);
        addHoverEffect(lblProduct);
        addHoverEffect(lblImport);
        addHoverEffect(lblExport);
        addHoverEffect(lblStock);
        addHoverEffect(lblInsurance);
        addHoverEffect(lblStatistics);
        addHoverEffect(lblMessage);
        addHoverEffect(lblExit);

        // Thêm các label vào menuPanel
        menuPanel.add(lblTitle);
        menuPanel.add(lblHome);
        menuPanel.add(lblCustomer);
        menuPanel.add(lblOrder);
        menuPanel.add(lblCategory);
        menuPanel.add(lblProduct);
        menuPanel.add(lblImport);
        menuPanel.add(lblExport);
        menuPanel.add(lblStock);
        menuPanel.add(lblInsurance);
        menuPanel.add(lblStatistics);
        menuPanel.add(lblMessage);
        menuPanel.add(lblExit);
        menuPanel.add(lblMenu);
        
       
        lblHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Home");
            }
        });
        
        lblCustomer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Customer");
            }
        });

        
        
        lblOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Order");
            }
        });

        lblCategory.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Category");
            }
        });
        
        lblProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Product");
            }
        });
        
        lblImport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Import");
            }
        });
        
        lblExport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Export");
            }
        });
        
        
        lblStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Stock");
            }
        });
        
        lblInsurance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Insurance");
            }
        });
        
        lblStatistics.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Statistics");
            }
        });
        
        lblMessage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parentFrame.showForm("Message");
            }
        });
      lblExit.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            boolean confirm = CustomDialog.showOptionPane(
                    "Exit",
                    "Are you sure to exit ?",
                    UIManager.getIcon("OptionPane.warningIcon"),
                    Color.decode("#08BAF5")
            );

              if (confirm) {
                   System.exit(0);
            }
        }
});

        // Thêm menuPanel vào frame
        setLayout(null);
        add(menuPanel);
   } catch (IOException e) {
        e.printStackTrace();
    }
}

    
   private void addHoverEffect(JLabel label) {
    Color hoverColor = new Color(173, 216, 230, 200); // Màu xanh nhạt
    Color transparentColor = new Color(0, 0, 0, 0); // Trong suốt

    label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            if (lastHoveredLabel != null && lastHoveredLabel != label) {
                resetLabelBackground(lastHoveredLabel);
            }

            lastHoveredLabel = label;

            SwingUtilities.invokeLater(() -> {
                label.setOpaque(true);
                label.setBackground(hoverColor);
                menuPanel.revalidate();
                menuPanel.repaint(); // Cập nhật cả panel
            });
        }

        @Override
        public void mouseExited(MouseEvent e) {
            resetLabelBackground(label);
        }
    });
}

   // Tạo label thường (không phải tiêu đề)
    private JLabel createLabel(String text, String iconName, int yPosition) throws IOException {
        return createLabelWithIcon(text, iconName, 20, yPosition, 260, 35, false);
    }

    // Tạo label có icon (dùng chung cho tiêu đề và menu)
    private JLabel createLabelWithIcon(String text, String iconName, int x, int y, int width, int height, boolean isTitle) throws IOException {
        // Kiểm tra file ảnh
        File file = new File("D:\\Đồ án Java\\Quanlybanhang\\src\\main\\resources\\Icons\\Dadboard_admin_icon\\" + iconName);
        if (!file.exists()) {
            System.err.println("⚠️ File not found: " + file.getAbsolutePath());
            return new JLabel(text);
        }

        // Đọc và resize ảnh
        Image img = ImageIO.read(file).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(img);

        // Tạo JLabel
        JLabel label = new JLabel("<html>" + text + "</html>", icon, JLabel.LEFT);
        label.setFont(isTitle ? new Font("Arial", Font.BOLD | Font.ITALIC, 20) : new Font("sansserif", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, width, height);
        label.setIconTextGap(15);
        label.setOpaque(false); // Ban đầu trong suốt
        return label;
    }

    private void resetLabelBackground(JLabel label) {
        SwingUtilities.invokeLater(() -> {
            label.setOpaque(false);
            label.setBackground(new Color(0, 0, 0, 0));
            menuPanel.revalidate();
            menuPanel.repaint();
        });
    }

     // Hiển thị hoặc ẩn các label con khi bấm vào lblMenu
    private void toggleMenu() {
        isMenuExpanded = !isMenuExpanded;
        setMenuVisibility(isMenuExpanded);
    }

    private void setMenuVisibility(boolean isVisible) {
        lblHome.setVisible(isVisible);
        lblCustomer.setVisible(isVisible);
        lblOrder.setVisible(isVisible);
        lblCategory.setVisible(isVisible);
        lblProduct.setVisible(isVisible);
        lblImport.setVisible(isVisible);
        lblExport.setVisible(isVisible);
        lblStock.setVisible(isVisible);
        lblInsurance.setVisible(isVisible);
        lblStatistics.setVisible(isVisible);
        lblMessage.setVisible(isVisible);
        lblExit.setVisible(isVisible);
        menuPanel.revalidate();
        menuPanel.repaint();
    }

    
      @Override
     protected void paintChildren(Graphics grphcs) {
         Graphics2D g2 = (Graphics2D) grphcs;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

         // Tạo hiệu ứng Gradient
         GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0, getHeight(), Color.decode("#000046"));
         g2.setPaint(g);

         // Vẽ nền không bo góc
         g2.fillRect(0, 0, getWidth(), getHeight());

         // Xóa phần thừa bo góc (không cần nữa)
         // g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

         super.paintChildren(grphcs);
 }
}
