package GamePlane.Players;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;

public class F16 extends Plane {
    public static final Shape F16 = new PolygonShape(-1.422f,-0.25f, 1.092f,-0.544f, 0.648f,0.08f, -0.714f,0.74f, -1.266f,0.266f, -1.446f,-0.226f);

    public static final BodyImage F16Image = new BodyImage("Data/F16.gif", 3);
    public F16(World world) {
        super(world, F16);
        addImage(F16Image);
    }


}
