package com.my.Football;

/**
 * Created by Paulius on 08/09/2014.
 */
        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.graphics.Color;
        import com.badlogic.gdx.graphics.OrthographicCamera;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
        import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
        import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
        import com.badlogic.gdx.math.Rectangle;

public class StadiumRenderer {

    private static final float CAMERA_WIDTH = 10f;
    private static final float CAMERA_HEIGHT = 7f;

    private Stadium stadium;
    private OrthographicCamera camera;

    /** for debug rendering **/
    ShapeRenderer debugRenderer = new ShapeRenderer();

    private Texture playerTexture;
    private Texture stadiumTexture;
    private SpriteBatch spriteBatch;
    private boolean debug = false;
    private int width;
    private int height;
    private float ppuX; // pixels per unit on the X axis
    private float ppuY; // pixels per unit on the Y axis

    public void setSize (int w, int h) {
        this.width = w;
        this.height = h;
        ppuX = (float)width / CAMERA_WIDTH;
        ppuY = (float)height / CAMERA_HEIGHT;
    }


    public StadiumRenderer(Stadium stadium, boolean debug) {
        this.stadium = stadium;
        this.camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        this.camera.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
        this.camera.update();
        this.debug = debug;
        spriteBatch = new SpriteBatch();
        loadTextures();
    }

    private void loadTextures() {
        playerTexture = new  Texture(Gdx.files.internal("data/player.gif"));
        stadiumTexture = new Texture(Gdx.files.internal("data/greenstr.gif"));
    }

    public void render() {
        spriteBatch.begin();
        drawStadium();
        drawPlayer();
        spriteBatch.end();
        debugRenderer.end();
    }

    private void drawStadium() {
        spriteBatch.draw(stadiumTexture,0,0);
    }

    private void drawPlayer() {
        Player player = stadium.getPlayer();
        spriteBatch.draw(playerTexture, player.position.x * ppuX, player.position.y * ppuY, Player.SIZE * ppuX, Player.SIZE * ppuY);
    }
}
