package environment.biomes;

import media.ImageLoader;

public class Grass extends Biome {

    public Grass(float noiseValue) {
        super(noiseValue);
        if (rand < .5) image = ImageLoader.grassOne;
        else image = ImageLoader.grassTwo;
    }

    public void update() {
        if (rand < .5) image = ImageLoader.grassOne;
        else image = ImageLoader.grassTwo;
    }

}