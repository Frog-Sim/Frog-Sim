package media;

import core.Game;

public class Camera {
	private float xPos;
	private float yPos;
	
	private final static float EASING = .06f;
	
	private Game g;
	
	public Camera(Game g) {
		xPos = 0; yPos = 0;
		this.g=g;
	}

	public float getX() { return xPos; }
	public float getY() { return yPos; }

	public void update() {
		float newX = g.getCamX();
		xPos += (newX - xPos) * EASING;
		float newY = g.getCamY();
		yPos += (newY - yPos) * EASING;
	}
}
