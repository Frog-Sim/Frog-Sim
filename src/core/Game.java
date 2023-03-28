package core;

import entities.Entity;
import entities.alive.Follower;
import entities.alive.PlayerFrog;
import entities.alive.Wanderer;
import entities.obstacles.Rock;
import entities.obstacles.Tree;
import environment.Map;
import media.Camera;
import media.ImageLoader;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

public class Game extends BasicGameState {
    public static PlayerFrog bestFrog;
    public static float zoomScale;
    private static Camera cam;
    //ENTITIES
    private static ArrayList<Entity> entities;
    private final int id;
    private StateBasedGame sbg;
    //	private float camX=0;
//	private float camY=0;
    private Map map;

    public Game(int id) {
        this.id = id;
    }

    public static void addEntity(Entity guy) {
        entities.add(guy);
    }

    public static void removeEntity(Entity guy) {
        entities.remove(guy);
    }

    public static int getCamX() {
        return cam.getX();
    }

    public static int getCamY() {
        return cam.getY();
    }

    public static ArrayList<Entity> getEntities() {
        return entities;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.sbg = sbg;
        zoomScale = 1;
        ImageLoader.init();
        entities = new ArrayList<Entity>();
        bestFrog = new PlayerFrog(Main.getScreenWidth() / 2, Main.getScreenHeight() / 2);
        entities.add(bestFrog);
//		entities.add(new Wanderer(500,500));
        for (int i = 0; i < 10; i++) {
            entities.add(new Rock(100 * i, 200 * i));
        }
        entities.add(new Tree(-100, 1000));
        cam = new Camera(this);
        map = new Map(this);

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        cam.update();
        map.update();
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }
//		for(Entity e: entities) {
//			e.update();
//		}
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.translate(-cam.getX(), -cam.getY());
        map.render(g);
        for (Entity e : entities) {
            e.render(g);
        }
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_M) sbg.enterState(Main.MAP_ID);
        if (key == Input.KEY_ESCAPE) sbg.enterState(Main.PAUSE_ID);
//		if(key==Input.KEY_W) camY-=300;
//		else if (key==Input.KEY_A) {
//			camX-=300;
//		}
//		else if (key==Input.KEY_S) camY+=300;
//		else if (key==Input.KEY_D) camX+=300;
        if (key == Input.KEY_O) bestFrog.getPack().modifyJumpDistance(1.2f);
        if (key == Input.KEY_P) bestFrog.getPack().modifyJumpTimer(0.8f);
        if (key == Input.KEY_N)
            for (int i = 0; i < 25; i++) {
                entities.add(new Wanderer((float) (1000 * Math.random()), (float) (1000 * Math.random())));
            }
        if (key == Input.KEY_B)
            for (int i = 0; i < 5; i++) {
                entities.add(new Follower((float) (1000 * Math.random()), (float) (1000 * Math.random())));
            }
        if (key == Input.KEY_1) {
            zoomScale *= .9;
            map.zoom(.9F);
            System.out.println("ZoomScale: " + zoomScale);
            System.out.println("MapSize: " + Map.TILE_SIZE);
        }
    }

    public void mousePressed(int button, int x, int y) {
        bestFrog.startJump(x + getCamX() * zoomScale, y + getCamY() * zoomScale);
    }

    public void mouseWheelMoved(int change) {

    }

    public int getID() {
        return id;
    }
}