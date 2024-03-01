package Entities;

import main.GamePanel;

public class Interactions {
	GamePanel panel;
	Snake head;
	Snake last;
	Food food;
	private int score = 0;

	public Interactions(GamePanel panel, Snake snake, Food food) {
		this.panel = panel;
		this.head = snake;
		this.last = snake;
		this.food = food;
	}

	public void update() {
		if (head.getX() == food.getX() && head.getY() == food.getY()) {
			food.randomPosition();
			Snake holder = new Snake(panel, head.getKey(), last, null);
			last.setBehind(holder);
			last = holder;
			score++;
		}
	}

	public int getScore() {
		return score;
	}
}
