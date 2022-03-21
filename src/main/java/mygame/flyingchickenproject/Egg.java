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

/**
 *
 * @author tennur
 */
public class Egg {
    
    Image img;
    Chicken chicken;
    int eggLimit = 5;
    int x;
    int y;
    int xa = 2;
    int width = 50;
    int height = 55;
    
    public Egg(Chicken chicken) {
		this.chicken = chicken;
                if(chicken.game.is_shot)
                {
                    x = chicken.getX();
                    y = chicken.getY();
                    img = Toolkit.getDefaultToolkit().getImage("res/goldenegg.png");
                }
	}
    
    public void paint(Graphics g) {
        g.drawImage(img,x,y,chicken.game);
    }
    
    public void move() {
                
		if (chicken.shot == "right")
			x = x + xa;
                if(chicken.shot == "left")
                    x = x - xa;
	}
    
    public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
    
}
