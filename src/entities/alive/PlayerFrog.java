package entities.alive;

import core.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class PlayerFrog extends Frog{

	public PlayerFrog(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(xPos, yPos, FROG_SIZE, FROG_SIZE);
	}
}
