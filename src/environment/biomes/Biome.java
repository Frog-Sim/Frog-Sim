<<<<<<< Updated upstream
package environment.biomes;

import org.newdawn.slick.Graphics;

import environment.Tile;


public abstract class Biome {
	protected Tile tile;

	public Biome(Tile t)
	{
		tile=t;
	}

	public void setTile(Tile t)
	{
		tile = t;
	}

	abstract public void update();
	abstract public void render(Graphics g);
}
=======
package environment.biomes;

import org.newdawn.slick.Graphics;

import environment.Tile;


public abstract class Biome {
	protected Tile tile;

	public Biome()
	{

	}

	public void setTile(Tile t)
	{
		tile = t;
	}

	abstract public void update();
	abstract public void render(Graphics g);
}
>>>>>>> Stashed changes
