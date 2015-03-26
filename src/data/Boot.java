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
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;

/**
 *
 * @author Keith
 */
public class Boot {
    
    public Boot()
    {
        Display.setTitle("Tower Defense");
        
        try
        {
            Display.setDisplayMode(new DisplayMode(600, 400));
            Display.create();
        }
        catch(LWJGLException e)
        {
            e.printStackTrace();
        }
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 600, 400, 0, 1, -1);      // set up camera
        glMatrixMode(GL_MODELVIEW);
        
        while (!Display.isCloseRequested())
        {
            glBegin(GL_LINES);
            
            glVertex2f(10, 10);
            glVertex2f(100, 100);           
            
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
