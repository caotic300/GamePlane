package GamePlane.Players;

import GamePlane.Levels.Level1;
import city.cs.engine.*;

public class FuturamaPlane extends Plane {





   public static final Shape futuramaPlane = new PolygonShape(-0.69f, 0.412f, -0.683f, -0.37f, 0.139f, -0.313f,
            0.799f, -0.007f, 0.309f, 0.272f, -0.69f, 0.412f);

    private static final BodyImage futuramaImage =
            new BodyImage("Data/futuramaPlane.png", 1.25f);

    public FuturamaPlane(World world) {
        super(world, 10, futuramaPlane);
        addImage(futuramaImage);


    }

    public FuturamaPlane(World world, Shape shape,  int health) {
        super(world, shape,  health);
    }



}
