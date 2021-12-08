
import Controlleur.Movement;
import Modele.Game;
import java.io.IOException;

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
        
        
        game.ShowMainMenu();
        
        boolean next = false;
        while(!next){  
            char input = Movement.GetInput();
            next = game.UpdateMainMenu(input);
              
        }
        
        next = false;
        game.ShowLevel();
        while(!next){
            char input = Movement.GetInput();
            game.UpdateLevel(input);
        }
        
    }
    
}
