package com.VIPKailiai.Football.Controller;

import com.my.Football.Player;
import com.my.Football.Player.State;
import com.my.Football.Stadium;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paulius on 09/09/2014.
 */
public class StadiumController {

    enum Keys {
        LEFT, RIGHT, UP, DOWN, FIRE
    }
    private Stadium stadium;
    private Player player;
    static Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();
    static {
        keys.put(Keys.LEFT, false);
        keys.put(Keys.RIGHT, false);
        keys.put(Keys.UP, false);
        keys.put(Keys.DOWN, false);
    };

    public StadiumController(Stadium stadium) {
        this.stadium = stadium;
        this.player = stadium.getPlayer();
    }
            // ** Key presses and touches **************** //
    public void leftPressed() {
        keys.get(keys.put(Keys.LEFT, true));
    }
    public void rightPressed() {
        keys.get(keys.put(Keys.RIGHT, true));
    }
    public void upPressed() {
        keys.get(keys.put(Keys.UP, true));
    }
    public void downPressed() {
        keys.get(keys.put(Keys.DOWN, true));
    }
    public void firePressed() {
        keys.get(keys.put(Keys.FIRE, false));
    }

    public void leftReleased() {
        keys.get(keys.put(Keys.LEFT, false));
    }
    public void rightReleased() {
        keys.get(keys.put(Keys.RIGHT, false));
    }
    public void upReleased() {
        keys.get(keys.put(Keys.UP, false));
    }
    public void downReleased() {
        keys.get(keys.put(Keys.DOWN, false));
    }
    public void fireReleased() {
        keys.get(keys.put(Keys.FIRE, false));
    }
            /** The main update method **/
    public void update(float delta) {
        processInput();
        player.update(delta);
    }
            /** Change Player's state and parameters based on input controls **/
    private void processInput() {
        if (keys.get(Keys.LEFT)) {
            // left is pressed
            player.setState(State.WALKING);
            player.getVelocity().x = -Player.SPEED;
        }
        if (keys.get(Keys.RIGHT)) {
            // left is pressed
            player.setState(State.WALKING);
            player.getVelocity().x = Player.SPEED;
        }

        if (keys.get(Keys.UP)) {
            // up is pressed
            player.setState(State.WALKING);
            player.getVelocity().y = Player.SPEED;
        }
        if (keys.get(Keys.DOWN)) {
            // down is pressed
            player.setState(State.WALKING);
            player.getVelocity().y = -Player.SPEED;
        }

        // need to check if both or none direction are pressed, then Player is idle
        if (
                (keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) ||
        (!keys.get(Keys.LEFT) && !keys.get(Keys.RIGHT) && !keys.get(Keys.UP) && !keys.get(Keys.DOWN))

                ) {
            player.setState(State.IDLE);
            // acceleration is 0 on the x
            player.getAcceleration().x = 0;
            // horizontal speed is 0
            player.getVelocity().x = 0;

            player.getAcceleration().y = 0;

            player.getVelocity().y = 0;
        }
    }
}

