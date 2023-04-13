package entities.alive;

import core.Game;
import entities.Entity;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;

import java.util.ArrayList;

public abstract class Animal extends Entity {
    public Point destinationPoint;
    protected float maxHealth = 1000;
    protected float curHealth = 500;
    protected float attackSpeed;
    protected float attackDamage;
    protected float regen = 0.5f;
    protected boolean flying;
    public Animal(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public void update() {
        xPos = this.xPos += xVel;
        yPos = this.yPos += yVel;
        ArrayList<Entity> allEntities = Game.getEntities();
        for (Entity e : allEntities) {
            if (collideWith(e) && e != this) {
                float newangle = (float) (getAngleTo(e) + Math.PI);
                xPos = this.xPos -= xVel;
                yPos = this.yPos -= yVel;
                xPos += (float) (1 * Math.cos(newangle));
                yPos += (float) (1 * Math.sin(newangle));
                return;
            }
        }
        if (curHealth < maxHealth) {
            curHealth += regen;
        }


    }

    public void render(Graphics g) {
        float compressionFactor = maxHealth / 128;
        g.setColor(new Color(0, 0, 0));
        g.drawRect((xPos - 1) * Game.zoomScale, (yPos - 1) * Game.zoomScale, 128 + 1, 21);
        g.setColor(Color.green);
        g.fillRect(xPos * Game.zoomScale, yPos * Game.zoomScale, curHealth / compressionFactor, 20);
        g.setColor(Color.red);
        g.fillRect((xPos + curHealth / compressionFactor) * Game.zoomScale, yPos * Game.zoomScale, (maxHealth - curHealth) / compressionFactor, 20);
    }

    public boolean isFlying() {
        return flying;
    }
}
