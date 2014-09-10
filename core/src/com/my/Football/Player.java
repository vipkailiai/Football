package com.my.Football;

/**
 * Created by Paulius on 09/09/2014.
 */
        import com.badlogic.gdx.math.Rectangle;
        import com.badlogic.gdx.math.Vector2;
public class Player {

    public enum State {
        IDLE, WALKING
    }

    public static final float SPEED = 4f;  // unit per second
    static final float SIZE = 0.5f; // half a unit

    Vector2     position = new Vector2();
    Vector2     acceleration = new Vector2();
    Vector2     velocity = new Vector2();
    Rectangle   bounds = new Rectangle();
    State       state = State.IDLE;

    public Player(Vector2 position) {
        this.position = position;
        this.bounds.height = SIZE;
        this.bounds.width = SIZE;
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
    }

    public void setState(State newState) {
        this.state = newState;
    }
    public Vector2 getVelocity(){
        return this.velocity;
    }
    public Vector2 getAcceleration(){
        return this.acceleration;
    }
}