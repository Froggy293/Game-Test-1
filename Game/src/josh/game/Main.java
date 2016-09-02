/*
 * Copyright Josh Laubach 2016-2016, All rights reserved, Matt can't claim it as his ever.
 */
package josh.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class Main extends JFrame implements KeyListener{
	Image dbImage;
	Graphics dbg;
	BufferedImage sprite;
	Animator joesh;
	
	int x = 0, y = 0, direction = 0;
	
	public Main(){
		setTitle("That guy");
		setSize(600, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		addKeyListener(this);
		init();
	}
	private void init(){
		BufferedImageLoader bil = new BufferedImageLoader();
		BufferedImage spriteSheet = null;
		try {
			spriteSheet = bil.loadImage("spritesheet.png");
			bil.loadImage("spritesheet.png");
		} catch (IOException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		Sprites s = new Sprites(spriteSheet);
		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>(); 
		switch (direction){
		case 0:
			sprites.add(0, s.grabSprite(3, 3, 46, 60));
			sprites.add(1, s.grabSprite(49, 0, 47, 63));
			sprites.add(2, s.grabSprite(99, 3, 46, 60));
			sprites.add(3, s.grabSprite(148, 0, 47, 63));
			
			joesh = new Animator(sprites);
			joesh.setSpeed(150);//Set time between frames in milliseconds
			joesh.start();
			break;
		case 1:
			sprites.add(0, s.grabSprite(3, 62, 46, 60));
			sprites.add(1, s.grabSprite(48, 64, 47, 63));
			sprites.add(2, s.grabSprite(102, 63, 46, 60));
			sprites.add(3, s.grabSprite(147, 63, 47, 63));
			
			joesh = new Animator(sprites);
			joesh.setSpeed(150);//Set time between frames in milliseconds
			joesh.start();
			break;
		case 2:
			sprites.add(0, s.grabSprite(3, 3, 39, 65));
			sprites.add(1, s.grabSprite(49, 0, 55, 63));
			sprites.add(2, s.grabSprite(99, 3, 41, 63));
			sprites.add(3, s.grabSprite(148, 0, 47, 63));
			
			joesh = new Animator(sprites);
			joesh.setSpeed(150);//Set time between frames in milliseconds
			joesh.start();
			break;
		case 3:
			sprites.add(0, s.grabSprite(3, 3, 46, 60));
			sprites.add(1, s.grabSprite(49, 0, 47, 63));
			sprites.add(2, s.grabSprite(99, 3, 46, 60));
			sprites.add(3, s.grabSprite(148, 0, 47, 63));
			
			joesh = new Animator(sprites);
			joesh.setSpeed(150);//Set time between frames in milliseconds
			joesh.start();
			break;
		default:
			sprites.add(0, s.grabSprite(3, 129, 46, 60));
			sprites.add(1, s.grabSprite(49, 129, 47, 63));
			sprites.add(2, s.grabSprite(102, 129, 46, 60));
			sprites.add(3, s.grabSprite(147, 129, 47, 63));
			
			joesh = new Animator(sprites);
			joesh.setSpeed(150);//Set time between frames in milliseconds
			joesh.start();
			break;
		}	
	}
	
	@Override
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, x, y, null);
	}	
	public void paintComponent(Graphics g){
		if (joesh != null){
			joesh.update(System.currentTimeMillis());
			g.drawImage(joesh.sprite, 100, 100, 50, 50, null);
		}
		repaint();
	}
	public static void main(String[] args){
		Main main = new Main();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(direction);
		if (e.getKeyCode() == 38){//down
			y -= 10;
			direction = 0;
		}else if (e.getKeyCode() == 40){//right
			y += 10;
			direction = 1;
		}else if (e.getKeyCode() == 37){//left
			x -= 10;
			direction = 2;
		}else if (e.getKeyCode() == 39){//up
			x += 10;
			direction = 3;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == 38){//down
			direction = 0;
		}else if (e.getKeyCode() == 40){//right
			direction = 1;
		}else if (e.getKeyCode() == 37){//left
			direction = 2;
		}else if (e.getKeyCode() == 39){//up
			direction = 3;
		}
	}
}
