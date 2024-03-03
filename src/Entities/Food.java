package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import main.GamePanel;

public class Food extends Entities {
	GamePanel panel;
	Snake snake;
	Random rand = new Random();
	int drawX, drawY; // randomX is the x,y coord of the grid it is in

	public Food(GamePanel panel, Snake snake) {
		super(panel);
		this.panel = panel;
		this.snake = snake;

		randomPosition();
	}

//send request if the randomX/Y is inside the snake in interactions, if it is keep looking for a new position
	public void randomPosition() {
//		randomX = rand.nextInt(panel.cols) * panel.size;
//		randomY = rand.nextInt(panel.rows) * panel.size;
		x = rand.nextInt(16) * panel.size;
		y = rand.nextInt(16) * panel.size;
		drawX = x + (panel.size) / 4;
		drawY = y + (panel.size) / 4;
	}

	public void update() {

	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(drawX, drawY, panel.size / 2, panel.size / 2);
	}

}
