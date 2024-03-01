package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean up, down, left, right;

	private void setKeys(boolean up, boolean down, boolean left, boolean right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;

		down = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			setKeys(true, false, false, false);
		} else if (code == KeyEvent.VK_S) {
			setKeys(false, true, false, false);
		} else if (code == KeyEvent.VK_A) {
			setKeys(false, false, true, false);
		} else if (code == KeyEvent.VK_D) {
			setKeys(false, false, false, true);
		}
	}
//test 
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
