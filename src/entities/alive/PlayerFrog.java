package entities.alive;

import core.Game;
import entities.Pool;
import entities.death.Explode;
import entities.death.Smoke;
import entities.death.baseDeath;
import grouping.Pack;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;

import java.util.ArrayList;

public class PlayerFrog extends Frog {
    private final int tick;
    public Pack playerPack;
    public boolean idle;

    public PlayerFrog(float x, float y) {
        super(x, y, true);
        playerPack = new Pack(this);
        this.flying = true;
        tick = 0;

        // TODO Auto-generated constructor stub
    }

    public void render(Graphics g) {

//		g.setColor(Color.white);
//		g.drawString("X: "+xPos, xPos-10, yPos-10);
//		g.drawString("Y: "+yPos, xPos-10, yPos-50);
//		g.drawString("Angle: "+angle, xPos-10, yPos-50);
//		float testRadius= (float) Math.sqrt(Math.pow(this.height/2, 2)+Math.pow(this.width/2, 2));
//		g.drawOval(getCenterX()-testRadius, getCenterY()-testRadius, testRadius*2, testRadius*2);
        super.render(g);

    }

    public void update() {
//        curHealth -= 4;
        super.update();
//        tick++;
//        if (spinner) {
//            tick++;
//            this.setAngle(tick);
//            this.image = this.image.getScaledCopy(this.image.getWidth() + tick, this.image.getHeight() + tick);
//            this.imageAccent = this.imageAccent.getScaledCopy(this.imageAccent.getWidth() + tick, this.imageAccent.getHeight() + tick);
//            this.imageExtra = this.imageExtra.getScaledCopy(this.imageExtra.getWidth() + tick, this.imageExtra.getHeight() + tick);
//            this.imageJump = this.imageJump.getScaledCopy(this.imageJump.getWidth() + tick, this.imageJump.getHeight() + tick);
//
//            if (tick >= 200) {
//                Game.entities.remove(this);
//            }
//        }

//        this.setAngle(tick);
//		curHealth-=0.1f;
//		if(this.isJumping)
//		{
//			playerPack.moveAll(angle);
//		}
        ArrayList<Pool> pools = Game.getPools();
        for (int i = 0; i < pools.size(); i++) {
            if (getDistance(pools.get(i)) < 500) {
                for (int j = 0; j < playerPack.getFrogs().size() / 2 && j < 11; j++) {
                    Frog newFrog = new Follower((float) (pools.get(i).getX() + Math.random() * 300 - 150), (float) (pools.get(i).getY() + Math.random() * 300 - 150));
                    Game.addEntity(newFrog);
                }
                Game.removePool(pools.get(i));
            }
        }
        playerPack.update();
        deathRing();
        super.update();
    }

    public Pack getPack() {
        return playerPack;
    }

    private void deathRing() {

    }

    public void setDestPoint(Point p) {
        destinationPoint = p;
    }


    public void onDeath() {
        Smoke smoke = new Smoke(this.xPos, this.yPos, 20, 20);
        baseDeath skull = new baseDeath(this.xPos, this.yPos, 20, 20);
        Explode explode;
        try {
            explode = new Explode(this.xPos, this.yPos, 20, 20);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
        double rand = Math.random();
        if (rand < 0.25) {
            Game.entities.add(smoke);
            Game.entities.remove(this);
        } else if (rand < 0.5) {
            Game.entities.add(skull);
            Game.entities.remove(this);
        } else if (rand < 0.75) {
            Game.entities.add(explode);
            Game.entities.remove(this);
        } else {
            spinner = true;
//        }
        }
    }
}