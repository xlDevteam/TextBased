package com;

import com.gui.*;
import com.player.PlayerConfig;
import com.player.item.Item;
import com.utils.FileSystem;

import java.util.List;

public class Main {
	
    public static void main(String[] args) {
    	
        GameConsole gameConsole = new GameConsole();
        gameConsole.setVisible(true);

        // Load player data
        PlayerConfig playerConfig = FileSystem.loadPlayerConfig();

        // Check if player data exists
        if (playerConfig == null) {
            // Create new player data
            playerConfig = new PlayerConfig("Talyn", 100);
            gameConsole.appendText("New player data created.");
        }

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


