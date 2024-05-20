package Assignment6View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Assignment6View.*;

public class UserLogin extends JFrame implements ActionListener {

    private int numTries = 1;
    JFrame hp;
    JTextField idField, passwordField;
    JButton loginButton, cancelButton;

    UserLogin() {
        setTitle("Customer Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 30, 80, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(100, 30, 160, 25);
        add(idField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 60, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(30, 100, 100, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(160, 100, 100, 25);
        cancelButton.addActionListener(this);
        add(cancelButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            String id = idField.getText();
            String password = passwordField.getText();

            // Here you would perform validation, for now, let's just check if ID is not empty
            if (!id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                this.setVisible(false);
                hp = new MainMenu();
                hp.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect ID or Password. Try again.");
                numTries++;
                if (numTries > 3) {
                    JOptionPane.showMessageDialog(this, "Exceeded max login attempts.");
                    dispose();
                }
            }
        } else if (ae.getSource() == cancelButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}