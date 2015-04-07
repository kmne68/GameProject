/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

import static data.helpers.Clock.*;

// import static helpers.Clock.*;
/**
 *
 * @author Keith
 */
public class Wave {
    
    private float timeSinceLastSpawn, spawnTime;
    private Enemy enemyType;
    private ArrayList<Enemy> enemyList;
    
    public Wave(float spawnTime, Enemy enemyType)
    {
        this.enemyType = enemyType;
        this.spawnTime = spawnTime;
        enemyList = new ArrayList<Enemy>();
    }
    
    public void Update()
    {
        timeSinceLastSpawn += Delta();
        if(timeSinceLastSpawn > spawnTime)
        {
            Spawn();
            timeSinceLastSpawn = 0;
        }
        
        for (Enemy e: enemyList)
        {
            e.Update();
            e.Draw();
        }
    }
    
    private void Spawn()
    {
        enemyList.add(new Enemy(enemyType.getTexture(), enemyType.getStartTile(), 64, 64, enemyType.getSpeed()));
    }
    
}
