package environment;

import environment.biomes.Biome;
import environment.biomes.Grass;
import environment.biomes.Snow;
import environment.biomes.Water;
import grouping.Pack;

import org.newdawn.slick.Graphics;

import core.Game;
import entities.alive.Frog;
import entities.alive.KingToad;
import entities.alive.Wanderer;
import entities.obstacles.Rock;
import entities.obstacles.Tree;


public class Tile {
    public final static float SCALE = .005f;
    protected Biome biome;
    protected float initX;
    protected float initY;
    protected float x;
    protected float y;

    public Tile(float x, float y) {
        this.x = x;
        this.y = y;
        float noiseValue = Map.getNoise().GetNoise(x * SCALE, y * SCALE);
        if (noiseValue < .2) setBiome(new Grass(noiseValue));
        else if (noiseValue<.4) setBiome(new Water(noiseValue));
        else setBiome(new Snow(noiseValue));
        if(Game.bestFrog.getPack().getFrogs().size()<5) {
        	double rand = Math.random();
        	if(rand<.05) Game.entities.add(new Wanderer(x,y));
        	else if (rand<.08) Game.entities.add(new Rock((float)(x+Math.random()*Map.TILE_SIZE),(float)(y+Math.random()*Map.TILE_SIZE)));
        	else if (rand<.1) Game.createPool(x,y);
        	else if (rand>.9999) {

        		KingToad k= new KingToad(x,y);
        		Game.entities.add(k);
        		Pack pack= new Pack(k);
        		k.setPack(pack);
        		
        	}
        } else if (Game.bestFrog.getPack().getFrogs().size()<10) {
        	double rand = Math.random();
        	if(rand<.025) Game.entities.add(new Wanderer(x,y));
        	else if (rand<.045) Game.entities.add(new Tree((float)(x+Math.random()*Map.TILE_SIZE),(float)(y+Math.random()*Map.TILE_SIZE)));
        	else if (rand<.07) Game.createPool(x,y);
        	else if (rand>.99) {
        		KingToad k= new KingToad(x,y);
        		Game.entities.add(k);
        		Pack pack= new Pack(k);
        		k.setPack(pack);
        	}
        } else {
        	double rand = Math.random();
        	if(rand<.01) Game.entities.add(new Wanderer(x,y));
        	else if (rand<.015) Game.createPool(x,y);
        	else if (rand<.05) Game.entities.add(new Rock((float)(x+Math.random()*Map.TILE_SIZE),(float)(y+Math.random()*Map.TILE_SIZE)));
        	else if (rand>.998) Game.entities.add(new Wanderer(x,y));
        	else if (rand>.95) {
        		KingToad k= new KingToad(x,y);
        		Game.entities.add(k);
        		Pack pack= new Pack(k);
        		k.setPack(pack);
        	}
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