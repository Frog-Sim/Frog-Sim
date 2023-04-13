package environment;

import core.Game;
import entities.alive.KingToad;
import entities.alive.Wanderer;
import entities.obstacles.Rock;
import entities.obstacles.Tree;
import environment.biomes.Biome;
import environment.biomes.Grass;
import environment.biomes.Snow;
import environment.biomes.Water;
import org.newdawn.slick.Graphics;


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
        else if (noiseValue < .4) setBiome(new Water(noiseValue));
        else setBiome(new Snow(noiseValue));
        if (Game.bestFrog.getPack().getFrogs().size() < 5) {
            double rand = Math.random();
            if (rand < .05) Game.entities.add(new Wanderer(x, y));
            else if (rand < .08)
                Game.entities.add(new Rock((float) (x + Math.random() * Map.TILE_SIZE), (float) (y + Math.random() * Map.TILE_SIZE)));
            else if (rand > .9999) Game.entities.add(new KingToad(x, y, Game.bestFrog.getPack()));
        } else if (Game.bestFrog.getPack().getFrogs().size() < 10) {
            double rand = Math.random();
            if (rand < .025) Game.entities.add(new Wanderer(x, y));
            else if (rand < .045)
                Game.entities.add(new Tree((float) (x + Math.random() * Map.TILE_SIZE), (float) (y + Math.random() * Map.TILE_SIZE)));
            else if (rand > .999) Game.entities.add(new KingToad(x, y, Game.bestFrog.getPack()));
        } else {
            double rand = Math.random();
            if (rand < .01) Game.entities.add(new Wanderer(x, y));
            else if (rand < .05)
                Game.entities.add(new Rock((float) (x + Math.random() * Map.TILE_SIZE), (float) (y + Math.random() * Map.TILE_SIZE)));
            else if (rand > .998) Game.entities.add(new Wanderer(x, y));
            else if (rand > .995) Game.entities.add(new KingToad(x, y, Game.bestFrog.getPack()));
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
        return x * Game.zoomScale;
    }

    public float getY() {
        return y * Game.zoomScale;
    }

    public Biome getTerrain() {
        return biome;
    }
}