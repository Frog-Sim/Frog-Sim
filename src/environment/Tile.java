
package environment;

import org.newdawn.slick.Graphics;

import environment.biomes.Biome;


public class Tile {
	protected Biome biome;
	protected int x;
	protected int y;
	public Tile(int x, int y)
	{
		this.x = x;
		this.y = y;
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
	
	public int getX() {	return x; }
	public int getY() {	return y; }
	
	public Biome getTerrain() {
		return biome;
	}
}
