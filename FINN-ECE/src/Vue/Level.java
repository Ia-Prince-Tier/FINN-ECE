/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author louis
 */
public class Level {
    
     private int nb_col;
     private int nb_lig;
     private char grille[][];

    public Level(int nb_col, int nb_lig) { //Constructeur
        
        this.nb_col = nb_col;
        this.nb_lig = nb_lig;
        
        for(int i = 0; i < nb_col; i++){
            for(int j = 0; j < nb_lig; j++){
                
                grille[i][j] = '#';
            }
        }
    }
    
    public void Afficher(){
        
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
