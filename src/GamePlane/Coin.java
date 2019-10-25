package GamePlane;

import city.cs.engine.*;

public class Coin extends StaticBody {

    /**
     * The shape of a coin.
     */
    public static final Shape coinShape = new CircleShape(0.304f);


    /**
     * The image of a coin
     */
    public static final BodyImage coinImage = new BodyImage("Data/bitCoin.gif", 1.5f);

    public Coin(World world) {
        super(world, coinShape);
        addImage(coinImage);
    }
}
