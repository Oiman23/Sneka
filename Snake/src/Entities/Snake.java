package Entities;

import java.awt.Color;
import java.awt.Graphics;

import main.GamePanel;
import main.KeyHandler;

public class Snake {
	GamePanel panel;
	KeyHandler key;
	int x;
	int y;
	int speed;

	public Snake(GamePanel panel, KeyHandler key) {
		this.panel = panel;
		this.key = key;
		this.x = panel.size;
		this.y = panel.size;
		this.speed = panel.size;
	}

	public void update() {
		if (key != null) {
			if (key.up == true) {
				if (y > 0) {
					y -= speed;
				}
			} else if (key.down == true) {
				if (y < panel.tileSize - panel.size) {
					y += speed;
				}
			} else if (key.left == true) {
				if (x > 0) {
					x -= speed;
				}
			} else if (key.right == true) {
				if (x < panel.tileSize - panel.size) {
					x += speed;
				}
			}
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, panel.size, panel.size);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
