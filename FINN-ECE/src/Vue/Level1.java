/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Eceman;

/**
 *
 * @author louis
 */
public class Level1 {
    
     private int nb_col;
     private int nb_lig;
     private char grille[][];

    public Level1(int nb_col, int nb_lig) { //Constructeur
        
        this.nb_col = nb_col;
        this.nb_lig = nb_lig;
        
        grille = new char[nb_col][nb_lig];
        
        //Affichage du vide
        for(int i = 0; i < nb_col; i++){
            for(int j = 0; j < nb_lig; j++){
                
                grille[i][j] = '#';
            }
        }
        
        //Affichage des murs
        for(int k = 7; k <= 9; k++){
            
            grille[k][1] = 'M';
        }
        for(int k = 7; k <= 9; k++){
            
            grille[k][15] = 'M';
        }
        for(int k = 1; k <= 15; k++){
            
            grille[7][k] = 'M';
        }
        for(int k = 1; k <= 15; k++){
            
            grille[9][k] = 'M';
        }
        
        //Affichage de la glace
        for(int k = 3; k <= 13; k++){
            
            grille[8][k] = 'o';
        }
        
        //Affichage du portail
        grille[8][2] = 'P';
        
        //Affichage eceMan
        grille[8][14] = 'E';
    }
    
    public void AfficherLevel1(){ //Afficher la grille dans la console
        
        System.out.println();
        
        for(int i = 0; i < nb_col; i++){
            for(int j = 0; j < nb_lig; j++){
                
                System.out.print(" | " + grille[i][j]);
            }
            System.out.println(" | ");
        }    
        System.out.println();
    } 
    
}
