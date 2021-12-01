/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Eceman;
import Modele.Game1;
import Vue.Level1;
import java.io.IOException;
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
        
        /*
        Eceman eceman = new Eceman();
        
        Scanner sc = new Scanner(System.in);
                                       
        Game1 game = new Game1(1);
        
        game.ReadFile();
        game.ViewBoard();
        
        int i = 1;
        
        while (i < 1000){
            
            System.out.println("choose a move : z (up) / q (left) / s (down) / d (right) -- then press enter to valide");
            
            char key = sc.next().charAt(0);
            eceman.Move(key);

            game.ViewBoard();
            
            i++;
        }

        */
        
        Level1 test = new Level1(15,19);
        test.AfficherLevel1();
        Eceman eceman = new Eceman();
        
        Scanner sc = new Scanner(System.in);
        
        int i = 1;
        
        while (i < 1000){
            
            System.out.println("choose a move : z (up) / q (left) / s (down) / d (right) -- then press enter to valide");
            
            char key = sc.next().charAt(0);
            eceman.Move(key);

            Level1 test2 = new Level1(eceman.getXPosition(),eceman.getYPosition());
            test2.AfficherLevel1();
            
            i++;
        }
                                       
    }
}
