package animations;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;

import core.Game;

public class Animation {
	protected float xPos;
	protected float yPos;
	protected SpriteSheet sprite;
	protected int slides;
	protected int timer;
	protected int slideTimer;
	protected int curSlide;
	
	public Animation(float xPos, float yPos, SpriteSheet sprite, int slideTimer) {
		this.xPos=xPos;
		this.yPos=yPos;
		this.sprite=sprite;
		slides=sprite.getVerticalCount();
		timer=0;
		curSlide=0;
		this.slideTimer=slideTimer;
	}
	
	public void update() {
		timer++;
		if(timer%slideTimer==0) curSlide++;
		if(curSlide>=slides) Game.removeAnimation(this);
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite.getSprite(0, curSlide), xPos, yPos);
	}
}
