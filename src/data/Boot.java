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
import data.helpers.Clock;
import java.io.IOException;
import java.util.Random;
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
        
        
        // This Section randomizes tile styles.
/*        int tileType = 0;
        Random randGen = new Random();
        
        int[][] randMap = new int[15][20];
        
        for(int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                tileType = randGen.nextInt(3);
                randMap[i][j] = tileType;
                System.out.print(tileType);
            }
                System.out.println();
        }
*/        
         int[][] map = {  
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,2,0,0,0,0,0,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,2,2,2,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };       
        
        TileGrid grid = new TileGrid(map);
        
        grid.SetTile(10, 7, TileType.Earth);
        
        // Change the type of the tile at 10, 3 to be the same as at tile 10, 2.
        grid.SetTile(10, 3, grid.GetTile(10, 2).getType());
        Enemy e = new Enemy(QuickLoad("enemy"), grid.GetTile(10, 10), 64, 64, 50);
        
        
        while (!Display.isCloseRequested())
        {
            Clock.update();
            e.Update();             // always do updates before drawing characters.
        //    tile.Draw();
        //    tile2.Draw();
          
            grid.Draw();
            
            // Draw enemy
            e.Draw();
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
