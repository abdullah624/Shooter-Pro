import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class InitialFrame extends JPanel implements ActionListener{
	
	private Timer timer;
	private int delay=8;
	private ImageIcon shooter1;
	private ImageIcon shooter2;
	
	
	public InitialFrame() {		
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
	}
	
	public void paint(Graphics g) {    		
		// play background
		g.setColor(Color.gray);
		g.fillRect(0, 0, 890, 630);
		
		
//		Draw shooter 1
		shooter1 = new ImageIcon("images/shooterl.png");
		shooter1.paintIcon(this, g, 260, 100);
		
//		Draw shooter 2
		shooter2 = new ImageIcon("images/shooterll.png");
		shooter2.paintIcon(this, g, 460, 105);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}


