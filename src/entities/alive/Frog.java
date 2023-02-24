package entities.alive;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Frog extends Animal{

	private static final int frogSize=100;
	public Frog(float x, float y) { super(x, y); }
	public void update() {}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(xPos, yPos, frogSize, frogSize);
	}
}
