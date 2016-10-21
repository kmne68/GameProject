/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.lwjgl.input.Mouse;
//import net.java.games.input.Mouse;

import static data.helpers.Artist.*;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author Keith
 */
public class Player {
    
    private final TileGrid grid;
    private TileType[] types;
    private int index;
    
    public Player(TileGrid grid)
    {
        this.grid = grid;
        this.types = new TileType[3];
        this.types[0] = TileType.Earth;
        this.types[1] = TileType.Veg;
        this.types[2] = TileType.Water;
        this.index = 0;
    }
    
    public void SetTile()
    {        
        grid.SetTile(((int)Math.floor(Mouse.getX()) / 64), (int)Math.floor(((HEIGHT - Mouse.getY()) -1 ) / 64), types[index]);
    }
    
    
    public void Update()
    {
        if (Mouse.isButtonDown(0))
        {
            SetTile();
        }
        while(Keyboard.next())
        {
            if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) // getKeyEventState => only performs action once
            {
                MoveIndex();
            }
        }
    }
    
    // Can use right mouse button to cycle through the tile types in the types array.
    private void MoveIndex()
    {
        index++;
        if (index > types.length -1)
        {
            index = 0;
        }
    }
}
