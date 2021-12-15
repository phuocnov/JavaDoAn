package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReaderViewAdjust extends JPanel {
    JLabel labelTitle = new JLabel();
    JLabel labelID = new JLabel();
    JLabel labelName = new JLabel();
    JLabel labelResult = new JLabel();
    JTextField fieldID = new JTextField();
    JTextField fieldName = new JTextField();
    JButton buttonAdj = new JButton();

    ReaderViewAdjust(ReaderController controller){
        labelTitle.setText("Chỉnh sửa độc giả");
        labelID.setText("Nhập ID người dùng");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        labelTitle.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonAdj.setText("Tìm");
        labelResult.setText("Status: ");
        labelName.setText("Nhập tên người dùng mới");

        labelTitle.setBounds(20,20, 600,70);
        labelID.setBounds(20, 80, 600, 20);
        fieldID.setSize(100, 30);
        fieldID.setBounds(20, 110, 200, 20);
        buttonAdj.setBounds(20, 140, 200, 20);
        labelName.setBounds(20, 180, 500, 20);
        fieldName.setBounds(20, 200, 200, 20);
        labelResult.setBounds(20, 220, 500, 20);
        
        buttonAdj.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Reader reader = controller.find(fieldID.getText());
                if(reader == null){
                    labelResult.setText("Người dùng không tồn tại, vui lòng thử lại " + fieldID.getText());
                }
                else{
                    try {
                        controller.adjustReader(reader, fieldName.getText());
                        labelResult.setText("Thành công: " + reader.print());
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

            }
        });

        this.setBackground(new Color(0xeedddd));
        this.add(labelTitle);
        this.add(labelID);
        this.add(labelName);
        this.add(fieldID);
        this.add(fieldName);
        this.add(buttonAdj);
        this.add(labelResult);
        this.setLayout(null);
    }
}
