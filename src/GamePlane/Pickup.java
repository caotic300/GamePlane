package GamePlane;

import GamePlane.Players.Plane;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Pickup implements CollisionListener {

    private Plane plane;
    private static SoundClip coinSound;

    static {
        try {
            coinSound = new SoundClip("Data/smw_coin.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Sound cound not be loaded due to" + e);
        }
    }

    public Pickup(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == plane) {
            plane.incrementCoinCount();
            e.getReportingBody().destroy();
            coinSound.play();
        }

    }


}
