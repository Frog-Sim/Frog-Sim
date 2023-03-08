
package environment;

import core.Game;
import org.newdawn.slick.Graphics;

import environment.biomes.Biome;


public class Tile {
	protected Biome biome;
	protected float initX;
	protected float initY;
	protected float x;
	protected float y;
	public Tile(float x, float y)
	{
		this.x=x;
		this.y=y;
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
