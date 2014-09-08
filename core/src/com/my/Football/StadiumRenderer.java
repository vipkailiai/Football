package com.my.Football;

/**
 * Created by Paulius on 08/09/2014.
 */
        import com.badlogic.gdx.graphics.Color;
        import com.badlogic.gdx.graphics.OrthographicCamera;
        import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
        import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
        import com.badlogic.gdx.math.Rectangle;

public class StadiumRenderer {
    private Stadium stadium;
    private OrthographicCamera camera;

            /** for debug rendering **/
    ShapeRenderer debugRenderer = new ShapeRenderer();
    public StadiumRenderer(Stadium stadium) {
        this.stadium = stadium;
        this.camera = new OrthographicCamera(10, 7);
        this.camera.position.set(5, 3.5f, 0);
        this.camera.update();
    }

    public void render() {
        // render blocks
        debugRenderer.setProjectionMatrix(camera.combined);
        debugRenderer.begin(ShapeType.Line);
        for (Block block : stadium.getBlocks()) {
            Rectangle rect = block.bounds;
            float x1 = block.position.x + rect.x;
            float y1 = block.position.y + rect.y;
            debugRenderer.setColor(new Color(1, 0, 0, 1));
            debugRenderer.rect(x1, y1, rect.width, rect.height);
        }
        // render Bob
       /* Bob bob = world.getBob();
        Rectangle rect = bob.getBounds();
        float x1 = bob.getPosition().x + rect.x;
        float y1 = bob.getPosition().y + rect.y;
        debugRenderer.setColor(new Color(0, 1, 0, 1));
        debugRenderer.rect(x1, y1, rect.width, rect.height);
        debugRenderer.end();*/
    }
}
