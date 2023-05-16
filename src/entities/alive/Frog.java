package entities.alive;


import core.Game;
import entities.death.Explode;
import entities.death.Smoke;
import entities.death.baseDeath;
import media.ImageLoader;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;

public class Frog extends Animal {

    protected static final int FROG_SIZE = 100;
    protected float curJumpTime;
    protected float jumpTimer;
    protected float jumpCooldown;
    protected float jumpDistance;
    protected boolean isJumping;
    protected boolean canJump;
    protected Point destination;

    protected Image image;
    protected Color color;
    protected Image imageAccent;
    protected Color colorAccent;
    protected Image imageExtra;
    protected Color colorExtra;
    protected Image imageJump;
    protected SpriteSheet sheet;
    protected boolean spinner;
    int tick;

    public Frog(float x, float y) {
        super(x, y, FROG_SIZE, FROG_SIZE);
        tick = 0;
        jumpTimer = 30;
        jumpDistance = 200;
        canJump = true;
        sheet = ImageLoader.frogOne;
        image = sheet.getSprite(0, 0);
        imageAccent = sheet.getSprite(0, 1);
        imageExtra = sheet.getSprite(0, (int) (Math.random() * 3 + 2));
        imageJump = sheet.getSprite(0, 5);
        color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        colorAccent = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        colorExtra = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        spinner = false;
    }

    public Frog(float x, float y, boolean player) {
        super(x, y, FROG_SIZE, FROG_SIZE);
        jumpTimer = 30;
        jumpDistance = 200;
        canJump = true;
        sheet = ImageLoader.frogOne;
        image = sheet.getSprite(0, 0);
        imageAccent = sheet.getSprite(0, 1);
        imageExtra = sheet.getSprite(0, 6);
        imageJump = sheet.getSprite(0, 5);
        this.color = new Color(Color.white);
        this.colorAccent = new Color(Color.black);
        this.colorExtra = new Color(Color.white);
    }

    public void update() {

        if (spinner) {
            tick++;
            this.setAngle(tick);
            this.image = this.image.getScaledCopy(this.image.getWidth() + tick, this.image.getHeight() + tick);
            this.imageAccent = this.imageAccent.getScaledCopy(this.imageAccent.getWidth() + tick, this.imageAccent.getHeight() + tick);
            this.imageExtra = this.imageExtra.getScaledCopy(this.imageExtra.getWidth() + tick, this.imageExtra.getHeight() + tick);
            this.imageJump = this.imageJump.getScaledCopy(this.imageJump.getWidth() + tick, this.imageJump.getHeight() + tick);

            if (tick >= 200) {
                Game.entities.remove(this);
            }
        }

        if (isJumping) {
            jump();
        } else {
            jumpCooldown--;
            canJump = jumpCooldown < 0;
        }
        super.update();
    }

    private void jump() {
        curJumpTime++;
        if (curJumpTime > jumpTimer || getDistance(destination) < (jumpDistance / jumpTimer) * 1.5f) {
            isJumping = false;
            xVel = 0;
            yVel = 0;
            jumpCooldown = jumpTimer / 4;
            return;
        }
        float speed = jumpDistance / jumpTimer;
        xVel = (float) (speed * Math.cos(getAngle()));
        yVel = (float) (speed * Math.sin(getAngle()));
    }

    public void startJump(float angle) {
        if (canJump) {
            canJump = false;
            this.setAngle(angle);
            curJumpTime = 0;
            isJumping = true;
            destination = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
    }

    public void startJump(float targetX, float targetY) {
        if (canJump) {
            canJump = false;
            this.setAngle(getAngleTo(targetX, targetY));
            curJumpTime = 0;
            isJumping = true;
            destination = new Point(targetX, targetY);
        }
    }

    public void startJump() {
        if (canJump) {
            canJump = false;
            curJumpTime = 0;
            isJumping = true;
            destination = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
    }

    public void render(Graphics g) {
        super.render(g);
        if (image != null) {
            Image tmp = image.getScaledCopy(Game.zoomScale);
            tmp.setCenterOfRotation(tmp.getWidth() / 2 * Game.zoomScale, tmp.getHeight() / 2 * Game.zoomScale);
            tmp.rotate(90 + (float) ((180 / Math.PI) * angle));
            tmp.draw(xPos, yPos, color);
        }
        if (imageAccent != null) {

            Image tmp = imageAccent.getScaledCopy(Game.zoomScale);
            tmp.setCenterOfRotation(tmp.getWidth() / 2 * Game.zoomScale, tmp.getHeight() / 2 * Game.zoomScale);
            tmp.rotate(90 + (float) ((180 / Math.PI) * angle));
            tmp.draw(xPos, yPos, colorAccent);
        }
        if (imageExtra != null) {
            Image tmp = imageExtra.getScaledCopy(Game.zoomScale);
            tmp.setCenterOfRotation(tmp.getWidth() / 2 * Game.zoomScale, tmp.getHeight() / 2 * Game.zoomScale);
            tmp.rotate(90 + (float) ((180 / Math.PI) * angle));
            tmp.draw(xPos, yPos, colorExtra);
        }
        if (imageJump != null && isJumping) {
            Image tmp = imageJump.getScaledCopy(Game.zoomScale);
            tmp.setCenterOfRotation(tmp.getWidth() / 2 * Game.zoomScale, tmp.getHeight() / 2 * Game.zoomScale);
            tmp.rotate(90 + (float) ((180 / Math.PI) * angle));
            tmp.draw(xPos, yPos, color);
        }
    }

    public void modifyHealth(float multi) {
        maxHealth *= multi;
    }

    public void modifyRegen(float multi) {
        regen *= multi;
    }

    public void modifyAttackDamage(float multi) {
        attackDamage *= multi;
    }

    public void modifyAttackSpeed(float multi) {
        jumpDistance *= multi;
    }

    public void modifyJumpTimer(float multi) {
        jumpTimer *= multi;
    }

    public void modifyJumpDistance(float multi) {
        jumpDistance *= multi;
    }


    public void setHealthBonus(float newHealth) {
        this.maxHealth = newHealth;
    }

    public void setAttackDamageBonus(float newAttack) {
        this.attackDamage = newAttack;
    }

    public void setAttackSpeedBonus(float newAttack) {
        this.attackSpeed = newAttack;
    }

    public void setJumpDistance(float jump) {
        jumpDistance = jump;
    }

    public void setJumpTimer(float timer) {
        jumpTimer = timer;
    }

    public void resetJump() {
        isJumping = false;
        jumpCooldown = -100;
    }

    @Override
    public void onDeath() {
        // TODO Auto-generated method stub
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
        }
    }

}