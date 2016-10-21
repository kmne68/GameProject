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
    private Piece enemyType;
    private ArrayList<Piece> enemyList;
    
    public Wave(float spawnTime, Piece enemyType)
    {
        this.enemyType = enemyType;
        this.spawnTime = spawnTime;
        enemyList = new ArrayList<Piece>();
    }
    
    public void Update()
    {
        timeSinceLastSpawn += Delta();
        if(timeSinceLastSpawn > spawnTime)
        {
            Spawn();
            timeSinceLastSpawn = 0;
        }
        
        for (Piece e: enemyList)
        {
            e.Update();
            e.Draw();
        }
    }
    
    private void Spawn()
    {
        enemyList.add(new Piece(enemyType.getTexture(), enemyType.getStartTile(), enemyType.getTileGrid(), 32, 32, enemyType.getSpeed()));
    }
    
}
