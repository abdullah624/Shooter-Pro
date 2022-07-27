import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GamePlay extends JPanel implements ActionListener {
	
	private Brick br;
	
	private ImageIcon shooter1;	
	private int shooter1X = 200;
	private int shooter1Y = 530;	
	private boolean shooter1right = false;
	private boolean shooter1left = false;
	private boolean shooter1down = false;
	private boolean shooter1up = true;	

	
	private ImageIcon shooter2;	
	private int shooter2X = 400;
	private int shooter2Y = 530;	
	private boolean shooter2right = false;
	private boolean shooter2left = false;
	private boolean shooter2down = false;
	private boolean shooter2up = true;

	private boolean play = true;
	
	public GamePlay()
	{				
		br = new Brick();
	}
	
	public void paint(Graphics g)
	{    		
		// play background
		g.setColor(Color.black);
		g.fillRect(0, 0, 650, 600);
		
		// score panel background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(660, 0, 140, 600);
		
		// draw solid bricks
		br.drawSolids(this, g);
		
		// draw breakable bricks	
		br.draw(this, g);
		
		if(play) {
			// draw shooter 1
						if(shooter1up)
							shooter1=new ImageIcon("images/shooter1up.png");	
						else if(shooter1down)
							shooter1=new ImageIcon("images/shooter1down.png");
						else if(shooter1right)
							shooter1=new ImageIcon("images/shooter1right.png");
						else if(shooter1left)
							shooter1=new ImageIcon("images/shooter1left.png");
							
						shooter1.paintIcon(this, g, shooter1X, shooter1Y);
						
						// draw shooter 2
						if(shooter2up)
							shooter2=new ImageIcon("images/shooter2up.png");	
						else if(shooter2down)
							shooter2=new ImageIcon("images/shooter2down.png");
						else if(shooter2right)
							shooter2=new ImageIcon("images/shooter2right.png");
						else if(shooter2left)
							shooter2=new ImageIcon("images/shooter2left.png");
									
						shooter2.paintIcon(this, g, shooter2X, shooter2Y);
		}
		
		
	
		
		
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
