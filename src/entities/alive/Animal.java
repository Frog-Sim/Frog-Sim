package entities.alive;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import core.Game;
import entities.Entity;

public abstract class Animal extends Entity{
	public Animal(float x, float y, float width, float height) { super(x,y,width,height); }
	protected float health;
	protected float attackSpeed;
	protected float attackDamage;
	public void update()
	{
		xPos=this.xPos += xVel;
		yPos=this.yPos += yVel;
		ArrayList<Entity> allEntities=Game.getEntities();
		for(Entity e: allEntities)
		{
			if(collideWith(e) && e!=this)
			{
				angle=(float) (getAngleToward(e)+Math.PI);
				xPos=this.xPos -= xVel;
				yPos=this.yPos -= yVel;
				xPos+=(float)(10*Math.cos(angle));
				yPos+=(float)(10*Math.sin(angle));
				return;
			}
		}
		
	}
}
