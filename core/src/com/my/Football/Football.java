package com.my.Football;

import com.badlogic.gdx.Game;

/**
 * Created by Paulius on 09/09/2014.
 */
public class Football extends Game{
    @Override
    public void create()
    {
        setScreen(new GameScreen());
    }
}
