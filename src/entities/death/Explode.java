package entities.death;

import core.Game;
import entities.Entity;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Explode extends Entity {

    private final SpriteSheet explosionSheet;
    private final Image explosionFrame;
    protected int timer;
    protected float tick;
    private int lifetime;
    private int tile;

    public Explode(float x, float y, float width, float height) throws SlickException {
        super(x, y, width, height);
        timer = 60;
        explosionFrame = new Image("res/explosion.png");
        explosionSheet = new SpriteSheet(explosionFrame, 128, 128);
        tick = 1;
        lifetime = 0;
    }

    @Override
    public boolean collideWith(Entity e) {
        return false;
    }

    public void update() {
        if (tick > 0) {
            tick -= 0.01;
        }
        lifetime++;

    }

    public void render(Graphics g) {

        if (lifetime < 120) {
            tile = lifetime / 10;
        } else {
            Game.entities.remove(this);
        }
        explosionSheet.getSprite(tile, 0).draw(xPos, yPos);

//        g.setColor(new Color(0, 0, 0));
////        if (image != null) {
//        Image tmp = explosionSheet.getScaledCopy(Game.zoomScale);
//        tmp.setAlpha(tick);
//
//        tmp.draw(xPos, yPos);
//        }
    }

}
