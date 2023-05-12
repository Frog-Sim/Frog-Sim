package entities.alive;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.Game;
import entities.Entity;
import grouping.Pack;

public class Follower extends Frog{
	
	public static final float ORBITAL_SIZE=210; 
	private int orbital;
	private int direction;
	public Pack myPack;
	private Animal leader;
	private Animal target;
	public Follower(float x, float y, Color color, Color colorAccent, Color colorExtra) {
		super(x, y);
		colorAccent = new Color(Color.black);
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
	}
	public Follower(float x, float y) {
		super(x, y);
		colorAccent = new Color(Color.black);
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
	}
	public Follower(float x, float y, Pack pack) {
		super(x, y);
		colorAccent = new Color(Color.black);
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
	}
	public void update() {
		if(myPack.alphaFrog instanceof PlayerFrog && ((PlayerFrog)myPack.alphaFrog).idle==true && !myPack.battling)
		{
			resetJump();
			if(inOrbital()) //&& !behindLeader())
			{
				if(jumpCooldown<-1)
				{
					startJump((float) (getAngleTo(leader) + Math.PI/2*direction));
				}
			}
			else {

				if(getDistance(leader)<orbital*ORBITAL_SIZE)
				{
					startJump((float) (getAngleTo(leader) - Math.PI));
				}
				else
				{
					startJump((float) (getAngleTo(leader)));
				}
					
			}
		}
		super.update();
	}
	public void attackClosest()
	{
		Pack enemy=null;
		if(attackTimer>attackSpeed)
		{	
			if(this instanceof Follower)
			{
				enemy = myPack.getEnemyPack();
			}
			if (enemy != null)
			{
				ArrayList<Frog> enemyFrogs = enemy.getFrogs();
				Animal target=null;
			
				float minDist=300;
				for(Frog f: enemyFrogs)
				{
					if(this.getDistance(f)<minDist)
					{
						target=f;
						minDist=this.getDistance(f);
					}
				}
				Animal a=enemy.alphaFrog;
				if(this.getDistance(a)<minDist)
				{
					target=a;
				}
				
				
				if(target != null)
				{
					this.target=target;
					target.curHealth-=attackDamage;
					attackTimer =0;
				}
			}
		}
	}
	public void render(Graphics g) {
		
		super.render(g);
	}
	public boolean inOrbital()
	{
		return getDistance(leader)<(orbital*ORBITAL_SIZE)+ORBITAL_SIZE/10 && getDistance(leader)>(orbital*ORBITAL_SIZE)-ORBITAL_SIZE/10;
	}
	public void moveToClosestEnemy()
	{
		Pack enemys= myPack.getEnemyPack();
			if(enemys != null)
			{
				float minDist=1000000000;
				Animal target=null;
				ArrayList<Frog> efrg= enemys.getFrogs();
				for(Animal a: efrg)
				{
					if(getDistance(a)<minDist)
					{
						target=a;
						minDist=getDistance(a);
					}
				}
				Animal e=myPack.getEnemyPack().alphaFrog;
				if(getDistance(e)<minDist)
				{
					target=e;
				}
				if(target != null)
				{
					resetJump();
					startJump(target.getX(),target.getY());
				}
				else
				{
					this.startJump(0);
				}
			}
			else
			{
				System.out.println("STUPPID");
			}
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
	public void onDeath()
	{
		Game.entities.remove(this);
	}

}
