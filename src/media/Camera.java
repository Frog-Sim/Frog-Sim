package media;

import core.Game;
import core.Main;

public class Camera {
    private final static float EASING = .06f;
    private final Game g;
    private float xPos;
    private float yPos;

    public Camera(Game g) {
        xPos = 0;
        yPos = 0;
        this.g = g;
    }

    public float getX() {
        return xPos * Game.zoomScale;
    }

    public float getY() {
        return yPos * Game.zoomScale;
    }

    public void update() {
        float newX = (Game.bestFrog.getX() - Main.getScreenWidth() / 2) * Game.zoomScale;
        xPos += (newX - xPos * Game.zoomScale) * EASING;
        float newY = (Game.bestFrog.getY() - Main.getScreenHeight() / 2) * Game.zoomScale;
        yPos += (newY - yPos * Game.zoomScale) * EASING;
    }
}
