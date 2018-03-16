/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Vu Xuan Phong
 */
public class Constants {
    public static ArrayList<Ball> listBall = new ArrayList<Ball>();
    public static ArrayList<Bomb> listBomb = new ArrayList<Bomb>();
    public static Image imageBomb = null;
    public static Image imageBombNo = null;
    public static int Score = 0;
    public static int numberOfBall = 1;
    public static int numberOfBomb = 1;
    public static int xClick = -1;
    public static int yClick = -1;
    public static int minDistance = 400;
    public static boolean Isclick = false;
    public static boolean gameOver = false;
   
    public Constants(){
         try {
            imageBomb = ImageIO.read(getClass().getResource("/image/bomb0.png"));
           
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try {
            imageBombNo = ImageIO.read(getClass().getResource("/image/bombNo.png"));
           
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    public static void createListBall(){
        Random r = new Random();
        for(int i=0;i<numberOfBall;i++){
            int x = (int) (Math.random()*(640 -20) + 20);
            int y = (int) (Math.random()*(520 -20) + 20);
            int dir = (int) (Math.random()*(4-1) +1);
            int size = 50;
            Color c=new Color(r.nextInt(250)+1,r.nextInt(250)+1,r.nextInt(250)+1,r.nextInt(250)+1);
            c.brighter();
            Ball b = new Ball(x,y,size,size,c,dir);
            listBall.add(b);
        }
    }
        public static void createListBomb(){
        Random r = new Random();
        for(int i=0;i<numberOfBomb;i++){
            int x = (int) (Math.random()*(620 -20) + 20);
            int y = (int) (Math.random()*(500 -20) + 20);
            int dir = (int) (Math.random()*(4-1) +1);
            //Color c=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
            
            Bomb b = new Bomb(x,y,dir,Constants.imageBomb);
            listBomb.add(b);
        }
    }
}
