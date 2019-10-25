package GamePlane.Levels;

import GamePlane.Game;
import GamePlane.Players.F16;
import GamePlane.Players.Plane;
import GamePlane.Players.PrivateJetPlane;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Level3 extends GameLevel {

    public Level3() {
        super(60);
    }

    @Override
    public void populate(Game game) {
        super.populate(game);
        // make the ground
        // make the ground
        generateGround();


        for (int i = 0; i < 4; i += 3) {
            movingObstacle(3 + i, 6);

        }

        createmovingObtacle(-7, -4, 5);

    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(-5, -3);
    }

    @Override
    public Vec2 portalPosition() {
        return new Vec2(4, 6);
    }

    @Override
    public boolean isCompleted() {
        return getMainCharacter(1).getHealth() > 0;
    }


    public void createmovingObstacle(float initialX, float initialY) {
        Shape rectangleMoving = new BoxShape(0.5f, 2f);
        createDynamicShapeCollition(this, rectangleMoving, getMainCharacter(1), initialX, initialY, 0);

    }

    public void movingObstacle(int p, int numberObstacle) {

        for (int i = -2; i < numberObstacle; i += p) {

            createmovingObstacle(-3 + i, i + 2.6f);

        }

        for (int i = -2; i < numberObstacle; i += p) {

            createmovingObstacle(2 + i, i - 2.6f);

        }
    }

    public void createmovingObtacle(float initialX, float initialY, float maxY) {
        Shape rectangleMoving = new BoxShape(0.5f, 2f);

        createDynamicShapeCollition(this, rectangleMoving, getMainCharacter(1), initialX, initialY, maxY, 0);


    }

    /**
     * creates a second character in the world.
     */
    @Override
    public void generateSecondCharacter() {
        /*getF = new F16(this);

        privateJetPlane.setPosition(new Vec2(-5, 8));
        privateJetPlane.startWalking(8);
        privateJetPlane.setLinearVelocity(new Vec2(8, -9));
        privateJetPlane.setAngularVelocity(7);

        privateJetPlane.setGravityScale(0);*/
        setMainCharacter(2);


    }

}
