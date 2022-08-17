import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		GamePlay gamePlay = new GamePlay();
		TIMERGAME timergame = new TIMERGAME();


		
		obj.setBounds(10, 10, 900, 630);
		obj.setTitle("Shooter Pro ");	
		obj.setBackground(Color.gray);
		obj.setResizable(false);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
;
		obj.setVisible(true);

	}
}
