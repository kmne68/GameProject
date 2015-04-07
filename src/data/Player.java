/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.lwjgl.input.Mouse;
//import net.java.games.input.Mouse;

import static data.helpers.Artist.*;

/**
 *
 * @author Keith
 */
public class Player {
    
    private final TileGrid grid;
    
    
    public Player(TileGrid grid)
    {
        this.grid = grid;
    }
    
    public void SetTile()
    {        
        grid.SetTile(((int)Math.floor(Mouse.getX()) / 64), (int)Math.floor(((HEIGHT - Mouse.getY()) -1 ) / 64), TileType.Water);
    }
    
}
