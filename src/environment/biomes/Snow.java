package environment.biomes;

import core.Game;
import media.ImageLoader;
import org.newdawn.slick.Graphics;

public class Snow extends Biome {

    public Snow(float noiseValue) {
        super(noiseValue);
    }

    public void update() {

    }

    public void render(Graphics g) {
        g.drawImage(ImageLoader.snowOne, tile.getX() * Game.zoomScale, tile.getY() * Game.zoomScale);
    }
}