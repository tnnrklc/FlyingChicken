/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.flyingchickenproject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

/**
 *
 * @author tennur
 */
public class Target {
    
    Game game;
    Random Index;
    int[] places = {0,50,420,425};
    Image img[] = new Image[3];
    Image target;
    int indexX;
    int indexTarget = 0;
    int x;
    int y = 750;
    int ya = 2;
    int points;
    int width;
    int height;
    
    public Target(Game game) {
		this.game = game;
                img[0] = Toolkit.getDefaultToolkit().getImage("res/target1.png");
                img[1] = Toolkit.getDefaultToolkit().getImage("res/target2.png");
                img[2] = Toolkit.getDefaultToolkit().getImage("res/target3.png");
                Index = new Random();
                indexX = Index.nextInt(places.length);
                x = places[indexX];
                indexTarget = Index.nextInt(img.length);
                target = img[indexTarget];
                if(indexTarget == 0) {
                    points = 50;
                    width = 48;
                    height = 54;
                }
                
                else if(indexTarget == 1) {
                    points = 75;
                    width = 54;
                    height = 64;
                }
                else if(indexTarget == 2) {
                    points = 100;
                    width = 59;
                    height = 76;
                }
	}
    
    public void paint(Graphics g) {
		g.drawImage(target,x,y,game);
	}
    
    public void move() {
        if(game.level == 2)
            ya = 2;
        if(game.level == 3)
            ya = 3;
        if(y - ya <= -100) 
            {   
                indexX = Index.nextInt(places.length);
                x = places[indexX];
                indexTarget = Index.nextInt(img.length);
                target = img[indexTarget];
                y = 750;
                if(indexTarget == 0) {
                    points = 50;
                    width = 48;
                    height = 54;
                }
                
                else if(indexTarget == 1) {
                    points = 75;
                    width = 54;
                    height = 64;
                }
                else if(indexTarget == 2) {
                    points = 100;
                    width = 59;
                    height = 76;
                }
            }
        else if(y - ya > -100)
            y = y - ya;
        if(collision() && game.is_shot)
         {
             game.point(points);
             resetTarget();
             game.is_shot = false;
         }
	}
    
    public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
    
    public boolean collision() {
		return game.chicken.egg.getBounds().intersects(getBounds());
	}
    
    public void resetTarget() {
        indexX = Index.nextInt(places.length);
        x = places[indexX];
        indexTarget = Index.nextInt(img.length);
        target = img[indexTarget];
        if(indexTarget == 0) {
                    points = 50;
                    width = 48;
                    height = 54;
                }
                
                else if(indexTarget == 1) {
                    points = 75;
                    width = 54;
                    height = 64;
                }
                else if(indexTarget == 2) {
                    points = 100;
                    width = 59;
                    height = 76;
                } 
        y = 750;
        
    }
          
}
