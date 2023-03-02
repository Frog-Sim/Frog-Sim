package entities.alive;


import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

public class Frog extends Animal{

	protected static final int FROG_SIZE=100;
	protected float curJumpTime;
	protected float jumpTimer;
	protected float jumpCooldown;
	protected float jumpDistance;
	protected boolean isJumping;
	protected boolean canJump;
	protected Point destination;
//	protected SpriteSheet me;
	
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
		if(curJumpTime>jumpTimer || getDistance(destination)<(jumpDistance/jumpTimer)*1.5f)
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
			canJump=false;
			this.angle=angle;
			curJumpTime=0;
			isJumping=true;
			destination= new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
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
			destination= new Point(targetX, targetY);
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(xPos, yPos, FROG_SIZE, FROG_SIZE);
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
