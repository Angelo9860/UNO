package ch.bzz.Uno.GUI.View;

import ch.bzz.Uno.GUI.ViewController.StartUIController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class StartUI extends JFrame{

	private JPanel buttonsLeft = new JPanel();
	private JPanel buttonsRight = new JPanel();
	private JButton add = new JButton("Add a Player");
	private JButton start = new JButton("Start a Game");
	private JButton rules = new JButton("Rules");
	private JLabel credit = new JLabel("Made by Nina");
	private JTextField field = new JTextField();
	private StartUIController controller = new StartUIController();
	

	public StartUI(){
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.init();
		this.listeners();
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("UNO - Ende");
		this.setSize(1000, 700);
		this.setResizable(true);
	}

	private void init(){

		buttonsLeft.setPreferredSize(new Dimension(400, 150));
		buttonsLeft.setBorder(new EmptyBorder(20, 20, 20, 20));
		buttonsRight.setPreferredSize(new Dimension(400, 150));
		buttonsRight.setBorder(new EmptyBorder(20, 20, 20, 20));
		credit.setPreferredSize(new Dimension(1000, 150));
		credit.setVerticalAlignment(SwingConstants.CENTER);
		
		//BufferedImage image = ImageIO.read(new File("./java.jpg"));
		//JLabel bildLabel = new JLabel(new ImageIcon(image));

		getContentPane().setLayout(new BorderLayout(0, 0));

		buttonsLeft.setLayout(new GridLayout(2, 1, 30, 30));
		buttonsRight.setLayout(new GridLayout(2, 1, 30, 30));

		buttonsLeft.add(add);
		buttonsLeft.add(field);
		buttonsRight.add(start);
		buttonsRight.add(rules);

		getContentPane().add(buttonsLeft, BorderLayout.WEST);
		getContentPane().add(buttonsRight, BorderLayout.EAST);
		getContentPane().add(credit, BorderLayout.SOUTH);

	}

	private void listeners(){
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addPlayerHasBeenPressed();
			}
		});
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startGameHasBeenPressed();
			}
		});

	}


	public void addPlayerHasBeenPressed(){
		System.out.print("Hello");
		controller.addPlayerHasBeenPressed(field.getText());

	}

	public void startGameHasBeenPressed(){
		System.out.print("Hello");
		controller.startGameHasBeenPressed();
		Field field = new Field();

	}

}
