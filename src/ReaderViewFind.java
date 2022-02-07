package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderViewFind extends JPanel {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JTextField jcomp3;
    private JButton jcomp4;
    private JList<String> jcomp5;
    private JLabel jcomp6;

    ReaderViewFind(ReaderController controller){
        jcomp1 = new JLabel ("TÌM KIẾM NGƯỜI DÙNG");
        jcomp2 = new JLabel ("Nhập tên người cần tìm kiếm");
        jcomp3 = new JTextField (5);
        jcomp4 = new JButton ("Tìm kiếm");
        jcomp5 = new JList<String>();
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
        jcomp5.setBounds (10, 200, 395, 150);
        jcomp6.setBounds (15, 175, 100, 25);

        jcomp4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = jcomp3.getText();
                DefaultListModel<String> jcom5Items = new DefaultListModel<String>();
                
                for (Reader reader : controller.readers) {
                    if(reader.name.contains(searchText)){
                        jcom5Items.addElement(reader.print());
                    }
                }
                jcomp5.setModel(jcom5Items);
            }
        });
    }
}
