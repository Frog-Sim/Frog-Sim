
package environment;

import core.Game;
import org.newdawn.slick.Graphics;

import environment.biomes.Biome;
import environment.biomes.Grass;
import environment.biomes.Snow;


public class Tile {
	protected Biome biome;
	protected float initX;
	protected float initY;
	protected float x;
	protected float y;
	public final static float SCALE=.02f;
	public Tile(float x, float y)
	{
		this.x=x;
		this.y=y;
		float noiseValue=Map.getNoise().GetNoise(x*SCALE, y*SCALE);
		if(noiseValue<.2) setBiome(new Grass(noiseValue));
		else setBiome(new Snow(noiseValue));
	}
	

	public void update()
	{
		if(biome!=null) biome.update();
	}
	
	public void render(Graphics g) 
	{
		if(biome!=null) biome.render(g);
	}

	public void setBiome(Biome b) {
		biome=b;
		b.setTile(this);
	}
	
	public float getX() {	return x; }
	public float getY() {	return y; }
	
	public Biome getTerrain() {
		return biome;
	}
}
