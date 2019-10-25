package GamePlane;


import GamePlane.Controllers.FuturamaController;
import GamePlane.Controllers.PrivateJetPlaneController;
import GamePlane.Levels.GameLevel;
import GamePlane.Levels.Level1;
import GamePlane.Levels.Level2;
import GamePlane.Levels.Level3;
import GamePlane.Menu.Layout;
import GamePlane.MyViews.MyView;
import GamePlane.Players.Plane;

import javax.swing.*;
import java.awt.*;

public class Game {


    /**
     * The world in which the bodies move and interact.
     */
    private GameLevel world;
    // private World superWorld;
    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;

    /**
     * The current level of the Game
     *
     */
    private static int level;

    /**
     * A Controller that controls a FuturamaPlane.
     *
     */
    private FuturamaController futuramaController;

    private PrivateJetPlaneController privateJetController;



    private final JFrame frame;

   //private final Container controlPanel;


    /**
     * Initialise a new Demo.
     */
    public Game() {

        //make the world
        level = 1;
        world = new Level1();
        world.populate(this);
        //make the view


        view = new MyView(world, world.getMainCharacter(1), 500, 500);


        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add this to the view, so coordinates are relative to the view

        //view.addMouseListener();

        //display the view in a frame
         frame = new JFrame("Plane Game");

        //add buttoms
        //controlPanel = new ControlPanel(this);
        frame.add(new Layout(this), BorderLayout.CENTER);
        //set background
        //frame.setIconImage(background);

        //quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        //display the world in the window
        frame.add(view, BorderLayout.SOUTH);



        //Don't let the game window be resized.
        frame.setResizable(false);

        //size the game window to fit the worldview.
        frame.pack();


        //make the window visible
        frame.setVisible(true);

        frame.requestFocus();
        futuramaController = new FuturamaController(world.getFuturamaPlane());
        frame.addKeyListener(futuramaController);

        // uncomment this to make a debugging view
        // JFrame debugView = new DebugViewer(world, 500, 500);


        //start the world
        world.start();

    }

    /**Gets Futurama Plane*/
    public Plane getFuturamaPlane() {
        return world.getFuturamaPlane();
    }





    public GameLevel getWorld() {

        return world;
    }

    public JFrame getFrame() {
        return frame;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Game.level = level;
    }

    public MyView getView(){
        return view;
    }

    public FuturamaController getFuturamaController() {
        return futuramaController;
    }

    public void setFuturamaController(FuturamaController futuramaController) {
        this.futuramaController = futuramaController;
    }
    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /** Transition to a new level
     *
     */
    public void goNextLevel() {

        world.stop();
        int actualCoins  = world.getMainCharacter(1).getCoinCount();
        int actualHealth= world.getMainCharacter(1).getHealth();
        if (level == 3) {
            System.exit(0);
        }

        else if (level == 0){
            level++;

            world = new Level1();

            world.populate(this);

            futuramaController.setFuturamaPlane(world.getMainCharacter(1));
            recordInfo(actualHealth, actualCoins, world);

            view.setWorld(world);
            view.setPlane(world.getMainCharacter(1));

            world.start();

        }


        else if (level == 1){

            level++;

            world = new Level2();

            world.populate(this);

            futuramaController.setFuturamaPlane(world.getMainCharacter(1));
            recordInfo(actualHealth, actualCoins, world);

            view.setWorld(world);
            view.setPlane(world.getMainCharacter(1));

            world.start();

        } else if (level == 2) {

            level++;

            world = new Level3();


            world.populate(this);

            futuramaController.setFuturamaPlane(world.getMainCharacter(1));
            recordInfo(actualHealth, actualCoins, world);

            view.setWorld(world);
            view.setPlane(world.getMainCharacter(1));

            world.start();


        }

    }

    /**Records the information of the main character
     *
     * @param actualHealth
     * @param actualCoins
     * @param world
     *
     */
    public  void recordInfo(int actualHealth, int actualCoins, GameLevel world) {

        world.getMainCharacter(1).setCoinCount(actualCoins);
        world.getMainCharacter(1).setHealth(actualHealth);
    }





    public static void main(String[] args) {
        // write your code here


        new Game();




    }


}
