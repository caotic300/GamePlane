package GamePlane.Controllers;

import GamePlane.Players.Plane;
import GamePlane.Players.PrivateJetPlane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PrivateJetPlaneController  implements KeyListener, MouseListener {
        Plane privateJetPlane;

    public PrivateJetPlaneController(Plane privateJetPlane) {

        this.privateJetPlane = privateJetPlane;
    }

    public Plane getPrivateJetPlane() {
        return privateJetPlane;
    }

    public void setPrivateJetPlane(PrivateJetPlane privateJetPlane) {
        this.privateJetPlane = privateJetPlane;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
