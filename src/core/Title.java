package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Title extends BasicGameState {
    private final int id;
    int width = 0;
    int x;
    int y;
    int height = 0;
    int tick;
    Image frog;
    int scaleNum;
    int angle;
    boolean grow;
    private StateBasedGame sbg;

    public Title(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        // This code happens when you enter a game state for the *first time.*
        gc.setShowFPS(true);
        this.sbg = sbg;
        y = Main.getScreenHeight() / 2;
        x = Main.getScreenWidth() / 2;
        frog = new Image("res/grassOne.png");
        scaleNum = 128;
        tick = 0;
        angle = 0;
        grow = true;
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        // This is updates your game's logic every frame.  NO DRAWING.

        tick++;
        angle++;
        if (scaleNum == 150) {
            grow = false;
        }
        if (scaleNum == 128) {
            grow = true;
        }
        if (tick == 2) {
            if (grow) {
                scaleNum += 1;
            } else {
                scaleNum -= 1;
            }
            tick = 0;
            frog = frog.getScaledCopy(frog.getWidth() - scaleNum, frog.getHeight() - scaleNum);
            frog.rotate(angle);
        }


    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        // This code renders shapes and images every frame.
        g.drawRect(10, 10, 30, 30);
        g.drawImage(frog, Main.getScreenWidth() / 2 - frog.getWidth() / 2, Main.getScreenHeight() / 2 - frog.getHeight() / 2);
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
        // This code happens when you enter a gameState.
    }

    public void leave(GameContainer gc, StateBasedGame sbg) {
        // This code happens when you leave a gameState.
    }

    public void keyPressed(int key, char c) {
        // This code happens every time the user presses a key
        if (key == Input.KEY_SPACE) sbg.enterState(Main.GAME_ID);
    }

    public void mousePressed(int button, int x, int y) {
        // This code happens every time the user presses the mouse
    }
}