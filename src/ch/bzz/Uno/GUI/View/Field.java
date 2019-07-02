package ch.bzz.Uno.GUI.View;

import ch.bzz.Uno.GUI.ViewController.FieldController;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Field extends JFrame {

    private JPanel panelWest = new JPanel();
    private JPanel panelSouth = new JPanel();
    private JPanel field = new JPanel();
    private JLabel playerName = new JLabel("");
    private JButton cardOnFieldLabel = new JButton("");
    private JButton drawCard = new JButton("Draw Card");
    private JButton uno = new JButton("Uno!");
    private JButton next = new JButton("Pass");
    private ArrayList<Card> hand = new ArrayList<>();
    private Player currentlyPlaying;
    private FieldController controller = new FieldController();
    private Card cardOnField;

    public Field() {
        listeners();
        getPlayer();
        getHand();
        getLayedDownCard();
        init();
    }

    private void getLayedDownCard() {
        cardOnField = controller.cardOnField();
    }


    public void init() {
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panelWest.setLayout(new GridLayout(4, 0));
        panelWest.add(drawCard);
        panelWest.add(next);
        panelWest.add(uno);
        panelWest.add(playerName);
        makeHandPanels();
        makeFieldPanel();
        add(panelWest, BorderLayout.WEST);
        add(panelSouth, BorderLayout.SOUTH);
        add(field, BorderLayout.CENTER);
        setVisible(true);
    }

    public void makeFieldPanel() {
        field.setLayout(new FlowLayout());
        cardOnFieldLabel.setText(cardOnField.getValue());
        cardOnFieldLabel.setBackground(cardOnField.getColor());
        field.add(cardOnFieldLabel);
    }

    private void getPlayer() {
        currentlyPlaying = controller.getPlayer();
        playerName.setText("Currently playing: " + currentlyPlaying.getUserName());
    }

    private void getHand() {
        hand = currentlyPlaying.getHand();
    }

    private void makeHandPanels() {
        panelSouth.setLayout(new FlowLayout());
        for (int i = 0; i < hand.size(); i++) {
            JButton button = new JButton(hand.get(i).getValue());
            button.setBackground(hand.get(i).getColor());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    layDownCardHasBeenPressed(button.getText(), button.getBackground());
                }
            });
            panelSouth.add(button);
        }
    }

    public void listeners() {
        drawCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.drawCardHasBeenPressed(currentlyPlaying);
                setVisible(false);
                Field field = new Field();
            }
        });
        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.unoHasBeenPressed();
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.nextHasBeenPressed();
                setVisible(false);
                Field field = new Field();
            }
        });
    }

    private void layDownCardHasBeenPressed(String value, Color color) {
        Card card = new Card();
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getColor().equals(color) && hand.get(i).getValue().equals(value)) {
                card = hand.get(i);
            }
        }
        if (controller.layDownCardHasBeenPressed(card)) {
            hand.remove(card);
            setVisible(false);
            Field field = new Field();
        } else {

        }
    }
}
