package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CLayout extends JFrame{
    JPanel panelOption = new JPanel();

    JPanel panelCont = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    // Reader
    JButton btnAddReader = new JButton("Thêm độc giả");
    JButton btnAdjReader = new JButton("Sửa độc giả");
    JButton btnSearchReader = new JButton("Tìm kiếm độc giả");
    JButton btnRemoveReader = new JButton("Xoá độc giả");

    // Borrow, return book
    JButton btnBorrowBook = new JButton("Mượn sách");
    JButton btnReturnBook = new JButton("Trả sách");
    
    // Book
    JButton btnAddBook = new JButton("Thêm sách");
    JButton btnAdjBook = new JButton("Sửa sách");
    JButton btnSearchBook = new JButton("Tìm kiếm sách");
    JButton btnRemoveBook = new JButton("Xoá sách");


    CardLayout cl = new CardLayout();


    CLayout(){
        panelOption.setBounds(0, 0, 200, 600);
        panelOption.setBackground(new Color(0xdddddd));
        panelOption.add(btnAddReader);
        panelOption.add(btnAdjReader);
        panelOption.add(btnSearchReader);
        panelOption.add(btnRemoveReader);
        panelOption.add(btnBorrowBook);
        panelOption.add(btnReturnBook);
        panelOption.add(btnAddBook);
        panelOption.add(btnAdjBook);
        panelOption.add(btnSearchBook);
        panelOption.add(btnRemoveBook);

        panelCont.setLayout(cl);
        panelCont.setBounds(200, 0, 800, 600);
        
        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.BLUE);

        panelCont.add(panel1, "1");
        panelCont.add(panel2, "2");
        cl.show(panelCont, "1");
    
        btnAddReader.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont, "2");
            }
        });
        btnAdjReader.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont, "1");
            }
        });

        this.add(panelCont);
        this.add(panelOption);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }
}
