package GamePlane.Players;


import GamePlane.Bullet;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Plane extends Walker {


    /**
     * The health of a mainCharacter
     */

    private static int health;
    /**
     * The number of coins collected
     */
    private static int coinCount;
    /**
     * The value by which the
     */
    private float moveUpValue;
    private float moveDownValue;

    //constructors, 1 arg.
    public Plane(World world) {
        super(world);
    }


    public Plane(World world, Shape shape) {
        super(world, shape);
        coinCount = 0;
    }

    public Plane(World world, int health, Shape shape) {
        super(world, shape);

        this.health = health;
        coinCount = 0;
    }


    //constructors, 5 args.
    public Plane(World world, Shape shape, int health) {
        super(world, shape);

        this.health = health;
    }

    /**
     * Gets the health of a Plane.
     *
     * @return
     */
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets the number of coins.
     *
     * @param coinCount
     */
    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    /**
     * Gets the number of coins collected by a plane
     *
     * @return coinCount
     */
    public int getCoinCount() {
        return coinCount;
    }

    /**
     * Increments the coint count by one
     */
    public void incrementCoinCount() {
        coinCount++;

        System.out.println(coinCount);
    }

    /**
     * Decreases the health a Plane
     */
    public void decrementHealth() {
        health--;


        System.out.println(health);
    }


    public float getMoveUpValue() {
        return moveUpValue;
    }

    public float getMoveDownValue() {
        return moveDownValue;
    }

    public void moveUpValue() {

        this.moveUpValue += 0.2f;

    }

    /**
     * Decreases the value by which the planes move down
     */
    public void moveDownValue() {

        this.moveDownValue -= 0.2f;

    }


}
