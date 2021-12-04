/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author tad-t
 */
public class Level {
    private final static int nb_col = 15;
    private final static int nb_lig = 19;


     //ajouter au case les autres level et créer la fonction correspondante
    public static Entity[][] Getlevel(int id){
        
        switch(id){
            case 1:
                return Level1();
        }
        return null;
    }
    
    private static Entity[][] Level1(){
        
        Entity[][] board = new Entity[nb_col][nb_lig];
        
        //Empty display
        for(int i = 0; i < nb_col; i++){
            for(int j = 0; j < nb_lig; j++){
                
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
        
        return board;
    }
    
    
    
    public static Entity[][] Update(Entity[][] board,char input){
        
        switch(input){
            case 'z':
                return GoUp(board);
            case 's':
                return GoDown(board);
            case 'q':
                return GoLeft(board);
            case 'd' :
                return GoRight(board);
            default:
                System.out.println("Error Update level switch");
        }
        
        return null;
    }
    
    private static Entity[][] GoUp(Entity[][] board){
        return board;
    }
    
    
    private static Entity[][] GoDown(Entity[][] board){
        return board;
    }
    
    private static Entity[][] GoLeft(Entity[][] board){
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].Print() == 'E'){ //Found eceman on the board
                    if(board[i][j-1].Print() == 'o' || board[i][j-1].Print() == 'P'){ //Test the legitimcy of the movement
                        board[i][j] = new MeltedIce(); //Remplace ice by water after eceman walk on it
                        board[i][j-1] = new Eceman() ; //Remplace the legit case by eceman
                    }
                    else{
                        System.out.println("no legit movement, please try again");
                    }
                }
            }
        }
        return board;
    }
    
    
    private static Entity[][] GoRight(Entity[][] board){
        return board;
    }
    
    public static boolean CheckEnd(Entity[][] board){
        
        
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].Print() == 'o' || board[i][j].Print() == 'O' )
                    return false;
            }
        }
        
        return true;
    }
    
    
}
