package environment.biomes;

import core.Game;
import core.Main;
import media.ImageLoader;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import environment.Map;
import environment.Tile;

public class Snow extends Biome{
    float elevation;

    public Snow(float noiseValue) {
        super();
        elevation=noiseValue;
    }

    public void update()
    {

    }

    public void render(Graphics g)
    {
        g.setColor(Color.white);
//        g.drawImage(ImageLoader.frogImage, tile.getX() * Map.TILE_SIZE + Game.getCamX(), tile.getY() * Map.TILE_SIZE + Game.getCamY());
		g.fillRect(tile.getX() * Map.TILE_SIZE + Game.getCamX(), tile.getY() * Map.TILE_SIZE + Game.getCamY(), Map.TILE_SIZE, Map.TILE_SIZE);
    }
}
