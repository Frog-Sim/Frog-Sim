package environment.biomes;

import core.Game;
import media.ImageLoader;
import org.newdawn.slick.Graphics;

public class Grass extends Biome {

    public Grass(float noiseValue) {
        super(noiseValue);
    }

    public void update() {

    }

    public void render(Graphics g) {
//		g.setColor(new Color(30,(int)(255*noiseValue+30),30));
//		g.fillRect(tile.getX(), tile.getY(), Map.TILE_SIZE, Map.TILE_SIZE);
        if (rand < .5) g.drawImage(ImageLoader.grassOne, tile.getX(), tile.getY());
        else g.drawImage(ImageLoader.grassTwo, tile.getX() * Game.zoomScale, tile.getY() * Game.zoomScale);
    }
}
