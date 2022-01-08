package src;
import java.io.IOException;

import java.awt.event.*;
import javax.swing.*;


public class BookViewAdd extends JPanel{
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

    BookViewAdd(BookController controller){
        //construct components
        labelTitle = new JLabel ("THÊM SÁCH");
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
        buttonAdd = new JButton ("Thêm");

        //adjust size and set layout
        // setPreferredSize (new Dimension (892, 592));
        setLayout (null);

        //add components
        add (labelTitle);
        add (labelName);
        add (fieldName);
        add (jcomp4);
        add (fieldAuthor);
        add (labelCategory);
        add (fieldCate);
        add (labelPosition);
        add (labelSelve);
        add (fieldShelve);
        add (labelFloor);
        add (fieldFloor);
        add (labelNumber);
        add (fieldNumber);
        add (buttonAdd);

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
                // System.out.println("field Cate: " + fieldCate.getText());
                try {
                    String name = fieldName.getText();
                    String author = fieldAuthor.getText();
                    String category = fieldCate.getText();
                    int shelve = Integer.parseInt(fieldShelve.getText());
                    int floor = Integer.parseInt(fieldFloor.getText());
                    int number = Integer.parseInt(fieldNumber.getText());

                    controller.create(name, author, category, shelve, floor, number);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
