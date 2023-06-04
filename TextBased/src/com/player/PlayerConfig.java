package com.player;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.player.item.Item;

public class PlayerConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String playerName;
    private int playerHP;
    private List<Item> inventory;

    public PlayerConfig(String playerName, int playerHP) {
        this.playerName = playerName;
        this.playerHP = playerHP;
        this.inventory = new ArrayList<>();
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }
    
    public void removeFromInventory(Item item) {
        inventory.remove(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }
}