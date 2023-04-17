package environment.biomes;

import core.Game;
import environment.Tile;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


public abstract class Biome {
    protected Tile tile;
    protected float noiseValue;
    protected float bigNoiseValue;
    protected double rand = Math.random();
    protected Image image;

    public Biome(float noiseValue) {
        this.noiseValue = noiseValue;
        bigNoiseValue = calculateBigNoiseValue(noiseValue);
    }

    public void setTile(Tile t) {
        tile = t;
    }

    abstract public void update();

    abstract public void scaleImages();

    public void render(Graphics g) {
        g.drawImage(image, tile.getX() * Game.zoomScale, tile.getY() * Game.zoomScale);
    }

    public float calculateBigNoiseValue(float value) {
        if (Math.abs(value) > 10) return value;
        else return calculateBigNoiseValue(10 * value);
    }
}