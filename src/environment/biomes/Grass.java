package environment.biomes;

import core.Game;
import core.Main;
import media.ImageLoader;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import environment.Map;
import environment.Tile;

public class Grass extends Biome{
	
	public Grass(float noiseValue) {
		super(noiseValue);
	}

	public void update() 
	{

	}

	public void render(Graphics g)
	{
		System.out.println("x: "+tile.getX()+"y: "+tile.getY());
//		g.setColor(new Color(30,(int)(255*noiseValue+30),30));
//		g.fillRect(tile.getX(), tile.getY(), Map.TILE_SIZE, Map.TILE_SIZE);
		if((int)(Math.abs(bigNoiseValue)%2)==0) g.drawImage(ImageLoader.grassOne, tile.getX(), tile.getY());
		else g.drawImage(ImageLoader.grassTwo, tile.getX(), tile.getY());
	}
}
