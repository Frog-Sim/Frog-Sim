package entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

import core.Game;

public abstract class Entity {
	protected float xPos;
	protected float yPos;
	protected float xVel;
	protected float yVel;
	protected float angle;
	
	public abstract void update();
	public abstract void render(Graphics g);
	public Entity(float x,float y) { xPos=x; yPos=y; 
	}
	
	public final float getAngleToward(float targetX, float targetY) 
	{
		float yDiff = targetY - yPos;
		float xDiff = targetX - xPos;

		float angle = (float) Math.atan2(yDiff, xDiff);

//		if (angle < 0) 
//		{
//			angle = 360 + angle;
//		}

		return angle;
	}
	
	public float getX()
	{
		return xPos;
	}
	public float getY()
	{
		return yPos;
	}
	public float getDistance(Point p)
	{
		return (float) Math.sqrt(Math.pow(xPos-p.getX(), 2)+Math.pow(yPos-p.getY(), 2));
	}
}
