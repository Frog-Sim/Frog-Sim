package environment;

import java.util.ArrayList;

import environment.biomes.Snow;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import core.Game;
import core.Main;
import environment.biomes.Grass;



public class Map {
	public static int updateRadius=4;
	public static int TILE_SIZE=120;

	private ArrayList<Tile> tiles;
//	private Tile topLeft;
//	private Tile topRight;
//	private Tile bottomLeft;
//	private Tile bottomRight;
	public int seed;
	private static FastNoiseLite noise;
	public Map(Game g) {
		seed=(int)(Math.random()*2000);
		noise=new FastNoiseLite(seed);
		noise.SetFractalType(FastNoiseLite.FractalType.PingPong);
		tiles = new ArrayList<Tile>();
		for(int i = 0; i < getTilesHorizontal()+2; i++)
		{
//			System.out.println("rows: "+tiles.length);
			for(int j = 0; j < getTilesVertical()+2; j++)
			{
//				System.out.println("col: "+tiles[i].length);
				tiles.add(new Tile(i*TILE_SIZE-TILE_SIZE, j*TILE_SIZE-TILE_SIZE));
			}
		}
	}
	public void update() {
		float TopY=Float.MAX_VALUE;
		float BottomY=Float.MIN_VALUE;
		float LeftX=Float.MAX_VALUE;
		float RightX=Float.MIN_VALUE;
		int xAdd=0; int yAdd=0;
		for(Tile t: tiles) {
			if(t.getY()<TopY) TopY=t.getY();
			if(t.getY()>BottomY) BottomY=t.getY();
			if(t.getX()<LeftX) LeftX=t.getX();
			if(t.getX()>RightX) RightX=t.getX();
		}
		if(Game.getCamX()<LeftX) {
			xAdd=(int)((LeftX-Game.getCamX())/TILE_SIZE)+1;
			for(float i=LeftX; i>Game.getCamX()-TILE_SIZE; i-=TILE_SIZE) {
				for(float j=TopY; j<BottomY+TILE_SIZE; j+=TILE_SIZE) {
					tiles.add(new Tile(i, j));
				}
			}
		}
		if(Game.getCamX()+Main.getScreenWidth()>RightX) {
			xAdd=(int)((Game.getCamX()+Main.getScreenWidth()-RightX)/TILE_SIZE)+1;
			for(float i=RightX; i<Game.getCamX()+Main.getScreenWidth()+TILE_SIZE; i+=TILE_SIZE) {
				for(float j=TopY; j<BottomY+TILE_SIZE; j+=TILE_SIZE) {
					tiles.add(new Tile(i, j));
				}
			}
		}
		if(Game.getCamY()<TopY) {
			yAdd=(int)((TopY-Game.getCamY())/TILE_SIZE)+1;
			for(float i=LeftX; i<RightX+TILE_SIZE; i+=TILE_SIZE) {
				for(float j=TopY; j>Game.getCamY()-TILE_SIZE; j-=TILE_SIZE) {
					tiles.add(new Tile(i, j));
				}
			}
		}
		if(Game.getCamY()+Main.getScreenHeight()>BottomY) {
			yAdd=(int)((Game.getCamY()+Main.getScreenHeight()-BottomY)/TILE_SIZE)+1;
			for(float i=LeftX; i<RightX+TILE_SIZE; i+=TILE_SIZE) {
				for(float j=BottomY; j<Game.getCamY()+Main.getScreenHeight()+TILE_SIZE; j+=TILE_SIZE) {
					tiles.add(new Tile(i, j));
				}
			}
		}
		for(Tile t: tiles) {
			if(t.getX()>Game.getCamX()-TILE_SIZE && t.getX()<Game.getCamX()+Main.getScreenWidth()+TILE_SIZE
			&& t.getY()>Game.getCamY()-TILE_SIZE && t.getY()<Game.getCamY()+Main.getScreenHeight()+TILE_SIZE) {
				t.update();
			}
		}
		System.out.println(tiles.size());
	}
	public void render(Graphics g) {
		for(Tile t: tiles) {
			if(t.getX()>Game.getCamX()-TILE_SIZE && t.getX()<Game.getCamX()+Main.getScreenWidth()+TILE_SIZE
			&& t.getY()>Game.getCamY()-TILE_SIZE && t.getY()<Game.getCamY()+Main.getScreenHeight()+TILE_SIZE) {
				t.render(g);
			}
		}
		
	}
	public Tile getTile(float x, float y) {
		for(Tile t: tiles) {
			if(t.getX()==x && t.getY()==y) return t;
		}
		return null;
	}

	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	public static int getTilesHorizontal()
	{
		return Main.getScreenWidth() / TILE_SIZE;
	}
	
	public static int getTilesVertical()
	{
		return Main.getScreenHeight() / TILE_SIZE;
	}
	public static FastNoiseLite getNoise() {
		return noise;
	}
}
