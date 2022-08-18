import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		JFrame frame1 = new JFrame();
		JFrame frame2 = new JFrame();
		InitialFrame initFrame = new InitialFrame();
		Level1 level1 = new Level1();
		GamePlay gamePlay = new GamePlay();
		TimerGame timerGame = new TimerGame();
		
		String[] optionsToChoose = {" Level 1", " Level 2", " Level 3"};
		JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(370, 320, 160, 45);
        jComboBox.setFont(new Font("Arial", Font.BOLD, 35));

        JButton jButton = new JButton("Play");
        jButton.setBounds(390, 410, 120, 45);
        jButton.setFont(new Font("Arial", Font.BOLD, 35));

        frame1.add(jButton);
        frame1.add(jComboBox);
        

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLevel = jComboBox.getItemAt(jComboBox.getSelectedIndex());
                if(selectedLevel == " Level 1") {
                	frame1.dispose();
                	frame2.setBounds(10, 10, 900, 630);
            		frame2.setTitle("Shooter Pro ");	
            		frame2.setBackground(Color.gray);
            		frame2.setResizable(false);
            		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	frame2.add(level1);
                	frame2.setVisible(true);
                } else if(selectedLevel == " Level 2") {
                	frame1.dispose();
                	frame2.setBounds(10, 10, 900, 630);
            		frame2.setTitle("Shooter Pro ");	
            		frame2.setBackground(Color.gray);
            		frame2.setResizable(false);
            		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	frame2.add(gamePlay);
                	frame2.setVisible(true);
                } else {
                	frame1.dispose();
                	frame2.setBounds(10, 10, 900, 630);
            		frame2.setTitle("Shooter Pro ");	
            		frame2.setBackground(Color.gray);
            		frame2.setResizable(false);
            		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                	frame2.add(timerGame);
                	frame2.setVisible(true);
                }
            }
        });


		
		frame1.setBounds(10, 10, 900, 630);
		frame1.setTitle("Shooter Pro ");	
		frame1.setBackground(Color.gray);
		frame1.setResizable(false);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(initFrame);
		frame1.setVisible(true);

	}
}
