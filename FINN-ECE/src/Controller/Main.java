/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Level1;
import java.util.Scanner;

/**
 *
 * @author louis
 */
public class Main {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {        
        
        Level1 first_board = new Level1(15,19);
        first_board.DisplayLevel1();
        //Eceman eceman = new Eceman();
        
        Scanner sc = new Scanner(System.in);
        
        int i = 1;
        
        while (i < 1000){
            
            System.out.println("choose a move : z (up) / q (left) / s (down) / d (right) -- then press enter to valide");
            
            char key = sc.next().charAt(0);
            
            //Movement key_move = new Movement(key);
            
            //key_move.Move(key);

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
            i++;
        }                                       
    }
}
