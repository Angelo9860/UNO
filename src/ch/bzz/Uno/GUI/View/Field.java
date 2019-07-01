package ch.bzz.Uno.GUI.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JFrame{

    private JTextArea textArea1 = new JTextArea();
    private JPanel panelTop = new JPanel();
    private JComboBox comboBox1;
    private JButton drawCard = new JButton("Draw Card");
    private JComboBox comboBox2;
    private JButton layDownCard = new JButton("lay down a Card");
    private JComboBox comboBox3;
    private JButton uno= new JButton("Uno!");
    private JComboBox comboBox4;
    private JButton next = new JButton("Pass");

    public Field(){
        init();
        listeners();


    }

    public void init(){
        setLayout(new BorderLayout());
        panelTop.setLayout(new BorderLayout());
        panelTop.add(drawCard, BorderLayout.EAST);
        panelTop.add(next, BorderLayout.WEST);

    }

    public void listeners(){
        getCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
