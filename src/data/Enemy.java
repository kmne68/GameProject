package data;

import data.Checkpoint.*;
import data.Tile;
import static data.helpers.Artist.*;
import static data.helpers.Clock.Delta;
import java.util.ArrayList;
import org.newdawn.slick.opengl.Texture;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Keith
 */
public class Enemy {
    
    private Texture texture;
    private Tile startTile;
    private int width, height, health;
    private float speed, x, y;
    private boolean first = true;       // for dealing with very large delta in Update() when first starting
    private TileGrid grid;
    
    private ArrayList<Checkpoint> checkpoints;
    private int[] directions;
    
    public Enemy(Texture texture, Tile startTile, TileGrid grid, int width, int height, float speed)
    {
        this.texture = texture;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.health = health;
        this.speed = speed;
        this.startTile = startTile;
        this.grid = grid;
        this.checkpoints = new ArrayList<Checkpoint>();
        this.directions = new int[2];           // correspond to x and y
        
        // X direction
        this.directions[0] = 0;
        // Y direction
        this.directions[1] = 0;
        directions = FindNextDirection(startTile);
    }
    
    public void Update()
    {
        if (isFirst())              // Don't do anything the first time around since the clock state isn't known (I think)
            setFirst(false);
        else
        {
            x += Delta() * directions[0];
            y += Delta() * directions[1];
            
/*            if(pathContinues())
            {
                setX(getX() + Delta() * getSpeed());    // Change x value as time passes (moves right)
            }
*/        }
    }
    
    
    // Check if tiles in current direction are the same as what we're on now.
    private Checkpoint FindNextCheckpoint(Tile start, int[] dir)
    {
        Tile next = null;
        Checkpoint check = null;
        
        // Boolean to decide if next checkpoint is found
        boolean found = false;
        int counter = 1;
        
        while(!found)
        {
            if(start.getType() != grid.GetTile(start.getXPlace() + dir[0] * counter,
                    start.getYPlace() + dir[1] * counter).getType());
            {
                // Make turn in the tile prior to the one we just checked. Move counter
                // back 1.
                found = true;
                counter -= -1;
                next = grid.GetTile(start.getXPlace() + dir[0] * counter,
                    start.getYPlace() + dir[1] * counter);
            }
        }
        counter++;
        check = new Checkpoint(next, dir[0], dir[1]);
        return check;
    }
    
    // Uses enemy's current tile to determine whether it will continue to move on 
    // contiguous tiles of the same type.
    private int[] FindNextDirection(Tile start)
    {
        int[] direction = new int[2];
        Tile up = grid.GetTile(start.getXPlace(), start.getYPlace() - 1);
        Tile right = grid.GetTile(start.getXPlace() + 1, start.getYPlace());
        Tile down = grid.GetTile(start.getXPlace(), start.getYPlace() + 1);
        Tile left = grid.GetTile(start.getXPlace() - 1, start.getYPlace() - 1);
        
        if(start.getType() == up.getType())
        {
            direction[0] = 0;
            direction[1] = -1;
        }
        if(start.getType() == right.getType())
        {
            direction[0] = 1;
            direction[1] = 0;
        }
        if(start.getType() == down.getType())
        {
            direction[0] = 0;
            direction[1] = 1;
        }
        if(start.getType() == left.getType())
        {
            direction[0] = -1;
            direction[1] = 0;
        }
        else
        {
            System.out.println("NO DIRECTION FOUND.");
        }
        return direction;
    }
    
    
    
/*    private boolean pathContinues()
    {
        boolean answer = true;
        
        Tile myTile = grid.GetTile((int) (x / 64), (int) (y / 64));
        Tile nextTile = grid.GetTile((int) (x / 64) + 1, (int) (y / 64));
        
        if(myTile.getType() != nextTile.getType())
            answer = false;
        return answer;
    }
*/    
    
    public void Draw() 
    {
        DrawQuadTexture(getTexture(), getX(), getY(), getWidth(), getHeight());
    }

    /**
     * @return the texture
     */
    public Texture getTexture() {
        return texture;
    }

    /**
     * @param texture the texture to set
     */
    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    /**
     * @return the startTile
     */
    public Tile getStartTile() {
        return startTile;
    }

    /**
     * @param startTile the startTile to set
     */
    public void setStartTile(Tile startTile) {
        this.startTile = startTile;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the first
     */
    public boolean isFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(boolean first) {
        this.first = first;
    }
    
    public TileGrid getTileGrid()
    {
        return grid;
    }
    
    
}
