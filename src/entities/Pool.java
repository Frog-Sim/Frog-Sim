package entities;

import core.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Pool extends Entity {
    final static private float POOL_SIZE = 200;

    public Pool(float x, float y) {
        super(x, y, POOL_SIZE, POOL_SIZE);
    }

    public void update() {
    }

    public void render(Graphics g) {
        g.setColor(new Color(100, 200, 100));
        g.fillOval(xPos * Game.zoomScale, yPos * Game.zoomScale, width * Game.zoomScale, height * Game.zoomScale);
    }

    public void zoom(float scale) {

    }
}
