/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *entity class for Eceman
 * @author tad-t
 */
public class Eceman extends Entity {
    
    private boolean leger;
    private int nb;
    
    public Eceman() {
        rpz = 'E';
        leger = false;
        nb = 3;
    }
    
    /**
     * 
     *  Bolean function for light potion 
     */
    public void setLeger(boolean leger) {
        this.leger = leger;
        nb = 3;
    }

    public boolean isLeger() {
        return leger;
    }
    /**
     * Counter that decrements the number of tiles where the light potion can be used 
     */
    public void setNb() {
        this.nb -= 1;
        if(nb == 0){
            leger = false;
        }
    }
    
    
    
    
}
