package com.gui;

import javax.swing.JPanel;

import com.map.Map;
import com.map.Tile;
import com.player.Player;

import java.awt.Color;
import java.awt.Graphics;

public class GamePanel extends JPanel {
	
    private static final int TILE_SIZE = 32;
    
    private Map map;
    private Player player;

    public GamePanel() {
        setFocusable(true);
        setBackground(Color.BLACK);
        // Initialize the map and player objects
        map = new Map(20, 10);
        map.loadMapFromFile("map.csv");
        Tile[] playerTiles = {
            new Tile(0, 0, false),
            new Tile(1, 0, false),
            new Tile(0, 1, false),
            new Tile(1, 1, false)
        };
        player = new Player(playerTiles, map);
        
    }
   
  
    
    public Map getMap() {
        return map;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public int getTileSize() {
    	return TILE_SIZE;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Render the game, draw map, characters, etc.
        
        // Draw the map
        Map map = getMap();
        if (map != null) {
            for (int x = 0; x < map.getWidth(); x++) {
                for (int y = 0; y < map.getHeight(); y++) {
                    Tile tile = map.getTile(x, y);
                    // Set the color based on the tile type
                    if (tile.isObstacle()) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.BLUE);
                    }
                    // Draw the tile
                    g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }
        
        // Draw the characters
        Player player = getPlayer();
        if (player != null) {
            Tile[] playerTiles = player.getTiles();
            g.setColor(Color.CYAN);
            for (Tile tile : playerTiles) {
                int x = tile.getX() * TILE_SIZE;
                int y = tile.getY() * TILE_SIZE;
                // Draw the player tile
                g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}