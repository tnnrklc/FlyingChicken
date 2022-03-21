/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.flyingchickenproject;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
/**
 *
 * @author tennur
 */
public class Game extends JPanel {
    Image img;
    Image intro;
    Image howtoplay;
    Chicken chicken;
    Cat cat;
    Target target;
    int level = 1;
    int score = 0;
    boolean is_started = false;
    boolean is_shot = false;
    
    Game() {
            chicken = new Chicken(this);
            cat = new Cat(this);
            target = new Target(this);
            
            addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				chicken.keyReleased(e);
                                
			}

			@Override
			public void keyPressed(KeyEvent e) {
				chicken.keyPressed(e); 
			}
		});
		setFocusable(true);
        
    }
    
    @Override
	public void paint(Graphics g) {
            
            if(is_started == false) {
                if(score == 0) { 
                img = Toolkit.getDefaultToolkit().getImage("res/background3.png");   
                intro = Toolkit.getDefaultToolkit().getImage("res/intro2.gif");
                howtoplay = Toolkit.getDefaultToolkit().getImage("res/howtoplay2.png");
                g.drawImage(img, 0, 0, this); 
                g.drawImage(intro, 220, 200, this); 
                g.drawImage(howtoplay, 20, 100, this);
                g.setColor(Color.PINK);
                g.setFont(new Font("Courier", 1, 30));
                g.drawString("Press Enter To", 135, 350);
                g.drawString("START", 200, 380);
                }
                
                if(score >= 1200) {
                g.drawImage(img, 0, 0, this); 
                g.setColor(Color.PINK);
                g.setFont(new Font("Courier", 1, 30));
                g.drawString("Completed All Levels" , 80, 300);
                g.drawString("Score: ", 150, 355);
                g.drawString("Press Enter To Start Again", 10, 415);
                g.drawString(Integer.toString(score), 280, 355);
                }
                    
            }
            
            if(is_started == true) {
                g.drawImage(img, 0, 0, this); 
                g.setColor(Color.PINK);
                g.setFont(new Font("Courier", 1, 18));
                g.drawString("Level: ", 10, 30);
                g.drawString(Integer.toString(level), 75, 30);
                g.drawString("Score: ", 100, 30);
                g.drawString(Integer.toString(score), 165, 30);
                chicken.paint(g);
                if(is_shot)
                    {
                        chicken.egg.paint(g);
                    }
                cat.paint(g);
                target.paint(g);
            }
        }
        
        public void move() {
                if(is_started) {
                    chicken.move();
                    if(is_shot)
                    {
                        chicken.egg.move();
                    }
                    cat.move();
                    target.move();
                } 
	}
        
        public void gameOver() {
		JOptionPane.showMessageDialog(this, "Score : " + Integer.toString(score) + "\nTo Play Again Run The Program",
				"Game Over", JOptionPane.YES_NO_OPTION);
                System.exit(0);
	}
        
        public void point(int sc) {
            score += sc;
            if(score >= 300) {
                level = 2;
                img = Toolkit.getDefaultToolkit().getImage("res/background2.png");
            }
            if(score >= 600) {
                level = 3;
                img = Toolkit.getDefaultToolkit().getImage("res/background4.png");
            }
            if(score >= 1200) {
            is_started = false;
            }
            
        }
    
    public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Flying Chicken");
		Game game = new Game();
		frame.add(game);
		frame.setSize(500, 750);
                frame.setResizable(false);
		frame.setVisible(true);
                //frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
                
    }
  
}
