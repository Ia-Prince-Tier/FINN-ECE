/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Level1;
import View.Level2;
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
        
        Movement key_move = new Movement();
        int i = 1;
        Scanner sc = new Scanner(System.in);
        
        //Level one
        /*Level1 first_board = new Level1(15,19);
        first_board.DisplayLevel1();
        
        while (i < 1000){            
            System.out.println("choose a move : z (up) / q (left) / s (down) / d (right) -- then press enter to valide");            
            char key = sc.next().charAt(0);           
            key_move.Move1(key);    
            i++;
        }*/
        
        //Level two        
        Level2 second_board = new Level2(15,19);
        second_board.DisplayLevel2();
        
        while (i < 1000){            
            System.out.println("choose a move : z (up) / q (left) / s (down) / d (right) -- then press enter to valide");            
            char key = sc.next().charAt(0);           
            key_move.Move2(key);    
            i++;
        }
        
        //Level three
        
        //Level four
        
        //Level five
    }
}
