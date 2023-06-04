package com.player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovementHandler extends KeyAdapter {
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_A) {
        	System.out.println("Attemting player move Left!");
            player.move(-1, 0); // Move left
        } else if (keyCode == KeyEvent.VK_D) {
        	System.out.println("Attemting player move Right!");
            player.move(1, 0); // Move right
        }
    }
}