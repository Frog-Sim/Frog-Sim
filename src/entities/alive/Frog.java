package entities.alive;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Frog extends Animal{

	protected static final int FROG_SIZE=100;
	private float curJumpTime;
	private float jumpTimer;
	private float jumpCooldown;
	private float jumpDistance;
	private boolean isJumping;
	private boolean canJump;
	public Frog(float x, float y) { super(x, y); jumpTimer=30; jumpDistance=400; canJump=true; }
	public void update() {
		if(isJumping)
		{
			jump();
		}
		else {
			jumpCooldown--;
			canJump = jumpCooldown<0;
		}
		super.update();
			
		}
	private void jump() {
		curJumpTime++;
		if(curJumpTime>jumpTimer)
		{
			isJumping = false;
			xVel=0;
			yVel=0;
			jumpCooldown=jumpTimer/4;
			return;
		}
		float speed = jumpDistance/jumpTimer;
		xVel=(float) (speed*Math.cos(angle));
		yVel=(float) (speed*Math.sin(angle));
		
		
	}
	public void startJump(float angle)
	{
		if(canJump)
		{
			canJump=false;;
			this.angle=angle;
			curJumpTime=0;
			isJumping=true;
		}
	}
	public void startJump(float targetX, float targetY)
	{
		if(canJump)
		{
			canJump=false;
			this.angle=getAngleToward(targetX,targetY) ;
			curJumpTime=0;
			isJumping=true;
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawOval(xPos, yPos, FROG_SIZE, FROG_SIZE);
	}
	public void modifyJumpDistance(float multi)
	{
		jumpDistance*=multi;
	}
	public void modifyJumpTimer(float multi)
	{
		jumpTimer*=multi;
	}
}
