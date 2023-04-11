package entities.alive;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.Game;
import grouping.Pack;

public class Follower extends Frog{
	
	public static final float ORBITAL_SIZE=210; 
	private int orbital;
	private int direction;
	private Pack myPack;
	private Animal leader;
	
	public Follower(float x, float y) {
		super(x, y);
		myPack=Game.bestFrog.getPack();
		orbital=myPack.getOrbital();
		myPack.addFrog(this);
		if(orbital %2 == 0)
		{
			direction = 1;
		}
		else
		{
			direction = -1;
		}
		this.jumpDistance=myPack.getJumpDist();
		this.jumpTimer=myPack.getJumpTimer();
		leader=myPack.alphaFrog;
		// TODO Auto-generated constructor stub
	}
	public Follower(float x, float y, Color color, Color colorAccent, Color colorExtra) {
		super(x, y);
		myPack=Game.bestFrog.getPack();
		orbital=myPack.getOrbital();
		myPack.addFrog(this);
		if(orbital %2 == 0)
		{
			direction = 1;
		}
		else
		{
			direction = -1;
		}
		this.jumpDistance=myPack.getJumpDist();
		this.jumpTimer=myPack.getJumpTimer();
		leader=myPack.alphaFrog;
		this.color=color;
		this.colorExtra=colorExtra;
		this.colorAccent=colorAccent;
		// TODO Auto-generated constructor stub
	}
	public Follower(float x, float y, Pack pack) {
		super(x, y);
		myPack=pack;
		orbital=myPack.getOrbital();
		myPack.addFrog(this);
		if(orbital %2 == 0)
		{
			direction = 1;
		}
		else
		{
			direction = -1;
		}
		this.jumpDistance=myPack.getJumpDist();
		this.jumpTimer=myPack.getJumpTimer();
		leader=myPack.alphaFrog;
		// TODO Auto-generated constructor stub
	}
	public void update() {
		if(inOrbital() && !behindLeader())
		{
			if(jumpCooldown<-1)
			{
				startJump();
			}
			this.angle= (float) (getAngleTo(leader) + Math.PI/2*direction);
			
//			startJump((float)(xPos+50*Math.cos(angle)), (float)(yPos+50*Math.sin(angle)));
		}
		else {
			if(getDistance(leader)-orbital*ORBITAL_SIZE>2000)
			{
//				startSuperJump();
			}
			if(getDistance(leader)<orbital*ORBITAL_SIZE)
			{
				this.angle= (float) (getAngleTo(leader) - Math.PI);
				startJump();
			}
			else
			{
				this.angle= (float) (getAngleTo(leader));
				startJump();
			}
				
		}
		super.update();
	}
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(xPos, yPos, FROG_SIZE, FROG_SIZE);
		g.setColor(Color.black);
		g.drawLine(xPos, yPos, (float)(xPos+20*Math.cos(angle)), (float)(yPos+20*Math.sin(angle)));
		super.render(g);
	}
	public boolean inOrbital()
	{
		return getDistance(leader)<(orbital*ORBITAL_SIZE)+ORBITAL_SIZE/2 && getDistance(leader)>(orbital*ORBITAL_SIZE)-ORBITAL_SIZE/2;
	}
	public int getOrbital()
	{
		return orbital;
	}
	protected boolean behindLeader()
	{
		if(leader.destinationPoint != null)
		{
			return this.getDistance(leader.destinationPoint)>leader.getDistance(leader.destinationPoint);
		}
		return false;
	}

}
