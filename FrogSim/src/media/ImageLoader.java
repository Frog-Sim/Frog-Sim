package media;

import environment.Map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

public class ImageLoader {
	public static Image grassOne;
	public static Image grassTwo;
	public static Image snowOne;
	public static void init() throws IOException, SlickException {
//		grassOne= new Image("res/grassOne.png");
//		grassOne=grassOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
//		grassTwo= new Image("res/grassTwo.png");
//		grassTwo=grassTwo.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
//		snowOne= new Image("res/snowOne.png");
//		snowOne=snowOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
		grassOne=loadImage("res/grassOne.png");
		grassOne=grassOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
		grassTwo=loadImage("res/grassTwo.png");
		grassTwo=grassTwo.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
		snowOne=loadImage("res/snowOne.png");
		snowOne=snowOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
	}
	public static Image loadImage(String path) throws IOException, SlickException {
        BufferedImage bufferedImage = ImageIO.read(new File(path));
        Texture texture = BufferedImageUtil.getTexture("", bufferedImage);
        Image image = new Image(texture.getImageWidth(), texture.getImageHeight());
        image.setTexture(texture);
        return image;
    }
}
