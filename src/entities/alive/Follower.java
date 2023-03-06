package entities.alive;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.Game;

public class Follower extends Frog{
	
	public static final float ORBITAL_SIZE=150; 
	private int orbital;
	private int direction;
	
	public Follower(float x, float y) {
		super(x, y);
		orbital=3;
		direction = 1;
		// TODO Auto-generated constructor stub
	}
	public void update() {
		if(inOrbital())
		{
			this.angle= (float) (getAngleToward(Game.bestFrog) + Math.PI/2*direction);
			startJump();
//			startJump((float)(xPos+50*Math.cos(angle)), (float)(yPos+50*Math.sin(angle)));
		}
		else {
			if(getDistance(Game.bestFrog)<orbital*ORBITAL_SIZE)
			{
				this.angle= (float) (getAngleToward(Game.bestFrog) - Math.PI);
				startJump();
			}
			else
			{
				startJump((float)(Game.bestFrog.getX()+200*(Math.random()-0.5f)),(float)(Game.bestFrog.getY()+200*(Math.random()-0.5f)));
			}
				
		}
		super.update();
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(xPos, yPos, FROG_SIZE, FROG_SIZE);
		g.setColor(Color.black);
		g.drawLine(xPos, yPos, (float)(xPos+20*Math.cos(angle)), (float)(yPos+20*Math.sin(angle)));
	}
	public boolean inOrbital()
	{
		return getDistance(Game.bestFrog)<(orbital*ORBITAL_SIZE)+ORBITAL_SIZE/2 && getDistance(Game.bestFrog)>(orbital*ORBITAL_SIZE)-ORBITAL_SIZE/2;
	}
	

}
