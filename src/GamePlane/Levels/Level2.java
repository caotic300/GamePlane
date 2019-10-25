package GamePlane.Levels;

import GamePlane.Coin;
import GamePlane.Game;
import GamePlane.Pickup;
import GamePlane.Players.F16;
import GamePlane.Players.Klm;
import GamePlane.Players.Plane;
import GamePlane.Players.PrivateJetPlane;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.ArrayList;

public class Level2 extends GameLevel {
    //Create List of Asteroids
    /**
     * A list of circle objects
     *
     */
    private ArrayList<Shape> circleShapes = new ArrayList<>();

    //private Plane klmPlane;

    public Level2() {
        super(60);
        //Initialize asteroids
        fillCircleList(circleShapes);


    }


    @Override
    public void populate(Game game) {
        game.getWorld().setGravity(6);
        super.populate(game);


        // Generate the ground of the world.
        generateGround();

        //generate second character
        generateSecondCharacter();
        // make some platforms
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(5, -2.5f));

        for (int i = 0; i < 4; i++) {
            Coin coin = new Coin(this);

            coin.setPosition(new Vec2(i * 2 - 10, 4));
            coin.addCollisionListener(new Pickup(getFuturamaPlane()));
        }

        for (int i = 0; i < 5; i++) {

            createStaticShapeCollition(this, circleShapes.get(i), getMainCharacter(1), i * 1.2f, i + 0.5f);
        }


    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-7, 3);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(6.5f, -7);
    }

    @Override
    public boolean isCompleted() {

        return getMainCharacter(1).getHealth() > 0;

    }

    public ArrayList<Shape> getCircleShapes() {
        return circleShapes;
    }

    /**
     * Creates circles in the level
     * @param circleShapes
     */
    private void fillCircleList(ArrayList<Shape> circleShapes) {

        float[] radius = {1.3f, 2.2f, 0.5f, 1.5f, 1.7f};
        for (int i = 0; i < 5; i++) {
            Shape asteroidsShape1 = new CircleShape(radius[i]);
            circleShapes.add(i, asteroidsShape1);

        }

    }


    @Override
    public void generateSecondCharacter() {
        F16 klmPlane = new F16(this);

        klmPlane.setPosition(new Vec2(-5, 8));
        klmPlane.startWalking(8);
        klmPlane.setLinearVelocity(new Vec2(8, -9));
        klmPlane.setAngularVelocity(7);

        klmPlane.setGravityScale(0);
    }
}


