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
//    public static final int WIDTH = 20;
//    public static final int HEIGHT = 15;
    
    public Tile[][] map;
    
    // Makes alternating strips of two tile types.
 /*   public TileGrid()
    {
        map = new Tile[20][15];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
                if(i % 2 == 0)
                {
                    map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Earth);
                }
                else
                {
                    map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Veg);
                }
            }
        }
    }  */
    
    
    public TileGrid()
    {
        map = new Tile[10][25];
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                map[i][j] = new Tile(i * 32, j *  32, 32, 32, TileType.Veg);
            }
        }
    }
    
    public TileGrid(int[][] newMap)
    {
        map = new Tile[10][25];
        for(int i = 0; i < map.length; i++)
        {
            for(int j = 0; j < map[i].length; j++)
            {
    /*            if (newMap[j][i] == 0)
                    map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Veg);
                else if (newMap[j][i] == 1)
                    map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Earth);
                else if (newMap[j][i] == 2)
                    map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Water);
    */            
                switch(newMap[j][i])
                {
                    case 0:
                        map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Veg);
                        break;
                    case 1:
                        map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Earth);
                        break;
                    case 2:
                        map[i][j] = new Tile(i * 32, j * 32, 32, 32, TileType.Water);
                        break;
                }        
            }
        }
    }
    
    // Sets a tile of a specific type in a specified location.
    public void SetTile(int xCoord, int yCoord, TileType type) 
    {
        map[xCoord][yCoord] = new Tile(xCoord * 32, yCoord * 32, 32, 32, type);
    }
    
    
    // Returns information for the tile at the specified location.
    public Tile GetTile(int xPlace, int yPlace)
    {
        return map[xPlace][yPlace];
    }
    
    
    
    public void Draw()
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                map[i][j].Draw();
//                Tile t = map[i][j];
//                DrawQuadTexture(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
            }
        }
    }
}
