package entities.alive;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Wanderer extends Frog{
	public Wanderer(float x, float y) { super(x,y); }
	public void update() {
		if(jumpCooldown<-60)
		{
			startJump((float)(Math.random()*2*Math.PI));
			
		}
		super.update();
	}
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(xPos, yPos, FROG_SIZE, FROG_SIZE);
	}
}
