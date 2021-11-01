/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author louis
 */
public class Game3 {
    
    private Entity[][] board;
    private float time;
    int brokenIce;
    int level;
    
    public Game3(int level){
        
        board = new Entity[15][19];
        time = 0;
        brokenIce = 0;
        this.level = level;
    }
    
    
    public void ReadFile() throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader("Level/level3.txt");
 
        // Declaring loop variable
        int k;
        int i = 0;
        int j = 0;
        
        // Holds true till there is nothing to read
        while ((k = fr.read()) != -1){
            switch(k){
                case (char)'#':
                    board[i][j] = new Void();
                    break;
                case (char)'M':
                    board[i][j] = new Wall();
                    break;
                case (char)'E':
                    board[i][j] = new Eceman();
                    break;
                case (char)'o':
                    board[i][j] = new Ice();
                    break;
                case (char)'P':
                    board[i][j] = new Eportal();
                    break;
                case (char)'O':
                    board[i][j] = new StrongIce();
                    break;
                case (char)'t':
                    board[i][j] = new Mower();
                    break;
                case (char)'L':
                    board[i][j] = new Lightness();
                    break;
                default:
                    break;
            }
            
            
            //System.out.println(i = "i++", j = "j++", char = "+k");
            if( k != 13 && k != 10)
                i++; j++;
        }  
    }
    
    public void ViewBoard(){
        
        for(int i =1; i < 15; i++){
            for(int j = 1; j < 19; j++){
                System.out.print(board[i][j].Print());
                if( (i%15) == 0 && (i%19) == 0)
                    System.out.println();
            }
        }
    }
    
}
