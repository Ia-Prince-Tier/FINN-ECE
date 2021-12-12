/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import View.ShowScreen;
import java.io.*;
import javafx.util.Pair;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    private String tmp;
    
    public Game(){
        time = 0;
        brokenIce = 0;
        inSubmenu = false;
        level = 0;
        tmp = "o";
    }
    
    
    public void ShowMainMenu(){
        String menu = "";
        menu += "Continuer -> 1\n";
        menu += "Nouvelle partie -> 2\n";
        menu += "Règles -> 3\n";
        menu += "Score -> 4\n";
        menu += "Touche déplacement -> 5\n";
        ShowScreen.Show(menu);
    }
    
    public void ShowLevel(){
        ShowScreen.ShowLevel(board);
    }
    
    private void Continue() throws IOException{
        Pair tapair = new Pair(1,1);
        ShowScreen.Show("Continuer");
        //récupérer ici dans un fichier le level sauvegarder
        this.level = LoadLevel();
        System.out.println(level);
        tapair = Level.Getlevel(level);
        this.board = (Entity[][]) tapair.getKey();
        this.tmp = (String) tapair.getValue();
    }
    
    private void NewGame(){
        Pair tapair = new Pair(1,1);
        ShowScreen.Show("Nouvelle partie");
        this.level = 1;
        SaveLevel();
        tapair = Level.Getlevel(level);
        this.board = (Entity[][]) tapair.getKey();
        this.tmp = (String) tapair.getValue();
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
    
    public boolean UpdateMainMenu(char input) throws IOException{
        
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
        Pair tapair = new Pair(1,1);
        if(input == 'z' || input == 'q' || input == 's' || input == 'd')
            tapair = Level.Update(board,input, tmp);
            this.board = (Entity[][]) tapair.getKey();
            this.tmp = (String) tapair.getValue();
            System.out.println(tmp);
        if(CheckEndLevel()){
            ShowScreen.Show("WIN");
            this.level += 1;
            SaveLevel();
            tapair = Level.Getlevel(level);
            this.board = (Entity[][]) tapair.getKey();
            this.tmp = (String) tapair.getValue();
            this.ShowLevel();
        }else
            ShowScreen.ShowLevel(this.board);
    }

    public int getLevel() {
        return level;
    }
    
    public void SaveLevel(){
  try {

   String content = Integer.toString(this.level);

   File file = new File("Sauvegarde.txt");

   // créer le fichier s'il n'existe pas
   if (!file.exists()) {
    file.createNewFile();
   }

   FileWriter fw = new FileWriter(file.getAbsoluteFile());
   BufferedWriter bw = new BufferedWriter(fw);
   bw.write(content);
   bw.close();

  } catch (IOException e) {
   e.printStackTrace();
  }
 }
    
    private boolean CheckEndLevel(){
        return Level.CheckEnd(board);
    }



  public int LoadLevel () throws IOException
  {
    BufferedReader lecteurAvecBuffer = null;
    String ligne;

    try
      {
	lecteurAvecBuffer = new BufferedReader(new FileReader("Sauvegarde.txt"));
      }
    catch(FileNotFoundException exc)
      {
	System.out.println("Erreur d'ouverture");
      }
    ligne = lecteurAvecBuffer.readLine();
    int i=Integer.parseInt(ligne);
    lecteurAvecBuffer.close();
    
    return i;
  }
} 

