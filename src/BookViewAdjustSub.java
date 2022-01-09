package src;

import javax.swing.JFrame;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class BookViewAdjustSub {
    JFrame frame = new JFrame();

    private JLabel labelTitle;
    private JLabel labelName;
    private JTextField fieldName;
    private JLabel jcomp4;
    private JTextField fieldAuthor;
    private JLabel labelCategory;
    private JTextField fieldCate;
    private JLabel labelPosition;
    private JLabel labelSelve;
    private JTextField fieldShelve;
    private JLabel labelFloor;
    private JTextField fieldFloor;
    private JLabel labelNumber;
    private JTextField fieldNumber;
    private JButton buttonAdd;

    BookViewAdjustSub(Book book, BookController controller){
        //construct components
        labelTitle = new JLabel ("SỬA SÁCH");
        labelName = new JLabel ("Tên sách");
        fieldName = new JTextField (5);
        jcomp4 = new JLabel ("Tác giả");
        fieldAuthor = new JTextField (5);
        labelCategory = new JLabel ("Thể loại");
        fieldCate = new JTextField (5);
        labelPosition = new JLabel ("Vịa trí");
        labelSelve = new JLabel ("Tủ");
        fieldShelve = new JTextField (5);
        labelFloor = new JLabel ("kệ");
        fieldFloor = new JTextField (5);
        labelNumber = new JLabel ("Số lượng");
        fieldNumber = new JTextField (5);
        buttonAdd = new JButton ("Lưu");

        fieldName.setText(book.name);
        fieldAuthor.setText(book.author);
        fieldCate.setText(book.category);
        fieldFloor.setText(Integer.toString(book.position.floor));
        fieldShelve.setText(Integer.toString(book.position.shelve));
        fieldNumber.setText(Integer.toString(book.number));

        //adjust size and set layout
        // setPreferredSize (new Dimension (892, 592));
        frame.setLayout (null);

        //add components
        frame.add (labelTitle);
        frame.add (labelName);
        frame.add (fieldName);
        frame.add (jcomp4);
        frame.add (fieldAuthor);
        frame.add (labelCategory);
        frame.add (fieldCate);
        frame.add (labelPosition);
        frame.add (labelSelve);
        frame.add (fieldShelve);
        frame.add (labelFloor);
        frame.add (fieldFloor);
        frame.add (labelNumber);
        frame.add (fieldNumber);
        frame.add (buttonAdd);

        //set component bounds (only needed by Absolute Positioning)
        labelTitle.setBounds (15, 10, 100, 25);
        labelName.setBounds (15, 50, 100, 25);
        fieldName.setBounds (115, 50, 220, 25);
        jcomp4.setBounds (15, 100, 100, 25);
        fieldAuthor.setBounds (115, 105, 225, 25);
        labelCategory.setBounds (15, 150, 100, 25);
        fieldCate.setBounds (115, 151, 225, 25);
        labelPosition.setBounds (15, 215, 100, 25);
        labelSelve.setBounds (110, 215, 30, 25);
        fieldShelve.setBounds (150, 215, 100, 25);
        labelFloor.setBounds (280, 215, 30, 25);
        fieldFloor.setBounds (305, 215, 100, 25);
        labelNumber.setBounds (10, 250, 100, 25);
        fieldNumber.setBounds (95, 250, 100, 25);
        buttonAdd.setBounds (105, 310, 145, 30);
        buttonAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                // book.ID = fieldName.getText();
                book.name = fieldName.getText();
                book.author = fieldAuthor.getText();
                book.category = fieldCate.getText();
                book.position.floor = Integer.parseInt(fieldFloor.getText());
                book.position.shelve = Integer.parseInt(fieldShelve.getText());
                book.number = Integer.parseInt(fieldNumber.getText());

                try {
                    controller.exportData();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.dispose();
            }
        });

        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
