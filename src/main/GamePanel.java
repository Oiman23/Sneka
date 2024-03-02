package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entities.*;

public class GamePanel extends JPanel implements Runnable {

	Thread thread;
	Snake snake;
	Food food;
	Interactions interactions;
	JLabel scoreLabel = new JLabel();
	KeyHandler key = new KeyHandler();
	JButton button;
	JPanel titleScreen = new JPanel();
	JPanel greyTint = new JPanel();
	Font font = new Font("Arial", Font.BOLD, 15);
	public final int size = 42;
	public final int rows = 16;
	public final int cols = 16;
	public final int screenSize = size * rows;
	private boolean gameStatus = true;

	public GamePanel() {
		// Snake Game Panel Sizes
		this.setPreferredSize(new Dimension(screenSize, screenSize));
		this.setBackground(Color.black);
		this.setLayout(null);
		this.setFocusable(true);
		this.addKeyListener(key);

		// Starting Title Screen to start game as well
		titleScreen.setBackground(Color.GRAY);
		titleScreen.setBounds((screenSize / 2) - (size * 4) / 2, (screenSize / 2) - (size * 3), size * 4, size * 2);
		// 10 --> 5, 4
		button = new JButton("Start Game");
		button.setBackground(Color.GRAY);
		button.setBounds((screenSize / 2) - (size * 4) / 2, (screenSize / 2) - (size * 1), size * 4, size * 1);
		button.setFont(font);

		button.addActionListener(e -> {
			gameStatus = true;
			titleScreen.setVisible(false);
			greyTint.setVisible(false);
			// Starts Game
			thread = new Thread(this);
			thread.start();
		});

		titleScreen.add(button);
		titleScreen.setVisible(true);
		this.add(titleScreen);

		// Score
		scoreLabel.setBounds((screenSize / 2) - (size * 2) / 2, 0, size * 2, size * 1);
		scoreLabel.setFont(font);
		this.add(scoreLabel);

		// Entities Creation
		snake = new Snake(this, key, null, null);
		food = new Food(this, snake);
		interactions = new Interactions(this, snake, food);

		updateScore();

		greyTint.setBackground(new Color(128, 128, 128, 50));
		greyTint.setBounds(0, 0, screenSize, screenSize);
		greyTint.setVisible(true);
		this.add(greyTint);	
	}

	@Override
	public void run() {
		while (thread != null && gameStatus == true) {
			try {
				Thread.sleep(500);
				update();
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {
		snake.update();
		interactions.update();
		Snake pointer = snake.next(); // check the first snake with interactions then the while loop
		while (pointer != null) {
			pointer.update();
			pointer = pointer.next();
		}

		food.update();
		updateScore();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Snake pointer = snake;
		while (pointer != null) {
			pointer.draw(g);
			pointer = pointer.next();
		}
		food.draw(g);
	}

	public void updateScore() {
		scoreLabel.setText("Score: " + interactions.getScore());
	}

}
