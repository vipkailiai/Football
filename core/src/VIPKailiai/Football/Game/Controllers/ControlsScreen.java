package VIPKailiai.Football.Game.Controllers;

import VIPKailiai.Football.Game.Models.TouchPad;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Paulius on 18/09/2014.
 */
public class ControlsScreen implements Screen {

    private OrthographicCamera camera;
    private Stage stage;
    private SpriteBatch batch;
    private Viewport viewport;
    private TouchPad touchPad;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        touchPad.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(1, 1);
        viewport = new ScreenViewport(camera);
        stage = new Stage(viewport, batch);
        touchPad = new TouchPad(stage, camera, batch);
        touchPad.create();
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
}
