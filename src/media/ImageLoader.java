package media;

import environment.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader {
	public static Image grassOne;
	public static Image grassTwo;
	public static Image snowOne;
	public static void init() throws SlickException {
		grassOne= new Image("res/grassOne.png");
		grassOne=grassOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
		grassTwo= new Image("res/grassTwo.png");
		grassTwo=grassTwo.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
		snowOne= new Image("res/snowOne.png");
		snowOne=snowOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
	}
}
