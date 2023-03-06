package environment.biomes;

import core.Game;
import core.Main;
import media.ImageLoader;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import environment.Map;
import environment.Tile;

public class Grass extends Biome{
	float elevation;
	
	public Grass(float noiseValue) {
		super();
		elevation=noiseValue;
	}

	public void update() 
	{

	}

	public void render(Graphics g)
	{
		g.drawImage(ImageLoader.grassOne, tile.getX() * Map.TILE_SIZE + Game.getCamX(), tile.getY() * Map.TILE_SIZE + Game.getCamY());
	}
}
