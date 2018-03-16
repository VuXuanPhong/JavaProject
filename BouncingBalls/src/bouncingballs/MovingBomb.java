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

public class MovingBomb extends Thread {
    GamePad GamePad;
    Bomb b;
    public MovingBomb(GamePad Pad, Bomb b ){
        this.GamePad = Pad;
        this.b = b;
    }
    @Override
    public void run() {
        while(b.isRuning){
            try {
                Moving();
            } catch (InterruptedException ex) {
                Logger.getLogger(MovingBall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        b.image = Constants.imageBombNo;
        GamePad.repaint();
        
        try {
            Thread.sleep(1000);
            //System.out.println("Hello : ))");
        } catch (InterruptedException ex) {
            Logger.getLogger(MovingBomb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Constants.listBomb.remove(b);
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(MovingBomb.class.getName()).log(Level.SEVERE, null, ex);
        }
        GamePad.repaint();
    }
    
    public void Moving() throws InterruptedException{
            b.move();
            Thread.sleep(10);
            GamePad.repaint();
    }
}
