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
        outBodyDef.position.set(new Vector2(100, 620));
        outBodyLeft = world.createBody(outBodyDef);
        PolygonShape outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(.1f, 400f);
        outBodyLeft.createFixture(outBodyBox, 0.0f);

        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(950f, 1020f));
        outBodyTop = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(850, .1f);
        outBodyTop.createFixture(outBodyBox, 0.0f);

        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(1800, 620));
        outBodyRight = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(.1f, 400f);
        outBodyRight.createFixture(outBodyBox, 0.0f);

        outBodyDef = new BodyDef();
        outBodyDef.position.set(new Vector2(950f, 220f));
        outBodyBottom = world.createBody(outBodyDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(850, .1f);
        outBodyBottom.createFixture(outBodyBox, 0.0f);
    }

    public void render(){


    }

}

