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
 *Class that manages the menu, backups and best times
 * @author tad-t
 */
public class Game {
    
    /**
     * Declaration of variables
     */
    private Entity[][] board;
    private float time;
    private float highScore;
    int brokenIce;
    int level;
    boolean inSubmenu;
    private String tmp;
    
    /**
    Constructor
    */
    public Game(){
        time = 0;
        brokenIce = 0;
        inSubmenu = false;
        level = 0;
        tmp = "o";
        highScore = 10000f;
    }
    
    /**Display the menu
     * 
     */
    public void ShowMainMenu(){
        String menu = "";
        menu += "Continuer -> 1\n";
        menu += "Nouvelle partie -> 2\n";
        menu += "Règles -> 3\n";
        menu += "Score -> 4\n";
        menu += "Touche déplacement -> 5\n";
        ShowScreen.Show(menu);
    }
    
    /**Display the level
     * 
     */
    public void ShowLevel(){
        ShowScreen.ShowLevel(board);
    }
    
    /**Continue a saved game
     * 
     * @throws IOException 
     */
    private void Continue() throws IOException{
        Pair tapair = new Pair(1,1);
        ShowScreen.Show("Continuer");
        //récupérer ici dans un fichier le level sauvegarder
        this.level = LoadLevel();
        tapair = Level.Getlevel(level);
        highScore = LoadHighScore();
        this.board = (Entity[][]) tapair.getKey();
        this.tmp = (String) tapair.getValue();
    }
    
    /**Start a new game
     * 
     */
    private void NewGame(){
        Pair tapair = new Pair(1,1);
        ShowScreen.Show("Nouvelle partie");
        this.level = 1;
        tapair = Level.Getlevel(level);
        this.board = (Entity[][]) tapair.getKey();
        this.tmp = (String) tapair.getValue();
    }
    
    /**Show the rules for play
     * 
     */
    private void ShowRegles(){
        String menu = "";
        menu += "Pour réussir un level, Eceman 'E' devra se déplacer jusqu'au Portail 'P'.\n\n"
                +"Il devra briser toutes les cases de glaces (en passant 2 fois sur la glace épaisse 'O' qui deviendra de la glace fine 'o') pour terminer un niveau.\n\n"
                +"La potion de légereté 'L' permettra à Eceman de passer sur la glace sans la casser.\n\n" 
                +"Le tunnel permet à Eceman de se déplacer d'un endroit à l'autre du niveau. 'x' est la porte d'entrée du tunnel et 'X' la porte de sortie.\n\n" 
                +"La tondeuse 'T' peut être poussée par Eceman et briser toute la glace sur sa lancée jusqu’à s’arrêter sur un mur.\n\n"
                +"Eceman peut déplacer des briques de murs 'm' (sur les emplacements 'Z' possibles pour ces murs amovibles) afin d'ouvrir le passage jusqu'au portail de fin.\n\n"
                +"Lors du dernier niveau Eceman pourra rencontrer un ennemi 'G' pouvant le géner dans ses deplacement.\n\n"
                + " \n";
        menu += "RETOUR -> 1\n";
        ShowScreen.Show(menu);
    }
    
    /**Display the score for the game
     * 
     * @throws IOException 
     */
    private void ShowScore() throws IOException{
        String menu = "";
        menu += "level 1 -> " + String.valueOf(LoadHighScore(1)) + "\n";  
        menu += "level 2 -> " + String.valueOf(LoadHighScore(2)) + "\n";  
        menu += "level 3 -> " + String.valueOf(LoadHighScore(3)) + "\n";  
        menu += "level 4 -> " + String.valueOf(LoadHighScore(4)) + "\n";  
        menu += "level 5 -> " + String.valueOf(LoadHighScore(5)) + "\n"; 
        menu += "RETOUR -> 1";
        ShowScreen.Show(menu);
    }
    
    /**Show the deplacement
     * 
     * 
     */
    private void ShowMovement(){
        String menu = "";
        menu += "Eceman peut se déplacer à gauche en utilisant 'q'\n";
        menu += " à droite en utilisant 'd'\n";
        menu += " en haut en utilisant 'z'\n";
        menu += " en bas en utilisant 's'\n\n";
        menu += "RETOUR -> 1";
        ShowScreen.Show(menu);
    }
    
    /**
     * Function that allows you to return to the menu when you are in a sub-menu
     * @param input
     * @return
     * @throws IOException 
     */
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

        /**Switch case on the menu
         * 
         */
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
    
    /**Update the level in the way of the deplacement (right/left/up/down)
     * 
     * @param input
     * @param seconds
     * @return 
     */
    public boolean UpdateLevel(char input,float seconds){
        time += seconds;
        Pair tapair = new Pair(1,1);
        
        if(input == 'z' || input == 'q' || input == 's' || input == 'd'){
            tapair = Level.Update(board, input, tmp);
            this.board = (Entity[][]) tapair.getKey(); //Get the board from the pair function
            this.tmp = (String) tapair.getValue(); //Get tmp from the pair function
            System.out.println(tmp);
            this.board = Level.UpdateEnnemy(board);
        }    
        if(CheckEndLevel()){ //If the level is finish
            if(time < highScore)
                SaveTime();
            ShowScreen.Show("WIN");
            time = 0f;
            this.level += 1; //Pass to the next level
            if(this.level > 5){
                return true;
            }
            else{
                SaveLevel();
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

  
    /**
     * Function which saves the time in a file 
     */
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
    /**
     * Function wich save the Leveld ID in a file
     */
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
    /**
     * Check for winning conditions
     * @return 
     */
    private boolean CheckEndLevel(){
        return Level.CheckEnd(board);
    }     
    
    /**
     * Show best score for each levels
     * @throws IOException 
     */
    public void ShowHighScore() throws IOException{
        String menu = "";
        menu += "level 1 -> " + String.valueOf(LoadHighScore(1)) + "\n";  
        menu += "level 2 -> " + String.valueOf(LoadHighScore(2)) + "\n";  
        menu += "level 3 -> " + String.valueOf(LoadHighScore(3)) + "\n";  
        menu += "level 4 -> " + String.valueOf(LoadHighScore(4)) + "\n";  
        menu += "level 5 -> " + String.valueOf(LoadHighScore(5)) + "\n"; 
        menu += "Merci d'avoir jouer ! \n";
        ShowScreen.Show(menu);
    }


    /**
     * Allows you to load level you mhad finished
     * @return
     * @throws IOException 
     */

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
  /**
   * Allows you to Load your highscore
   * @return
   * @throws IOException 
   */
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
  
  /**
   * Allows you to Load your highscore
   * @return
   * @throws IOException 
   */
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

