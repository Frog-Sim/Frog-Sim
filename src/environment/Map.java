package environment;

import java.util.ArrayList;

import environment.biomes.Snow;
import org.newdawn.slick.Graphics;

import core.Game;
import core.Main;
import environment.biomes.Grass;



public class Map {
	public static int updateRadius=4;
	public static int TILE_SIZE=120;

	private Tile[][] tiles;
	public int seed;
	private FastNoiseLite noise;
	public Map(Game g) {
		seed=(int)(Math.random()*2000);
		noise=new FastNoiseLite(seed);
		noise.SetFractalType(FastNoiseLite.FractalType.PingPong);
		tiles = new Tile[getTilesHorizontal()*5+2][getTilesVertical()*5+2];
		for(int i = 0; i < getTilesHorizontal()*5+2; i++)
		{
//			System.out.println("rows: "+tiles.length);
			for(int j = 0; j < getTilesVertical()*5+2; j++)
			{
//				System.out.println("col: "+tiles[i].length);
				tiles[i][j] = new Tile(i*TILE_SIZE-TILE_SIZE, j*TILE_SIZE-TILE_SIZE);
				generateTileAdvancedNoise(i, j);
			}
		}
	}
	public void update() {
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				generateTileAdvancedNoise(i, j);
				tiles[i][j].update();
			}
		}
	}
	public void render(Graphics g) {
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				tiles[i][j].render(g);
			}
		}
	}

	public void generateTileAdvancedNoise(int x, int y) {
		int xTile = x; int yTile = y;
		float SCALE = .2f;
		float noiseValue=noise.GetNoise(x*SCALE, y*SCALE);
		if(noiseValue<.2) tiles[xTile][yTile].setBiome(new Grass(noiseValue));
		else tiles[xTile][yTile].setBiome(new Snow(noiseValue));
//		if(noiseValue<.042 && noiseValue>.041)
//			tiles[(int) getXMinus(x)][(int) getYMinus(y)]
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
	public int getXPlus(int i) {
		return (i+Game.getCamX());
	}
	public int getYPlus(int j) {
		return (j+Game.getCamY());
	}
	public int getXMinus(int i) {
		return (i-Game.getCamX());
	}
	public int getYMinus(int j) {
		return (j-Game.getCamY());
	}
}
