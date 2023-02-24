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
import entities.alive.Frog;
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
	//ENTITIES
	private ArrayList<Entity> entities;
	
	public Game(int id) { this.id = id; }
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		this.sbg=sbg;
		entities = new ArrayList<Entity>();
		cam=new Camera(this);
		entities.add(new Frog(200,200));
		map=new Map(this);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		cam.update();
		map.update();
		for(Entity e: entities) {
			e.update();
		}
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
	}
	public void mouseWheelMoved(int change)
	{
		
	}
	public int getID() { return id; }
	public float getCamX() { return camX; }
	public float getCamY() { return camY; }
}
