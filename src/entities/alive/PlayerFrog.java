package entities.alive;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import grouping.Pack;

public class PlayerFrog extends Frog{
	private Pack playerPack;

	public PlayerFrog(float x, float y) {
		super(x, y);
		playerPack=new Pack();
		playerPack.addFrog(this);
		// TODO Auto-generated constructor stub
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(xPos, yPos, FROG_SIZE, FROG_SIZE);
		g.setColor(Color.white);
		g.drawString("X: "+xPos, xPos-10, yPos-10);
		g.drawString("Y: "+yPos, xPos-10, yPos-50);
		float testRadius= (float) Math.sqrt(Math.pow(this.height/2, 2)+Math.pow(this.width/2, 2));
		g.drawOval(getCenterX()-testRadius, getCenterY()-testRadius, testRadius*2, testRadius*2);
	}
	public Pack getPack()
	{
		return playerPack;
	}

}