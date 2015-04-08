/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 * Keeps variables for each turn enemy needs to make
 * @author Keith
 */
public class Checkpoint {
    
    private Tile tile;          // tile the checkpoint is on
    private int xDirection, yDirection;
    
    public Checkpoint(Tile tile, int xDirection, int yDirection)
    {
        this.tile = tile;
        this.xDirection = xDirection;   // Directions are relative to the enemy's
        this.yDirection = yDirection;   // current position.
    }

    /**
     * @return the tile
     */
    public Tile getTile() {
        return tile;
    }

    /**
     * @return the xDirection
     */
    public int getxDirection() {
        return xDirection;
    }

    /**
     * @return the yDirection
     */
    public int getyDirection() {
        return yDirection;
    }
    
    
}
