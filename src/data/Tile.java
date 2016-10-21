/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.helpers.Artist.DrawQuadTexture;
import static data.helpers.Artist.QuickLoad;
import org.newdawn.slick.opengl.Texture;


/**
 *
 * @author Keith
 */
public class Tile {
    private float x, y, width, height;
    private Texture texture;
    private TileType type;
    
    public Tile(float x, float y, float width, float height, TileType type)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.texture = QuickLoad(type.textureName);
    }

    public void Draw()
    {
        DrawQuadTexture(texture, x, y, width, height);
    }
    /**
     * @return the x
     */
    public float getX() {
        return x;
    }
    
    public int getXPlace()
    {
        return (int) x / 32;
    }
    
    public int getYPlace()
    {
        return (int) y / 32;
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
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
        this.height = height;
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
     * @return the type
     */
    public TileType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TileType type) {
        this.type = type;
    }    
}
