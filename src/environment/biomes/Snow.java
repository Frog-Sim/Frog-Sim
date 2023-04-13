package environment.biomes;

import media.ImageLoader;

public class Snow extends Biome {

    public Snow(float noiseValue) {
        super(noiseValue);
        image = ImageLoader.snowOne;
//        if (rand < .5) image = ImageLoader.grassOne;
//        else image = ImageLoader.grassTwo;
    }

    public void update() {
        image = ImageLoader.snowOne;
    }

}