import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		GamePlay gamePlay = new GamePlay();
		TIMERGAME timergame = new TIMERGAME();
//		JButton button=new JButton("restart");

		
		obj.setBounds(10, 10, 800, 630);
		obj.setTitle("Shooter Pro");	
		obj.setBackground(Color.gray);
		obj.setResizable(false);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
		
//		gamePlay.setBounds(50,100,95,30);  
//		button.setLocation(270, 250);
//		obj.add(button);
//		obj.add(timergame);
		
		obj.setVisible(true);

	}
}
