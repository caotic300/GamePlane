package GamePlane.Levels;

import GamePlane.Coin;
import GamePlane.Game;
import GamePlane.Pickup;
import GamePlane.Players.Plane;
import GamePlane.Players.PrivateJetPlane;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel {

    //private Plane futuramaPlane;
    //privateJetPlane here so it is the one who is secondary plane.
    private Plane privateJetPlane;
    /**A coin*/
    private Coin bitCoin;


    public Level1() {
        super(60);


    }


    @Override
    public void populate(Game game) {
        game.getWorld().setGravity(3.5f);
        super.populate(game);

        //generate the ground of the world.
        generateGround();


        //make another character
        generateSecondCharacter();


        // make the coins

        for (int i = 0; i < 11; i++) {
            bitCoin = new Coin(this);
            // createCoin(11, i*2 - 10, 4,1);
            bitCoin.setPosition(new Vec2(i * 2 - 10, 4));
            bitCoin.addCollisionListener(new Pickup(getMainCharacter(1)));
        }

        //createCoin(11, 2, 4, 1);

        createCoin(11, 2, 4, 4);


        // build a tower
        Shape shape1 = new BoxShape(0.5f, 0.25f);
        for (int n = 0; n < 10; n++) {

            createDynamicShapeCollition(this, shape1, getMainCharacter(1), -5, n * 0.5f - 10.75f, this.getGravity());

        }

        // build a pyramid
        Shape shape2 = new CircleShape(0.5f);
        for (int y = 0; y < 10; y++) {

            for (int x = y; x < 10; x++) {

                createDynamicShapeCollition(this, shape2, getMainCharacter(1), x - y / 2.0f, y - 10.5f, 0);

            }


        }


    }


    @Override
    public Vec2 startPosition() {
        return new Vec2(-14, 2);
    }

    @Override
    public Vec2 portalPosition() {

        return new Vec2(5, 8);
    }

    @Override
    public boolean isCompleted() {

        return getMainCharacter(1).getHealth() > 0;

    }


    @Override
    protected void generateGround() {
        super.generateGround();

        // walls
        Shape wallShape = new BoxShape(0.5f, 6);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-11.5f, -6));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(11.5f, -6));
    }


    @Override
    public void generateSecondCharacter() {
        privateJetPlane = new PrivateJetPlane(this);

        privateJetPlane.setPosition(new Vec2(-5, 8));
        privateJetPlane.startWalking(8);
        privateJetPlane.setLinearVelocity(new Vec2(8, -9));
        privateJetPlane.setAngularVelocity(7);

        privateJetPlane.setGravityScale(0);
    }


}

