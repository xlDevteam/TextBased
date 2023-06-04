package com.map;

public class Tile {
    private int x;
    private int y;
    private boolean isObstacle;
    // Other properties and methods
    
    // Constructor
    public Tile(int x, int y, boolean isObstacle) {
        this.x = x;
        this.y = y;
        this.isObstacle = isObstacle;
    }
    
    // Getters
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean isObstacle() {
        return isObstacle;
    }
    
    // Setters
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setObstacle(boolean isObstacle) {
        this.isObstacle = isObstacle;
    }
    
    // Other methods
    // ...
}