import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class DeveloperInfo extends JPanel implements ActionListener{
	
	private Timer timer;
	private int delay=8;
	private ImageIcon shooter1;
	private ImageIcon shooter2;
	
	
	public DeveloperInfo() {		
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
	}
	
	public void paint(Graphics g) {    		
		// play background
		g.setColor(Color.gray);
		g.fillRect(0, 0, 890, 630);
		
		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.ITALIC, 50));
		g.drawString("...Shooter Pro...", 250, 100);
		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.ITALIC, 30));
		g.drawString("Developed by", 40, 230);
		g.drawString("........................", 30, 250);
		
		shooter1 = new ImageIcon("images/mokbul.png");
		shooter1.paintIcon(this, g, 40, 290);
		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 22));
		g.drawString("Mokbul Hossain", 205, 400);
		g.setFont(new Font("serif",Font.BOLD, 17));
		g.drawString("Reg. No: 2017831059", 205, 425);
		
		shooter2 = new ImageIcon("images/hasan.png");
		shooter2.paintIcon(this, g, 500, 287);
		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 22));
		g.drawString("Md Hasan Ali", 655, 400);
		g.setFont(new Font("serif",Font.BOLD, 17));
		g.drawString("Reg. No: 2017831048", 655, 425);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}



