/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * 
 * NOTE: Slick isn't working, have to figure that out eventually
 * 
 */

package data;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;

//import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;

import static data.helpers.Artist.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.opengl.Texture;


/**
 *
 * @author Keith
 */
public class Boot {
    
    public Boot()
    {       
        BeginSession();
        // Texture earthTex = null;
        // Texture vegTex = null;
        
        // earthTex = QuickLoad("earth");
        // vegTex = QuickLoad("veg");
        
        //Tile tile = new Tile(0, 0, 64, 64, TileType.Earth);
        //Tile tile2 = new Tile(0, 64, 64, 64, TileType.Veg);
        
        TileGrid grid = new TileGrid();
        
        while (!Display.isCloseRequested())
        {
        //    tile.Draw();
        //    tile2.Draw();
          
            grid.Draw();
            
        //    DrawQuadTexture(tile.getTexture(), tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
        //    DrawQuadTexture(tile2.getTexture(), tile2.getX(), tile2.getY(), tile2.getWidth(), tile2.getHeight());
        //    DrawLine(20, 30, 10, 50);
        //    DrawQuadTexture(earthTex, 0,  0, 64, 64);
        //    DrawQuadTexture(vegTex, 64, 0, 64, 64);
            
        //    DrawQuad(50, 50, 20, 20);
        //    DrawQuad(350, 350, 10, 10);
           
            Display.update();
            Display.sync(60);
        }
        Display.destroy();
    }
    
    public static void main(String[] args)
    {
        new Boot();
    }
}
