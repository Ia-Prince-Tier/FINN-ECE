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
    private final static int nb_lig = 15;
    private final static int nb_col = 19;


     //ajouter au case les autres level et créer la fonction correspondante
    public static Entity[][] Getlevel(int id){
        
        switch(id){
            case 1:
                return Level1();
        }
        return null;
    }
    
    private static Entity[][] Level1(){
        
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
        
        return board;
    }
    
 
    private static Entity[][] Level3(){
        
        Entity[][] board = new Entity[nb_lig][nb_col];
        
        //Empty display
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
        board[8][12] = new tondeuse();
    
        //movin bricks display
        board [4][9] = new Mbrick ();
        board [6][12] = new Mbrick ();
    
        //Fusion Wall Display 
        board [4][10] = new FusionWall ();
        board [5][12] = new FusionWall ();
        
        return board;
    }
    
    private static Entity[][] Level5(){
        
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
        
        //Ice display
        for(int k = 3; k <= 10; k++){
            
            board[5][k] = new Ice();
        }
        
        //Portal display
        board[5][3] = new Eportal();
        
        //Eceman display
        board[5][10] = new Eceman();
        
        //Ennemi display
        board[5][6] = new Ennemy();
        
        //Eceman move tiles display
       for(int k = 2; k <= 8; k++){
            
            board[k][6] = new Wall();
        }
        
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
