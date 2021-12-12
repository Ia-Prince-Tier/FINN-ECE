/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import javafx.util.Pair;

/**
 *
 * @author tad-t
 */
public class Level {
    private final static int nb_lig = 15;
    private final static int nb_col = 19;
    private static String tmp;

     //Switch case on id level
    public static Pair<Entity[][], String> Getlevel(int id) {
        
        switch(id){
            case 1:
                return Level1 ();
            case 2 :
                return Level2 ();
            case 3:
                return Level3 ();
            case 4 : 
                return Level4 ();
            case 5:
                return Level5();
        }
        return null;
    }
    
    //Generate the level 1
    private static Pair<Entity[][], String> Level1() {
        
        Entity[][] board = new Entity[nb_lig][nb_col];
        
        //Empty display
        for(int i = 0; i < nb_lig; i++){
            for(int j = 0; j < nb_col; j++){
                
                board[i][j] = new Void();
            }
        }
        
        //Wall display
        for(int k = 7; k <= 9; k++){
            
            board[k][1] = new Wall();
        }
        for(int k = 7; k <= 9; k++){
            
            board[k][15] = new Wall();
        }
        for(int k = 1; k <= 15; k++){
            
            board[7][k] = new Wall();
        }
        for(int k = 1; k <= 15; k++){
            
            board[9][k] = new Wall();
        }
        
        //Ice display
        for(int k = 3; k <= 13; k++){
            
            board[8][k] = new Ice();
        }
        
        //Portal display
        board[8][2] = new Eportal();
        
        //Eceman display
        board[8][14] = new Eceman();
        
        return new Pair<>(board, "o");
    }
    
    //Generate the level 2
    private static Pair<Entity[][], String> Level2() {
        
        Entity[][] board = new Entity[nb_lig][nb_col];
        
        //Empty display
        for(int i = 0; i < nb_lig; i++){
            for(int j = 0; j < nb_col; j++){
                
                board[i][j] = new Void();
            }
        }
        
        //Wall display
        for(int k = 7; k <= 9; k++){
            
            board[k][1] = new Wall();
        }
        for(int k = 3; k <= 7; k++){
            
            board[k][2] = new Wall();
        }
        for(int k = 2; k <= 7; k++){
            
            board[3][k] = new Wall();
        }
        for(int k = 13; k <= 15; k++){
            
            board[4][k] = new Wall();
        }
        for(int k = 3; k <=5; k++){
            
            board[k][7] = new Wall();            
        }
        for(int k = 1; k <=7; k++){
            
            board[9][k] = new Wall();
        }       
        for(int k = 9; k <=15; k++){
            
            board[9][k] = new Wall();
        }
        for(int k = 5; k <=7; k++){
            
            board[k][11] = new Wall();
        }
        for(int k = 4; k <=7; k++){
            
            board[k][13] = new Wall();
        }
        for(int k = 4; k <=9; k++){
            
            board[k][15] = new Wall();
        }
        for(int k = 4; k <=5; k++){
            
            board[5][k] = new Wall();
        }
        for(int k = 7; k <=11; k++){
            
            board[5][k] = new Wall();
        }
        for(int k = 7; k <=11; k++){
            
            board[5][k] = new Wall();
        }
        for(int k = 1; k <=5; k++){
            
            board[7][k] = new Wall();
        }
        for(int k =7 ; k <= 8; k++){
            
            board[k][7] = new Wall();
        }
        for(int k = 7; k <=9; k++){
            
            board[7][k] = new Wall();
        }             
        for(int k = 7; k <=9; k++){
            
            board[k][9] = new Wall();
        }
        board[7][12] = new Wall(); 
                                      
        //Ice display                 
        for(int k = 4; k <=6; k++){
            
            board[k][3] = new Ice();
        }
        for(int k = 3; k <= 6; k++){
            
            board[4][k] = new Ice();
        }
        for(int k = 3; k <=6; k++){
            
            board[8][k] = new Ice();
            }       
        for(int k = 3; k <=5; k++){
            
            board[6][k] = new Ice();
        }   
        for(int k = 7; k <=10; k++){
            
            board[6][k] = new Ice();
        }
         for(int k =6 ; k <= 8; k++){
            
            board[k][14] = new Ice();
        }
          for(int k =7 ; k <= 8; k++){
            
            board[k][6] = new Ice();
        }
          for(int k =7 ; k <= 8; k++){
            
            board[k][10] = new Ice();
        }
           for(int k =10     ; k <= 13; k++){
            
            board[8][k] = new Ice();
        }
        board [5] [6] = new Ice(); 
        
        //Strong ice display
        board[6][6] = new BigIce();
          
        //Portal display
        board[5][14] = new Eportal();
        
        //Eceman display
        board[8][2] = new Eceman();
       
        return board;
    }
    
    //Generate the level 3
    private static Pair<Entity[][], String> Level3() {
        
        Entity[][] board = new Entity[nb_lig][nb_col];

        for(int i = 0; i < nb_lig; i++){
            for(int j = 0; j < nb_col; j++){
                
                board[i][j] = new Void();
            }
        }
        
        //Wall display
        for(int k = 3; k <= 11; k++){
            
            board[k][7] = new Wall();
        }
        for(int k = 3; k <= 11; k++){
            
            board[k][14] = new Wall();
        }
        
        for(int k = 3; k <= 11; k++){
            
            board[k][8] = new Wall();
        }
        for(int k = 3; k <= 11; k++){
            
            board[k][9] = new Wall();
        }
    
        for(int k = 3; k <= 11; k++){
            
            board[k][10] = new Wall();
        }
        
        for(int k = 3; k <= 11; k++){
            
            board[k][11] = new Wall();
        }
    
        for(int k = 3; k <= 11; k++){
            
            board[k][12] = new Wall();
        }
    
        for(int k = 3; k <= 11; k++){
            
            board[k][13] = new Wall();
        }
    
        //Ice display
        for(int k = 4; k <= 6; k++){
            
            board[k][8] = new Ice();
        }
    
        for(int k = 8; k <= 9; k++){
            
            board[k][13] = new Ice();
        }
    
        for(int k = 9; k <= 11; k++){
            
            board[6][k] = new Ice();
        }
    
        for(int k = 9; k <= 11; k++){
            
            board[8][k] = new Ice();
        }
    
        for(int k = 9; k <= 12; k++){
            
            board[10][k] = new Ice();
        }
    
        board[7][12] = new Ice();
        
        //Portal display
        board[3][9] = new Eportal();
        
        //Eceman display
        board[11][13] = new Eceman();
    
        //Potion de legerete display
        board[10][13] = new Popol();
    
        //Tondeuse display
        board[8][12] = new Tondeuse();
    
        //movin bricks display
        board [4][9] = new Mbrick ();
        board [6][12] = new Mbrick ();
    
        //Fusion Wall Display 
        board [4][10] = new FusionWall ();
        board [5][12] = new FusionWall ();
        
        return new Pair<>(board, "o");
    }
    
    //Generate the level 4
    private static Pair<Entity[][], String> Level4() {
        
        Entity[][] board = new Entity[nb_lig][nb_col];
        
        //Empty display
        for(int i = 0; i < nb_lig; i++){
            for(int j = 0; j < nb_col; j++){
                
                board[i][j] = new Void();
            }
        }
        
        //Wall display
        for(int k = 7; k <= 9; k++){
            
            board[k][7] = new Wall();
        }
        for(int k = 7; k <= 9; k++){
            
            board[k][9] = new Wall();
        }                
        for(int k = 7; k <= 9; k++){
            
            board[k][1] = new Wall();
        }
        for(int k = 7; k <= 9; k++){
            
            board[k][15] = new Wall();
        }                
        for(int k = 1; k <= 7; k++){
            
            board[7][k] = new Wall();
        }
        for(int k = 1; k <= 7; k++){
            
            board[9][k] = new Wall();
        }                
        for(int k = 9; k <= 15; k++){
            
            board[7][k] = new Wall();
        }
        for(int k = 9; k <= 15; k++){
            
            board[9][k] = new Wall();
        }
        
        //Ice display
        for(int k = 3; k <= 6; k++){
            
            board[8][k] = new Ice();
        }
        for(int k = 10; k <= 13; k++){
            
            board[8][k] = new Ice();
        }
        
        //Tunnel display
        board[8][6] = new TunnelArrive();
        board[8][10] = new TunnelDepart();
        
        //Portal display
        board[8][2] = new Eportal();
        
        //Eceman display
        board[8][14] = new Eceman();
                
        return new Pair<>(board, "o");
    }
    
    //Generate the level 5
     private static Pair<Entity[][], String> Level5(){
        
        Entity[][] board = new Entity[nb_lig][nb_col];
        
        //Empty display
        for(int i = 0; i < nb_lig; i++){
            for(int j = 0; j < nb_col; j++){
                
                board[i][j] = new Void();
            }
        }
        
        //Wall display
        for(int k = 2; k <= 11; k++){
            
            board[4][k] = new Wall();
        }
        for(int k = 2; k <= 11; k++){
            
            board[6][k] = new Wall();
        }
        for(int k = 1; k <= 9; k++){
            
            board[k][5] = new Wall();
        }
        for(int k = 1; k <= 9; k++){
            
            board[k][7] = new Wall();
        }
        
        board[1][6] = new Wall();
        board[5][2] = new Wall();
        board[5][11] = new Wall();
        board[9][6] = new Wall();
        
        //Ice display
        for(int k = 3; k <= 10; k++){
            
            board[5][k] = new Ice();
        }
        
        //Portal display
        board[5][3] = new Eportal();
        
        //Eceman display
        board[5][10] = new Eceman();
        
        //Eceman move tiles display
       for(int k = 2; k <= 8; k++){
            
            board[k][6] = new EnnemyMove();
        }
       
       //Ennemi display
        board[5][6] = new Ennemy();
        
        return new Pair<>(board, "o");
    }
    
     //Update the board in case of the deplacement (go left/right/up/down)
    public static Pair<Entity[][], String> Update(Entity[][] board, char input, String tmp) {
        
        switch(input){
            case 'z':
                return GoUp(board, tmp);
            case 's':
                return GoDown(board, tmp);
            case 'q':
                return GoLeft(board, tmp);
            case 'd' :
                return GoRight(board, tmp);
            default:
                System.out.println("Error Update level switch");
        }        
        return null;
    }
    
    public static Entity[][] UpdateEnnemy(Entity[][] board){
        int random = 0 + (int)(Math.random()*(2 - 0) + 1);
        
        if(random == 1){
            return GoUpEnnemy(board);
        }
        
        if(random == 2){
            return GoDownEnnemy(board);
        }
        
        return null;
    }
    
    //Go up -- key : z
    private static Pair<Entity[][], String> GoUp(Entity[][] board, String tmp) {
        int n = 0;
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].Print() == 'E'){ //Found eceman on the board
                    Eceman eceman = (Eceman) board[i][j];
                    if(board[i-1][j].Print() == 'o' || board[i-1][j].Print() == 'O' || board[i-1][j].Print() == 'P'
                            || board[i-1][j].Print() == 'L' || board[i-1][j].Print() == 'T'){ //Test the legitimcy of the movement
                        switch (tmp.charAt(0)) {
                            case 'O':
                                tmp = board[i-1][j].toString(); //Save the case before eceman walk on it
                                board[i][j] = new Ice(); //Remplace strong ice by ice after eceman walk on it
                                board[i-1][j] = eceman; //Remplace the legit case by eceman
                                break;
                            case 'o':
                                tmp = board[i-1][j].toString();
                                board[i][j] = new MeltedIce(); //Remplace ice by water after eceman walk on it
                                board[i-1][j] = eceman;                         
                                break;
                            case 'T':
                                tmp = "o";                                
                                board[i-1][j] = eceman;
                                for(int k = 0; k <= 3; k++){
                                    board[i][j-k] = new MeltedIce(); //The mowner break the ice in front of it
                                } 
                                break;
                            default:
                                System.out.println("no legit movement, please try again");
                                break;
                        }
                        n++;
                        if(n == 1){
                            return new Pair<>(board, tmp);
                        }
                    }
                    else if(board[i-1][j].Print() == 'm'){
                        tmp = "o";
                        board[i][j] = new MeltedIce(); //Remplace ice by water after eceman walk on it
                        board[i-1][j] = eceman; //Remplace the legit case by eceman
                        board[i-2][j] = new Wall();
                    }
                }
            }
        }
        return board;
    }
    
    //Go down -- key : s
    private static Pair<Entity[][], String> GoDown(Entity[][] board, String tmp) {
        int n = 0;
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].Print() == 'E'){ //Found eceman on the board
                    Eceman eceman = (Eceman) board[i][j];
                    if(board[i+1][j].Print() == 'o' || board[i+1][j].Print() == 'O' || board[i+1][j].Print() == 'P'
                            || board[i+1][j].Print() == 'L' || board[i+1][j].Print() == 'T'){ //Test the legitimcy of the movement
                        switch (tmp.charAt(0)) {
                            case 'O':
                                tmp = board[i+1][j].toString(); //Save the case before eceman walk on it
                                board[i][j] = new Ice(); //Remplace strong ice by ice after eceman walk on it
                                board[i+1][j] = eceman; //Remplace the legit case by eceman
                                break;
                            case 'o':
                                tmp = board[i+1][j].toString();
                                board[i][j] = new MeltedIce(); //Remplace ice by water after eceman walk on it
                                board[i+1][j] = eceman;                       
                                break;
                            default:
                                System.out.println("no legit movement, please try again");
                                break;
                        }
                        n++;
                        if(n == 1){
                            return new Pair<>(board, tmp);
                        }
                    }
                    else{
                        System.out.println("no legit movement, please try again");
                    }
                }
            }
        }
        return board;
    }
    
    //Go left -- key : q
    private static Pair<Entity[][], String> GoLeft(Entity[][] board, String tmp) {
        int n = 0;
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].Print() == 'E'){ //Found eceman on the board
                    Eceman eceman = (Eceman) board[i][j];
                    if(board[i][j-1].Print() == 'o' || board[i][j-1].Print() == 'O' || board[i][j-1].Print() == 'P'
                            || board[i][j-1].Print() == 'L' || board[i][j-1].Print() == 'T' || board[i][j-1].Print() == 'g'){ //Test the legitimcy of the movement
                        switch (tmp.charAt(0)) {
                            case 'O':
                                tmp = board[i][j-1].toString(); //Save the case before eceman walk on it
                                board[i][j] = new Ice(); //Remplace strong ice by ice after eceman walk on it
                                board[i][j-1] = eceman; //Remplace the legit case by eceman
                                break;
                            case 'o':
                                if(eceman.isLeger()){ //If lightness potion
                                    tmp = board[i][j-1].toString(); 
                                    eceman.setNb(); //Start the count of case he can walk on without break them
                                    if(eceman.isLeger()){ //Test if eceman had lightness potion
                                        tmp = board[i][j-1].toString(); 
                                    }else{ //Without lightness potion
                                        tmp = "o"; 
                                    }
                                    board[i][j] = new Ice(); //Eceman dont break the ice (cause of potion)
                                    board[i][j-1] = eceman; 
                                }else{
                                    tmp = board[i][j-1].toString(); 
                                    board[i][j] = new MeltedIce(); //Remplace ice by water after eceman walk on it
                                    board[i][j-1] = eceman; //Remplace the legit case by eceman     
                                }                      
                                break;
                            case 'L':
                                tmp = "o"; 
                                eceman.setLeger(true); //Activation of lightness capabilities
                                board[i][j] = new Ice(); //No more potion after eceman catch it
                                board[i][j-1] = eceman; 
                                break;
                            case 'x':
                                tmp = "o"; 
                                board[i][j] = new TunnelArrive(); //Let the arrive of the tunnel fixed
                                board[i][j-1] = eceman;
                                break;
                            case 'g':
                                tmp = "o";
                                board[i][j] = new EnnemyMove();
                                board[i][j-1] = eceman;
                                break;
                            default:
                                System.out.println("no legit movement, please try again");
                                break;
                        }
                        n++;
                        if(n == 1){
                            return new Pair<>(board, tmp);
                        }
                    }
                    else if(board[i][j-1].Print() == 'x'){ //Eceman enter in the tunnel
                        tmp = "x"; 
                        board[i][j] = new MeltedIce(); 
                        board[i][j-5] = eceman; //He arrive directly to the other side of the tunnel
                    }
                }
            }       
        }
        return new Pair<>(board, tmp);
    }
    
    //Go right -- key : d
    private static Pair<Entity[][], String> GoRight(Entity[][] board, String tmp) {
        int n = 0;
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].Print() == 'E'){ //Found eceman on the board
                    Eceman eceman = (Eceman) board[i][j];
                    if(board[i][j+1].Print() == 'o' || board[i][j+1].Print() == 'O' || board[i][j+1].Print() == 'P'
                            || board[i][j+1].Print() == 'L' || board[i][j+1].Print() == 'T'){ //Test the legitimacy of the movement
                        switch (tmp.charAt(0)) {
                            case 'O':
                                tmp = board[i][j+1].toString(); //Save the case before eceman walk on it
                                board[i][j] = new Ice(); //Remplace strong ice by ice after eceman walk on it
                                board[i][j+1] = eceman; //Remplace the legit case by eceman
                                break;
                            case 'o':
                                tmp = board[i][j+1].toString();
                                board[i][j] = new MeltedIce(); //Remplace ice by water after eceman walk on it
                                board[i][j+1] = eceman;                         
                                break;
                            default:
                                System.out.println("no legit movement, please try again");
                                break;
                        }
                        n++;
                        if(n == 1){
                            return new Pair<>(board, tmp);
                        }
                    }
                    else if(board[i][j+1].Print() == 'm'){ //If want to move a movable wall
                        tmp = "o"; 
                        board[i][j] = new MeltedIce(); 
                        board[i][j+1] = eceman; 
                        board[i][j+2] = new Wall(); //Move the wall on the board
                    }
                }
            }
        }
        return board;
    }
    
    //Go up for the ennemy
    public static Entity[][] GoUpEnnemy(Entity[][] board){
        int n = 0;
        for (int i = 0; i < nb_lig; i++){
            for(int j = 0; j < nb_col; j++){
                if(board[i][j].Print() == 'G'){ //Found the ennemy on the board
                    if(board[i+1][j].Print() == 'g'){ //Test the legitimacy of the movement
                        board[i][j].rpz = 'g'; //Remplace the ennemy by an ennemy deplacement case
                        board[i+1][j].rpz = 'G'; //Remplace the legit case by the ennemy
                        n++;
                        if(n == 1){
                            return board;
                        }
                    }
                }
            }
        }
        return board;
    }
    
    //Go down for the ennemy
    public static Entity[][] GoDownEnnemy(Entity[][] board){
        int n = 0;
        for (int i = 0; i < nb_lig; i++){
            for(int j = 0; j < nb_col; j++){
                if(board[i][j].Print() == 'G'){ //Found the ennemy on the board
                    if(board[i-1][j].Print() == 'g'){ //Test the legitimacy of the movement
                        board[i][j].rpz = 'g'; //Remplace the ennemy by an ennemy deplacement case
                        board[i-1][j].rpz = 'G'; //Remplace the legit case by the ennemy
                        n++;
                        if(n == 1){
                            return board;
                        }
                    }
                }
            }
        }
        return board;
    }
    
    //Check if the level is finish
    public static boolean CheckEnd(Entity[][] board) {
                
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                //Condition of ending a level : no more ice and portal on the board
                if(board[i][j].Print() == 'P' || board[i][j].Print() == 'o' || board[i][j].Print() == 'O')
                    return false;
            }
        }        
        return true;
    }
        
}