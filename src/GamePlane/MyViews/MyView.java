package GamePlane.MyViews;

import GamePlane.Game;
import GamePlane.Players.Plane;
import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;


public class MyView extends UserView {
     private Image[] background = new Image[3];


    private Plane plane;


    private int level;

    public MyView(World w, Plane plane, int width, int height) {

        super(w, width, height);
        this.plane = plane;

        background[0] = new ImageIcon("Data/cascade.jpg").getImage();
        background[1] = new ImageIcon("Data/finalDay.PNG").getImage();
        background[2] = new ImageIcon("Data/landscape.png").getImage();

    }


    @Override
    protected void paintForeground(Graphics2D g) {

        g.drawString("score: " + plane.getCoinCount(), 100, 100);
        g.drawString("lifes: " + plane.getHealth(), 100, 80);

    }



    @Override
    protected void paintBackground(Graphics2D g) {
        level = Game.getLevel();

        if (level == 1) {

            g.drawImage(background[0], 0, 0, 500, 500, this);

        }

        else if (level == 0) {
            g.drawImage(background[0], 0, 0, 500, 500, this);
        }

        else if (level == 2) {

            g.drawImage(background[1], 0, 0, 500, 500, this);

        } else if (level == 3) {

            g.drawImage(background[2], 0, 0, 500, 500, this);

        }
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

}
