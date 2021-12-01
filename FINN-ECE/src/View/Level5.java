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
public class Level5 {
    
    private int nb_col;
    private int nb_lin;
    private char board[][];

    public Level5(int nb_col, int nb_lin) {
        this.nb_col = nb_col;
        this.nb_lin = nb_lin;
    }
    
    public void DisplayLevel5(){ //Board display in console
        
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
                    if(board[i][j-1] == 'o' || board[i][j-1] == 'P'){ //Test the legitimcy of the movement
                        board[i][j] = 'w'; //Remplace ice by water after eceman walk on it
                        board[i][j-1] = 'E'; //Remplace the legit case by eceman
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
                    if(board[i][j+1] == 'o' || board[i][j+1] == 'P'){ //Test the legitimcy of the movement
                        board[i][j] = 'w'; //Remplace ice by water after eceman walk on it
                        board[i][j+1] = 'E'; //Remplace the legit case by eceman
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
                    if(board[i-1][j] == 'o' || board[i-1][j] == 'P'){ //Test the legitimcy of the movement
                        board[i][j] = 'w'; //Remplace ice by water after eceman walk on it
                        board[i-1][j] = 'E'; //Remplace the legit case by eceman
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
                    if(board[i+1][j] == 'o' || board[i+1][j] == 'P'){ //Test the legitimcy of the movement
                        board[i][j] = 'w'; //Remplace ice by water after eceman walk on it
                        board[i+1][j] = 'E'; //Remplace the legit case by eceman
                    }
                    else{
                        System.out.println("no legit movement, please try again");
                    }
                }
            }
        }
    }
}
