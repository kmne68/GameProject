package data;


import data.Tile;
import static data.helpers.Artist.*;
import static data.helpers.Clock.Delta;
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
    
    public Enemy(Texture texture, Tile startTile, int width, int height, float speed)
    {
        this.texture = texture;
        this.x = startTile.getX();
        this.y = startTile.getY();
        this.width = width;
        this.height = height;
        this.health = health;
        this.speed = speed;
        this.startTile = startTile;
    }
    
    public void Update()
    {
        if (isFirst())
            setFirst(false);
        else
            setX(getX() + Delta() * getSpeed());
        
    }
    
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
    
    
}
