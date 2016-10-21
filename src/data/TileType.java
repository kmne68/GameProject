/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;

/**
 *
 * @author Keith
 */
public enum TileType {
    
    Veg("veg", true), Earth("earth", false), Water("water", false);
    
    String textureName;
    boolean buildable;
    
    TileType(String textureName, boolean buildable)
    {
        this.textureName = textureName;
        this.buildable = buildable;
    }    
}
