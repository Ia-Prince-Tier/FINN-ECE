/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author louis
 */
public class Enemy extends Entity{
    
    private int x;
    private int y;
    
    //constructor
    
    public Enemy(){
        
        rpz = 'e';
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
