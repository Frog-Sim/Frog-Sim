package entities.obstacles;

import core.Game;
import entities.Entity;
import environment.Map;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Tree extends Entity {
    public Tree(float x, float y) {
        super(x, y, Map.TILE_SIZE * 4, Map.TILE_SIZE * 4);
    }

    public void update() {
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(xPos * Game.zoomScale, yPos * Game.zoomScale, height * Game.zoomScale, width * Game.zoomScale);
        float testRadius = (float) Math.sqrt(Math.pow(this.height / 2, 2) + Math.pow(this.width / 2, 2));
//
//        if (getDistance(Game.bestFrog) > 500) {
//            g.drawImage(ImageLoader.bigTree, xPos - ImageLoader.bigTree.getWidth() / 4, yPos - ImageLoader.bigTree.getHeight() / 4);
//        } else {
//            g.drawImage(ImageLoader.clearBigTree, xPos - ImageLoader.bigTree.getWidth() / 4, yPos - ImageLoader.bigTree.getHeight() / 4);
//        }
        g.drawOval(getCenterX() - testRadius, getCenterY() - testRadius, testRadius * 2, testRadius * 2);

    }
}
