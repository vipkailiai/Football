package VIPKailiai.Football.Game;


import VIPKailiai.Football.Game.Controllers.ControlsScreen;
import VIPKailiai.Football.Game.Controllers.GameScreen;
import com.badlogic.gdx.Game;

/**
 * Created by Paulius on 09/09/2014.
 */

public class Football extends Game{

    @Override
    public void create()
    {
     //   setScreen(new ControlsScreen());
        setScreen(new GameScreen());

    }
}
