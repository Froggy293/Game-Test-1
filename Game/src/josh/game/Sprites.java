package josh.game;

import java.awt.image.BufferedImage;

public class Sprites {
	
	public BufferedImage spriteSheet;	
	public Sprites(BufferedImage ss){
		this.spriteSheet = ss;
	}
	public BufferedImage grabSprite(int x, int y, int width, int height){
		BufferedImage sprite = spriteSheet.getSubimage(x, y, width, height);
		return sprite;
	}
}
