package environment.biomes;

import core.Game;
import media.ImageLoader;
import org.newdawn.slick.Graphics;

public class Sand extends Biome {

    public Sand(float noiseValue) {
        super(noiseValue);
    }

    public void update() {

    }

    public void render(Graphics g) {
//		g.setColor(new Color(30,(int)(255*noiseValue+30),30));
//		g.fillRect(tile.getX(), tile.getY(), Map.TILE_SIZE, Map.TILE_SIZE);
        if (rand < .25) g.drawImage(ImageLoader.sandOne, tile.getX(), tile.getY());
        else if (rand < .5) g.drawImage(ImageLoader.sandTwo, tile.getX() * Game.zoomScale, tile.getY() * Game.zoomScale);
        else if (rand < .75) g.drawImage(ImageLoader.sandThree, tile.getX() * Game.zoomScale, tile.getY() * Game.zoomScale); 
        else g.drawImage(ImageLoader.sandFour, tile.getX() * Game.zoomScale, tile.getY() * Game.zoomScale);
    }
}