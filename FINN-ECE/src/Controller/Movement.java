/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.Level1;
import View.Level2;
import View.Level3;
import View.Level4;
import View.Level5;
/**
 *
 * @author louis
 */
public class Movement {
    
    Level1 first_board = new Level1(15,19);
    Level2 second_board = new Level2(15,19);
    Level3 third_board = new Level3(15,19);
    Level4 fourth_board = new Level4(15,19);
    Level5 fifth_board = new Level5(15,19);
        
    public Movement() {
        
    }
    
    public void Move1(char key){
                       
        switch(key){
            
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
    
     public void Move2(char key){
                       
        switch(key){
            
                case 'z': //go up
                    second_board.GoUp();
                    second_board.DisplayLevel2();
                    break;
                
                case 's': //go down
                    second_board.GoDown();
                    second_board.DisplayLevel2();
                    break;
                
                case 'q': //go left
                    second_board.GoLeft();
                    second_board.DisplayLevel2();
                    break;
                
                case 'd': //go right
                    second_board.GoRight();
                    second_board.DisplayLevel2();
                    break;
                
                default:
                    break;           
            } 
    }   
     
      public void Move3(char key){
                       
        switch(key){
            
                case 'z': //go up
                    third_board.GoUp();
                    third_board.DisplayLevel3();
                    break;
                
                case 's': //go down
                    third_board.GoDown();
                    third_board.DisplayLevel3();
                    break;
                
                case 'q': //go left
                    third_board.GoLeft();
                    third_board.DisplayLevel3();
                    break;
                
                case 'd': //go right
                    third_board.GoRight();
                    third_board.DisplayLevel3();
                    break;
                
                default:
                    break;           
            } 
    }   
      
     public void Move4(char key){
                       
        switch(key){
            
                case 'z': //go up
                    fourth_board.GoUp();
                    fourth_board.DisplayLevel4();
                    break;
                
                case 's': //go down
                    fourth_board.GoDown();
                    fourth_board.DisplayLevel4();
                    break;
                
                case 'q': //go left
                    fourth_board.GoLeft();
                    fourth_board.DisplayLevel4();
                    break;
                
                case 'd': //go right
                    fourth_board.GoRight();
                    fourth_board.DisplayLevel4();
                    break;
                
                default:
                    break;           
            } 
    }   
     
     public void Move5(char key){
                       
        switch(key){
            
                case 'z': //go up
                    fifth_board.GoUp();
                    fifth_board.DisplayLevel5();
                    break;
                
                case 's': //go down
                    fifth_board.GoDown();
                    fifth_board.DisplayLevel5();
                    break;
                
                case 'q': //go left
                    fifth_board.GoLeft();
                    fifth_board.DisplayLevel5();
                    break;
                
                case 'd': //go right
                    fifth_board.GoRight();
                    fifth_board.DisplayLevel5();
                    break;
                
                default:
                    break;           
            } 
    }   
}
