import java.awt.*;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame obj=new JFrame();
		GamePlay gamePlay = new GamePlay();
		
		obj.setBounds(10, 10, 800, 630);
		obj.setTitle("Shooter Pro");	
		obj.setBackground(Color.gray);
		obj.setResizable(false);
		
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
		obj.setVisible(true);

	}
}
