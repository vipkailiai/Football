package com.my.Football;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Paulius on 08/09/2014.
 */
public class GameScreen implements Screen{

    private Stadium stadium;
    private StadiumRenderer stadiumRenderer;

    @Override
    public void show() {
        stadium = new Stadium();
        stadiumRenderer = new StadiumRenderer(stadium);
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stadiumRenderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }
}
