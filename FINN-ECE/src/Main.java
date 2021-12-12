
import Controlleur.Movement;
import Modele.Game;
import java.io.IOException;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tad-t
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Game game = new Game();
        
        game.ShowMainMenu(); //Display the menu in the console
        
        boolean next = false;
        while(!next){  
            char input = Movement.GetInput();
            next = game.UpdateMainMenu(input); //Send the user input for the menu to the function which display the user choice 
        }
        
        next = false;
        game.ShowLevel();
        while(!next){
            long tempsDebut = System.currentTimeMillis();
            char input = Movement.GetInput();
            long tempsFin = System.currentTimeMillis();
            float seconds = (tempsFin - tempsDebut) / 1000F;
            game.UpdateLevel(input,seconds);
        }
        
        game.ShowHighScore();
        
    }
    
}
