package VIPKailiai.Football.Game.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Paulius on 08/09/2014.
 */
public class Stadium {

    Player player;

    public Player getPlayer() {
        return player ;
    }

    public Stadium() {
        createMockStadium();
    }


    private void createMockStadium() {
      player = new Player(new Vector2(7, 2), new Rectangle(0,0, Gdx.graphics.getWidth()-50,Gdx.graphics.getHeight()));
    }
}

