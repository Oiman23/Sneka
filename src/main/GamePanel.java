package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
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

		// Score
		scoreLabel.setBounds((screenSize / 2) - (size * 2) / 2, 0, size * 2, size * 1);
		scoreLabel.setFont(font);
		this.add(scoreLabel);

		// Entities Creation
		snake = new Snake(this, key, null, null);
		food = new Food(this, snake);
		interactions = new Interactions(this, snake, food);

		updateScore();
		this.setVisible(true);

	}

	public void secondScreen() {
		Font font = new Font("Arial", Font.BOLD, 15);
		JPanel loseScreen = new JPanel();
		JPanel titleScreen = new JPanel();
		JPanel greyTint = new JPanel();
		JButton button = new JButton("Start Game");

		titleScreen.setVisible(false);
		loseScreen.setVisible(false);
		greyTint.setVisible(false);

		loseScreen.setPreferredSize(new Dimension(screenSize, screenSize));
		loseScreen.setBackground(Color.white);

		titleScreen.setPreferredSize(new Dimension(screenSize, screenSize));
		titleScreen.setBackground(Color.GRAY);
		// Starting Title Screen to start game as well
		titleScreen.setBackground(Color.GRAY);
		// 10 --> 5, 4
		button.setBackground(Color.GRAY);
		button.setFont(font);

		button.addActionListener(e -> {
			// Starts Game
			titleScreen.setVisible(false);
			this.setVisible(false);
			startGame();
		});

		loseScreen.setPreferredSize(new Dimension(screenSize, screenSize));
		greyTint.setPreferredSize(new Dimension(screenSize, screenSize));

		titleScreen.add(button);
		this.add(greyTint);
		this.add(loseScreen);
		this.add(titleScreen);
	}

	@Override
	public void run() {
		while (thread != null && gameStatus == true) {
			try {
				Thread.sleep(500);
				update();
				loseCondition();
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void loseCondition() {
		if (snake.getX() < 0 || snake.getX() > screenSize || snake.getY() < 0 || snake.getY() > screenSize) {

		}
	}

	public void startGame() {
		gameStatus = true;
		thread = new Thread(this);
		thread.start();
	}

	public void update() {
		Snake pointer = snake; // check the first snake with interactions then the while loop
		pointer.update();
		interactions.update();
		pointer = pointer.next();
		while (pointer != null) {
			pointer.update();
			pointer = pointer.next();
		}
		interactions.update();

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

	public Interactions getInteractions() {
		return interactions;
	}

}
