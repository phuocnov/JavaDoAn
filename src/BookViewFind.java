package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookViewFind extends JPanel{
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JTextField jcomp3;
    private JButton jcomp4;
    private JList<String> jcomp5;
    private JLabel jcomp6;
    
    // ArrayList<Book> jcomp5Items = new ArrayList<Book>();

    BookViewFind(BookController controller){
        //construct components
        jcomp1 = new JLabel ("TÌM KIẾM SÁCH");
        jcomp2 = new JLabel ("Nhập tên sách cần tìm kiếm");
        jcomp3 = new JTextField (5);
        jcomp5 = new JList<String>();
        jcomp4 = new JButton ("Tìm kiếm");
        jcomp6 = new JLabel ("Kết quả");
        
        jcomp5.setModel(controller.toDefaultList());
        //adjust size and set layout
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (10, 10, 100, 25);
        jcomp2.setBounds (10, 50, 175, 25);
        jcomp3.setBounds (180, 50, 220, 25);
        jcomp4.setBounds (10, 90, 100, 25);
        jcomp5.setBounds (10, 200, 500, 150);
        jcomp6.setBounds (15, 175, 100, 25);

        jcomp4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = jcomp3.getText();
                DefaultListModel<String> jcom5Items = new DefaultListModel<String>();
                
                for (Book book : controller.books) {
                    if(book.name.contains(searchText)){
                        jcom5Items.addElement(book.print());
                    }
                }
                jcomp5.setModel(jcom5Items);
            }
        });
    }
}
