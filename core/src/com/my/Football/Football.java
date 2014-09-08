package com.my.Football;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public  class Football implements ApplicationListener {
	private SpriteBatch batch;
	private Texture texture;
    private Sprite sprite;
    private Camera camera;
	
	@Override
	public void create () {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        batch = new SpriteBatch();

        FileHandle file = new FileHandle("data/vova.jpg");

		texture = new Texture(file);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        TextureRegion region = new TextureRegion(texture, 0, 0, 300, 278);

        sprite = new Sprite(region);
        sprite.setSize(0.9f, 0.9f);
        sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
        sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
		sprite.draw(batch);
        sprite.draw(batch);
        sprite.draw(batch);
        sprite.draw(batch);
		batch.end();
	}

    @Override
    public void dispose()
    {
        batch.dispose();
        texture.dispose();
    }

    @Override
    public void resume(){}

    @Override
    public void pause(){}

    @Override
    public void resize(int width, int height){}
}
