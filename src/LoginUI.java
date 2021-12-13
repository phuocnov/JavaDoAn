package src;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI extends JFrame{
    JLabel headerLabel;
    JLabel statusLabel;
    JPanel controlPanel;

    public LoginUI(){
        this.setTitle("Đăng nhập hệ thống");
        this.setSize(800, 600);
        this.setLayout(new GridLayout (3, 1));
        this.setResizable(false);
        
        this.controlPanel = new JPanel();
        this.statusLabel = new JLabel();
        this.headerLabel = new JLabel();

        UISetup();
        // Set default close button to stop program
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanel.setLayout(new FlowLayout());
        this.add(controlPanel);
        this.add(headerLabel);
        this.add(statusLabel);
        this.setVisible(true);
    }

    private void UISetup(){
        JLabel usernameLabel = new JLabel("Username: ", JLabel.RIGHT);
        JLabel passwordLabel = new JLabel("Password: ", JLabel.CENTER);
        JTextField usernameField = new JTextField(6);
        JPasswordField passwordField = new JPasswordField(6);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Login(usernameField.getText(), new String(passwordField.getPassword()));
            }
        });

        controlPanel.add(usernameLabel);
        controlPanel.add(passwordLabel);
        controlPanel.add(usernameField);
        controlPanel.add(passwordField);
        controlPanel.add(loginButton);
    }
    private void Login(String username, String password){
        System.out.println(username + password);
        if(username == "username" && password == "123456"){
            statusLabel.setText("Login thanh cong");
        }else{
            System.out.println("sai thong tin");
        }
    }
}
