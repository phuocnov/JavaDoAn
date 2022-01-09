package src;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class BorrowView extends JPanel{
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JTextField fieldReader;
    private JTextField fieldBook;
    private JButton jcomp6;
    private JLabel jcomp7;
    private JLabel jcomp8;

    BorrowView(BorrowController controller){
        //construct components
        jcomp1 = new JLabel ("MƯỢN SÁCH");
        jcomp2 = new JLabel ("Mã người mượn");
        jcomp3 = new JLabel ("Mã sách mượn");
        fieldReader = new JTextField (5);
        fieldBook = new JTextField (5);
        jcomp6 = new JButton ("Đồng ý");
        jcomp7 = new JLabel ("Status");
        jcomp8 = new JLabel ("...");

        //adjust size and set layout
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (fieldReader);
        add (fieldBook);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);

         //set component bounds (only needed by Absolute Positioning)
         jcomp1.setBounds (10, 10, 100, 25);
         jcomp2.setBounds (5, 45, 100, 25);
         jcomp3.setBounds (5, 90, 100, 25);
         fieldReader.setBounds (120, 45, 100, 25);
         fieldBook.setBounds (120, 90, 100, 25);
         jcomp6.setBounds (70, 160, 100, 25);
         jcomp7.setBounds (5, 125, 100, 25);
         jcomp8.setBounds (120, 125, 100, 25);

         jcomp6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String readerID = fieldReader.getText();
                String bookID = fieldBook.getText();
                if(controller.check(readerID, bookID)){
                    try {
                        controller.borrow(readerID, bookID);
                        jcomp8.setText("Thành công!");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                else{
                    jcomp8.setText("Dữ liệu nhập không tồn tại, vui lòng thử lại");
                }
            }
        });
    }
}
