/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Vu Xuan Phong
 */
public class Ball {
   public int x, y, width, height;
   public Color color = Color.red;
   boolean running = true;
   int dirX = -1;
   int dirY = -2;
   public  Ellipse2D eclipse;
   public Ball(int x, int y, int width, int height, Color color, int dir){
       this.x = x;
       this.y = y;
       this.width = width;
       this.height = height;
       this.color = color;
       eclipse = new Ellipse2D.Double(x, y, width, height);
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
        if(x>(690 - this.width)) dirX = -dirX;
        if(y <0) dirY = -dirY;
        if(y > (570 - this.width)) dirY = -dirY;
        //eclipse = new  Ellipse2D.Double(x, y, width, height);
        eclipse.setFrame(x, y, this.width, this.height);
    }
    
    public boolean isClick(){
        int distance = (this.x - Constants.xClick)*(this.x - Constants.xClick) + (this.y - Constants.yClick)*(this.y - Constants.yClick);
        Constants.xClick = -1;
        Constants.yClick = -1;
        return distance<= Constants.minDistance;
    }


}
