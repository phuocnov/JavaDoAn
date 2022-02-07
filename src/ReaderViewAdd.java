package src;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ReaderViewAdd extends JPanel {
    JLabel labelTitle = new JLabel();
    JLabel labelName = new JLabel();
    JLabel labelResult = new JLabel();
    JTextField fieldName = new JTextField();
    JButton buttonAdd = new JButton();

    ReaderViewAdd(ReaderController controller){
        labelTitle.setText("Tạo mới độc giả");
        labelName.setText("Nhập tên người dùng");
        labelTitle.setHorizontalTextPosition(JLabel.CENTER);
        labelTitle.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonAdd.setText("Thêm");
        labelResult.setText("Status: ");
        labelTitle.setBounds(20,20, 600,70);
        labelName.setBounds(20, 80, 600, 20);
        fieldName.setSize(100, 30);
        fieldName.setBounds(20, 110, 200, 20);
        buttonAdd.setBounds(20, 140, 200, 20);
        labelResult.setBounds(20, 160, 500, 20);

        buttonAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Reader reader = controller.create(fieldName.getText());
                    labelResult.setText("Thành công: " + reader.print());
                    
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        
        
        this.setBackground(new Color(0xeedddd));
        this.add(labelTitle);
        this.add(labelName);
        this.add(fieldName);
        this.add(buttonAdd);
        this.add(labelResult);
        this.setLayout(null);
    }
}
