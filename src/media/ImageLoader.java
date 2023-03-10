package media;

import environment.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class ImageLoader {
    public static Image grassOne;
    public static Image grassTwo;
    public static Image snowOne;
    private static ArrayList<Image> images;

    public static void init() throws SlickException {
        images = new ArrayList<Image>();
        grassOne = new Image("res/grassOne.png");
        grassOne = grassOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(grassOne);
        grassTwo = new Image("res/grassTwo.png");
        grassTwo = grassTwo.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(grassTwo);
        snowOne = new Image("res/snowOne.png");
        snowOne = snowOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(snowOne);
    }

    public static void scaleImage(int x, int y) {
        for (Image i : images) {
            i = i.getScaledCopy(x, y);
        }
    }
}
