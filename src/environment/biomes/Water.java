package environment.biomes;

import core.Game;
import media.ImageLoader;

import org.newdawn.slick.Graphics;

public class Water extends Biome {

    public Water(float noiseValue) {
        super(noiseValue);
    }

    public void update() {

    }

    public void render(Graphics g) {
        g.drawImage(ImageLoader.waterOne, tile.getX() * Game.zoomScale, tile.getY() * Game.zoomScale);
    }
}