package VIPKailiai.Football.Game.Controllers;

import VIPKailiai.Football.Game.Models.Stadium;
import VIPKailiai.Football.Game.Models.TouchPad;
import VIPKailiai.Football.Game.ViewModels.StadiumRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Paulius on 08/09/2014.
 */
public class GameScreen implements Screen {

    private OrthographicCamera camera;
    private Stage stage;
    private SpriteBatch batch;
    private Viewport viewport;

    private Stadium stadium;
    private StadiumRenderer stadiumRenderer;
    private TouchPad touchPad;

    public int Width, Height;

    @Override
    public void show() {

        batch = new SpriteBatch();

        float aspectRatio = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 10f*aspectRatio, 10f);
        viewport = new ScreenViewport(camera);
        stage = new Stage(viewport, batch);

        stadium = new Stadium();
        touchPad = new TouchPad(stage, camera, batch);
        touchPad.create();
        stadiumRenderer = new StadiumRenderer(stadium, camera, batch, touchPad);
       // stadiumController = new StadiumController(stadium);

    //    Gdx.input.setInputProcessor(touchPad);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stadiumRenderer.render();
        touchPad.render();
        //   stadiumController.update(delta);



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
     //   stadiumRenderer.setSize(width, height);
        this.Width = width;
        this.Height = height;
    }

    //@Override
//    public boolean keyDown(int keycode) {
//        if (keycode == Input.Keys.LEFT)
//            stadiumController.leftPressed();
//        if (keycode == Input.Keys.RIGHT)
//            stadiumController.rightPressed();
//        if (keycode == Input.Keys.UP)
//            stadiumController.upPressed();
//        if (keycode == Input.Keys.DOWN)
//            stadiumController.downPressed();
//        return true;
//   }

   // @Override
//    public boolean keyUp(int keycode) {
//        if (keycode == Input.Keys.LEFT)
//            stadiumController.leftReleased();
//        if (keycode == Input.Keys.RIGHT)
//            stadiumController.rightReleased();
//        if (keycode == Input.Keys.UP)
//            stadiumController.upReleased();
//        if (keycode == Input.Keys.DOWN)
//            stadiumController.downReleased();
//        return true;
//    }

//   @Override
//    public boolean keyTyped(char character) {
//        return false;
//    }

//    @Override
//    public boolean touchDown(int x, int y, int pointer, int button) {
//        if (x < this.Width / 2 && y > this.Height / 2) {
//            stadiumController.leftPressed();
//        }
//        if (x > this.Width / 2 && y > this.Height / 2) {
//            stadiumController.rightPressed();
//        }
//        return true;
//    }

  //  @Override
//    public boolean touchUp(int x, int y, int pointer, int button) {
//        if (x < this.Width / 2 && y > this.Height / 2) {
//            stadiumController.leftReleased();
//        }
//        if (x > this.Width / 2 && y > this.Height / 2) {
//            stadiumController.rightReleased();
//        }
//        return true;
//    }

  //  @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        return false;
//    }

  //  @Override
//    public boolean mouseMoved(int screenX, int screenY) {
//        return false;
//    }

  //  @Override
//    public boolean scrolled(int amount) {
//        return false;
//    }
}
