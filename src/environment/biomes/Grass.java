package environment.biomes;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import environment.Map;
import environment.Tile;

public class Grass extends Biome{
	float elevation;
	
	public Grass(Tile t, float noiseValue) { 
		super(t); 
		elevation=noiseValue;
	}

	public void update() 
	{

	}

	public void render(Graphics g)
	{
		int red = 30;
		int green = (int) (255*elevation);
		int blue = 30;
		g.setColor(new Color(red, green, blue));
		g.fillRect(tile.getX() * Map.TILE_SIZE, tile.getY() * Map.TILE_SIZE, Map.TILE_SIZE, Map.TILE_SIZE);
	}
}
