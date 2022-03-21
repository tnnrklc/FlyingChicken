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
public class Cat {
    
    Game game;
    Image img;
    int max = 420;
    int min = 0;
    int x = (int)Math.floor(Math.random()*(max-min+1)+min);
    int y = 780;
    int ya = 1;
    int width = 80;
    int height = 140;
    
    
    public Cat(Game game) {
		this.game = game;
                img = Toolkit.getDefaultToolkit().getImage("res/cat.png");
	}
    
    public void paint(Graphics g) {
		g.drawImage(img,x,y,game);
	}
    
    public void move() {
        if(game.level == 2)
            ya = 2;
        if(game.level == 3)
            ya = 3;
        if(collision())
            {
                game.gameOver();
            }
        if(y - ya <= -100) 
            {
                x = (int)Math.floor(Math.random()*(max-min+1)+min);
                y = 750;
            }
        else if(y - ya > -100)
            y = y - ya;
            
	}
    
    public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
    
    public boolean collision() {
		return game.chicken.getBounds().intersects(getBounds());
	}
    
}
