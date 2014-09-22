package VIPKailiai.Football.Game.Models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Paulius on 08/09/2014.
 */
public class Stadium {

    private World world;
    private Body outBodyLeft;
    private Body outBodyTop;
    private Body outBodyRight;
    private Body outBodyBottom;
    private Body pitchBody;
    private Texture texture;
    private Camera camera;
    private BodyDef outBodyDef;
    private BodyDef pitchBodyDef;
    private SpriteBatch spriteBatch;



    public Stadium(World world, Texture texture, SpriteBatch spriteBatch, Camera camera) {

        this.world = world;
        this.texture = texture;
        this.spriteBatch = spriteBatch;
        this.camera = camera;

        // World Bounds
        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(0f/32, 620f/32));
        outBodyLeft = world.createBody(outBodyDef);
        PolygonShape outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(0f, 400f/32);
        outBodyLeft.createFixture(outBodyBox, 0.0f);

        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(850f/32, 1020f/32));
        outBodyTop = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(850f/32f, 0f);
        outBodyTop.createFixture(outBodyBox, 0.0f);

        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(1700f/32f, 620f/32f));
        outBodyRight = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(0f, 400f/32f);
        outBodyRight.createFixture(outBodyBox, 0.0f);


        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(850f/32f, 220f/32f));
        outBodyBottom = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(850f/32f,0f);
        outBodyBottom.createFixture(outBodyBox, 0.0f);

        // Pitch Bounds
        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(80f/32f, 620f/32f));
        outBodyLeft = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(0f, 336f/32f);
        outBodyLeft.createFixture(outBodyBox, 0.0f);
        outBodyLeft.setUserData(new Bound());

        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(850f/32f, 956f/32f));
        outBodyTop = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(770f/32f, 0f);
        outBodyTop.createFixture(outBodyBox, 0.0f);
        outBodyTop.setUserData(new Bound());

        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(1620f/32f, 620f/32f));
        outBodyRight = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(0f, 336f/32f);
        outBodyRight.createFixture(outBodyBox, 0.0f);
        outBodyRight.setUserData(new Bound());

        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(850f/32f, 284f/32f));
        outBodyBottom = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(770f/32f,0f);
        outBodyBottom.createFixture(outBodyBox, 0.0f);
        outBodyBottom.setUserData(new Bound());
    }

    public void render(){


    }

}

