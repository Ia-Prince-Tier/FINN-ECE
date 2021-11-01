/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author louis
 */
public class Mower extends Entity{
    
    private int x;
    private int y;
    
    //constructor
    
    public Mower(){
        
        rpz = 't';
        x = 0;
        y = 0;
    }
    
    //getter
    
    public int getXPosition() {
        
        return this.x;
    }
    
    public int getYPosition() {
        
        return this.y;
    }
    
    //setter
    
    public void setXPosition(int x) {
        
        this.x = x;
    }
    
    public void setYPosition(int y) {
        
        this.y = y;
    }
    
}
