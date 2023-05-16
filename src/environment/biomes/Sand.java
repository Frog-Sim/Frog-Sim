package environment.biomes;

import core.Game;
import media.ImageLoader;
import org.newdawn.slick.Graphics;

public class Sand extends Biome {

    public Sand(float noiseValue) {
        super(noiseValue);
    }

    public void update() {

    }

    public void render(Graphics g) {
        if (rand < .25) g.drawImage(ImageLoader.sandOne, tile.getX(), tile.getY());
        else if (rand < .5) g.drawImage(ImageLoader.sandTwo, tile.getX() , tile.getY() );
        else if (rand < .75) g.drawImage(ImageLoader.sandThree, tile.getX() , tile.getY()); 
        else g.drawImage(ImageLoader.sandFour, tile.getX() , tile.getY() );
    }
}