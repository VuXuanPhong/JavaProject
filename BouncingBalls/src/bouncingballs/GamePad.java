/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs;

import static bouncingballs.Constants.listBall;
import static bouncingballs.Constants.listBomb;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Vu Xuan Phong
 */
public class GamePad extends JPanel implements MouseListener{
     private boolean play = false;
     private Graphics2D g2D;
     public GamePad(){
         addMouseListener(this);
     }

    @Override
    public void paint(Graphics g) {
        g2D = (Graphics2D) g; 
        g.setColor(Color.white);
        g.fillRect(1, 1, 692, 592);
        
        for(int i=0; i<Constants.listBall.size();i++){
            Ball b = listBall.get(i);
            g.setColor(b.color);
            g.fillOval(b.x,b.y, b.width, b.height);
        }
        for(int i=0; i<Constants.listBomb.size();i++){
            Bomb bomb = listBomb.get(i);
            g.drawImage(bomb.image, bomb.x, bomb.y, this);
        }
        g.setColor(Color.BLACK);
        g2D.drawString("Score: " + Constants.Score, 600, 20);
       // if(Constants.gameOver) gameOver();
    }
    public void start(){
        for(int i=0; i<Constants.listBall.size();i++){
            int speed = (int) (Math.random()*(20-10) + 10);
            MovingBall b = new MovingBall(this,listBall.get(i),speed);
            b.start();
        }
        for(int i=0; i<Constants.listBomb.size();i++){
            MovingBomb bomb = new MovingBomb(this,listBomb.get(i));
            bomb.start();
        }
    }
    public void gameOver(){
        g2D.setStroke(new BasicStroke(5.0f));
        g2D.drawString("Game Over!!!\n Score: " +Constants.Score , 300, 230);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Constants.xClick = e.getX();
//        Constants.yClick = e.getY();
//        Constants.Isclick = true;
       // System.out.println(Constants.xClick + " -- "+ Constants.yClick);
        
    }
 
    @Override
    public void mousePressed(MouseEvent e) {
        Constants.xClick = e.getX();
        Constants.yClick = e.getY();
        
        CheckThread check = new CheckThread();
        check.start();
        //Constants.Isclick = true;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
