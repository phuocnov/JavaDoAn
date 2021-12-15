package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class ReaderViewDelete extends JPanel{
    JLabel labelTitle = new JLabel();
    JLabel labelID = new JLabel();
    JLabel labelResult = new JLabel();
    JTextField fieldName = new JTextField();
    JButton buttonFind = new JButton();

    ReaderViewDelete(ReaderController controller){
        labelTitle.setText("Xoá kiếm độc giả");
        labelID.setText("Nhập ID người dùng");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        labelTitle.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonFind.setText("Xoá");
        labelResult.setText("Status: ");
        labelTitle.setBounds(20,20, 600,70);
        labelID.setBounds(20, 80, 600, 20);
        fieldName.setSize(100, 30);
        fieldName.setBounds(20, 110, 200, 20);
        buttonFind.setBounds(20, 140, 200, 20);
        labelResult.setBounds(20, 160, 500, 20);

        buttonFind.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Reader reader = controller.find(fieldName.getText());
                if(reader == null){
                    labelResult.setText("Người dùng không tồn tại, vui lòng thử lại ");
                }
                else{
                    try {
                        controller.removeReader(reader);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    // labelResult.setText("Thành công: " + reader.print());
                }

            }
        });


        this.setBackground(new Color(0xeedddd));
        this.add(labelTitle);
        this.add(labelID);
        this.add(fieldName);
        this.add(buttonFind);
        this.add(labelResult);
        this.setLayout(null);
    }
}
