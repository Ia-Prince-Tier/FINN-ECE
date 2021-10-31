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
public class Game {
    private Entity[] board;
    private float time;
    int brokenIce;
    int level;
    
    public Game(int level){
        board = new Entity[15*15];
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
                case 13:
                    break;
                case 15:
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
        for(int i =1; i < 15*15; i++){
            System.out.print(board[i].Print());
            if( (i%15) == 0 )
                System.out.println();
        }
    }
    
}
