package Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import main.GamePanel;
import main.KeyHandler;

public class Snake {
	GamePanel panel;
	KeyHandler key;
	Snake front;
	Snake behind;
	int xP;
	int yP;
	int x;
	int y;
	int speed;

	public Snake(GamePanel panel, KeyHandler key, Snake front, Snake behind) {
		this.panel = panel;
		this.key = key;
		this.x = panel.size;
		this.y = panel.size;
		this.speed = panel.size;
		this.front = front;
		this.behind = behind;
	}

	public void update() {
		if (key != null) {
			yP = y;
			xP = x;
			if (front == null) {
				if (key.up == true) {
					if (y > 0) {
						y -= speed;
					}
				} else if (key.down == true) {
					if (y < panel.screenSize - panel.size) {
						y += speed;
					}
				} else if (key.left == true) {
					if (x > 0) {
						x -= speed;
					}
				} else if (key.right == true) {
					if (x < panel.screenSize - panel.size) {
						x += speed;
					}
				}
			} else {
				
				x = front.getXP();
				y = front.getYP();
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

	public int getXP() {
		return xP;
	}

	public int getYP() {
		return yP;
	}

	public Snake next() {
		return behind;
	}

	public KeyHandler getKey() {
		return key;
	}
	
	public void setBehind(Snake behind) {
		this.behind = behind;
	}
	
	public Snake getFront() {
		return front;
	}

}
