package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameConsole extends JFrame {
	
    private JTextArea textArea;
    private JTextField inputField;

    public GameConsole() {
        setTitle("Game Console");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                processInput(input);
                inputField.setText("");
            }
        });
        add(inputField, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void processInput(String input) {
        // Process the input and update the game logic accordingly
    	
        // Display the input in the console
        appendText("> " + input);
    }

    public void appendText(String message) {
        textArea.append(message + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameConsole console = new GameConsole();
                console.setVisible(true);
            }
        });
    }
}