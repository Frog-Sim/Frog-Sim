package environment;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import core.Game;
import core.Main;
import environment.biomes.Grass;



public class Map {
	private Tile[][] tiles;
	public static int TILE_SIZE;
	public int seed;
	private FastNoiseLite noise;
	private Game g;
	public Map(Game g) {
		seed=(int)(Math.random()*2000);
		noise=new FastNoiseLite(seed);
		TILE_SIZE=40;
		tiles = new Tile[getTilesHorizontal()][getTilesVertical()];
		this.g=g;
	}
	public void update() {

		for(int i = 0; i < getTilesHorizontal(); i++)
		{
//			System.out.println("rows: "+tiles.size());
			for(int j = 0; j < getTilesVertical(); j++)
			{
//				System.out.println("col: "+tiles.get(i).size());
				tiles[i][j] = new Tile(i, j);
				generateTileAdvancedNoise((int) getXPlus(i), (int) getYPlus(j));
			}
		}
		for(int i = 0; i < getTilesHorizontal(); i++)
		{
			for(int j = 0; j < getTilesVertical(); j++)
			{
				tiles[i][j].update();
			}
		}
	}
	public void render(Graphics g) {
		for(int i = 0; i < getTilesHorizontal(); i++)
		{
			for(int j = 0; j < getTilesVertical(); j++)
			{
				tiles[i][j].render(g);
			}
		}
	}

	public void generateTileAdvancedNoise(int x, int y) {
		float SCALE = 1f;
		float noiseValue=noise.GetNoise(x*SCALE, y*SCALE);
		tiles[(int) getXMinus(x)][(int) getYMinus(y)].setBiome(new Grass(noiseValue));
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
	return tiles[x][y];
	}
	public float getXPlus(int i) {
		return (i+Game.bestFrog.getX()/32-Main.getScreenWidth()/2);
	}
	public float getYPlus(int j) {
		return (j+Game.bestFrog.getY()/32-Main.getScreenHeight()/2);
	}
	public float getXMinus(int i) {
		return (i-Game.bestFrog.getX()/32+Main.getScreenWidth()/2);
	}
	public float getYMinus(int j) {
		return (j-Game.bestFrog.getY()/32+Main.getScreenHeight()/2);
	}
}
