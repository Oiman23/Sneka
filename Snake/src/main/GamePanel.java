package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Entities.*;

public class GamePanel extends JPanel implements Runnable {

	Thread thread;
	Snake snake;
	Food food;
	Interactions interactions;
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	KeyHandler key = new KeyHandler();
	public final int size = 42;
	public final int rows = 16;
	public final int cols = 16;
	public final int tileSize = size * rows;

	public GamePanel() {
		this.setPreferredSize(new Dimension(tileSize, tileSize));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(key);
		this.add(panel);
		panel.add(label);

		snake = new Snake(this, key);
		food = new Food(this, snake);
		interactions = new Interactions(this, snake, food);
		updateScore();
	}

	public void startGame() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(500);
				update();
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateScore() {
		label.setText("Score: " + interactions.getScore());
	}

	public void update() {
		snake.update();
		food.update();
		interactions.update();
		updateScore();
//		System.out.println(food.getX() + " " + food.getY() + " " + snake.getX() + ", " + snake.getY());
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		snake.draw(g);
		food.draw(g);
	}
}
