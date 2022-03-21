/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.flyingchickenproject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

/**
 *
 * @author tennur
 */
public class Chicken {
    
    Game game;
    Egg egg;
    Image img;
    int x = 0;
    int y = 75;
    int xa = 0;
    int width = 82;
    int height = 82;
    //boolean is_shot = false;
    String shot = "";
    
    public Chicken(Game game) {
		this.game = game;
                egg = new Egg(this);
                img = Toolkit.getDefaultToolkit().getImage("res/chickenright.png");
	}
    
    public void paint(Graphics g) {
		g.drawImage(img,x,y,game);
	}
    
    public void move() {
		if (x + xa > 0 && x + xa < 415)
			x = x + xa;
	}
    
    public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
    
    public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {   
                    if(game.score == 0) {
                        game.is_started = true;
                    }
                      
                        
                    else if(game.score >= 1200)
                    {
                        game.is_started = false;
                        game.score = 0;
                        game.level = 1;
                    }
                } 
		
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                {   
                    img = Toolkit.getDefaultToolkit().getImage("res/chickenleft.png");
                    xa = -1;
                }
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    img = Toolkit.getDefaultToolkit().getImage("res/chickenright.png");
	            xa = 1;     
                }
                if (e.getKeyCode() == KeyEvent.VK_D)
                {   
                    game.is_shot = true;
                    egg = new Egg(this);
                    shot = "right";
                } 
                if (e.getKeyCode() == KeyEvent.VK_A)
                {   
                    game.is_shot = true;
                    egg = new Egg(this);
                    shot = "left";
                }
	}
        
        public int getX()
        {
            return x;
        }
        
        public int getY()
        {
            return y;
        }
    
    
}
