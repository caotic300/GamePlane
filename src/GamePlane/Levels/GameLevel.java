package GamePlane.Levels;

import GamePlane.Coin;
import GamePlane.CollisionListeners.PlaneCollision;
import GamePlane.CollisionListeners.PortalCollision;
import GamePlane.Pickup;
import GamePlane.Players.*;
import GamePlane.Game;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import GamePlane.Players.Klm.*;

import java.awt.*;

public abstract class GameLevel extends World {
    private Plane futuramaPlane;
    private Plane privateJetPlane;
    private Plane klmPlane;
    private Plane f16;
    private UserView view;
    private Portal portal;
    private Coin coin;
    //private


    public GameLevel(int framesPerSecond) {
        super(framesPerSecond);
    }


    public void populate(Game game) {

        setMainCharacter(1);

        portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalCollision(game));


    }


    /**
     * The initial position of the player.
     */
    public abstract Vec2 startPosition();

    /**
     * The position of the exit portal.
     */
    public abstract Vec2 portalPosition();

    /**
     * Is the level complete?
     */
    public abstract boolean isCompleted();


    public Plane getFuturamaPlane() {
        return futuramaPlane;
    }

    public Plane getPrivateJetPlane() {
        return privateJetPlane;
    }

    public Plane getKlmPlane() {
        return klmPlane;
    }

    public Plane getF16() {
        return f16;
    }

    public Portal getPortal() {
        return portal;
    }

    /**
     * retrieves the selected Character
     * @return the Character Selected,
     * @param character - the character selected
     *
     */
    public Plane getMainCharacter(int character) {

        switch (character) {
            case 1:
                return getFuturamaPlane();

            case 2:
               return getPrivateJetPlane();

            case 3:
                return getKlmPlane();

            case 4:
                return getF16();

            default:
                String s = "Incorrect number";
                System.out.println(s);
                return null;
        }

    }

    /**
     * Set Character Selected
     * @author Pedro
     */
    public void setMainCharacter(int character) {
        switch (character) {
            case 1:
                futuramaPlane = new FuturamaPlane(this);
                futuramaPlane.setPosition(startPosition());
                futuramaPlane.startWalking(5);

                break;

            case 2:
                privateJetPlane = new PrivateJetPlane(this);
                privateJetPlane.setPosition(startPosition());
                privateJetPlane.startWalking(5);

                break;

            case 3:
                klmPlane = new Klm(this);
                klmPlane.setPosition(startPosition());
                klmPlane.startWalking(5);

                break;
            case 4:
                f16 = new F16(this);
                f16.setPosition(startPosition());
                f16.startWalking(5);
                break;

            default:
                String s = "Incorrect number";
                System.out.println(s);
                break;
        }
    }



    /**
     * Create a new Body with a new Collision for any Static Body, setting the position
     * @param world - The world where objects are placed
     * @param shape - A shape in the world
     * @param plane - the plane that collisi
     */
    public void createStaticShapeCollition(World world, Shape shape, Plane plane, float x, float y) {

        Body body = new StaticBody(world, shape);

        body.setPosition(new Vec2(x, y));
        body.addCollisionListener(new PlaneCollision(plane));

    }

    /**
     *
     * Creates a Body attaching a collitionListener to it, when a Plane is the object that must collide.
     *
     * @param world - The world where the shape is created
     * @param shape - The shape created
     * @param plane - The plane that is going to collide
     * @param x - The horizontal position of the Body.
     * @param y - The vertical position of the Body.
     * @param gravity - The gravity of the Body
     */
    public void createDynamicShapeCollition(World world, Shape shape, Plane plane, float x, float y, float gravity) {
        Body body = new DynamicBody(world, shape);
        body.setPosition(new Vec2(x, y));
        body.addCollisionListener(new PlaneCollision(plane));
        ((DynamicBody) body).setGravityScale(gravity);

    }

    /**
     * Creates a Dynamic Body attaching a collitionListener to it, when a Plane is the object that must collide.
     * @param world - The world where the shape is created
     * @param shape - The shape created
     * @param plane - The plane that is going to collide
     * @param x - The horizontal position of the Body.
     * @param y - The vertical position of the Body.
     * @param maxY - The maximum vertical position of the Body
     * @param gravity - The gravity of the Body
     */
    public void createDynamicShapeCollition(World world, Shape shape, Plane plane, float x, float y, float maxY, float gravity) {
        Body body = new DynamicBody(world, shape);
        body.setPosition(new Vec2(x, y));

        body.addCollisionListener(new PlaneCollision(plane));
        ((DynamicBody) body).setGravityScale(gravity);

        if (y <= maxY) {

            ((DynamicBody) body).setLinearVelocity(new Vec2(0,20));
        } else {
            ((DynamicBody) body).setLinearVelocity(new Vec2(0,-20));
        }
    }
    /**
     * Creates the ground of a level.
     * */
    protected void generateGround() {
        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        createStaticShapeCollition(this, groundShape, getMainCharacter(1), 0, -11.5f);

        // make a platform
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(9, 3.5f));
        platform2.setAngleDegrees(30);
        createStaticShapeCollition(this, platformShape, getMainCharacter(1), -9, 5.5f);
    }

    /**
     * Sets the number of coins
     */
    public void createCoin(int coins, float x, float y, int p) {
        Coin bitCoin;

        for (int i = 0; i < coins; i += p) {
            bitCoin = new Coin(this);
            bitCoin.setPosition(new Vec2(i * x - 10, y));
            bitCoin.addCollisionListener(new Pickup(getMainCharacter(1)));
        }
    }

        /**Generates a second character in a Level */
        public abstract void generateSecondCharacter();
}

