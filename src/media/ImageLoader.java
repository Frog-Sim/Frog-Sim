package media;

import environment.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader {
	public static Image frogImage;
	public static void init() throws SlickException {
		frogImage= new Image("res/grassOne.png");
		frogImage=frogImage.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
	}
}
