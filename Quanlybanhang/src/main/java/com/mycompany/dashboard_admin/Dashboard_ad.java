package com.mycompany.dashboard_admin;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mycompany.component.MyButton;
import com.mycompany.component.MyPanel;
import com.mycompany.home.Form_Home;
import com.mycompany.category.Form_Category;
import com.mycompany.order.Form_Order;
import com.mycompany.customer.Form_Customer;
import com.mycompany.product.Form_Product;
import com.mycompany.importation.Form_Import;
import com.mycompany.export.Form_Export;
import com.mycompany.stock.Form_Stock;
import com.mycompany.insurance.Form_Insurance;
import com.mycompany.statistics.Form_Statistics;
import com.mycompany.message.Form_Message;
public class Dashboard_ad extends JFrame {

    private JPanel bg, contentPanel;
    private JLabel title, lblDateTime;
    private MyButton logout;
    private MyPanel panelTitle;
    private Menu menu;
    private CardLayout cardLayout;
    private boolean isFullScreen = true; // Biến kiểm tra trạng thái full screen
    public Dashboard_ad() {
        initComponents();
       addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F11) {
                    toggleFullScreen(); // Nhấn F11 để bật/tắt full screen
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    exitFullScreen(); // Nhấn ESC để thoát khỏi full screen
                }
            }
        });
        setFocusable(true); // Đảm bảo JFrame nhận sự kiện bàn phím
        requestFocusInWindow();
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Panel nền
        bg = new JPanel();
        bg.setLayout(null); // Đặt layout null để set vị trí thủ công
        bg.setBackground(new java.awt.Color(255, 255, 255));

        // Menu Panel
        menu = new Menu(this);
        menu.setBounds(0, 0, 260, 1000); // Định vị menu ở bên trái
        bg.add(menu); // Thêm menu vào bg
        
            // Panel tiêu đề
        panelTitle = new MyPanel();
        panelTitle.setLayout(null);
        panelTitle.setBounds(260, 0, 1300, 50); // Kéo dài chiều rộng của panelTitle
        panelTitle.setGradientColors(Color.decode("#1CB5E0"), Color.decode("#000046"));

        // Tiêu đề
        title = new JLabel("Sales Management Application || Developed by Quang Vinh", JLabel.CENTER);
        title.setFont(new Font("Times New Roman", Font.BOLD, 20));
        title.setForeground(new Color(255, 255, 255)); // Đổi màu chữ thành trắng để nổi bật
        title.setBounds(0, 5, 950, 40); // Căn chỉnh vị trí của tiêu đề
            
// Thêm tiêu đề vào panelTitle

        logout = new MyButton("Logout", 20);
        logout.setBackgroundColor(Color.decode("#E55454")); // Màu nền
        logout.setPressedColor(Color.decode("#C04444")); // Màu khi nhấn
        logout.setHoverColor(Color.decode("#FF7F7F")); // Màu khi rê chuột vào
        logout.setBounds(1130, 8, 130, 35); // Tăng chiều rộng để icon không bị che mất
        logout.setFont(new Font("Times New Roman", Font.BOLD, 18));
        logout.setForeground(Color.WHITE);
        logout.setButtonIcon("D:\\Đồ án Java\\Quanlybanhang\\src\\main\\resources\\Icons\\Dadboard_admin_icon\\logout.png", 25, 25, 10, SwingConstants.RIGHT, SwingConstants.CENTER);

        // Xử lý sự kiện khi nhấn nút logout
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestFocusInWindow(); // Trả focus về JFrame
            }
        });

                // Label Ngày & Giờ
        lblDateTime = new JLabel();
        lblDateTime.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblDateTime.setForeground(Color.WHITE);
        lblDateTime.setBounds(830, 5, 300, 40); // Điều chỉnh vị trí và kích thước
        updateDateTime(); // Gọi hàm cập nhật thời gian ban đầu

        // Tạo Timer để cập nhật thời gian mỗi giây
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDateTime();
            }
        });
        timer.start();

        
        panelTitle.add(title);
        panelTitle.add(logout);
        panelTitle.add(lblDateTime);

      // Thêm panelTitle vào bg
        bg.add(panelTitle);
        
         // **Panel chính dùng CardLayout để chứa form**
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBounds(260, 50, 1300, 1000);
        bg.add(contentPanel);

        // **Thêm các form vào contentPanel**
        contentPanel.add(new Form_Home(), "Home");
        contentPanel.add(new Form_Category(), "Category");
        contentPanel.add(new Form_Order(), "Order");
        contentPanel.add(new Form_Customer(), "Customer");
        contentPanel.add(new Form_Product(), "Product");
        contentPanel.add(new Form_Import(), "Import");
        contentPanel.add(new Form_Export(), "Export");
        contentPanel.add(new Form_Stock(), "Stock");
        contentPanel.add(new Form_Insurance(), "Insurance");
        contentPanel.add(new Form_Statistics() ,"Statistics");
        contentPanel.add(new Form_Message(), "Message");

        
        // Cài đặt JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,750); // Kích thước cửa sổ
        setResizable(true);
        setTitle("Dashboard Admin");
        setLocationRelativeTo(null); // Hiển thị ở giữa màn hình
        setFullScreen();
        getContentPane().setLayout(null);
        getContentPane().add(bg);
        bg.setBounds(0, 0, 1560, 1000);
        revalidate(); // Cập nhật bố cục
        repaint(); // Vẽ lại giao diện
 
    }
    
     private void setFullScreen() {
        dispose(); // Giải phóng JFrame trước khi thay đổi undecorated
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true); // Hiển thị lại JFrame
        isFullScreen = true;
    }

    private void exitFullScreen() {
        if (isFullScreen) {
            toggleFullScreen();
        }
    }

    private void toggleFullScreen() {
        dispose(); // Giải phóng JFrame trước khi thay đổi undecorated
        if (isFullScreen) {
            setUndecorated(false);
            setExtendedState(JFrame.NORMAL); // Chuyển về cửa sổ bình thường
        } else {
            setUndecorated(true);
            setExtendedState(JFrame.MAXIMIZED_BOTH); // Bật lại full screen
        }
        setVisible(true); // Hiển thị lại JFrame
        isFullScreen = !isFullScreen;
    }
    
     private void updateDateTime() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("'Date:' dd/MM/yyyy  '-' HH:mm:ss");
        String currentTime = sdf.format(new java.util.Date());
        lblDateTime.setText(currentTime);
}
      // **Phương thức hiển thị form theo tên**
    public void showForm(String formName) {
        cardLayout.show(contentPanel, formName);
    }
     
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard_ad().setVisible(true);
        });
    }
}
