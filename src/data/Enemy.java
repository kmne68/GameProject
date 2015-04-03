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
    }
    
    public void Update()
    {
        if (first)
            first = false;
        else
            x += Delta() * speed;
        
    }
    
    public void Draw() 
    {
        DrawQuadTexture(texture, x, y, width, height);
    }
}
