package VIPKailiai.Football.Game.Models;

/**
 * Created by Paulius on 09/09/2014.
 */
import VIPKailiai.Configuration.FootballConfiguration;
import VIPKailiai.Libraries.BodyEditorLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Ball {

    private World world;
    private Body body;
    private BodyDef bodyDef;
    private Sprite sprite;
    private SpriteBatch spriteBatch;
    private Texture texture;
    private BodyEditorLoader loader;
    private Camera camera;
    private Stadium stadium;
    Vector2 modelOrigin;
    private ContactListener contactListener;

    public Ball(World world, Texture texture, SpriteBatch batch, Camera camera, Vector2 position) {

        this.world = world;
        this.spriteBatch = batch;
        this.texture = texture;
        this.camera = camera;

        this.loader = new BodyEditorLoader(Gdx.files.internal(FootballConfiguration.getGetAssetsPath()+"block.json"));

        this.bodyDef = new BodyDef();
        this.bodyDef.type = BodyDef.BodyType.DynamicBody;
        this.bodyDef.position.set(position);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(.3f/32f);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circleShape;
        fixtureDef.density = .00001f;
        fixtureDef.friction = 0;
        fixtureDef.restitution = 0.4f;

        this.body = world.createBody(bodyDef);
        this.body.createFixture(fixtureDef);

        //   this.loader.attachFixture(this.body, "PlayerRed", fixtureDef, 5f);

        //    this.modelOrigin = loader.getOrigin("PlayerRed",1f).cpy();
        //   world.setGravity(new Vector2(0,0));
    }

    public void render(){

        this.body.setFixedRotation(true);
        this.body.setUserData(this);

//          Vector2 playerPosition = this.body.getPosition();
//          this.sprite = new Sprite(this.texture);
//          this.sprite.setPosition(this.body.getPosition().x-19, this.body.getPosition().y-19);
//          playerSprite.setColor(Color.WHITE);
//          this.sprite.setOrigin(this.modelOrigin.x, this.modelOrigin.y);


//          playerSprite.setRotation(0);
//          spriteBatch.begin();
//          this.sprite.draw(spriteBatch);
//          spriteBatch.end();
    }

    public void update(float delta) {

    }

    public Vector2 getVelocity(){
        return body.getLinearVelocity();
    }

    public void setVelocity(Vector2 velocity){
        this.body.setLinearVelocity(velocity);
    }

    public void setDamping(float damping){
        this.body.setLinearDamping(damping);
    }

    public Vector2 getPosition(){
        return this.body.getPosition();
    }

    public void setAcceleration(){

    }
}