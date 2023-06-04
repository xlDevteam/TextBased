package com;

import com.gui.GameConsole;
import com.gui.GameFrame;
import com.gui.GamePanel;
import com.map.Map;
import com.map.Tile;
import com.player.Player;
import com.player.PlayerConfig;
import com.player.item.Item;
import com.utils.FileSystem;
import com.player.MovementHandler;

import java.awt.*;
import java.util.List;

public class Test {
    public static void main(String[] args) {
    	
    	// create the game console
        GameConsole gameConsole = new GameConsole();
        gameConsole.setVisible(true);
        
        PlayerConfig playerConfig = FileSystem.loadPlayerConfig();

        // Check if player data exists
        if (playerConfig == null) {
            // Create new player data
            playerConfig = new PlayerConfig("Talyn", 100);
            gameConsole.appendText("New player data created.");
        }
    	
        // Create a game frame
        GameFrame gameFrame = new GameFrame();
        
        // Get the game panel from the game frame
        GamePanel gamePanel = gameFrame.getGamePanel();
        
        // Create the map
        Map map = new Map(20, 10);

        // Load map from a CSV file
        map.loadMapFromFile("map.csv");

        // Create player tiles
        Tile[] playerTiles = {
                new Tile(0, 0, false),
                new Tile(1, 0, false),
                new Tile(0, 1, false),
                new Tile(1, 1, false)
        };

        // Create the player character
        Player player = new Player(playerTiles, map);



        // Set the player character for the game panel
        gamePanel.setPlayer(player);

        int tileSize = gamePanel.getTileSize();
        int mapWidth = map.getWidth() * tileSize;
        int mapHeight = map.getHeight() * tileSize;

        // Set the size of the game panel to map size
        gamePanel.setPreferredSize(new Dimension(mapWidth, mapHeight));

        gameFrame.getContentPane().add(gamePanel);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);

        // Create the movement handler
        MovementHandler movementHandler = new MovementHandler();

        // Set the player for the movement handler
        movementHandler.setPlayer(player);

        // Add key listener to the game panel using the movement handler
        gamePanel.addKeyListener(movementHandler);

        // Set the game panel focusable to receive key events
        gamePanel.setFocusable(true);

        // Request keyboard focus for the game panel
        gamePanel.requestFocus();

        // Start the game
        gameFrame.startGame();
        
        // Add a sword to the player's inventory
        Item sword = Item.SWORD1;
        playerConfig.addToInventory(sword);
        gameConsole.appendText("Added " + sword.getName() + " to the player's inventory.");

        // Save player data
        FileSystem.savePlayerConfig(playerConfig);

        gameConsole.appendText("Player name: " + playerConfig.getPlayerName());
        gameConsole.appendText("Player Inventory:");
        List<Item> inventory = playerConfig.getInventory();
        if (inventory.isEmpty()) {
            gameConsole.appendText("Inventory is empty.");
        } else {
            for (Item item : inventory) {
                gameConsole.appendText("- " + item.getName());
            }
        }
        
        
    }
}
