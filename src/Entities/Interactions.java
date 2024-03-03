package Entities;

import java.util.ArrayList;

import main.GamePanel;

public class Interactions {
	ArrayList<String> positions;
	GamePanel panel;
	Snake head;
	Snake last;
	Food food;
	private int score = 0;
	String key;

	public Interactions(GamePanel panel, Snake snake, Food food) {
		positions = new ArrayList<>();
		this.panel = panel;
		this.head = snake;
		this.last = snake;
		this.food = food;
		key = getKey(head.getX(), head.getY());
		positions.add(key);
	}

	public ArrayList<String> getPositions() {
		return positions;
	}

	public String getKey(int x, int y) {
		return Integer.toString(x) + Integer.toString(y);
	}

	public void updatePositions() {
		positions.add(getKey(head.getX(), head.getY()));
		positions.remove(0);
	}

	public void update() {
		if (head.getX() == food.getX() && head.getY() == food.getY()) {
			while (positions.contains(getKey(food.getX(), food.getY()))) {	
				food.randomPosition();
			}

			Snake holder = new Snake(panel, head.getKey(), last, null);
			positions.add(getKey(holder.getX(), holder.getY()));
			last.setBehind(holder);
			last = holder;
			score++;
		}
	}

	public int getScore() {
		return score;
	}

	public boolean checkBoundaries(Entities entities, int x, int y) {
		return true;
	}
}
