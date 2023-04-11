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
	
	public Frog(float x, float y) { super(x, y, FROG_SIZE, FROG_SIZE); jumpTimer=30; jumpDistance=200; canJump=true; }
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
		xVel=(float) (speed*Math.cos(getAngle()));
		yVel=(float) (speed*Math.sin(getAngle()));
	}
	public void startJump(float angle)
	{
		if(canJump)
		{
			canJump=false;
			this.setAngle(angle);
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
			this.setAngle(getAngleTo(targetX,targetY)) ;
			curJumpTime=0;
			isJumping=true;
			destination= new Point(targetX, targetY);
		}
	}
	public void startJump()
	{
		if(canJump)
		{
			canJump=false;
			curJumpTime=0;
			isJumping=true;
			destination= new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		}
	}
	public void render(Graphics g) {
		super.render(g);
	}
	public void modifyHealth(float multi)
	{
		maxHealth*=multi;
	}
	public void modifyAttackDamage(float multi)
	{
		attackDamage*=multi;
	}
	public void modifyAttackSpeed(float multi)
	{
		jumpDistance*=multi;
	}
	public void modifyJumpTimer(float multi)
	{
		jumpTimer*=multi;
	}
	
	public void modifyJumpDistance(float multi)
	{
		jumpDistance*=multi;
	}
	
	
	public void setHealthBonus(float newHealth) {
		this.maxHealth=newHealth;
	}
	public void setAttackDamageBonus(float newAttack) {
		this.attackDamage=newAttack;
	}
	public void setAttackSpeedBonus(float newAttack) {
		this.attackSpeed=newAttack;
	}
	public void setJumpDistance(float jump){
		jumpDistance=jump;
	}
	public void setJumpTimer(float timer){
		jumpTimer=timer;
	}
	public void resetJump()
	{
		isJumping=false;
		jumpCooldown=-100;
	}
	
}