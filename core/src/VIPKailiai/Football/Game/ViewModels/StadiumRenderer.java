package VIPKailiai.Football.Game.ViewModels;

/**
 * Created by Paulius on 08/09/2014.
 */

import VIPKailiai.Football.Game.Models.Player;
import VIPKailiai.Football.Game.Models.Stadium;
import VIPKailiai.Football.Game.Models.TouchPad;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class StadiumRenderer {
    World world = new World(new Vector2(0, -100), true);
    private TouchPad touchpad;
    private Stage stage;
    private Stadium stadium;
    public OrthographicCamera camera;
    public Texture playerTexture;
    public Texture stadiumTexture;
    public SpriteBatch spriteBatch;
    Box2DDebugRenderer debugRenderer;
    public int width;
    public int height;
    public float ppuX; // pixels per unit on the X axis
    public float ppuY; // pixels per unit on the Y axis

    static final float BOX_STEP=1/60f;
    static final int BOX_VELOCITY_ITERATIONS=6;
    static final int BOX_POSITION_ITERATIONS=2;
    static final float WORLD_TO_BOX=0.01f;
    static final float BOX_WORLD_TO=100f;

    public void setSize (int w, int h) {
        this.width = w;
        this.height = h;
    }


    public StadiumRenderer(Stadium stadium, OrthographicCamera camera, SpriteBatch batch, TouchPad touchpad) {
        this.camera = camera;
        this.touchpad = touchpad;
        this.stadium = stadium;
        this.camera.update();
        this.spriteBatch = batch;
        loadTextures();
        spriteBatch.begin();
        drawPlayer();
        spriteBatch.end();

        //Ground body
        BodyDef groundBodyDef =new BodyDef();
        groundBodyDef.position.set(new Vector2(0, 10));
        Body groundBody = world.createBody(groundBodyDef);
        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox((camera.viewportWidth) * 2, 10.0f);
        groundBody.createFixture(groundBox, 0.0f);

        //Dynamic Body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2);
        Body body = world.createBody(bodyDef);
        CircleShape dynamicCircle = new CircleShape();
        dynamicCircle.setRadius(25f);
        MassData massData = new MassData();
        massData.mass = 5f;
        body.setMassData(massData);
        body.applyForce(500f,5f,500f,5f, false);
        body.applyAngularImpulse(500f, true);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = dynamicCircle;
        fixtureDef.density = 1.0f;
        fixtureDef.friction = 0.0f;
        fixtureDef.restitution = 1;
        body.createFixture(fixtureDef);
        debugRenderer = new Box2DDebugRenderer();
    }

    private void loadTextures() {
        playerTexture = new  Texture(Gdx.files.internal("data/block.png"));
        stadiumTexture = new Texture(Gdx.files.internal("data/aikste.png"));
    }

    public void render() {
        spriteBatch.begin();
        drawStadium();
        reDrawPlayer();
        spriteBatch.end();
        debugRenderer.render(world, camera.combined);
        world.step(BOX_STEP, BOX_VELOCITY_ITERATIONS, BOX_POSITION_ITERATIONS);
    }

    private void drawStadium() {
        spriteBatch.draw(stadiumTexture,0,0);
    }

    private void drawPlayer() {
        Player player = stadium.getPlayer();
        player.position = new Vector2(Gdx.graphics.getWidth()/2-player.Size/2, Gdx.graphics.getHeight()/2-player.Size/2);
        spriteBatch.draw(playerTexture,player.position.x ,player.position.y);
    }

    private void reDrawPlayer() {
        Player player = stadium.getPlayer();
        if((player.bounds.x <= player.position.x + touchpad.getX()*player.Speed) && (player.bounds.x + player.bounds.width) >= player.position.x + touchpad.getX()*player.Speed) {
            player.position.x = player.position.x + touchpad.getX() * player.Speed;
        }
        if((player.bounds.y <= player.position.y + touchpad.getY()*player.Speed) && (player.bounds.y + player.bounds.height) >= player.position.y + touchpad.getY()*player.Speed) {
            player.position.y = player.position.y + touchpad.getY() * player.Speed;
        }

            spriteBatch.draw(playerTexture, player.position.x, player.position.y);

    }
}
