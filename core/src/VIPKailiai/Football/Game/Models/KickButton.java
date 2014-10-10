package VIPKailiai.Football.Game.Models;

import VIPKailiai.Football.Game.ViewModels.BallContactListener;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.InputProcessor;
//import java.util.Timer.*;
//import java.util.*;
import java.util.TimerTask;

/**
 * Created by Vilius on 10/2/2014.
 */
public class KickButton implements ApplicationListener {
    private OrthographicCamera camera;
    private Stage stage;
    Player player;
    private Skin buttonSkin;
    private Button.ButtonStyle buttonStyle;
    private Button button;
    BallContactListener contact=null;
    private float timeSinceCollision= 0;
    long grabtime=0;


    public KickButton(Stage stage, OrthographicCamera camera)
    {
        this.stage = stage;
        this.camera = camera;
    }

    @Override
    public void create() {
        buttonSkin = new Skin();
        buttonSkin.add("button", new Texture("touchBackground.png"));
        buttonSkin.add("button1", new Texture("block.png"));
        buttonStyle = new Button.ButtonStyle();
        buttonStyle.up = buttonSkin.getDrawable("button");
        buttonStyle.down = buttonSkin.getDrawable("button1");
        button = new Button(buttonStyle);

        //timer.sc
        //timer.schedule(new Reminder(1), 1, 1);


        button.setBounds(700, 15, 200, 200);
        stage.addActor(button);
        Gdx.input.setInputProcessor(stage);
        button.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                grabtime = System.currentTimeMillis();


                    Gdx.app.log("touchdown: ", "k " + player.iskicked);

                    player.iskicked = true;
                 return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                player.iskicked = false;

            }
            @Override
           public void touchDragged(InputEvent event, float x, float y, int pointer){


                long currtime = System.currentTimeMillis();


                Gdx.app.log("deley ", "k" + player.iskicked);



                    if((currtime-grabtime)>500)

                        player.iskicked = false;


            }
            @Override
            public boolean keyDown(InputEvent event, int keyCode) {
               //   event.;
                grabtime = System.currentTimeMillis();
                if(keyCode == Input.Keys.ENTER) {
                    //{
                    timeSinceCollision = 0;
                    player.iskicked = true;

                    Gdx.app.log("down: ", "k " + player.iskicked);

                }
                return true;
            }
  //          @Override

            public boolean keyTyped(InputEvent event, char character){
                int tmpint = character+53;

                long currtime = System.currentTimeMillis();


                Gdx.app.log("deley ", "k" + player.iskicked);

                if(tmpint == Input.Keys.ENTER)

                    if((currtime-grabtime)>500)

                    player.iskicked = false;

                return true;
            }
            @Override
            public boolean keyUp(InputEvent event, int keyCode) {


                if(keyCode == Input.Keys.ENTER) {

                }
                return true;
            }

        });
        stage.setKeyboardFocus(button);
       // Gdx.input.setInputProcessor(this);


    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
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
    public void dispose() {

    }
}

