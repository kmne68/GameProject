/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.helpers;

import org.lwjgl.Sys;

/**
 *
 * @author Keith
 */
public class Clock {
    private static boolean paused = false;
    
    public static long lastFrame, totalTime;
    public static float d = 0, multiplier = 1; // d = delta time
    
    public static long getTime()
    {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }
   
    
    public static float getDelta()
    {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        
        return delta * 0.01f;
    }
    
    public static float Delta()
    {
        if (paused)
            return 0;
        else
            return d * multiplier;
    }
    
    public static float totalTime()
    {
        return totalTime;
    }
    
    public static float Multiplier()
    {
        return multiplier;
    }
    
    public static void update()
    {
        d = getDelta();
        totalTime += d;
    }
    
    public static void ChangeMultiplier(int change)
    {
        if(multiplier + change < -1 && multiplier + change > 7) // -1 and 7 are arbitrary
        {
            
        }
        else
            multiplier += change;
    }
    
    
    public static void pause()
    {
        if (paused)
            paused = false;
        else
            paused = true;
    }
}


