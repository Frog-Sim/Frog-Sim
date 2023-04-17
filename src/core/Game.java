package core;

import entities.Entity;
import entities.Pool;
import entities.alive.*;
import entities.obstacles.Tree;
import environment.Map;
import grouping.Pack;
import media.Camera;
import media.ImageLoader;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.IOException;
import java.util.ArrayList;

public class Game extends BasicGameState {
    public static float zoomScale;
    public static PlayerFrog bestFrog;
    public static Pack enemyPack1;
    public static Pack enemyPack2;
    public static Pack enemyPack3;
    public static int time;
    //ENTITIES
    public static ArrayList<Entity> entities;
    private static Camera cam;
    private static ArrayList<Pack> packs;
    private static ArrayList<Pool> pools;
    private final int id;
    private StateBasedGame sbg;
    //	private float camX=0;
//	private float camY=0;
    private Map map;
    private int mouseX;
    private int mouseY;

    public Game(int id) {
        this.id = id;
        zoomScale = 1;
    }

    public static void addEntity(Entity guy) {
        entities.add(guy);
    }

    public static void removeEntity(Entity guy) {
        entities.remove(guy);
    }

    public static void removePool(Pool p) {
        pools.remove(p);
    }

    public static float getCamX() {
        return cam.getX();
    }

    public static float getCamY() {
        return cam.getY();
    }

    public static ArrayList<Entity> getEntities() {
        return entities;
    }

    public static ArrayList<Pool> getPools() {
        return pools;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.sbg = sbg;
        try {
            ImageLoader.init();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        zoomScale = 1;
        entities = new ArrayList<Entity>();
        packs = new ArrayList<Pack>();
        pools = new ArrayList<Pool>();
        bestFrog = new PlayerFrog(Main.getScreenWidth() / 2, Main.getScreenHeight() / 2);
        entities.add(bestFrog);
        entities.add(new Wanderer(500, 500));
//		for(int i=0;i<10;i++)
//		{
//			entities.add(new Rock(100*i,200*i));
//		}
        entities.add(new Tree(-100, 1000));
        Pool newPool = new Pool(000, 000);
        pools.add(newPool);
        entities.add(newPool);
        cam = new Camera(this);
        map = new Map(this);
//		setupPacks();

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        mouseX = Mouse.getX();
        mouseY = Mouse.getY();
        if (mouseY > Main.getScreenHeight() / 2) {
            mouseY = Main.getScreenHeight() / 2 - (mouseY - (Main.getScreenHeight() / 2));
        } else if (mouseY < Main.getScreenHeight() / 2) {
            mouseY = Main.getScreenHeight() / 2 + (-mouseY + (Main.getScreenHeight() / 2));
        }
        mouseX += cam.getX();
        mouseY += cam.getY();
        time++;
        cam.update();
        map.update();
        if (bestFrog.getDistance(new Point(mouseX, mouseY)) > 150) {
            bestFrog.startJump(mouseX, mouseY);
            bestFrog.getPack().moveAll(mouseX, mouseY);
            bestFrog.setDestPoint(new Point(mouseX, mouseY));
        } else {
            bestFrog.setDestPoint(null);
        }
//		if(time%20==0)
//		{
//			entities.add(new Wanderer(mouseX,mouseY));
//		}
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }
//		for(Entity e: entities) {
//			e.update();
//		}
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.yellow);
        g.drawString("#Tiles: " + map.getTiles().size(), 25, 25);
        g.drawString("#RenderTiles: " + map.renderedTiles, 25, 50);
//        System.out.println("Total Tiles: " + map.getTiles().size());
        g.translate(-cam.getX(), -cam.getY());
        map.render(g);
//        for (Entity e : entities) {
//            e.render(g);
//        }
        for (int i = entities.size() - 1; i >= 0; i--) entities.get(i).render(g);
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_M) sbg.enterState(Main.MAP_ID);
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
    }

    public void mousePressed(int button, int x, int y) {
        bestFrog.startJump(x + getCamX(), y + getCamY());
    }

    public void mouseWheelMoved(int change) {
        if (change > 0) {
            zoom(2f);
            //zoom in
        } else {
            zoom(.5f);
            //zoom out
        }
    }

    public int getID() {
        return id;
    }

    private void setupPacks() {
        KingToad kingToad1 = new KingToad(-100, -300, enemyPack1);
        KingToad kingToad2 = new KingToad(-1000, -1000, enemyPack2);
        KingToad kingToad3 = new KingToad(-2000, -2000, enemyPack3);
        entities.add(kingToad1);
        entities.add(kingToad2);
        entities.add(kingToad3);
        enemyPack1 = new Pack(kingToad1);
        enemyPack1.boostAll(1.2f);
        for (int i = 0; i < 10; i++) {
            Frog temp = new Follower(-100 * i, -100, enemyPack1);
            entities.add(temp);
            enemyPack1.addFrog(temp);
        }
        enemyPack2 = new Pack(kingToad2);
        enemyPack2.boostAll(1.4f);
        for (int i = 0; i < 20; i++) {
            Frog temp = new Follower(-1000 - 100 * i, -1000, enemyPack2);
            entities.add(temp);
            enemyPack2.addFrog(temp);
        }
        enemyPack3 = new Pack(kingToad3);
        enemyPack3.boostAll(2.6f);
        for (int i = 0; i < 30; i++) {
            Frog temp = new Follower(-3000 - 100 * i, -3000, enemyPack3);
            entities.add(temp);
            enemyPack3.addFrog(temp);
        }
    }

    public void zoom(float scale) {
        zoomScale *= scale;
        ImageLoader.scaleImage((int) (map.getTileSize() * zoomScale), (int) (map.getTileSize() * zoomScale));
        map.zoom(scale);
        for (Entity e : entities) {
            e.zoom(scale);
        }
        for (Pool p : pools) {
            p.zoom(scale);
        }

    }
}
