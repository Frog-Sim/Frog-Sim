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
}
