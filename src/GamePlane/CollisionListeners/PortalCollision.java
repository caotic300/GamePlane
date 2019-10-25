package GamePlane.CollisionListeners;

import GamePlane.Game;
import GamePlane.Players.Plane;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PortalCollision implements CollisionListener {
        private Game game;
    public PortalCollision(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Plane plane = game.getFuturamaPlane();
        if (e.getOtherBody() == plane && game.isCurrentLevelCompleted()) {
            System.out.println("Going to the next level...");

            game.goNextLevel();
            System.out.println("in collide method, class PortalCollision");
        }
    }
}
