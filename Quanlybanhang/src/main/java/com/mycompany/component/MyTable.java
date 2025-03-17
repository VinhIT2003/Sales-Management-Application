package com.mycompany.component;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class MyTable extends JTable {
    public MyTable(DefaultTableModel model, Color backgroundColor, Color foregroundColor, 
                   Color selectionBackgroundColor, Color selectionForegroundColor,
                   Color headerBackgroundColor, Color headerForegroundColor) {
        super(model);
        initTable(backgroundColor, foregroundColor, selectionBackgroundColor, selectionForegroundColor, headerBackgroundColor, headerForegroundColor);
    }

    private void initTable(Color backgroundColor, Color foregroundColor, 
                           Color selectionBackgroundColor, Color selectionForegroundColor,
                           Color headerBackgroundColor, Color headerForegroundColor) {
        // Căn giữa nội dung trong bảng
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Thiết lập màu sắc cho bảng
        setBackground(backgroundColor);
        setForeground(foregroundColor);
        setSelectionBackground(selectionBackgroundColor);
        setSelectionForeground(selectionForegroundColor);
        setGridColor(Color.GRAY);

        // Thiết lập tiêu đề cột
        getTableHeader().setBackground(headerBackgroundColor);
        getTableHeader().setForeground(headerForegroundColor);
        getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        getTableHeader().setReorderingAllowed(false);

        // Tắt chế độ co giãn tự động theo bảng (giúp cột tự chỉnh theo nội dung)
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Gọi phương thức tự điều chỉnh kích thước cột theo nội dung
        adjustColumnWidths();
    }

    // Phương thức điều chỉnh kích thước cột theo nội dung
    public void adjustColumnWidths() {
        TableColumnModel columnModel = getColumnModel();
        for (int col = 0; col < getColumnCount(); col++) {
            int maxWidth = 75; // Độ rộng tối thiểu
            for (int row = 0; row < getRowCount(); row++) {
                TableCellRenderer renderer = getCellRenderer(row, col);
                Component comp = prepareRenderer(renderer, row, col);
                maxWidth = Math.max(comp.getPreferredSize().width + 10, maxWidth);
            }
            columnModel.getColumn(col).setPreferredWidth(maxWidth);
        }
    }

    public static JScrollPane createScrollPane(MyTable table, int x, int y, int width, int height) {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(x, y, width, height);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }
}
