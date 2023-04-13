package entities.obstacles;

import core.Game;
import entities.Entity;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Tree extends Entity {
    public Tree(float x, float y) {
        super(x, y, 300, 300);
    }

    public void update() {
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(xPos * Game.zoomScale, yPos * Game.zoomScale, height * Game.zoomScale, width * Game.zoomScale);
//		float testRadius= (float) Math.sqrt(Math.pow(this.height/2, 2)+Math.pow(this.width/2, 2));
//		g.drawOval(getCenterX()-testRadius, getCenterY()-testRadius, testRadius*2, testRadius*2);
    }
}
