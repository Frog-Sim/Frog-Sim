package entities;

import org.newdawn.slick.Graphics;

public abstract class Entity {
	protected float xPos;
	protected float yPos;
	protected float xVel;
	protected float yVel;
	
	public abstract void update();
	public abstract void render(Graphics g);
	public Entity(float x,float y) { xPos=x; yPos=y; }
}
