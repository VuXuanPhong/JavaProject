/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs;

import java.awt.Image;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Vu Xuan Phong
 */
public class Bomb{
    int x,  y;
    int dirX = -1;
    int dirY = -2;
    public boolean isRuning = true;
    public Image image = null;
    public  Ellipse2D eclipse;
    
    public Bomb(int x, int y, int dir, Image image){
        this.x = x;
        this.y = y;
        
        this.image = image;
        
        eclipse = new Ellipse2D.Double(x, y, 50, 50);
        
        switch (dir) {
           case 1:
               dirX = -1;
               dirY = -2;
               break;
           case 2:
               dirX = 1;
               dirY = -2;
               break;
           case 3:
               dirX = -1;
               dirY = 2;
               break;
           case 4:
               dirX = 1;
               dirY = 2;
               break;
           default:
               break;
       }
    }

    public void move(){
        x += dirX;
        y += dirY;
        if(x<0) dirX = -dirX;
        if(x>630) dirX = -dirX;
        if(y <0) dirY = -dirY;
        if(y >520) dirY = -dirY;
        eclipse.setFrame(x, y, 50, 50);
    }
    
    public boolean isClick(){
        int distance = (this.x - Constants.xClick)*(this.x - Constants.xClick) + (this.y - Constants.yClick)*(this.y - Constants.yClick);
        return distance<= Constants.minDistance;
    }
}
