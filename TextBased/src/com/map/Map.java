package com.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gui.GamePanel;

public class Map {
    private int width;
    private int height;
    private Tile[][] tiles;
    // Other properties and methods

    // Constructor
    public Map(int width, int height) {
        tiles = new Tile[width][height];
    }

    public void loadMapFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            List<String> lines = new ArrayList<>();
            
            // Read all lines from the file
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            
            // Process the lines and load the map
            int height = lines.size();
            int width = lines.get(0).split(",").length;
            Tile[][] tiles = new Tile[width][height];
            
            for (int y = 0; y < height; y++) {
                String[] tokens = lines.get(y).split(",");
                for (int x = 0; x < width; x++) {
                    int tileType = Integer.parseInt(tokens[x]);
                    boolean obstacle = (tileType == 1);
                    tiles[x][y] = new Tile(x, y, obstacle);
                }
            }
            
            // Set the loaded map
            this.tiles = tiles;
            this.width = width;
            this.height = height;
            
            // Log a message indicating successful map loading
            System.out.println("Map loaded successfully: " + filename);
        } catch (IOException e) {
            // Log an error message if there was an exception
            System.err.println("Error loading map from file: " + filename);
            e.printStackTrace();
        }
    }

    // Check for intersection between tiles
    public boolean hasIntersection(int x, int y) {
        if (x < 0 || y < 0 || x >= tiles.length || y >= tiles[0].length) {
            return true; // Consider out-of-bounds as intersection
        }
        return tiles[x][y].isObstacle();
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }


    
    

    // Other methods
    // ...
}