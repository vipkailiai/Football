package VIPKailiai.Football.Game.Models;

/**
 * Created by Paulius on 09/09/2014.
 */
        import com.badlogic.gdx.math.Rectangle;
        import com.badlogic.gdx.math.Vector2;
public class Player {

    public enum State {
        IDLE, WALKING
    }

    public float Speed = 5f;  // unit per second
    public float Size = 0.5f; // half a unit

    public Vector2     position = new Vector2();
    public Vector2     acceleration = new Vector2();
    public Vector2     velocity = new Vector2();
    public Rectangle   bounds = new Rectangle();
    public State       state = State.IDLE;

    public Player(Vector2 position, Rectangle bounds) {
        this.position = position;
        this.bounds = bounds;
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