package entities;

import org.newdawn.slick.Graphics;

import core.Game;
import entities.alive.Frog;
import entities.alive.PlayerFrog;

import org.newdawn.slick.geom.Point;

public abstract class Entity {
	protected float xPos;
	protected float yPos;
	protected float xVel;
	protected float yVel;
	protected float angle;
	protected float height;
	protected float width;
	
	public abstract void update();
	public abstract void render(Graphics g);
	public Entity(float x,float y, float width, float height) { xPos=x; yPos=y; this.width=width; this.height= height;}
	
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
	public final float getAngleToward(Entity frog) 
	{
		float yDiff = frog.getY() - yPos;
		float xDiff = frog.getX() - xPos;

		float angle = (float) Math.atan2(yDiff, xDiff);

//		if (angle < 0) 
//		{
//			angle = 360 + angle;
//		}

		return angle;
	}
	public float getX() {return xPos;}
	public float getY() {return yPos;}
	public float getCenterX()
	{
		return this.getX()+this.width/2;
	}
	public float getCenterY()
	{
		return this.getY()+this.height/2;
	}
	public float getDistance(Point p)
	{
		return (float) Math.sqrt(Math.pow(getCenterX()-p.getX(), 2)+Math.pow(getCenterY()-p.getY(), 2));
	}

	protected float getDistance(Entity e) {
		return (float) Math.sqrt(Math.pow(getCenterX()-e.getCenterX(), 2)+Math.pow(getCenterY()-e.getCenterY(), 2));
	}
	public boolean collideWith(Entity e)
	{
		if(getDistance(e)>0.5*(Math.sqrt(Math.pow(this.height/2, 2)+Math.pow(this.width/2, 2))+Math.sqrt(Math.pow(e.height/2, 2)+Math.pow(e.width/2, 2))))
		{
			return false;
		}
		else
		{
	    	return true;
	    }
	}
}
