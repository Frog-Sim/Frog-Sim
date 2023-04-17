package environment.biomes;

import media.ImageLoader;

public class Water extends Biome {

    public Water(float noiseValue) {
        super(noiseValue);
        image = ImageLoader.waterOne;
    }

    public void scaleImages() {
        image = ImageLoader.waterOne;
    }

    public void update() {
        image = ImageLoader.waterOne;
    }

}