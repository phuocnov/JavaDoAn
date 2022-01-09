package src;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookViewAdjust extends JPanel {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JTextField jcomp3;
    private JButton jcomp4;
    private JLabel jcomp5;
    private JLabel jcomp6;

    BookViewAdjust(BookController controller) {
        // construct components
        jcomp1 = new JLabel("CHỈNH SỬA SÁCH");
        jcomp2 = new JLabel("Nhập mã sách cần sửa");
        jcomp3 = new JTextField(5);
        jcomp4 = new JButton("Chỉnh sửa");
        jcomp5 = new JLabel("Status: ");
        jcomp6 = new JLabel("...");

        // adjust size and set layout
        setPreferredSize(new Dimension(944, 574));
        setLayout(null);

        // add components
        add(jcomp1);
        add(jcomp2);
        add(jcomp3);
        add(jcomp4);
        add(jcomp5);
        add(jcomp6);

        // set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds(20, 15, 100, 25);
        jcomp2.setBounds(15, 70, 150, 20);
        jcomp3.setBounds(165, 65, 160, 25);
        jcomp4.setBounds(95, 130, 100, 25);
        jcomp5.setBounds(15, 95, 100, 25);
        jcomp6.setBounds(60, 95, 100, 25);

        jcomp4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = jcomp3.getText();
                 Book book = controller.find(ID);
                 if(book == null){
                    jcomp6.setText("Mã sách không tồn tại, vui lòng thử lại"); 
                 }
                 else{
                     new BookViewAdjustSub(book, controller);
                 }

            }
        });
    }
}