package environment;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import core.Game;
import core.Main;
import environment.biomes.Grass;



public class Map {
	private ArrayList<ArrayList<Tile>> tiles;
	public static int TILE_SIZE;
	public int seed;
	private FastNoiseLite noise;
	private Game g;
	public Map(Game g) {
		seed=(int)(Math.random()*2000);
		noise=new FastNoiseLite(seed);
		TILE_SIZE=50;
		tiles=new ArrayList<ArrayList<Tile>>();
		this.g=g;
		generateMap();
	}
	public void update() {
		for(int i = 0; i < getTilesHorizontal(); i++)
		{
			for(int j = 0; j < getTilesVertical(); j++)
			{
				tiles.get(i).get(j).update();
			}
		}
	}
	public void render(Graphics g) {
		for(int i = 0; i < getTilesHorizontal(); i++)
		{
			for(int j = 0; j < getTilesVertical(); j++)
			{
				tiles.get(i).get(j).render(g);
			}
		}
	}

	public void generateMap()
	{
		for(int i = 0; i < getTilesHorizontal(); i++)
		{
//			System.out.println("rows: "+tiles.size());
			tiles.add(new ArrayList<Tile>());
			for(int j = 0; j < getTilesVertical(); j++)
			{
//				System.out.println("col: "+tiles.get(i).size());
				tiles.get(i).add(new Tile(i, j));
				generateTileAdvancedNoise(i,j);
			}
		}
	}
	public void generateTileAdvancedNoise(int x, int y) {
		float SCALE = 1f;
		float noiseValue=noise.GetNoise(x*SCALE, y*SCALE);
		if(noiseValue<=1) tiles.get(x).get(y).setBiome(new Grass(tiles.get(x).get(y), noiseValue));
//		if(noiseValue<.1) tiles[x][y].setTerrain(new Grass(noiseValue));
//		else tiles[x][y].setTerrain(new Ocean(noiseValue));
	}
	public static int getTilesHorizontal()
	{
		return Main.getScreenWidth() / TILE_SIZE;
	}
	
	public static int getTilesVertical()
	{
		return Main.getScreenHeight() / TILE_SIZE;
	}
	public Tile getTile(int x, int y)
	{
	return tiles.get(x).get(y);
	}
}
