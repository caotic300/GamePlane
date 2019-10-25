package GamePlane.Menu;

import GamePlane.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Layout extends JPanel {
    private JButton quit;
    private JButton stop;
    private JButton restart;
    private JButton saveScore;
    private JButton loadScore;

    /**The Image of the quit button */
    private ImageIcon imageQuit = new ImageIcon("Data/close_normal.png");

    /**The Image oof the play button */
    private ImageIcon imagePlay = new ImageIcon("Data/play_normal.png");
    private ImageIcon imagePause = new ImageIcon("Data/pause_normal.png");

    private static final String fileName = "record.txt";
    /**The file where the information is saved */
    private static final String saveData = "save.txt";

    public Layout(Game game) {

        quit = new JButton(imageQuit);
        stop = new JButton(imagePause);
        restart = new JButton(imagePlay);
        saveScore = new JButton("Save Level");
        loadScore = new JButton("Load Level");

        setBackground(Color.GRAY);//0.8331f, 0.8270f, 0.6899f

        add(quit, BorderLayout.EAST);
        add(stop, BorderLayout.CENTER);
        add(restart, BorderLayout.WEST);
        add(saveScore, BorderLayout.WEST);
        add(loadScore, BorderLayout.EAST);

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getWorld().stop();
            }
        });


        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getFrame().addKeyListener(game.getFuturamaController());


                game.getWorld().start();
                game.getFrame().requestFocus();
            }
        });

        saveScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    boolean append = true;
                    FileWriter writer = null;
                    try {
                        writer = new FileWriter(saveData);
                        writer.write(Integer.toString(Game.getLevel()));
                        game.getFrame().requestFocus();
                    }  finally {
                        if (writer != null) {
                            writer.close();
                        }
                    }

                } catch (IOException e1) {
                    System.out.println(e1);
                }


            }
        });

        loadScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileReader fr = new FileReader(saveData);
                    BufferedReader br = new BufferedReader(fr);
                    String str = br.readLine();
                    br.close();
                    int saveLevelnum = Integer.parseInt(str);
                    game.setLevel(saveLevelnum - 1);
                    game.goNextLevel();
                    game.getFrame().requestFocus();

                } catch (IOException e1) {
                    System.out.println(e1);
                }


            }
        });


        //stop.
    }



}

