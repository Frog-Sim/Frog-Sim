package media;

import environment.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageLoader {
    public static Image grassOne;
    public static Image grassTwo;
    public static Image snowOne;
    public static Image bigTree;
    public static Image clearBigTree;
    public static Image waterOne;
    public static SpriteSheet frogOne;
    private static Image frogOneImage;
    private static ArrayList<Image> images;

    public static void init() throws SlickException, IOException {
        images = new ArrayList<Image>();
        grassOne = loadImage("res/grassOne.png");
        grassOne = grassOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(grassOne);
        grassTwo = loadImage("res/grassTwo.png");
        grassTwo = grassTwo.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(grassTwo);
        snowOne = loadImage("res/snowOne.png");
        snowOne = snowOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(snowOne);
        bigTree = loadImage("res/largeTree.png");
        bigTree = bigTree.getScaledCopy(Map.TILE_SIZE * 9, Map.TILE_SIZE * 9);
        images.add(bigTree);
        clearBigTree = loadImage("res/clearTree.png");
        clearBigTree = clearBigTree.getScaledCopy(Map.TILE_SIZE * 9, Map.TILE_SIZE * 9);
        images.add(clearBigTree);
        waterOne = loadImage("res/water.png");
        waterOne = waterOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(waterOne);

        frogOne = new SpriteSheet(loadImage("res/frogOne.png").getScaledCopy(100, 700), 100, 100);
    }

    public static void scaleImage(int x, int y) {
        grassOne = grassOne.getScaledCopy(x, y);
        grassTwo = grassTwo.getScaledCopy(x, y);
        snowOne = snowOne.getScaledCopy(x, y);
        bigTree = bigTree.getScaledCopy(x, y);
        clearBigTree = clearBigTree.getScaledCopy(x, y);
        waterOne = waterOne.getScaledCopy(x, y);
//        grassOne=grassOne.getScaledCopy(x,y);
//        grassOne=grassOne.getScaledCopy(x,y);
    }

    public static void scaleImage(float scale) {
        grassOne = grassOne.getScaledCopy(scale);
        grassTwo = grassTwo.getScaledCopy(scale);
        snowOne = snowOne.getScaledCopy(scale);
        bigTree = bigTree.getScaledCopy(scale);
        clearBigTree = clearBigTree.getScaledCopy(scale);
        waterOne = waterOne.getScaledCopy(scale);
//        grassOne=grassOne.getScaledCopy(x,y);
//        grassOne=grassOne.getScaledCopy(x,y);
    }

    public static Image loadImage(String path) throws IOException, SlickException {
        BufferedImage bufferedImage = ImageIO.read(new File(path));
        Texture texture = BufferedImageUtil.getTexture("", bufferedImage);
        Image image = new Image(texture.getImageWidth(), texture.getImageHeight());
        image.setTexture(texture);
        return image;
    }
}