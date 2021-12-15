package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CLayout extends JFrame{
    JPanel panelOption = new JPanel();
    JPanel panelCont = new JPanel();
    JPanel panelAddReader;
    JPanel panelAdjReader = new JPanel();
    JPanel panelFindReader = new JPanel();
    JPanel panelRemoveReader = new JPanel();

    // Reader
    JButton btnAddReader = new JButton("Thêm độc giả");
    JButton btnAdjReader = new JButton("Sửa độc giả");
    JButton btnFindReader = new JButton("Tìm kiếm độc giả");
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


    CLayout() throws FileNotFoundException, IOException{
        ReaderController readerController = new ReaderController();
        panelAddReader = new ReaderViewAdd(readerController);
        panelFindReader = new ReaderViewFind(readerController);
        panelAdjReader = new ReaderViewAdjust(readerController);
        panelRemoveReader = new ReaderViewDelete(readerController);
        

        panelOption.setBounds(0, 0, 200, 600);
        panelOption.setBackground(new Color(0xdddddd));
        panelOption.add(btnAddReader);
        panelOption.add(btnAdjReader);
        panelOption.add(btnFindReader);
        panelOption.add(btnRemoveReader);
        panelOption.add(btnBorrowBook);
        panelOption.add(btnReturnBook);
        panelOption.add(btnAddBook);
        panelOption.add(btnAdjBook);
        panelOption.add(btnSearchBook);
        panelOption.add(btnRemoveBook);

        panelCont.setLayout(cl);
        panelCont.setBounds(200, 0, 800, 600);
        

        panelCont.add(panelAddReader, "add reader");
        panelCont.add(panelAdjReader, "adj reader");
        panelCont.add(panelFindReader, "find reader");
        panelCont.add(panelRemoveReader, "remove reader");
        cl.show(panelCont, "add reader");
    
        btnAddReader.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont, "add reader");
            }
        });
        btnAdjReader.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(panelCont, "adj reader");
            }
        });
        btnFindReader.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cl.show(panelCont, "find reader");
            }
        });
        btnRemoveReader.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cl.show(panelCont, "remove reader");
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
