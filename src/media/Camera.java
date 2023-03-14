package media;

import core.Game;
import core.Main;

public class Camera {
    private final static float EASING = .06f;
    private int xPos;
    private int yPos;
    private final Game g;

    public Camera(Game g) {
        xPos = 0;
        yPos = 0;
        this.g = g;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void update() {
        float newX = Game.bestFrog.getX() * Game.zoomScale - Main.getScreenWidth() / 2;
        xPos += (newX - xPos) * EASING;
        float newY = Game.bestFrog.getY() * Game.zoomScale - Main.getScreenHeight() / 2;
        yPos += (newY - yPos) * EASING;
    }
}
