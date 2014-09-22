package VIPKailiai.Football.Game.Models;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Paulius on 10/09/2014.
 */

public class TouchPad implements ApplicationListener {
    private OrthographicCamera camera;
    private Stage stage;
    private SpriteBatch batch;
    private Viewport viewport;
    private Touchpad touchpad;
    private Touchpad.TouchpadStyle touchpadStyle;
    private Skin touchpadSkin;
    private Drawable touchBackground;
    private Drawable touchKnob;

//    private float blockSpeed;

    public float getX() {
        return touchpad.getKnobPercentX();
    }

    public float getY() {
        return touchpad.getKnobPercentY();
    }

    public TouchPad(Stage stage, OrthographicCamera camera, SpriteBatch batch) {
        this.stage = stage;
        this.camera = camera;
        this.batch = batch;
    }


    @Override
        public void create() {

            //Create a touchpad skin
            touchpadSkin = new Skin();
            //Set background image
            touchpadSkin.add("touchBackground", new Texture("touchBackground.png"));
            //Set knob image
            touchpadSkin.add("touchKnob", new Texture("touchKnob.png"));
            //Create TouchPad Style
            touchpadStyle = new Touchpad.TouchpadStyle();
            //Create Drawable's from TouchPad skin
            touchBackground = touchpadSkin.getDrawable("touchBackground");
            touchKnob = touchpadSkin.getDrawable("touchKnob");
            //Apply the Drawables to the TouchPad Style
            touchpadStyle.background = touchBackground;
            touchpadStyle.knob = touchKnob;
            //Create new TouchPad with the created style
            touchpad = new Touchpad(10, touchpadStyle);
            //setBounds(x,y,width,height)
            touchpad.setBounds(15, 15, 200, 200);

            stage.addActor(touchpad);
            Gdx.input.setInputProcessor(stage);

            //Create block sprite
//            blockTexture = new Texture(Gdx.files.internal("block.png"));
//            blockSprite = new Sprite(blockTexture);
            //Set position to centre of the screen
//            blockSprite.setPosition(Gdx.graphics.getWidth()/2-blockSprite.getWidth()/2, Gdx.graphics.getHeight()/2-blockSprite.getHeight()/2);

//            blockSpeed = 5;
        }

        @Override
        public void dispose() {

        }

        @Override
        public void render() {


            //Move blockSprite with TouchPad
//            blockSprite.setX(blockSprite.getX() + touchpad.getKnobPercentX()*blockSpeed);
//            blockSprite.setY(blockSprite.getY() + touchpad.getKnobPercentY()*blockSpeed);
//
//            //Draw
         //   batch.begin();
//            blockSprite.draw(batch);
        //    batch.end();
            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();

        }

        @Override
        public void pause() {
        }

        @Override
        public void resume() {
        }

        @Override
        public void resize(int width, int height) {
        }
    }
