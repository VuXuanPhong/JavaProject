/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingballs;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Vu Xuan Phong
 */
public class BouncingBalls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Constants constants = new Constants();
        Constants.numberOfBall = 20;
        Constants.numberOfBomb = 5;
        Constants.createListBall();
        Constants.createListBomb();
        
        JFrame obj = new JFrame();
        GamePad gamePad = new GamePad();
        gamePad.start();
        
        obj.getContentPane().add(gamePad);
        
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Moving Ball");
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        CheckingClick check = new CheckingClick();
//        check.start();
    }
    
}
