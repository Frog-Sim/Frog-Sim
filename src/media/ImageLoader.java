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
    public static Image grassThree;
    public static Image grassFour;
    public static Image grassFive;
    public static Image snowOne;
    public static Image snowTwo;
    public static Image snowThree;
    public static Image snowFour;
    public static Image snowFive;
    public static Image bigTree;
    public static Image clearBigTree;
    public static Image waterOne;
    public static Image pool;
    public static Image toad;
    public static SpriteSheet frogOne;
    public static Image deathSkull;
    public static Image deathSmoke;
    private static Image frogOneImage;
    private static ArrayList<Image> images;


    public static void init() throws SlickException, IOException {
        images = new ArrayList<Image>();
        grassOne = loadImage("res/grassOne.png");
        grassOne = grassOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        images.add(grassOne);
        grassTwo = loadImage("res/grassTwo.png");
        grassTwo = grassTwo.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        grassThree = loadImage("res/grassThree.png");
        grassThree = grassThree.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        grassFour = loadImage("res/grassFour.png");
        grassFour = grassFour.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        grassFive = loadImage("res/grassFive.png");
        grassFive = grassFive.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);

        images.add(grassTwo);
        snowOne = loadImage("res/snowOne.png");
        snowOne = snowOne.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        snowTwo = loadImage("res/snowTwo.png");
        snowTwo = snowTwo.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        snowThree = loadImage("res/snowThree.png");
        snowThree = snowThree.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        snowFour = loadImage("res/snowFour.png");
        snowFour = snowFour.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
        snowFive = loadImage("res/snowFive.png");
        snowFive = snowFive.getScaledCopy(Map.TILE_SIZE, Map.TILE_SIZE);
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
        pool = loadImage("res/breeding pool.png").getScaledCopy(200, 200);
        images.add(pool);

        toad = loadImage("res/toad.png").getScaledCopy(256, 256);
        images.add(toad);

        deathSkull = loadImage("res/skull.png");
        images.add(deathSkull);
        deathSmoke = loadImage("res/smoke.png");
        images.add(deathSmoke);

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

    public static Image loadImage(String path) throws IOException, SlickException {
        BufferedImage bufferedImage = ImageIO.read(new File(path));
        Texture texture = BufferedImageUtil.getTexture("", bufferedImage);
        Image image = new Image(texture.getImageWidth(), texture.getImageHeight());
        image.setTexture(texture);
        return image;
    }
}