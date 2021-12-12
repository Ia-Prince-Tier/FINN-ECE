/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Modele.Entity;

/**
 *
 * @author tad-t
 */
public class ShowScreen {
    
    //Show a string in the console 
    public static void Show(String show){
        Clear();
        System.out.println(show);
    }
    
    //Clear the console between each board refresh
    public static void Clear(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }
    
    public static void ShowLevel(Entity[][] board){
        Clear();
        System.out.println();
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 19; j++){
                System.out.print(" | " + board[i][j].Print());
            }
            System.out.println(" | ");
        }    
        System.out.println();
    }
    
}
