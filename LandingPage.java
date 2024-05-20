package Assignment6View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LandingPage extends JFrame implements ActionListener {

    JButton startButton;

    // Constructor
    public LandingPage() {
        setTitle("Banking Application - Welcome"); // Set frame title
        setSize(400, 300); // Set frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation

        JPanel panel = new JPanel(); // Panel for layout
        panel.setLayout(new BorderLayout()); // Set layout to BorderLayout

        JLabel titleLabel = new JLabel("Welcome to the Banking Application"); // Create title label
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Align title label to center
        panel.add(titleLabel, BorderLayout.NORTH); // Add title label to the top of the panel

        JTextArea descriptionTextArea = new JTextArea(); // Create text area for description
        descriptionTextArea.setText("This application allows you to manage your bank accounts and transactions.\nClick 'Start' to begin.");
        descriptionTextArea.setEditable(false); // Make text area non-editable
        panel.add(descriptionTextArea, BorderLayout.CENTER); // Add description text area to the center of the panel

        startButton = new JButton("Start"); // Create start button
        startButton.addActionListener(this); // Add action listener to start button
        panel.add(startButton, BorderLayout.SOUTH); // Add start button to the bottom of the panel

        add(panel); // Add panel to frame
        setVisible(true); // Make frame visible
    }

    // ActionPerformed method for handling button click events
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) { // Check if the source of action is startButton
            // Close the Landing Page and open the Main Menu Page
            dispose(); // Close Landing Page
            new UserLogin(); // Open UserLogin Page
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        new LandingPage(); // Create and display LandingPage frame
    }
}