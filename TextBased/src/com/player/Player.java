package com.player;

import com.map.Map;
import com.map.Tile;

public class Player {
	
    private Tile[] tiles;
    private Map map; // Reference to the Map object
    // Other properties and methods
    
    // Constructor
    public Player(Tile[] tiles, Map map) {
        this.tiles = tiles;
        this.map = map;
    }
    
    // Move the character
    public void move(int dx, int dy) {
        // Create a copy of the character's tiles with the new position
        Tile[] newTiles = new Tile[tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            newTiles[i] = new Tile(tiles[i].getX() + dx, tiles[i].getY() + dy, tiles[i].isObstacle());
        }
        
        // Check for intersection with the map
        boolean hasIntersection = false;
        for (Tile tile : newTiles) {
            if (map.hasIntersection(tile.getX(), tile.getY())) {
                hasIntersection = true;
                break;
            }
        }
        
        // If there is no intersection, move the character to the new position
        if (!hasIntersection) {
            tiles = newTiles;
        }
    }
    
    public void moveLeft() {
        move(-1, 0);
    }

    public void moveRight() {
        move(1, 0);
    }
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public Tile[] getTiles() {
        return tiles;
    }
    // Other methods
    // ...
}