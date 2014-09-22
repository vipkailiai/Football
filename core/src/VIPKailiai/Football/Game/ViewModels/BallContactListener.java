package VIPKailiai.Football.Game.ViewModels;

import VIPKailiai.Football.Game.Models.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.lang.reflect.Type;

/**
 * Created by Paulius on 17/09/2014.
 */
public class BallContactListener implements ContactListener {

    Fixture fixtureA;
    Fixture fixtureB;


    @Override
    public void beginContact(Contact contact) {
        playerBallContact(contact);
     //   playerBoundContact(contact);
    }

    private void playerBoundContact(Contact contact) {
        Fixture player = null;
        Fixture bound = null;

        if(contact.getFixtureA().getBody().getUserData() instanceof Player && contact.getFixtureB().getBody().getUserData() instanceof Bound)
        {
            player = contact.getFixtureA();
            bound = contact.getFixtureB();
        }

        if(contact.getFixtureB().getBody().getUserData() instanceof Player && contact.getFixtureA().getBody().getUserData() instanceof Bound)
        {
            player = contact.getFixtureB();
            bound = contact.getFixtureA();
        }

        if(player != null && bound != null)
        {
            contact.setEnabled(false);
        }
    }

    private void playerBallContact(Contact contact) {
        Fixture player = null;
        Fixture ball = null;

        if(contact.getFixtureA().getBody().getUserData() instanceof Ball)
        {
            player = contact.getFixtureB();
            ball = contact.getFixtureA();
        }

        if(contact.getFixtureB().getBody().getUserData() instanceof Ball)
        {
            player = contact.getFixtureA();
            ball = contact.getFixtureB();
        }
        if(player != null && ball != null) {
            float playerX = player.getBody().getWorldCenter().x;
            float playerY = player.getBody().getWorldCenter().y;
            float ballX = ball.getBody().getWorldCenter().x;
            float ballY = ball.getBody().getWorldCenter().y;
        //    ball.getBody().setActive(false);
            Vector2 force = new Vector2(ballX-playerX,ballY-playerY);
         //   WorldManifold wm = contact.getWorldManifold();

         //   Vector2 contactPoint = wm.getPoints()[0];

            ball.getBody().applyForceToCenter(force,true);
        }
    }

    @Override
    public void endContact(Contact contact) {
        contact.getFixtureA().getBody().setActive(true);
        contact.getFixtureB().getBody().setActive(true);
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        playerBoundContact(contact);
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
              contact.getFixtureA().getBody().setActive(true);
              contact.getFixtureB().getBody().setActive(true);
    }
}
