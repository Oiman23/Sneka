package Entities;

import main.GamePanel;

public class Entities {
	GamePanel panel;
	protected int x;
	protected int y;

	public Entities(GamePanel panel) {
		this.panel = panel;
	}

	public Entities(GamePanel panel, int x, int y) {
		this.panel = panel;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
