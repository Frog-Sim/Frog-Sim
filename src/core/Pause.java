package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Pause extends BasicGameState {
    private final int id;
    private StateBasedGame sbg;

    public Pause(int id) {
        this.id = id;
    }


    public int getID() {
        return id;
    }


    public void init(GameContainer gameContainer, StateBasedGame sbg) throws SlickException {
        this.sbg = sbg;
    }


    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

    }

    public void keyPressed(int key, char c) {
        // This code happens every time the user presses a key
        if (key == Input.KEY_ESCAPE) sbg.enterState(Main.GAME_ID);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}