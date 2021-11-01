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
    
    private Entity[] board;
    private float time;
    int brokenIce;
    int level;
    
    public Game3(int level){
        
        board = new Entity[15*19];
        time = 0;
        brokenIce = 0;
        this.level = level;
    }
    
    
    public void ReadFile() throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader("level/level3.txt");
 
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
                case (char)'O':
                    board[i] = new StrongIce();
                    break;
                case (char)'t':
                    board[i] = new Mower();
                    break;
                case (char)'L':
                    board[i] = new Lightness();
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
