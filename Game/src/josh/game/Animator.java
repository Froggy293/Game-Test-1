package josh.game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animator {
	ArrayList<BufferedImage> frames;
	public BufferedImage sprite;
	private volatile boolean running = false;
	private long previousTime, speed;
	private int frameAtPause, currentFrame;
	public Animator(ArrayList<BufferedImage> frames){
		this.frames = frames;
	}
	public void setSpeed(long speed){
		this.speed = speed;
	}
	public void update(long time){
		if(running){
			if (time - previousTime >= speed){
				//Update the animation
				currentFrame++;
				try{
					sprite = frames.get(currentFrame);
				}catch(IndexOutOfBoundsException ex){
					currentFrame = 0;
					sprite = frames.get(currentFrame);
				}
				previousTime = time;
			}
		}
	}
	public void start(){
		running = true;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	public void stop(){
		running = false;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	public void pause(){
		frameAtPause = currentFrame;
		running = false;
	}
	public void resume(){
		frameAtPause = currentFrame;
		running = true;
	}
}
