package environment.biomes;

import core.Game;
import core.Main;
import media.ImageLoader;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import environment.Map;
import environment.Tile;

public class Snow extends Biome{

    public Snow(float noiseValue) {
        super(noiseValue);
    }

    public void update()
    {

    }

    public void render(Graphics g)
    {
        g.drawImage(ImageLoader.snowOne, tile.getX() * Map.TILE_SIZE + Game.getCamX(), tile.getY() * Map.TILE_SIZE + Game.getCamY());
    }
}
