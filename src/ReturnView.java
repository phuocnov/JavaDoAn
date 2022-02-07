package src;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class ReturnView extends JPanel{
    private JLabel labelTittle;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JTextField fieldReader;
    private JTextField fieldBook;
    private JButton jcomp6;
    private JLabel jcomp7;
    private JLabel jcomp8;
    private JLabel jcomp9;
    private JTextField fieldDay;
    private JLabel jcomp11;

    ReturnView(BorrowController controller){
        //construct components
        labelTittle = new JLabel ("TRẢ SÁCH");
        jcomp2 = new JLabel ("Mã người mượn");
        jcomp3 = new JLabel ("Mã sách mượn");
        fieldReader = new JTextField (5);
        fieldBook = new JTextField (5);
        jcomp6 = new JButton ("Đồng ý");
        jcomp7 = new JLabel ("Status");
        jcomp8 = new JLabel ("...");
        jcomp9 = new JLabel ("Ngày mượn");
        fieldDay = new JTextField (5);
        jcomp11 = new JLabel ("yyyy-mm-dd");

        //adjust size and set layout
        setLayout (null);

        //add components
        add (labelTittle);
        add (jcomp2);
        add (jcomp3);
        add (fieldReader);
        add (fieldBook);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);
        add (jcomp9);
        add (fieldDay);
        add (jcomp11);

        //set component bounds (only needed by Absolute Positioning)
        labelTittle.setBounds (10, 5, 100, 25);
        jcomp2.setBounds (5, 45, 100, 25);
        jcomp3.setBounds (5, 90, 100, 25);
        fieldReader.setBounds (120, 45, 100, 25);
        fieldBook.setBounds (120, 90, 100, 25);
        jcomp6.setBounds (75, 195, 100, 25);
        jcomp7.setBounds (5, 160, 100, 25);
        jcomp8.setBounds (115, 160, 100, 25);
        jcomp9.setBounds (5, 130, 100, 25);
        fieldDay.setBounds (120, 130, 130, 25);
        jcomp11.setBounds (260, 130, 100, 25);

        jcomp6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String readerID = fieldReader.getText();
                String bookID = fieldBook.getText();
                String date = fieldDay.getText();
                
                if(controller.returnBookCheck(readerID, bookID, date)){
                    try {
                        controller.returnBook(readerID, bookID, date);
                        jcomp8.setText("Thành công");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    jcomp8.setText("Dữ liệu nhập sai, vui lòng thử lại");
                }
            }
        });
    }
}
