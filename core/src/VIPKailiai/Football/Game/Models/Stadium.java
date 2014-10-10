package VIPKailiai.Football.Game.Models;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Paulius on 08/09/2014.
 */
public class Stadium {

    private final BodyDef leftTopPostDef;
    private final Body leftTopPostBody;
    private final Body rightTopPostBody;
    private final CircleShape rightTopPost;
    private final BodyDef rightTopPostDef;
    private final BodyDef leftBottomPostDef;
    private final Body leftBottomPostBody;
    private final CircleShape leftBottomPost;
    private final Body rightBottomPostBody;
    private final CircleShape rightBottomPost;
    private final BodyDef rightBottomPostDef;
    private final BodyDef leftGoalBackDef;
    private final Body leftGoalBackBody;
    private final Body rightGoalBackBody;
    private final BodyDef rightGoalBackDef;
    private final BodyDef leftGoalTopDef;
    private final Body leftGoalBottomBody;
    private final BodyDef leftGoalBottomDef;
    private final Body leftGoalTopBody;
    private final Body rightGoalBottomBody;
    private final BodyDef rightGoalBottomDef;
    private final Body rightGoalTopBody;
    private final BodyDef rightGoalTopDef;
    private final Body rightGoalLineBody;
    private final BodyDef leftGoalLineDef;
    private final Body leftGoalLineBody;
    private final BodyDef rightGoalLineDef;
    private CircleShape leftTopPost;
    private World world;
    private Body outBodyLeft;
    private Body outBodyTop;
    private Body outBodyRight;
    private Body outBodyBottom;
    private Texture texture;
    private Camera camera;

    private BodyDef outBodyDefLeft;
    private BodyDef outBodyDefRight;
    private BodyDef outBodyDefTop;
    private BodyDef outBodyDefBottom;


    private Body outBodyLeftTop;
    private Body outBodyLeftBottom;
    private Body outBodyRightTop;
    private Body outBodyRightBottom;

    private BodyDef pitchBodyDefBottom;
    private BodyDef pitchBodyDefTop;
    private BodyDef pitchBodyDefLeftTop;
    private BodyDef pitchBodyDefLeftBottom;
    private BodyDef pitchBodyDefRightTop;
    private BodyDef pitchBodyDefRightBottom;

    private SpriteBatch spriteBatch;


    // kadangi sugalvojau, kad 1 metre bus 30 pixeliu tai viska reik is 30 dalint, okey?!
    private float pixelsInAMeter = 30f;

    // stadiono ir aiksteles matmenys
    private float worldBoundsWidth = 110f;
    private float worldBoundsHeight = 62f;
    private float pitchBoundsWidth = 100f;
    private float pitchBoundsHeight = 57f;
    private float goalWidth = 15f;
    private float lineThickness = 0f;

    //koordinaciu sistemos pradzios taskas, siaip hui znaet kam cia as ji apsirasau, nes paliubomu nulis, bet tai gal reiks veliau ar kazka...
    private float worldX = 0f;
    private float worldY = 0f;
    
    private float pitchX = (worldBoundsWidth - pitchBoundsWidth)/2f;
    private float pitchY = (worldBoundsHeight - pitchBoundsHeight)/2f;



    public Stadium(World world, Texture texture, SpriteBatch spriteBatch, Camera camera) {

        this.world = world;
        this.texture = texture;
        this.spriteBatch = spriteBatch;
        this.camera = camera;

        // World Bounds
        outBodyDefLeft = new BodyDef();
        outBodyDefLeft.position.set(new Vector2(worldX / pixelsInAMeter, worldY / pixelsInAMeter));
        outBodyLeft = world.createBody(outBodyDefLeft);
        PolygonShape outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, worldBoundsHeight / pixelsInAMeter);
        outBodyLeft.createFixture(outBodyBox, 0.0f);

        outBodyDefRight = new BodyDef();
        outBodyDefRight.position.set(new Vector2(worldBoundsWidth * 2 / pixelsInAMeter, worldY / pixelsInAMeter));
        outBodyRight = world.createBody(outBodyDefRight);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, worldBoundsHeight / pixelsInAMeter);
        outBodyRight.createFixture(outBodyBox, 0.0f);

        outBodyDefTop = new BodyDef();
        outBodyDefTop.position.set(new Vector2((worldBoundsWidth / pixelsInAMeter), worldBoundsHeight / pixelsInAMeter));
        outBodyTop = world.createBody(outBodyDefTop);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(worldBoundsWidth / pixelsInAMeter, lineThickness / pixelsInAMeter);
        outBodyTop.createFixture(outBodyBox, 0.0f);

        outBodyDefBottom = new BodyDef();
        outBodyDefBottom.position.set(new Vector2(worldBoundsWidth / pixelsInAMeter, - worldBoundsHeight / pixelsInAMeter));
        outBodyBottom = world.createBody(outBodyDefBottom);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(worldBoundsWidth / pixelsInAMeter, lineThickness / pixelsInAMeter);
        outBodyBottom.createFixture(outBodyBox, 0.0f);

        // Pitch Bounds
        pitchBodyDefLeftBottom = new BodyDef();
        pitchBodyDefLeftBottom.position.set(new Vector2(pitchX*2 / pixelsInAMeter, (-pitchBoundsHeight-goalWidth) / 2f / pixelsInAMeter));
        outBodyLeftBottom = world.createBody(pitchBodyDefLeftBottom);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, (pitchBoundsHeight-goalWidth) / 2f / pixelsInAMeter);
        outBodyLeftBottom.createFixture(outBodyBox, 0.0f);
        outBodyLeftBottom.setUserData(new Bound());

        pitchBodyDefLeftTop = new BodyDef();
        pitchBodyDefLeftTop.position.set(new Vector2(pitchX*2 / pixelsInAMeter, (pitchBoundsHeight + goalWidth)  / 2f / pixelsInAMeter));
        outBodyLeftTop = world.createBody(pitchBodyDefLeftTop);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, (pitchBoundsHeight-goalWidth) / 2f / pixelsInAMeter);
        outBodyLeftTop.createFixture(outBodyBox, 0.0f);
        outBodyLeftTop.setUserData(new Bound());

        pitchBodyDefRightBottom = new BodyDef();
        pitchBodyDefRightBottom.position.set(new Vector2(((pitchX  + pitchBoundsWidth) * 2) / pixelsInAMeter, (-pitchBoundsHeight-goalWidth) / 2f / pixelsInAMeter));
        outBodyRightBottom = world.createBody(pitchBodyDefRightBottom);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, (pitchBoundsHeight-goalWidth) / 2f / pixelsInAMeter);
        outBodyRightBottom.createFixture(outBodyBox, 0.0f);
        outBodyRightBottom.setUserData(new Bound());

        pitchBodyDefRightTop = new BodyDef();
        pitchBodyDefRightTop.position.set(new Vector2(((pitchX  + pitchBoundsWidth) * 2) / pixelsInAMeter, (pitchBoundsHeight + goalWidth)  / 2f / pixelsInAMeter));
        outBodyRightTop = world.createBody(pitchBodyDefRightTop);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, (pitchBoundsHeight-goalWidth) / 2f / pixelsInAMeter);
        outBodyRightTop.createFixture(outBodyBox, 0.0f);
        outBodyRightTop.setUserData(new Bound());

        pitchBodyDefTop = new BodyDef();
        pitchBodyDefTop.position.set(new Vector2((pitchBoundsWidth + pitchX*2)/pixelsInAMeter, pitchBoundsHeight/pixelsInAMeter));
        outBodyTop = world.createBody(pitchBodyDefTop);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(pitchBoundsWidth/pixelsInAMeter, lineThickness/pixelsInAMeter);
        outBodyTop.createFixture(outBodyBox, 0.0f);
        outBodyTop.setUserData(new Bound());

        pitchBodyDefBottom = new BodyDef();
        pitchBodyDefBottom.position.set(new Vector2((pitchBoundsWidth + pitchX*2) / pixelsInAMeter, - pitchBoundsHeight / pixelsInAMeter));
        outBodyBottom = world.createBody(pitchBodyDefBottom);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(pitchBoundsWidth / pixelsInAMeter, lineThickness / pixelsInAMeter);
        outBodyBottom.createFixture(outBodyBox, 0.0f);
        outBodyBottom.setUserData(new Bound());

        // Stangos

        leftTopPostDef = new BodyDef();
        leftTopPostDef.position.set(new Vector2(pitchX*2 / pixelsInAMeter, goalWidth/pixelsInAMeter));
        leftTopPostBody = world.createBody(leftTopPostDef);
        leftTopPost = new CircleShape();
        leftTopPost.setRadius(.5f/pixelsInAMeter);
        leftTopPostBody.createFixture(leftTopPost, 0.0f);

        rightTopPostDef = new BodyDef();
        rightTopPostDef.position.set(new Vector2((pitchX+pitchBoundsWidth)*2 / pixelsInAMeter, goalWidth/pixelsInAMeter));
        rightTopPostBody = world.createBody(rightTopPostDef);
        rightTopPost = new CircleShape();
        rightTopPost.setRadius(.5f/pixelsInAMeter);
        rightTopPostBody.createFixture(rightTopPost, 0.0f);

        leftBottomPostDef = new BodyDef();
        leftBottomPostDef.position.set(new Vector2(pitchX*2 / pixelsInAMeter, -goalWidth/pixelsInAMeter));
        leftBottomPostBody = world.createBody(leftBottomPostDef);
        leftBottomPost = new CircleShape();
        leftBottomPost.setRadius(.5f/pixelsInAMeter);
        leftBottomPostBody.createFixture(leftBottomPost, 0.0f);

        rightBottomPostDef = new BodyDef();
        rightBottomPostDef.position.set(new Vector2((pitchX+pitchBoundsWidth)*2 / pixelsInAMeter, -goalWidth/pixelsInAMeter));
        rightBottomPostBody = world.createBody(rightBottomPostDef);
        rightBottomPost = new CircleShape();
        rightBottomPost.setRadius(.5f/pixelsInAMeter);
        rightBottomPostBody.createFixture(rightBottomPost, 0.0f);

        // Vartu huinia

        leftGoalBackDef = new BodyDef();
        leftGoalBackDef.position.set(new Vector2(pitchX / pixelsInAMeter, worldY / pixelsInAMeter));
        leftGoalBackBody = world.createBody(leftGoalBackDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, goalWidth / pixelsInAMeter);
        leftGoalBackBody.createFixture(outBodyBox, 0.0f);
        leftGoalBackBody.setUserData(new Bound());

        leftGoalTopDef = new BodyDef();
        leftGoalTopDef.position.set(new Vector2((pitchX+pitchX/2f) / pixelsInAMeter, goalWidth / pixelsInAMeter));
        leftGoalTopBody = world.createBody(leftGoalTopDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(pitchX / 2f / pixelsInAMeter, lineThickness / pixelsInAMeter);
        leftGoalTopBody.createFixture(outBodyBox, 0.0f);
        leftGoalTopBody.setUserData(new Bound());

        leftGoalBottomDef = new BodyDef();
        leftGoalBottomDef.position.set(new Vector2((pitchX+pitchX/2f) / pixelsInAMeter, -goalWidth / pixelsInAMeter));
        leftGoalBottomBody = world.createBody(leftGoalBottomDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(pitchX / 2f / pixelsInAMeter, lineThickness / pixelsInAMeter);
        leftGoalBottomBody.createFixture(outBodyBox, 0.0f);
        leftGoalBottomBody.setUserData(new Bound());

        rightGoalBackDef = new BodyDef();
        rightGoalBackDef.position.set(new Vector2(((pitchX+pitchBoundsWidth)*2+pitchX) / pixelsInAMeter, worldY / pixelsInAMeter));
        rightGoalBackBody = world.createBody(rightGoalBackDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, goalWidth / pixelsInAMeter);
        rightGoalBackBody.createFixture(outBodyBox, 0.0f);
        rightGoalBackBody.setUserData(new Bound());


        rightGoalTopDef = new BodyDef();
        rightGoalTopDef.position.set(new Vector2(((pitchX*2f+pitchX/2f)+pitchBoundsWidth*2f) / pixelsInAMeter, goalWidth / pixelsInAMeter));
        rightGoalTopBody = world.createBody(rightGoalTopDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(pitchX / 2f / pixelsInAMeter, lineThickness / pixelsInAMeter);
        rightGoalTopBody.createFixture(outBodyBox, 0.0f);
        rightGoalTopBody.setUserData(new Bound());

        rightGoalBottomDef = new BodyDef();
        rightGoalBottomDef.position.set(new Vector2(((pitchX*2f+pitchX/2f)+pitchBoundsWidth*2f) / pixelsInAMeter, -goalWidth / pixelsInAMeter));
        rightGoalBottomBody = world.createBody(rightGoalBottomDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(pitchX / 2f / pixelsInAMeter, lineThickness / pixelsInAMeter);
        rightGoalBottomBody.createFixture(outBodyBox, 0.0f);
        rightGoalBottomBody.setUserData(new Bound());

        leftGoalLineDef = new BodyDef();
        leftGoalLineDef.position.set(new Vector2(pitchX*2 / pixelsInAMeter, worldY / pixelsInAMeter));
        leftGoalLineBody = world.createBody(leftGoalLineDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, goalWidth / pixelsInAMeter);
        leftGoalLineBody.createFixture(outBodyBox, 0.0f);
        leftGoalLineBody.setUserData(new GoalLine());

        rightGoalLineDef = new BodyDef();
        rightGoalLineDef.position.set(new Vector2(((pitchX+pitchBoundsWidth)*2) / pixelsInAMeter, worldY / pixelsInAMeter));
        rightGoalLineBody = world.createBody(rightGoalLineDef);
        outBodyBox = new PolygonShape();
        outBodyBox.setAsBox(lineThickness / pixelsInAMeter, goalWidth / pixelsInAMeter);
        rightGoalLineBody.createFixture(outBodyBox, 0.0f);
        rightGoalLineBody.setUserData(new GoalLine());

    }

    public void render(){


    }

    public Vector2 getCenter()
    {
        return new Vector2((worldBoundsWidth)/pixelsInAMeter, (worldY)/pixelsInAMeter);
    }

}

