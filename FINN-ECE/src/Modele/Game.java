/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import View.ShowScreen;
import java.io.*;

/**
 *
 * @author tad-t
 */
public class Game {
    private Entity[][] board;
    private float time;
    int brokenIce;
    int level;
    boolean inSubmenu;
    
    public Game(){
        time = 0;
        brokenIce = 0;
        inSubmenu = false;
        level = 0;
    }
    
    
    public void ShowMainMenu(){
        String menu = "";
        menu += "Continuer -> 1\n";
        menu += "Nouvelle partie -> 2\n";
        menu += "Règles -> 3\n";
        menu += "Score -> 4\n";
        menu += "Touche déplacement -> 4\n";
        ShowScreen.Show(menu);
    }
    
    public void ShowLevel(){
        ShowScreen.ShowLevel(board);
    }
    
    private void Continue(){
        ShowScreen.Show("Continuer");
        //récupérer ici dans un fichier le level sauvegarder
        this.level = 1;
        board = Level.Getlevel(level);
        
    }
    
    private void NewGame(){
        ShowScreen.Show("Nouvelle partie");
        this.level = 5;
        board = Level.Getlevel(level);
    }
        
    private void ShowRegles(){
        String menu = "";
        menu += "les règles ici lol\n";
        menu += "RETOUR -> 1\n";
        ShowScreen.Show(menu);
    }
    
    private void ShowScore(){
        String menu = "";
        menu += "le score ici, mais ca va etre technique je serai la vous inquietez pas\n";
        menu += "RETOUR -> 1";
        ShowScreen.Show(menu);
    }
    
    private void ShowMovement(){
        String menu = "";
        menu += "comment jouer ici trop simple\n";
        menu += "RETOUR -> 1";
        ShowScreen.Show(menu);
    }
    
    public boolean UpdateMainMenu(char input){
        
        if(inSubmenu){
            if(input != '1')
                return false;
            else{
                ShowMainMenu();
                inSubmenu = false;
                return false;
            }
        }

        switch(input){
            case '1':
                Continue();
                return true;
            case '2':
                NewGame();
                return true;
            case '3':
                ShowRegles();
                inSubmenu = true;
                break;
            case '4':
                ShowScore();
                inSubmenu = true;
                break;
            case '5':
                ShowMovement();
                inSubmenu = true;
                break;
            default:
                ShowScreen.Show("Erreur mainMenu");
                break;    
        }
        return false;
    }
    
    public void UpdateLevel(char input){
        if(input == 'z' || input == 'q' || input == 's' || input == 'd')
            board = Level.Update(board,input);
        if(CheckEndLevel()){
            ShowScreen.Show("GAGNeraccent");
        }else
            ShowScreen.ShowLevel(board);
    }
    
    private boolean CheckEndLevel(){
        return Level.CheckEnd(board);
    }
    
    
    
            
    
}
