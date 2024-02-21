package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import main.GamePanel;

public class Food {
	GamePanel panel;
	Snake snake;
	Random rand = new Random();
	int x, y; // x,y is absolute x,y position in the game
	int randomX, randomY; // randomX is the x,y coord of the grid it is in

	public Food(GamePanel panel, Snake snake) {
		this.panel = panel;
		this.snake = snake;

		randomPosition();
	}

	public void randomPosition() {
		randomX = rand.nextInt(panel.cols) * panel.size;
		randomY = rand.nextInt(panel.rows) * panel.size;
		x = randomX + (panel.size) / 4;
		y = randomY + (panel.size) / 4;
	}

	public void update() {
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, panel.size / 2, panel.size / 2);
	}

	public int getX() {
		return randomX;
	}

	public int getY() {
		return randomY;
	}
}
