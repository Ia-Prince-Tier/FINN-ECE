/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author louis
 */
public class Level2 {
    
    private int nb_col;
    private int nb_lin;
    private char board[][];
    private char tmp;

    public Level2(int nb_col, int nb_lin) {
        this.nb_col = nb_col;
        this.nb_lin = nb_lin;
        
        board = new char[nb_col][nb_lin];
        
        //Empty display
        for(int i = 0; i < nb_col; i++){
            for(int j = 0; j < nb_lin; j++){
                
                board[i][j] = '#';
            }
        }
        
        //Wall display
        for(int k = 7; k <= 9; k++){
            
            board[k][1] = 'M';
        }
        for(int k = 7; k <= 9; k++){
            
            board[k][15] = 'M';
        }
        for(int k = 1; k <= 15; k++){
            
            board[7][k] = 'M';
        }
        for(int k = 1; k <= 15; k++){
            
            board[9][k] = 'M';
        }
        
        //Ice display
        for(int k = 8; k <= 13; k++){
            
            board[8][k] = 'o';
        }
        
        //Strong ice display
        for(int k = 3; k <= 7; k++){
            
            board[8][k] = 'O';
        }
        
        //Portal display
        board[8][2] = 'P';
        
        //Eceman display
        board[8][14] = 'E';
    }
    
    public void DisplayLevel2(){ //Board display in console
        
        System.out.println();
        
        for(int i = 0; i < nb_col; i++){
            for(int j = 0; j < nb_lin; j++){
                
                System.out.print(" | " + board[i][j]);
            }
            System.out.println(" | ");
        }    
        System.out.println();
    }
    
    public void GoLeft(){ //Go left
        
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j] == 'E'){ //Found eceman on the board
                    if(board[i][j-1] == 'o' || board[i][j-1] == 'O'){ //Test the legitimcy of the movement
                        if(tmp == 'O'){
                            this.tmp = board[i][j-1];
                            board[i][j] = 'o'; //Remplace ice by water after eceman walk on it
                            board[i][j-1] = 'E'; //Remplace the legit case by eceman
                        }
                        else{
                            this.tmp = board[i][j-1];
                            board[i][j] = 'w'; //Remplace ice by water after eceman walk on it
                            board[i][j-1] = 'E'; //Remplace the legit case by eceman
                        }                        
                    }
                    else{
                        System.out.println("no legit movement, please try again");
                    }
                }
            }
        }
    }
    
    public void GoRight(){ //Go right
        
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j] == 'E'){ //Found eceman on the board
                    if(board[i][j+1] == 'o' || board[i][j+1] == 'O'){ //Test the legitimcy of the movement
                        if(tmp == 'O'){
                            this.tmp = board[i][j+1];
                            board[i][j] = 'o'; //Remplace ice by water after eceman walk on it
                            board[i][j+1] = 'E'; //Remplace the legit case by eceman
                        }
                        else{
                            this.tmp = board[i][j+1];
                            board[i][j] = 'w'; //Remplace ice by water after eceman walk on it
                            board[i][j+1] = 'E'; //Remplace the legit case by eceman
                        }                        
                    }
                    else{
                        System.out.println("no legit movement, please try again");
                    }
                }
            }
        }
    }
    
    public void GoUp(){ //Go up
        
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j] == 'E'){ //Found eceman on the board
                    if(board[i-1][j] == 'o' || board[i-1][j] == 'O'){ //Test the legitimcy of the movement
                        if(tmp == 'O'){
                            this.tmp = board[i-1][j];
                            board[i][j] = 'o'; //Remplace ice by water after eceman walk on it
                            board[i-1][j] = 'E'; //Remplace the legit case by eceman
                        }
                        else{
                            this.tmp = board[i-1][j];
                            board[i][j] = 'w'; //Remplace ice by water after eceman walk on it
                            board[i-1][j] = 'E'; //Remplace the legit case by eceman
                        }                        
                    }
                    else{
                        System.out.println("no legit movement, please try again");
                    }
                }
            }
        }
    }
    
    public void GoDown(){ //Go down
        
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j] == 'E'){ //Found eceman on the board
                    if(board[i+1][j] == 'o' || board[i+1][j] == 'O'){ //Test the legitimcy of the movement
                        if(tmp == 'O'){
                            this.tmp = board[i+1][j];
                            board[i][j] = 'o'; //Remplace ice by water after eceman walk on it
                            board[i+1][j] = 'E'; //Remplace the legit case by eceman
                        }
                        else{
                            this.tmp = board[i+1][j];
                            board[i][j] = 'w'; //Remplace ice by water after eceman walk on it
                            board[i+1][j] = 'E'; //Remplace the legit case by eceman
                        }
                    }
                    else{
                        System.out.println("no legit movement, please try again");
                    }
                }
            }
        }
    }
}
