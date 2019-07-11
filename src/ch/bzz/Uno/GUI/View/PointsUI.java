package ch.bzz.Uno.GUI.View;

import ch.bzz.Uno.GUI.ViewController.PointsUIController;
import ch.bzz.Uno.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PointsUI extends JFrame {
    private JLabel win = new JLabel("");
    private JLabel points = new JLabel("");
    private JButton newRound = new JButton("Neue Runde");
    private JLabel centerSpace1 = new JLabel("");
    private JLabel centerSpace2 = new JLabel("");
    private JLabel bottomSpace1 = new JLabel("");
    private JLabel bottomSpace2 = new JLabel("");
    private JLabel bottomSpace3 = new JLabel("");
    private JLabel bottomSpace4 = new JLabel("");
    private JPanel bottom = new JPanel();
    private JPanel center = new JPanel();
    private JPanel north = new JPanel();
    private ArrayList<Player> players = new ArrayList<>();
    private PointsUIController controller = new PointsUIController();

    public PointsUI() {
        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        players = controller.getPlayers();
        getPoints();
        this.init();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setTitle("UNO - Runde gewonnen");
        this.setSize(700, 500);
        this.setResizable(false);
    }

    private void init() {
       /* getContentPane().setLayout(new BorderLayout(0, 0));
        bottom.setLayout((new BorderLayout(0, 0)));
        centerSpace1.setPreferredSize(new Dimension(200, 300));
        centerSpace2.setPreferredSize(new Dimension(200, 300));

        bottomSpace1.setPreferredSize(new Dimension(200, 0));
        bottomSpace2.setPreferredSize(new Dimension(200, 0));
        bottomSpace3.setPreferredSize(new Dimension(1000, 60));
        bottomSpace4.setPreferredSize(new Dimension(1000, 60));

        bottom.add(newRound, BorderLayout.CENTER);
        bottom.add(bottomSpace1, BorderLayout.WEST);
        bottom.add(bottomSpace2, BorderLayout.EAST);
        bottom.add(bottomSpace3, BorderLayout.NORTH);
        bottom.add(bottomSpace4, BorderLayout.SOUTH);*/
        setLayout(new BorderLayout());
        center.setLayout(new GridLayout(7, 0));
        north.setLayout(new GridLayout(0, 3));
        makeWin();
        north.add(new JLabel(" "));
        north.add(win);
        north.add(new JLabel(" "));
        showPoints();
        add(north, BorderLayout.NORTH);
        add(newRound, BorderLayout.SOUTH);
        add(center, BorderLayout.CENTER);
        win.setFont(new Font("Arial", Font.PLAIN, (20)));

        newRound.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                setVisible(false);
                controller.startGameHasBeenPressed();
                Field ui = new Field();

            }
        });/*
        win.setFont(new Font("Arial", Font.PLAIN, (20)));
        getContentPane().add(centerSpace1, BorderLayout.WEST);
        getContentPane().add(centerSpace2, BorderLayout.EAST);
        getContentPane().add(win, BorderLayout.CENTER);
        getContentPane().add(bottom, BorderLayout.SOUTH);
    */
    }

    public void makeWin(){
        win.setText(controller.getPlayer().getUserName() + " has won the Round");
    }


    public void showPoints() {
        for (int i = 0; i < players.size() - 1; i++) {
            JLabel label = new JLabel(players.get(i).getUserName() + ": " + players.get(i).getPoints());
            center.add(label);
        }

    }

    public void getPoints(){
        for(int i = 0; i < players.size(); i++){
            System.out.println("SIZEARRAY" + players.size());
            System.out.println(points.getText() + "\n" + players.get(i).getUserName() + ": " + players.get(i).getPoints()+ " HELLO"
            );
            points.setText(points.getText() + "\n" + players.get(i).getUserName() + ": " + players.get(i).getPoints()+ " HELLO");
        }
    }
}
