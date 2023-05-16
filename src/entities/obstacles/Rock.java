package entities.obstacles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import entities.Entity;
import environment.biomes.Biome;
import environment.biomes.Grass;
import environment.biomes.Sand;
import environment.biomes.Snow;
import environment.biomes.Water;
import media.ImageLoader;

public class Rock extends Entity{
	private Color colorAccent;
	private Image image;
	public Rock(float x, float y) { 
		super(x,y,128,128); 
		image=ImageLoader.boulder;
	}
	public void update() {}
	public void render(Graphics g) {
		image.draw(xPos,yPos, colorAccent);
	}
	public void colorChange(Biome b) {
		if(b instanceof Grass) {
			colorAccent = new Color((int) (Math.random() * 255), (int) (Math.random() * 80)+175, (int) (Math.random() * 255));
		} else if (b instanceof Water) {
			colorAccent = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 80)+175);
		} else if (b instanceof Sand) {
			colorAccent = new Color((int) ((int) (Math.random() * 50)+205), (int) (Math.random() * 50)+205, (int) (Math.random() * 255));
		} else if (b instanceof Snow) {
			colorAccent = new Color((int) (Math.random() * 80)+175, (int) (Math.random() * 80)+175, (int) (Math.random() * 80)+175);
		}
	}
}
