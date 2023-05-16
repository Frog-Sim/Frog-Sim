package entities.death;

import core.Game;
import entities.Entity;
import media.ImageLoader;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class KingToadDeath extends Entity {

    protected int timer;
    protected Image image;
    protected float tick;

    public KingToadDeath(float x, float y, float width, float height) {
        super(x, y, width, height);
        timer = 60;
        image = ImageLoader.deathToad;
        tick = 1;
    }

    @Override
    public boolean collideWith(Entity e) {
        return false;
    }

    public void update() {
        if (tick > 0) {
            tick -= 0.01;
        }

    }

    public void render(Graphics g) {

        g.setColor(new Color(0, 0, 0));
//        if (image != null) {
        Image tmp = image.getScaledCopy(Game.zoomScale);
        tmp.setAlpha(tick);
        if (tmp.getAlpha() == 0) {
            Game.entities.remove(this);
        }
        tmp.draw(xPos, yPos);
//        }
    }

}
