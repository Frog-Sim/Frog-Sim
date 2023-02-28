package core;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import entities.alive.Follower;
import entities.alive.Frog;
import entities.alive.PlayerFrog;
import entities.alive.Wanderer;
import environment.Map;
import media.Camera;

public class Game extends BasicGameState 
{	
	private int id;
	private StateBasedGame sbg;
	private Camera cam;
	private float camX=0;
	private float camY=0;
	private Map map;
	public static PlayerFrog bestFrog;
	//ENTITIES
	private static ArrayList<Entity> entities;
	
	public Game(int id) { this.id = id; }
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		this.sbg=sbg;
		entities = new ArrayList<Entity>();
		cam=new Camera(this);
		map=new Map(this);
		bestFrog= new PlayerFrog(200,200);
		entities.add(bestFrog);
		entities.add(new Wanderer(500,500));
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		cam.update();
		map.update();
		for(Entity e: entities) {
			e.update();
		}
		System.out.println(entities.size());
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		g.translate(-cam.getX(), -cam.getY());
		g.drawString("GAME", 100, 100);
		map.render(g);
		for(Entity e: entities) {
			e.render(g);
		}
	}

	public void keyPressed(int key, char c)
	{
		if(key==Input.KEY_M) sbg.enterState(Main.MAP_ID);
		if(key==Input.KEY_W) camY-=300;
		else if (key==Input.KEY_A) camX-=300;
		else if (key==Input.KEY_S) camY+=300;
		else if (key==Input.KEY_D) camX+=300;
		if (key==Input.KEY_O) bestFrog.modifyJumpDistance(1.2f);
		if (key==Input.KEY_P) bestFrog.modifyJumpTimer(0.8f);
		if (key==Input.KEY_N) 
			for(int i=0; i<25; i++)
			{entities.add(new Wanderer((float)(1000*Math.random()),(float)(1000*Math.random())));}
		if (key==Input.KEY_B) 
			for(int i=0; i<5; i++)
			{entities.add(new Follower((float)(1000*Math.random()),(float)(1000*Math.random())));}
	}
	public void mousePressed(int button, int x, int y)
	{
		bestFrog.startJump(x+camX, y+camY);
		System.out.println("click");
 	}
	public void mouseWheelMoved(int change)
	{
		
	}
	public static void addEntity(Entity guy)
	{
		entities.add(guy);
	}
	public int getID() { return id; }
	public float getCamX() { return camX; }
	public float getCamY() { return camY; }
}
