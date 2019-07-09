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
    private JButton colorWish = new JButton("Click for Color");
    private JButton cardOnFieldLabel = new JButton("");
    private JButton drawCard = new JButton("Draw Card");
    private JButton uno = new JButton("Uno!");
    private JButton next = new JButton("Pass");
    private ArrayList<Card> hand = new ArrayList<>();
    private Player currentlyPlaying;
    private FieldController controller = new FieldController();
    private Card cardOnField;
    private JLabel wished = new JLabel("");
    private static Color defaultColor = new Color(238,238,238);

    public Field() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        listeners();
        getPlayer();
        getHand();
        defaultColor = colorWish.getBackground();
        getWished();
        getLayedDownCard();
        mappingWishColor();
        init();
        //resetWishColor();
    }

    private void resetWishColor() {
        controller.resetWishColor();
    }

    private void mappingWishColor() {
        if(getWished() == Color.blue){
            wished.setText("WISHED COLOR IS BLUE");
        }else if(getWished() == Color.red){
            wished.setText("WISHED COLOR IS RED");
        }else if(getWished() == Color.yellow){
            wished.setText("WISHED COLOR IS YELLOW");
        }else if(getWished() == Color.green){
            wished.setText("WISHED COLOR IS GREEN");
        }else{
            wished.setText(" ");
        }
    }

    private void getLayedDownCard() {
        cardOnField = controller.cardOnField();
    }


    public void init() {
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelWest.setLayout(new GridLayout(6, 0));
        panelWest.add(drawCard);
        panelWest.add(next);
        panelWest.add(uno);
        panelWest.add(colorWish);
        panelWest.add(playerName);
        panelWest.add(wished);
        makeHandPanels();
        makeFieldPanel();
        getWished();
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
        colorWish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(colorWish.getBackground() == Color.blue){
                    colorWish.setBackground(Color.green);
                }else if(colorWish.getBackground() == Color.yellow) {
                    colorWish.setBackground(Color.red);
                }else if(colorWish.getBackground() == Color.green){
                    colorWish.setBackground(Color.yellow);
                }else if(colorWish.getBackground() == Color.red){
                    colorWish.setBackground(Color.blue);
                }else if(colorWish.getBackground() == defaultColor){
                    colorWish.setBackground(Color.blue);
                }

            }
        });

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
        Color wishColor = Color.pink;
        Card card = new Card();
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getColor().equals(color) && hand.get(i).getValue().equals(value)) {
                card = hand.get(i);
            }
        }
            if(card.getColor() == Color.black){
                wishColor = colorWish.getBackground();
            }else{
                wishColor = Color.pink;
            }
        if (controller.layDownCardHasBeenPressed(card, wishColor)) {

            hand.remove(card);
            if(hand.size() == 0){
                controller.calculatePoints();
                showPoints();
            }else{
                setVisible(false);
                Field field = new Field();
            }

        }


    }


    public Color getWished(){
    return controller.getWishColor();

    }
    public void showPoints(){
    PointsUI ui = new PointsUI();
    }
}
