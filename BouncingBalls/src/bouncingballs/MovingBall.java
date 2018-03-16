/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu Xuan Phong
 */
public class MovingBall extends Thread{
    GamePad GamePad;
    Ball b;
    int speed;
    public MovingBall(GamePad Pad, Ball b , int speed){
        this.GamePad = Pad;
        this.b = b;
        this.speed = speed;
    }
    
    @Override
    public void run() {
        while(b.running){
            try {
                    Moving();
//                    if(Constants.Isclick ){
//                        if(b.eclipse.contains(Constants.xClick, Constants.yClick)) b.running = false;
//                        Constants.Isclick = false;
//                    }
            } catch (InterruptedException ex) {
                Logger.getLogger(MovingBall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        int width = b.width;
        int height = b.height;
        b.height = (int) (1.2*height);
        GamePad.repaint();
        
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(MovingBall.class.getName()).log(Level.SEVERE, null, ex);
        }
        b.height = height;
        b.width = (int) (1.3*width);
        GamePad.repaint();
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(MovingBall.class.getName()).log(Level.SEVERE, null, ex);
        }
        Constants.listBall.remove(b);
        GamePad.repaint();
    }
    
    public void Moving() throws InterruptedException{
            b.move();
            Thread.sleep(this.speed);
            GamePad.repaint();
            //Constants.Isclick = false;
    }
    
}
