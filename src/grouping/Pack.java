package grouping;

import java.util.ArrayList;

import entities.alive.Frog;

public class Pack {
	private ArrayList<Frog> frogs; 
	private float moveDistance=100;
	private float moveTimer=30;
	private float healthBonus;
	private float attackBonus;
	private boolean battling;
	public Pack()
	{
		frogs= new ArrayList<Frog>();
	}
	public void modifyJumpDistance(float multi)
	{
		moveDistance*=multi;
		for(Frog f: frogs)
		{
			f.setJumpDistance(moveDistance);
		}
	}
	public void modifyJumpTimer(float multi)
	{
		moveTimer*=multi;
		for(Frog f: frogs)
		{
			f.setJumpTimer(moveTimer);
		}
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
}
