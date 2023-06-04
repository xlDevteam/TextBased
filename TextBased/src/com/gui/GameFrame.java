package com.gui;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    
    private GamePanel gamePanel;
    
    public GameFrame() {
        setTitle("Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        gamePanel = new GamePanel();
        add(gamePanel);
    }
    
    public void startGame() {
        setVisible(true);
    }
    
    public GamePanel getGamePanel() {
        return gamePanel;
    }
    
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.startGame();
    }
}