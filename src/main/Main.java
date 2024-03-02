package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Snake Game");
		GamePanel panel = new GamePanel();
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		

	}
}
