package Entities;

import main.GamePanel;

public class Interactions {
	GamePanel panel;
	Snake snake;
	Food food;
	private int score = 0;

	public Interactions(GamePanel panel, Snake snake, Food food) {
		this.panel = panel;
		this.snake = snake;
		this.food = food;
	}

	public void update() {
		if (snake.getX() == food.getX() && snake.getY() == food.getY()) {
			food.randomPosition();
			score++;
		}
	}

	public int getScore() {
		return score;
	}
}
