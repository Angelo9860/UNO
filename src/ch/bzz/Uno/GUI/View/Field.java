package ch.bzz.Uno.GUI.View;

import ch.bzz.Uno.GUI.viewController.SpielbrettController;
import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.controller.Controller;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Field extends JFrame {

    private JPanel panelWest = new JPanel();
    private JPanel panelSouth = new JPanel();
    private JLabel playerName = new JLabel(" ");
    private JButton drawCard = new JButton("Draw Card");
    private JButton layDownCard = new JButton("lay down a Card");
    private JButton uno= new JButton("Uno!");
    private JButton next = new JButton("Pass");
    private ArrayList<Card> hand = new ArrayList<>();
    private Player currentlyPlaying;
    private SpielbrettController controller = new SpielbrettController();

    public Field(){
        listeners();
        getPlayer();
        getHand();
        init();

    }




    public void init(){
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panelWest.setLayout(new GridLayout(4,0));
        panelWest.add(drawCard);
        panelWest.add(next);
        panelWest.add(uno);
        panelWest.add(playerName);
        makeHandPanels();

        add(panelWest, BorderLayout.WEST);
        add(panelSouth, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void getPlayer() {
        currentlyPlaying =  controller.getPlayer();
        playerName.setText("Currently playing: " + currentlyPlaying.getUserName());
    }

    private void getHand() {
        hand = currentlyPlaying.getHand();
        System.out.println("SIZE OF PLAYER HAND" + hand.size());
    }

    private void makeHandPanels(){
        panelSouth.setLayout(new FlowLayout());
        for(int i = 0; i < hand.size(); i++){
            System.out.println(hand.get(i).getValue());
            JButton button = new JButton (" " + hand.get(i).getValue());
            button.setBackground(hand.get(i).getColor());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    layDownCardHasBeenPressed(e);
                }
            });
            panelSouth.add(button);
        }

    }

    public void listeners(){
        drawCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void layDownCardHasBeenPressed(ActionEvent e){
        System.out.println(e.paramString());
    }

}
