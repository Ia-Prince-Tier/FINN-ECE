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
    
    private boolean leger;
    private int nb;
    
    public Eceman() {
        rpz = 'E';
        leger = false;
        nb = 3;
    }

    public void setLeger(boolean leger) {
        this.leger = leger;
        nb = 3;
    }

    public boolean isLeger() {
        return leger;
    }

    public void setNb() {
        this.nb -= 1;
        if(nb == 0){
            leger = false;
        }
    }
    
    
    
    
}
