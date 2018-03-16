/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu Xuan Phong
 */
public class CheckThread extends Thread {

    @Override
    public void run() {
        //super.run(); //To change body of generated methods, choose Tools | Templates.
        for(int i =0; i<Constants.listBall.size(); i++){
            Ball b = Constants.listBall.get(i);
            if(b.eclipse.contains(Constants.xClick, Constants.yClick)){
                b.running = false;
                Constants.Score++;
               // Constants.listBall.remove(b);
            }
        }
        
        for(int i =0; i<Constants.listBomb.size(); i++){
            Bomb b = Constants.listBomb.get(i);
            
            if(b.eclipse.contains(Constants.xClick, Constants.yClick)){
                
               for(int j =0; j<Constants.listBomb.size(); j++){
                    Bomb bomb = Constants.listBomb.get(j);
                    bomb.isRuning = false;
                }
                
                for(int j =0; j<Constants.listBall.size(); j++){
                    Ball ball = Constants.listBall.get(j);
                    ball.running = false;
                }
                
                //Constants.listBomb.removeAll(Constants.listBomb);
                Constants.listBall.removeAll(Constants.listBall);
               // Constants.gameOver = true;
               
                 
               // Constants.listBall.remove(b);
            }
        }
    }
    
}
