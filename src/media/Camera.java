package media;

import core.Game;
import core.Main;

public class Camera {
    // Basic Zooming and Scrolling
    public static final float ZOOM_RATE = .02f; //.01
    public static final float ZOOM_DISTANT = .25f;
    public static final float ZOOM_MEDIUM = .5f;
    public static final float ZOOM_CLOSE = 1;
    private final static float EASING = .06f;
    private static float currentZoom;
    private static float goalZoom;
    private static int viewSizeX;
    private static int viewSizeY;
    private final Game g;
    private final float xVel = 0;
    private final float yVel = 0;
    private float xPos;
    private float yPos;

    public Camera(Game g) {
        xPos = 0;
        yPos = 0;
        this.g = g;
    }

    public static void zoom(float amount) {
        // Increase by a zoom level
        if (amount > 0) {
            if (goalZoom == ZOOM_MEDIUM) {
                goalZoom = ZOOM_CLOSE;
            } else if (goalZoom == ZOOM_DISTANT) {
                goalZoom = ZOOM_MEDIUM;
            }
        }

        // Decrease by a zoom level
        else if (amount < 0) {
            if (goalZoom == ZOOM_CLOSE) {
                goalZoom = ZOOM_MEDIUM;
            } else if (goalZoom == ZOOM_MEDIUM) {
                goalZoom = ZOOM_DISTANT;
            }
        }

        viewSizeX = (int) (Main.getScreenWidth() / currentZoom);
        viewSizeY = (int) (Main.getScreenHeight() / currentZoom);
    }

    public float getX() {
        return xPos;
    }

    public float getY() {
        return yPos;
    }

    public void update() {
        if (currentZoom < goalZoom) {
            currentZoom = Math.min(currentZoom + ZOOM_RATE, goalZoom);
        }

        if (currentZoom > goalZoom) {
            currentZoom = Math.max(currentZoom - ZOOM_RATE, goalZoom);
        }

        viewSizeX = (int) (Main.getScreenWidth() / currentZoom);
        viewSizeY = (int) (Main.getScreenHeight() / currentZoom);
        float newX = Game.bestFrog.getX() * Game.zoomScale - Main.getScreenWidth() / 2;
        xPos += (newX - xPos) * EASING;
        float newY = Game.bestFrog.getY() * Game.zoomScale - Main.getScreenHeight() / 2;
        yPos += (newY - yPos) * EASING;
    }
}
