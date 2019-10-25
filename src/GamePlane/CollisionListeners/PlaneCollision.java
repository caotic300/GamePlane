package GamePlane.CollisionListeners;

import GamePlane.Players.Plane;
import GamePlane.Levels.Portal;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PlaneCollision implements CollisionListener {
    private Plane plane;

    public PlaneCollision(Plane plane) {
        this.plane = plane;

    }



    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == plane) {

            plane.decrementHealth();

            if (plane.getHealth() == 0) {
                e.getOtherBody().destroy();
                System.exit(0);
            }
        }


    }


}
