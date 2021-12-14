package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderViewFind extends JPanel {
    JLabel labelTitle = new JLabel();
    JLabel labelName = new JLabel();
    JLabel labelResult = new JLabel();
    JTextField fieldName = new JTextField();
    JButton buttonFind = new JButton();

    ReaderViewFind(ReaderController controller){
        labelTitle.setText("Tìm kiếm độc giả");
        labelName.setText("Nhập ID người dùng");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        labelTitle.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonFind.setText("Tìm");
        labelResult.setText("Status: ");
        labelTitle.setBounds(20,20, 600,70);
        labelName.setBounds(20, 80, 600, 20);
        fieldName.setSize(100, 30);
        fieldName.setBounds(20, 110, 200, 20);
        buttonFind.setBounds(20, 140, 200, 20);
        labelResult.setBounds(20, 160, 500, 20);

        buttonFind.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Reader reader = controller.find(fieldName.getText());
                if(reader == null){
                    labelResult.setText("Người dùng không tồn tại, vui lòng thử lại " + fieldName.getText());
                }
                else{
                    labelResult.setText("Thành công: " + reader.print());
                }

            }
        });


        this.setBackground(new Color(0xeedddd));
        this.add(labelTitle);
        this.add(labelName);
        this.add(fieldName);
        this.add(buttonFind);
        this.add(labelResult);
        this.setLayout(null);
    }
}
