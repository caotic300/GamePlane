package GamePlane;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Bullet extends Walker {

    /**
     * The shape of a bullet.
     */
    public static final Shape bulletShape = new CircleShape(0.304f);

    /**
     * The image of a coin
     */
    public static final BodyImage bulletImage = new BodyImage("Data/fireball.jpg", 1.5f);

    public Bullet(World world) {
        super(world, bulletShape);
        addImage(bulletImage);
    }

    /**Creates a new Bullet when the coordinates are specified, moving in straight line
     *
     * @param speed - The speed of the bullet
     * @param x - The horizontal position of the bullet
     * @param y - The vertical position of the bullet
     */
    public void bullet(Bullet bullet, float speed, float x, float y) {

        bullet.setPosition(new Vec2(x + 2, y));
        bullet.setLinearVelocity(new Vec2(speed, 0));
        bullet.setGravityScale(0);
    }

}
