/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.helpers.Artist.DrawQuadTexture;

/**
 *
 * @author Keith
 */
public class TileGrid
{
    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;
    
    public Tile[][] map;
    
    public TileGrid()
    {
        map = new Tile[20][15];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                if(i % 2 == 0)
                {
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Earth);
                }
                else
                {
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Veg);
                }
            }
        }
    }
    
    public TileGrid(int[][] newMap)
    {
        map = new Tile[20][15];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                if (newMap[j][i] == 0)
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Veg);
                else
                    map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Earth);
            }
        }
    }
    
    public void Draw()
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                Tile t = map[i][j];
                DrawQuadTexture(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
            }
        }
    }
}
