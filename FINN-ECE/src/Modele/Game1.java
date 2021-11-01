/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.io.*;

/**
 *
 * @author tad-t
 */
public class Game1 {
    
    private Entity[] board;
    private float time;
    int brokenIce;
    int level;
    
    public Game1(int level){
        
        board = new Entity[15*19];
        time = 0;
        brokenIce = 0;
        this.level = level;
    }
    
    
    public void ReadFile() throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader("level/level1.txt");
 
        // Declaring loop variable
        int k;
        int i = 0;
        
        // Holds true till there is nothing to read
        while ((k = fr.read()) != -1){
            
            switch(k){
                case (char)'#':
                    board[i] = new Void();
                    break;
                case (char)'M':
                    board[i] = new Wall();
                    break;
                case (char)'E':
                    board[i] = new Eceman();
                    break;
                case (char)'o':
                    board[i] = new Ice();
                    break;
                case (char)'P':
                    board[i] = new Eportal();
                    break;
                default:
                    break;
            }
            
            
            //System.out.println("i ="+i+" char = "+k);
            if( k != 13 && k != 10)
                i++;
        }  
    }
    
        public void ViewBoard(){
            for(int i =1; i < 15*19; i++){
                System.out.print(board[i].Print());
                if( (i%19) == 0 )
                    System.out.println();
            }
        }
}
    
    /*
    public void GoLeft(){
        
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].equals('E')){
                    if(board[i][j-1].equals('o') || board[i][j-1].equals('P')){
                        board[i][j] = new MeltIce();
                        board[i][j-1] = new Eceman();
                    }
                }
            }
        }
    }
    
    public void GoRight(){
        
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].equals('E')){
                    if(board[i][j+1].equals('o') || board[i][j+1].equals('P')){
                        board[i][j] = new MeltIce();
                        board[i][j+1] = new Eceman();
                    }
                }
            }
        }
    }
    
    public void GoUp(){
        
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].equals('E')){
                    if(board[i-1][j].equals('o') || board[i-1][j].equals('P')){
                        board[i][j] = new MeltIce();
                        board[i-1][j] = new Eceman();
                    }
                }
            }
        }
    }
    
    public void GoDown(){
        
        for(int i = 0; i < 15; i++){           
            for(int j = 0; j < 19; j++){
                if(board[i][j].equals('E')){
                    if(board[i+1][j].equals('o') || board[i+1][j].equals('P')){
                        board[i][j] = new MeltIce();
                        board[i+1][j] = new Eceman();
                    }
                }
            }
        }
    }
    */

