/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.util.Scanner;

/**
 *
 * @author tad-t
 */
public class Movement {
    
    //Char scanner to get the key deplacement of the user (z/q/s/d) 
    public static char GetInput(){
        Scanner sc = new Scanner(System.in);
        return (sc.next().charAt(0)); 
    }
    
}
