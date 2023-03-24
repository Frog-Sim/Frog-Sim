package media;

import environment.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class ImageLoader {
    public static Image grassOne;
    public static Image grassTwo;
    public static Image snowOne;
    public static Image bigTree;
    public static Image clearBigTree;
    private static ArrayList<Image> images;

    public static void init() throws SlickException {
        images = new ArrayList<Image>();
        grassOne = new Image("res/grassOne.png");
        grassOne = grassOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(grassOne);
        grassTwo = new Image("res/grassTwo.png");
        grassTwo = grassTwo.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(grassTwo);
        snowOne = new Image("res/sandTexture.png");
        snowOne = snowOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(snowOne);
        bigTree = new Image("res/bigTree.png");
        bigTree = bigTree.getScaledCopy(Map.TILE_SIZE * 9, Map.TILE_SIZE * 9);
        images.add(bigTree);
        clearBigTree = new Image("res/clearTree.png");
        clearBigTree = clearBigTree.getScaledCopy(Map.TILE_SIZE * 9, Map.TILE_SIZE * 9);
        images.add(clearBigTree);
    }

    public static void scaleImage(int x, int y) {
        grassOne = grassOne.getScaledCopy(x, y);
        grassTwo = grassTwo.getScaledCopy(x, y);
        snowOne = snowOne.getScaledCopy(x, y);
        bigTree = bigTree.getScaledCopy(x, y);
        clearBigTree = clearBigTree.getScaledCopy(x, y);
//        grassOne=grassOne.getScaledCopy(x,y);
//        grassOne=grassOne.getScaledCopy(x,y);
    }
}