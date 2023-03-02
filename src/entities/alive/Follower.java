package entities.alive;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.Game;

public class Follower extends Frog{

	private int orbital;
	private int direction;
	
	public Follower(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	public void update() {
		if(canJump)
		{
			startJump((float)(Game.bestFrog.getX()+200*(Math.random()-0.5f)),(float)(Game.bestFrog.getY()+200*(Math.random()-0.5f)));
			
		}
		super.update();
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(xPos, yPos, FROG_SIZE, FROG_SIZE);
	}

}
