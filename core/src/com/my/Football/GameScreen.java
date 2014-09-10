package com.my.Football;

import com.VIPKailiai.Football.Controller.StadiumController;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Paulius on 08/09/2014.
 */
public class GameScreen implements Screen, InputProcessor{

    private Stadium stadium;
    private StadiumRenderer stadiumRenderer;
    private StadiumController stadiumController;

    private int width, height;

    @Override
    public void show() {
        stadium = new Stadium();
        stadiumRenderer = new StadiumRenderer(stadium, true);
        stadiumController = new StadiumController(stadium);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stadiumController.update(delta);
        stadiumRenderer.render();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
   }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
        stadiumRenderer.setSize(width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT)
            stadiumController.leftPressed();
        if (keycode == Input.Keys.RIGHT)
            stadiumController.rightPressed();
        if (keycode == Input.Keys.UP)
            stadiumController.upPressed();
        if (keycode == Input.Keys.DOWN)
            stadiumController.downPressed();
        return true;
   }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT)
            stadiumController.leftReleased();
        if (keycode == Input.Keys.RIGHT)
            stadiumController.rightReleased();
        if (keycode == Input.Keys.UP)
            stadiumController.upReleased();
        if (keycode == Input.Keys.DOWN)
            stadiumController.downReleased();
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        if (x < width / 2 && y > height / 2) {
            stadiumController.leftPressed();
        }
        if (x > width / 2 && y > height / 2) {
            stadiumController.rightPressed();
        }
        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        if (x < width / 2 && y > height / 2) {
            stadiumController.leftReleased();
        }
        if (x > width / 2 && y > height / 2) {
            stadiumController.rightReleased();
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
