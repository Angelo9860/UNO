package ch.bzz.Uno.GUI.View;

import ch.bzz.Uno.GUI.ViewController.StartUIController;
import ch.bzz.Uno.model.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUI extends JFrame {
    private JTextField playerName = new JTextField();
    private JButton addPlayer = new JButton("AddPlayer");
    private JButton startGame = new JButton("Start Game");
    private StartUIController controller = new StartUIController();
    public StartUI(){
        super("Uno");
        init();

    }

    private void init(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(800, 600);
        addPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPlayerHasBeenPressed();
            }
        });
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGameHasBeenPressed();
            }
        });
        add(playerName, BorderLayout.SOUTH);
        add(addPlayer, BorderLayout.EAST);
        add(startGame, BorderLayout.NORTH);
        setVisible(true);
    }

    public void addPlayerHasBeenPressed(){
        System.out.print("Hello");
        controller.addPlayerHasBeenPressed(playerName.getText());

    }

    public void startGameHasBeenPressed(){
        System.out.print("Hello");
        controller.startGameHasBeenPressed();

    }

}
