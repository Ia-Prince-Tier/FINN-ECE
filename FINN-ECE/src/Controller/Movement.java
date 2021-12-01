/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.Level1;
/**
 *
 * @author louis
 */
public class Movement {
    
    private char key;

    public Movement(char key) {
        this.key = key;      
    }
    
    public void Move(char key){
        
        this.key = key;
        
        Level1 first_board = new Level1(15,19);
        first_board.DisplayLevel1();
        
        switch(this.key){
            
                case 'z': //go up
                    first_board.GoUp();
                    first_board.DisplayLevel1();
                    break;
                
                case 's': //go down
                    first_board.GoDown();
                    first_board.DisplayLevel1();
                    break;
                
                case 'q': //go left
                    first_board.GoLeft();
                    first_board.DisplayLevel1();
                    break;
                
                case 'd': //go right
                    first_board.GoRight();
                    first_board.DisplayLevel1();
                    break;
                
                default:
                    break;           
            } 
    }   
}
