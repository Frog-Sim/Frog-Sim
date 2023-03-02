package entities.alive;

import org.newdawn.slick.Graphics;

import entities.Entity;

public abstract class Animal extends Entity{
	public Animal(float x, float y) { super(x,y); }
	public void update()
	{
		this.xPos += xVel;
		this.yPos += yVel;
	}
}
