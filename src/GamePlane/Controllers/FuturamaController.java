package GamePlane.Controllers;

import GamePlane.Bullet;
import GamePlane.Coin;
import GamePlane.Game;
import GamePlane.Players.FuturamaPlane;
import GamePlane.Players.Plane;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.event.*;

public class FuturamaController implements KeyListener, MouseListener {
    /**The plane to be controlled */
    private Plane futuramaPlane;

    /**The speed of the plane*/
    private final float JUMPING_SPEED = 3f;
    /**Sets a new futuramaPlane*/
    public void setFuturamaPlane(Plane futuramaPlane) {
        this.futuramaPlane = futuramaPlane;
    }
    /**Initialises a new futuramaPlane
     * @param futuramaPlane
     * @see Plane*/
    public FuturamaController(Plane futuramaPlane) {

        this.futuramaPlane = futuramaPlane;


    }


    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        for (int i = 0; i < 3; i++) {
            movePlaneKeyPressed(code);


        }


    }

    /**
     * goes down
     *
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        for (int i = 0; i < 3; i++) {
            movePlaneKeyReleased(code);

        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //if (Game)
        System.exit(0);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    /** Moves the plane up and down when a key is pressed */
    private void movePlaneKeyPressed(int code) {
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_J) { // J = jump
            moveUp(futuramaPlane);


        } else if (code == KeyEvent.VK_F) {
            moveDown(futuramaPlane);

        } else if ((code == KeyEvent.VK_SPACE)) {
            Bullet bullet = new Bullet(futuramaPlane.getWorld());
           bullet.bullet(bullet,5, futuramaPlane.getPosition().x, futuramaPlane.getPosition().y);

        }
    }
    /**
     * Moves the plane up and down when a key is realeased
     * */
    private void movePlaneKeyReleased(int code) {
        if (code == KeyEvent.VK_J) {

            moveDown(futuramaPlane);

        } else if (code == KeyEvent.VK_F) {

            moveUp(futuramaPlane);

        }
    }
    /**makes the futuramaPlane to move up
     * @author Pedro
     * @param futuramaPlane - a futurama plane
     * @see Plane*/
    private void moveUp(Plane futuramaPlane) {
        futuramaPlane.setGravityScale(-4f);
        futuramaPlane.moveUpValue();
        futuramaPlane.setLinearVelocity(new Vec2(futuramaPlane.getPosition().x, futuramaPlane.getMoveUpValue()));
    }
    /**makes a Plane to move down
     * @author Pedro
     * @param futuramaPlane - a futurama plane
     * @see Plane
     * */
    private void moveDown(Plane futuramaPlane) {
        futuramaPlane.setGravityScale(4f);
        futuramaPlane.moveDownValue();
        futuramaPlane.setLinearVelocity(new Vec2(futuramaPlane.getPosition().x, futuramaPlane.getMoveDownValue()));
    }

}
