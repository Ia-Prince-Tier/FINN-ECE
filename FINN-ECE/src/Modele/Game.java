/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import View.ShowScreen;
import java.io.*;
import javafx.util.Pair;

/**
 *
 * @author tad-t
 */
public class Game {
    
    //Declaration of variables
    private Entity[][] board;
    private float time;
    private float highScore;
    int brokenIce;
    int level;
    boolean inSubmenu;
    private String tmp;
    
    //Constructor
    public Game(){
        time = 0;
        brokenIce = 0;
        inSubmenu = false;
        level = 0;
        tmp = "o";
        highScore = 10000f;
    }
    
    //Display the menu
    public void ShowMainMenu(){
        String menu = "";
        menu += "Continuer -> 1\n";
        menu += "Nouvelle partie -> 2\n";
        menu += "Règles -> 3\n";
        menu += "Score -> 4\n";
        menu += "Touche déplacement -> 5\n";
        ShowScreen.Show(menu);
    }
    
    //Display the level
    public void ShowLevel(){
        ShowScreen.ShowLevel(board,highScore);
    }
    
    //Continue a saved game
    private void Continue(){
        Pair tapair = new Pair(1,1);
        ShowScreen.Show("Continuer");
        //récupérer ici dans un fichier le level sauvegarder
        this.level = LoadLevel();
        tapair = Level.Getlevel(level);
        highScore = LoadHighScore();
        this.board = (Entity[][]) tapair.getKey();
        this.tmp = (String) tapair.getValue();
    }
    
    //Start a new game
    private void NewGame(){
        Pair tapair = new Pair(1,1);
        ShowScreen.Show("Nouvelle partie");
        this.level = 5;
        tapair = Level.Getlevel(level);
        this.board = (Entity[][]) tapair.getKey();
        this.tmp = (String) tapair.getValue();
    }
    
    //Show the rules for play
    private void ShowRegles(){
        String menu = "";
        menu += "les règles ici lol\n";
        menu += "RETOUR -> 1\n";
        ShowScreen.Show(menu);
    }
    
    //Display the score for the game
    private void ShowScore(){
        String menu = "";
        menu += "level 1 -> " + String.valueOf(LoadHighScore(1)) + "\n";  
        menu += "level 2 -> " + String.valueOf(LoadHighScore(2)) + "\n";  
        menu += "level 3 -> " + String.valueOf(LoadHighScore(3)) + "\n";  
        menu += "level 4 -> " + String.valueOf(LoadHighScore(4)) + "\n";  
        menu += "RETOUR -> 1";
        ShowScreen.Show(menu);
    }
    
    //Show the deplacement
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

        //Switch case on the menu
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
    
    //Update the level in the way of the deplacement (right/left/up/down)
    public boolean UpdateLevel(char input){
        
        Pair tapair = new Pair(1,1);
        
        if(input == 'z' || input == 'q' || input == 's' || input == 'd'){
            tapair = Level.Update(board, input, tmp);
            this.board = (Entity[][]) tapair.getKey(); //Get the board from the pair function
            this.tmp = (String) tapair.getValue(); //Get tmp from the pair function
            System.out.println(tmp);
            this.board = Level.UpdateEnnemy(board);
        }    
        if(CheckEndLevel()){ //If the level is finish
        if(CheckEndLevel()){
            System.out.print(time);
            if(time < highScore)
                SaveTime();
            ShowScreen.Show("WIN");
            this.level += 1; //Pass to the next level
            if(this.level > 5){
                return true;
            }
            else{
                tapair = Level.Getlevel(level);
                this.board = (Entity[][]) tapair.getKey();
                this.tmp = (String) tapair.getValue();
                this.ShowLevel();
            }
        }
        else{
            ShowScreen.ShowLevel(this.board);
        }
        
        return false;
    }

    public int getLevel() {
        return level;
    }   
    
    public void SaveTime(){
  try {

   String content = String.valueOf(this.time);;
   String fileName = "score_" + String.valueOf(this.level)+".txt";
   File file = new File(fileName);

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
    
    public void ShowHighScore(){
        System.out.println("gagnééé!!!!");
    }
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
  
  public float LoadHighScore () throws IOException
  {
    BufferedReader lecteurAvecBuffer = null;
    String ligne;
    String fileName = "score_" + String.valueOf(this.level)+".txt";
    try
      {
	lecteurAvecBuffer = new BufferedReader(new FileReader(fileName));
      }
    catch(FileNotFoundException exc)
      {
	System.out.println("Erreur d'ouverture");
        return 1000f;
      }
    ligne = lecteurAvecBuffer.readLine();
    float i= Float.parseFloat(ligne);
    lecteurAvecBuffer.close();
    
    return i;
  }
  
  public float LoadHighScore (int niveau) throws IOException
  {
    BufferedReader lecteurAvecBuffer = null;
    String ligne;
    String fileName = "score_" + String.valueOf(niveau)+".txt";
    try
      {
	lecteurAvecBuffer = new BufferedReader(new FileReader(fileName));
      }
    catch(FileNotFoundException exc)
      {
	System.out.println("Erreur d'ouverture");
        return 1000f;
      }
    ligne = lecteurAvecBuffer.readLine();
    float i= Float.parseFloat(ligne);
    lecteurAvecBuffer.close();
    
    return i;
  }
} 

