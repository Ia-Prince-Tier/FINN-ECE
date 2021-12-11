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
    
 
    private static Entity[][] Level3(){
        
        Entity[][] board = new Entity[nb_col][nb_lig];
        
        //Empty display
        for(int i = 0; i < nb_col; i++){
            for(int j = 0; j < nb_lig; j++){
                
                board[i][j] = new Void();
            }
        }
        
        //Wall display
        for(int k = 3; k <= 11; k++){
            
            board[7][k] = new Wall();
        }
        for(int k = 3; k <= 11; k++){
            
            board[14][k] = new Wall();
        }
        
        for(int k = 3; k <= 11; k++){
            
            board[8][k] = new Wall();
        }
        for(int k = 3; k <= 11; k++){
            
            board[9][k] = new Wall();
        }
    
        for(int k = 3; k <= 11; k++){
            
            board[10][k] = new Wall();
        }
        
        for(int k = 3; k <= 11; k++){
            
            board[11][k] = new Wall();
        }
    
        for(int k = 3; k <= 11; k++){
            
            board[12][k] = new Wall();
        }
    
        for(int k = 3; k <= 11; k++){
            
            board[13][k] = new Wall();
        }
    
        //Ice display
        for(int k = 4; k <= 6; k++){
            
            board[8][k] = new Ice();
        }
    
        for(int k = 8; k <= 9; k++){
            
            board[13][k] = new Ice();
        }
    
        for(int k = 9; k <= 11; k++){
            
            board[k][6] = new Ice();
        }
    
        for(int k = 9; k <= 11; k++){
            
            board[k][8] = new Ice();
        }
    
        for(int k = 9; k <= 12; k++){
            
            board[k][10] = new Ice();
        }
    
        board[12][7] = new Ice();
        
        //Portal display
        board[9][3] = new Eportal();
        
        //Eceman display
        board[13][11] = new Eceman();
    
        //Potion de legerete display
        board[13][10] = new Popol();
    
        //Tondeuse display
        board[12][8] = new tondeuse();
    
        //movin bricks display
        board [9][4] = new Mbrick ();
        board [12][6] = new Mbrick ();
    
        //Fusion Wall Display 
        board [10][4] = new FusionWall ();
        board [12][5] = new FusionWall ();
        
        return board;
    }
    
    private static Entity[][] Level5(){
        
        Entity[][] board = new Entity[nb_col][nb_lig];
        
        //Empty display
        for(int i = 0; i < nb_col; i++){
            for(int j = 0; j < nb_lig; j++){
                
                board[i][j] = new Void();
            }
        }
        
        //Wall display
        for(int k = 2; k <= 11; k++){
            
            board[k][4] = new Wall();
        }
        for(int k = 2; k <= 11; k++){
            
            board[k][6] = new Wall();
        }
        for(int k = 1; k <= 9; k++){
            
            board[5][k] = new Wall();
        }
        for(int k = 1; k <= 9; k++){
            
            board[7][k] = new Wall();
        }
        
        //Ice display
        for(int k = 3; k <= 10; k++){
            
            board[k][5] = new Ice();
        }
        
        //Portal display
        board[3][5] = new Eportal();
        
        //Eceman display
        board[10][5] = new Eceman();
        
        //Ennemi display
        board[6][5] = new Ennemy();
        
        //Eceman move tiles display
       for(int k = 2; k <= 8; k++){
            
            board[6][k] = new Wall();
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
