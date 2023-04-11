package grouping;

import java.util.ArrayList;

import entities.alive.Animal;
import entities.alive.Frog;
import entities.alive.KingToad;

public class Pack {
	private ArrayList<Frog> frogs; 
	public Animal alphaFrog;
	private float moveDistance=200;
	private float moveTimer=25;
	private float healthBonus;
	private float attackDamageBonus;
	private float attackSpeedBonus;
	private boolean battling;
	public Pack(Frog alpha)
	{
		alphaFrog=alpha;
		frogs= new ArrayList<Frog>();
		frogs.add(alpha);
	}
	public Pack(KingToad alpha)
	{
		alphaFrog=alpha;
		frogs= new ArrayList<Frog>();
//		frogs.add(alpha);
	}
	public void update()
	{
		moveAll(alphaFrog.getAngle());
		if(battling)
		{
			
		}
	}
	public void modifyJumpDistance(float multi)
	{
		moveDistance*=multi;
		for(Frog f: frogs)
		{
			f.modifyJumpDistance(multi);
		}
		if(alphaFrog instanceof KingToad)
		{
			((KingToad) alphaFrog).modifyJumpDistance(multi);
		}
	}
	public void modifyHealth(float multi)
	{
		healthBonus*=multi;
		for(Frog f: frogs)
		{
			f.modifyHealth(multi);
		}
		if(alphaFrog instanceof KingToad)
		{
			((KingToad) alphaFrog).modifyHealth(multi);
		}
	}
	public void modifyAttackDamage(float multi)
	{
		attackSpeedBonus*=multi;
		for(Frog f: frogs)
		{
			f.modifyAttackDamage(multi);
		}
		if(alphaFrog instanceof KingToad)
		{
			((KingToad) alphaFrog).modifyAttackDamage(multi);
		}
	}
	public void modifyAttackSpeed(float multi)
	{
		attackDamageBonus*=multi;
		for(Frog f: frogs)
		{
			f.modifyAttackDamage(multi);
		}
		if(alphaFrog instanceof KingToad)
		{
			((KingToad) alphaFrog).modifyAttackDamage(multi);
		}
	}
	public void modifyJumpTimer(float multi)
	{
		moveTimer*=multi;
		for(Frog f: frogs)
		{
			f.modifyJumpTimer(multi);
		}
		if(alphaFrog instanceof KingToad)
		{
			((KingToad) alphaFrog).modifyJumpTimer(multi);
		}
	}
	public void boostAll(float multi)
	{
		modifyAttackDamage(multi);
		modifyAttackSpeed(1/multi);
		modifyHealth(multi);
		modifyJumpDistance(multi);
		modifyJumpTimer(1/multi);
	}
	public int getOrbital() {
		for(int i=0; i<20; i++)
		{
			if(frogs.size()<4*Math.pow(3, i)-1)
			{
				return i;
			}
				
		}
		return 1;
	}
	public void moveAll(float angle)
	{
		for(Frog f: frogs)
		{
			if(f!=alphaFrog)
			{
				f.startJump(angle);
			}
			
		}
	}
	public void moveAll(float x,float y)
	{
		for(Frog f: frogs)
		{
			if(f!=alphaFrog)
			{
				f.resetJump();
				f.startJump(x,y);
			}
			
		}
	}
	public void addFrog(Frog f)
	{
		frogs.add(f);
	}
	public float getJumpDist()
	{
		return moveDistance;
	}
	public float getJumpTimer()
	{
		return moveTimer;
	}
	public ArrayList<Frog> getFrogs()
	{
		return frogs;
	}
}
