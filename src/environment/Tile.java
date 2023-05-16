package environment;

import environment.biomes.Biome;
import environment.biomes.Grass;
import environment.biomes.Sand;
import environment.biomes.Snow;
import environment.biomes.Water;
import grouping.Pack;

import org.newdawn.slick.Graphics;

import core.Game;
import entities.alive.Follower;
import entities.alive.Frog;
import entities.alive.KingToad;
import entities.alive.Wanderer;
import entities.obstacles.Rock;
import entities.obstacles.Tree;


public class Tile {
    public final static float SCALE = .0025f;
    protected Biome biome;
    protected float initX;
    protected float initY;
    protected float x;
    protected float y;

    public Tile(float x, float y) {
        this.x = x;
        this.y = y;
        float noiseValue = Map.getNoise().GetNoise(x * SCALE, y * SCALE);
        float noiseValueTwo = Map.getNoiseTwo().GetNoise(x*SCALE, y*SCALE);
        if (noiseValue < .2) {
        	if (noiseValueTwo<.35  ) {
        		setBiome(new Grass(noiseValue));
        	} else {
        		setBiome(new Sand(noiseValue));
        	}
        } else {
        	if(noiseValue<.3) {
        		setBiome(new Water(noiseValue));
        	} else {
        		setBiome(new Snow(noiseValue));
        	}
        }
//        else if (noiseValue<.15) setBiome(new Water(noiseValue));
//        else if (noiseValue<.3) setBiome(new Snow(noiseValue));
//        else setBiome(new Sand(noiseValue));
        if(Game.bestFrog.getPack().getFrogs().size()<5) {
        	double rand = Math.random();
        	if(rand<.05) addWanderer();
        	else if (rand<.08) addObstacle(0);
        	else if (rand<.1) Game.createPool(x,y);
        	else if (rand>.9999) {

        		KingToad k= new KingToad(x,y);
        		Game.entities.add(k);
        		Pack pack= new Pack(k);
        		k.setPack(pack);

        	}
        } else if (Game.bestFrog.getPack().getFrogs().size()<10) {
        	double rand = Math.random();
        	if(rand<.025) addWanderer();
        	else if (rand<.045) addObstacle(0);
        	else if (rand<.07) Game.createPool(x,y);
        	else if (rand>.99) {
        		KingToad k= new KingToad(x,y);
        		Game.entities.add(k);
        		Pack pack= new Pack(k);
        		k.setPack(pack);
        	}
        } else {
        	double rand = Math.random();
        	if(rand<.01) addWanderer();
        	else if (rand<.015) Game.createPool(x,y);
        	else if (rand<.05) addObstacle(0);
        	else if (rand>.998) Game.entities.add(new Wanderer(x,y));
        	else if (rand>.95) {
        		KingToad k= new KingToad(x,y);
        		Game.entities.add(k);
        		Pack pack= new Pack(k);
        		k.setPack(pack);
        	}
        }
    }

    public void addWanderer() {
    	Wanderer w = new Wanderer(x,y);
    	Game.addEntity(w);
    	w.colorChange(biome);
    }

    public void addObstacle(int size) {
    	if(size==0) {
    		Rock o = new Rock(x,y);
    		Game.addEntity(o);
        	o.colorChange(biome);
    	} else {
    		Tree o = new Tree(x,y);
    		Game.addEntity(o);
        	o.colorChange(biome);
    	}
    	
    }

    public void addEnemyPack() {

    	KingToad kingToad1= new KingToad(-10000,-30000);
    	Pack p=new Pack(kingToad1);
		Game.addEntity(kingToad1);
		float boost = 60/Game.bestFrog.getPack().getAttackSpeed();
		p.boostAll(boost);
		kingToad1.setPack(p);
		int enemyToadsNumber=Game.bestFrog.getPack().getFrogs().size()/2;
		for(int i=0;i<enemyToadsNumber;i++)
		{
			Frog temp=new Follower((float)(Game.bestFrog.getX()+(2000*Math.random()-1000)),(float)( Game.bestFrog.getY()+(2000*Math.random()-1000)));
//			Frog temp= new Follower(-10000+i*10,-30000,p);
			Game.addEntity(temp);
			p.addFrog(temp);
		}
    }

    public void update() {
        if (biome != null) biome.update();
    }

    public void render(Graphics g) {
        if (biome != null) biome.render(g);
    }

    public void setBiome(Biome b) {
        biome = b;
        b.setTile(this);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Biome getTerrain() {
        return biome;
    }
}