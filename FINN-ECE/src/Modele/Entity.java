/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *Abstract class for each type of entity
 * @author tad-t
 */

//Abstract class : Entity which every object on the board extends
public abstract class Entity {
    protected char rpz;
    
    public char Print(){
        return rpz; //Char correspondant to a specific entity
    }

    @Override
    
    public String toString() {
        return String.valueOf(rpz);
    }
       
}
