package GamePlane.Players;

import city.cs.engine.*;

public class PrivateJetPlane extends Plane {

    public static final Shape privateJetPlane = new PolygonShape(-0.654f,-0.402f, 0.698f,
            -0.198f, 0.72f,0.409f, -0.522f,0.406f, -0.713f,0.063f, -0.657f,-0.399f);

    public static final BodyImage jetImage = new BodyImage("Data/privateJet.gif", 2);


    public PrivateJetPlane(World world) {
        super(world, privateJetPlane);
        addImage(jetImage);

    }


}
