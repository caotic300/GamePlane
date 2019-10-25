package GamePlane.Players;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;

public class Klm extends Plane{
    /**The shape of a Klm Plane */
    public static final Shape klm = new PolygonShape(-1.849f,1.099f, -2.036f,-0.368f, 2.276f,-0.234f, -0.116f,0.868f, -1.84f,1.081f);

    /**The image of a klm Plane*/
    public static BodyImage klmImage = new BodyImage("Data/klmPlane.png" );

    public Klm(World world) {
        super(world);
        addImage(klmImage);
    }

    /** Gets the Klm Plane
     *
     * @return klm
     */
    public static Shape getKlm() {
        return klm;
    }
}
