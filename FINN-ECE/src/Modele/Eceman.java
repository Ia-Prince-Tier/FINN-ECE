/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author tad-t
 */
public class Eceman extends Entity {
    
    private int x;
    private int y;
    
    //contructor
    
    public Eceman() {
        
        rpz = 'E';
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
    
    //move function
    
    public void Move(char movement){
        
        
        
        
            switch(movement){
            
                case 'z': //go up
                    this.y = y--;
                    setYPosition(y);
                    break;
                
                case 's': //go down
                    this.y = y++;
                    setYPosition(y);
                    break;
                
                case 'q': //go left
                    this.x = x--;
                    setYPosition(x);
                    break;
                
                case 'd': //go right
                    this.x = x++;
                    setYPosition(x);
                    break;
                
                default:
                    break;
            
        }
    }
    
}
