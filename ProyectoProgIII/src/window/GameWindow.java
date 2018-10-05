package window;

import java.awt.*;

import javax.swing.*;

public class GameWindow extends JFrame{
	
	public GameWindow() {
		
		Container cp = this.getContentPane();
		cp.setLayout(null);
		Enemy enem = new Enemy();
		enem.setLocation(0, 300);
		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		cp.setBackground(Color.gray);
		
	}
	
	public static void main(String[] args) {
		
		GameWindow v = new GameWindow();
		
	}
	
	

}
