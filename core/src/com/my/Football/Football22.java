//package com.my.Football;
//
//import com.badlogic.gdx.ApplicationAdapter;
//import com.badlogic.gdx.ApplicationListener;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.Camera;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.math.Rectangle;
//
//public  class Football implements ApplicationListener {
//	private SpriteBatch batch;
//	private Texture texture;
//    private Sprite sprite;
//    private Camera camera;
//    private Stadium stadium;
//    private StadiumRenderer stadiumRenderer;
//
//	@Override
//	public void create () {
//
////        float w = Gdx.graphics.getWidth();
////        float h = Gdx.graphics.getHeight();
////
////        camera = new OrthographicCamera();
////        batch = new SpriteBatch();
////
////		texture = new Texture(Gdx.files.internal("data/stadium.gif"));
////        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
////
////        TextureRegion region = new TextureRegion(texture, 0, 0, 900, 600);
////
////        sprite = new Sprite(region);
////      //  sprite.setSize(0.9f, 0.9f);
////      //  sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
////        sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
//
//	}
//
//	@Override
//	public void render () {
//
////        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
////        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
////        stadiumRenderer.render();
////
/////*		Gdx.gl.glClearColor(1, 1, 1, 1);
////		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);*/
////
/////*        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
////            if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
////                sprite.translateX(-1f);
////            else
////                sprite.translateX(-10.0f);
////        }
////
////        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
////            if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
////                sprite.translateX(1f);
////            else
////                sprite.translateX(10.0f);
////        }
////
////        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
////            if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
////                sprite.translateY(1f);
////            else
////                sprite.translateY(10.0f);
////        }
////
////        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
////            if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
////                sprite.translateY(-1f);
////            else
////                sprite.translateY(-10.0f);
////        }*/
////
////       // batch.setProjectionMatrix(camera.combined);
////        batch.begin();
////        sprite.draw(batch);
////		batch.end();
//	}
//
//    public Football(Stadium stadium) {
//        this.stadium = stadium;
//        this.camera = new OrthographicCamera(10, 7);
//        this.camera.position.set(5, 3.5f, 0);
//        this.camera.update();
//    }
//
//    @Override
//    public void dispose()
//    {
//        batch.dispose();
//        texture.dispose();
//    }
//
//    @Override
//    public void resume(){}
//
//    @Override
//    public void pause(){}
//
//    @Override
//    public void resize(int width, int height){}
//}
