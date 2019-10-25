package GamePlane.Levels;

import city.cs.engine.*;

public class Portal extends StaticBody {

    public static final Shape portalShape = new PolygonShape(0.029f,0.414f,
            -0.143f,-0.034f, -0.011f,-0.47f, 0.171f,-0.052f, 0.031f,0.414f);

    /**
     * Contructs the portal of a game in a World
     * @param world - The World where the portal is coontructed
     */
    public Portal(World world) {
        super(world,  portalShape);
        addImage(new BodyImage("Data/portal.png", 2.5f));
    }


}
