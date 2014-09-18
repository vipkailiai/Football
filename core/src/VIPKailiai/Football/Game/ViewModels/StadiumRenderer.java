package VIPKailiai.Football.Game.ViewModels;

/**
 * Created by Paulius on 08/09/2014.
 */

import VIPKailiai.Football.Game.Models.Ball;
import VIPKailiai.Football.Game.Models.Player;
import VIPKailiai.Football.Game.Models.Stadium;
import VIPKailiai.Football.Game.Models.TouchPad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.graphics.ParticleEmitterBox2D;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class StadiumRenderer {
    private World world;
    private TouchPad touchpad;
    private Stage stage;
    private Stadium stadiumModel;
    public OrthographicCamera camera;
    public Texture playerTexture;
    public Texture stadiumTexture;
    public SpriteBatch spriteBatch;
    private ContactListener contactListener;
    Box2DDebugRenderer debugRenderer;
    private FPSLogger logger;
    Player playerModel;
    Ball ball;
    Sprite playerSprite;
    private final Vector2 gravity = new Vector2(0,0);
    public int width;
    public int height;
    private Vector2 playerModelOrigin;
    static final float BOX_STEP=1/60f;
    static final int BOX_VELOCITY_ITERATIONS=6;
    static final int BOX_POSITION_ITERATIONS=2;
    static final float WORLD_TO_BOX=0.01f;
    static final float BOX_WORLD_TO=100f;
    ParticleEmitterBox2D emitter;
    Player player2;
    public void setSize (int w, int h) {
        this.width = w;
        this.height = h;
    }


    public StadiumRenderer(Stadium stadium, OrthographicCamera camera, SpriteBatch spriteBatch, TouchPad touchpad) {

        this.world  = new World(gravity, true);
        this.contactListener = new BallContactListener();
        this.world.setContactListener(contactListener);
        this.camera = camera;
        this.touchpad = touchpad;
        this.stadiumModel = stadium;
        this.camera.update();
        this.spriteBatch = spriteBatch;
        loadTextures();

        this.playerModel = new Player(this.world, this.playerTexture, this.spriteBatch, this.camera);
        this.player2 = new Player(this.world, this.playerTexture, this.spriteBatch, this.camera);
        this.ball = new Ball(this.world, this.playerTexture, this.spriteBatch, this.camera);
        this.stadiumModel = new Stadium(this.world, this.stadiumTexture, this.spriteBatch, this.camera);

        debugRenderer = new Box2DDebugRenderer();
        logger = new FPSLogger();

    }

    private void loadTextures() {
        this.playerTexture = new  Texture(Gdx.files.internal("data/suarezas.png"));
        this.playerSprite = new Sprite(new  Texture(Gdx.files.internal("data/block.png")));
        this.stadiumTexture = new Texture(Gdx.files.internal("data/greenpitch.png"));
    }

    public void render() {
//        spriteBatch.begin();
//        drawStadium();
     //   reDrawPlayer();
//        spriteBatch.end();

        if(touchpad.getX() == 0 && touchpad.getY() == 0)
            playerModel.setDamping(2);
        else {
//            playerModel.applyLinearImpulse((new Vector2(1000000 * touchpad.getX(), 1000000 * touchpad.getY())), playerModel.getWorldCenter(), true);
//            playerModel.applyLinearImpulse((new Vector2(1000000 * touchpad.getX(), 1000000 * touchpad.getY())), playerModel.getWorldCenter(), true);
            playerModel.setAcceleration();

            playerModel.setVelocity(new Vector2(touchpad.getX()*100, touchpad.getY()*100));
        }

        this.player2.setDamping(2);
        playerModel.setDamping(2);
        this.ball.setDamping(1);
        this.ball.render();
        this.playerModel.render();

        world.step(BOX_STEP, BOX_VELOCITY_ITERATIONS, BOX_POSITION_ITERATIONS);
        debugRenderer.render(world, camera.combined);
           logger.log();
    }


}
