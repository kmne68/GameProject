/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * Handles OpenGL
 *
 */
package data.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Keith
 */
public class Artist {
    
    public static final int WIDTH = 1280, HEIGHT = 960;
    
    public static void BeginSession() 
    {
        Display.setTitle("Tower Defense");
        
        try 
        {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
        }
        
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);     // set up camera
        glMatrixMode(GL_MODELVIEW); 
        
        glEnable(GL_TEXTURE_2D);                 // enable use of textures
        glEnable(GL_BLEND);                         // For blending backgrounds/textures
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);  // For blending backgrounds/textures
        
    }   
    
    public static void DrawQuad(float x, float y, float height, float width)
    {
        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y + height);
        glVertex2f(x, y + width);
        glEnd();
    }
    
    public static void DrawQuadTexture(Texture tex, float x, float y, float width, float height)
    {
        tex.bind();
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);
        glTexCoord2f(0,0);
        glVertex2f(0,0);
        glTexCoord2f(1, 0);
        glVertex2f(width,0);
        glTexCoord2f(1, 1);
        glVertex2f(width, height);
        glTexCoord2f(0,1);
        glVertex2f(0,height);
        glEnd();
        glLoadIdentity();
    }
    
    public static void DrawLine(float x1, float y1, float x2, float y2)
    {
        glBegin(GL_LINES);
        glVertex2f(x1, y1);
        glVertex2f(x2, y2);
        glEnd();        
    }
    
    public static Texture LoadTexture (String path, String fileType) throws IOException
    {
        Texture tex = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        
        try
        {
            tex = TextureLoader.getTexture(fileType, in);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return tex;
    }
    
    public static Texture QuickLoad(String name)
    {
        Texture tex = null;
        try {
            tex = LoadTexture("res/" + name + ".png", "PNG");
        } catch (IOException ex) {
            Logger.getLogger(Artist.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tex;
    }
}