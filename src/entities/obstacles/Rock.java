package entities.obstacles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import entities.Entity;

public class Rock extends Entity{
	public Rock(float x, float y) { super(x,y,128,128); }
	public void update() {}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(xPos, yPos, height, width);
		float testRadius= (float) Math.sqrt(Math.pow(this.height/2, 2)+Math.pow(this.width/2, 2));
		g.drawOval(getCenterX()-testRadius, getCenterY()-testRadius, testRadius*2, testRadius*2);
	}
}
