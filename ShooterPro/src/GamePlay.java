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
	private int shooter1score = 0;
	private int shooter1lives = 10;
	private boolean shooter1Shoot = false;
	private String bulletShootDir1 = "";
	
	
	private ImageIcon shooter2;	
	private int shooter2X = 400;
	private int shooter2Y = 530;	
	private boolean shooter2right = false;
	private boolean shooter2left = false;
	private boolean shooter2down = false;
	private boolean shooter2up = true;
	private int shooter2score = 0;
	private int shooter2lives = 10;
	private boolean shooter2Shoot = false;
	private String bulletShootDir2 = "";
	
	
	private Timer timer;
	private int delay=8;
	
	
	private Shooter1Listener shooter1Listener;
	private Shooter2Listener shooter2Listener;
	
	private Shooter1Bullet shooter1Bullet = null;
	private Shooter2Bullet shooter2Bullet = null;

	private boolean play = true;
	
	public GamePlay()
	{				
		br = new Brick();
		shooter1Listener = new Shooter1Listener();
		shooter2Listener = new Shooter2Listener();
        setFocusable(true);
        //addKeyListener(this);
        addKeyListener(shooter1Listener);
        addKeyListener(shooter2Listener);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
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
		br.drawSolidBricks(this, g);
		
		// draw breakable bricks	
		br.drawBreakBricks(this, g);
		
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
			
			// Shooter 1 shooting and scoring
			if(shooter1Bullet != null && shooter1Shoot)
			{
				if(bulletShootDir1.equals(""))
				{
					if(shooter1up)
					{					
						bulletShootDir1 = "up";
					}
					else if(shooter1down)
					{					
						bulletShootDir1 = "down";
					}
					else if(shooter1right)
					{				
						bulletShootDir1 = "right";
					}
					else if(shooter1left)
					{			
						bulletShootDir1 = "left";
					}
				}
				else
				{
					shooter1Bullet.move(bulletShootDir1);
					shooter1Bullet.drawBullet(g);
				}
				
				
				if(new Rectangle(shooter1Bullet.getXPos(), shooter1Bullet.getYPos(), 10, 10)
				.intersects(new Rectangle(shooter2X, shooter2Y, 50, 50)))
				{
					shooter1score += 10;
					shooter2lives -= 1;
					shooter1Bullet = null;
					shooter1Shoot = false;
					bulletShootDir1 = "";
				}
				
				if(br.checkSolidCollision(shooter1Bullet.getXPos(), shooter1Bullet.getYPos()))
				{
					shooter1Bullet = null;
					shooter1Shoot = false;
					bulletShootDir1 = "";				
				}
				else if(br.checkBreakCollision(shooter1Bullet.getXPos(), shooter1Bullet.getYPos())) {
					shooter1score += 5;
					shooter1Bullet = null;
					shooter1Shoot = false;
					bulletShootDir1 = "";
				}
	
				if(shooter1Bullet.getYPos() < 1 
						|| shooter1Bullet.getYPos() > 580
						|| shooter1Bullet.getXPos() < 1
						|| shooter1Bullet.getXPos() > 630)
				{
					shooter1Bullet = null;
					shooter1Shoot = false;
					bulletShootDir1 = "";
				}
			}
			
			// Shooter 2 shooting and scoring
			if(shooter2Bullet != null && shooter2Shoot)
			{
				if(bulletShootDir2.equals(""))
				{
					if(shooter2up)
					{					
						bulletShootDir2 = "up";
					}
					else if(shooter2down)
					{					
						bulletShootDir2 = "down";
					}
					else if(shooter2right)
					{				
						bulletShootDir2 = "right";
					}
					else if(shooter2left)
					{			
						bulletShootDir2 = "left";
					}
				}
				else
				{
					shooter2Bullet.move(bulletShootDir2);
					shooter2Bullet.drawBullet(g);
				}
				
				
				if(new Rectangle(shooter2Bullet.getXPos(), shooter2Bullet.getYPos(), 10, 10)
				.intersects(new Rectangle(shooter1X, shooter1Y, 50, 50)))
				{
					shooter2score += 10;
					shooter1lives -= 1;
					shooter2Bullet = null;
					shooter2Shoot = false;
					bulletShootDir2 = "";
				}
				
				if(br.checkSolidCollision(shooter2Bullet.getXPos(), shooter2Bullet.getYPos()))
				{
					shooter2Bullet = null;
					shooter2Shoot = false;
					bulletShootDir2 = "";				
				}
				else if(br.checkBreakCollision(shooter2Bullet.getXPos(), shooter2Bullet.getYPos())) {
					shooter2score += 5;
					shooter2Bullet = null;
					shooter2Shoot = false;
					bulletShootDir2 = "";
				}
				
				if(shooter2Bullet.getYPos() < 1 
						|| shooter2Bullet.getYPos() > 580
						|| shooter2Bullet.getXPos() < 1
						|| shooter2Bullet.getXPos() > 630)
				{
					shooter2Bullet = null;
					shooter2Shoot = false;
					bulletShootDir2 = "";
				}
			}
		}
		
		
		
		// Score Panel 		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 15));
		g.drawString("Scores", 700,30);
		g.drawString("Player 1:  "+shooter1score, 670,60);
		g.drawString("Player 2:  "+shooter2score, 670,90);
		
		g.drawString("Lives", 700,150);
		g.drawString("Player 1:  "+shooter1lives, 670,180);
		g.drawString("Player 2:  "+shooter2lives, 670,210);
		
		if(shooter1lives == 0)
		{
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD, 60));
			g.drawString("Game Over", 200,300);
			g.drawString("Player 2 Won!", 180,380);
			play = false;
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD, 30));
			g.drawString("(Space to Restart)", 230,430);
		}
		else if(shooter2lives == 0)
		{
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD, 60));
			g.drawString("Game Over", 200,300);
			g.drawString("Player 1 Won!", 180,380);
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD, 30));
			g.drawString("(Space to Restart)", 230,430);
			play = false;
		}
		
		
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		
		repaint();
		
	}
	
	private class Shooter1Listener implements KeyListener
	{
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}		
		public void keyPressed(KeyEvent e) {
			
			// Reset score panel and restart the game
			if(e.getKeyCode()== KeyEvent.VK_SPACE && (shooter1lives == 0 || shooter2lives == 0))
			{
				br = new Brick();
				shooter1X = 200;
				shooter1Y = 530;	
				shooter1right = false;
				shooter1left = false;
				shooter1down = false;
				shooter1up = true;
				
				shooter2X = 400;
				shooter2Y = 530;	
				shooter2right = false;
				shooter2left = false;
				shooter2down = false;
				shooter2up = true;	
				
				shooter1score = 0;
				shooter1lives = 10;
				shooter2score = 0;
				shooter2lives = 10;
				
				play = true;
				repaint();
			}
			
			// Shooter 1 shoots
			if(e.getKeyCode()== KeyEvent.VK_U)
			{
				if(!shooter1Shoot)
				{
					if(shooter1up)
					{					
						shooter1Bullet = new Shooter1Bullet(shooter1X + 20, shooter1Y);
					}
					else if(shooter1down)
					{					
						shooter1Bullet = new Shooter1Bullet(shooter1X + 20, shooter1Y + 40);
					}
					else if(shooter1right)
					{				
						shooter1Bullet = new Shooter1Bullet(shooter1X + 40, shooter1Y + 20);
					}
					else if(shooter1left)
					{			
						shooter1Bullet = new Shooter1Bullet(shooter1X, shooter1Y + 20);
					}
					
					shooter1Shoot = true;
				}
			}

			// Shooter 1 navigation
			if(e.getKeyCode()== KeyEvent.VK_W)
			{
				shooter1right = false;
				shooter1left = false;
				shooter1down = false; 
				shooter1up = true;		
				
				if(!(shooter1Y < 10))
					shooter1Y-=10;

			}
			if(e.getKeyCode()== KeyEvent.VK_A)
			{
				shooter1right = false;
				shooter1left = true;
				shooter1down = false;
				shooter1up = false;
				
				if(!(shooter1X < 10))
					shooter1X-=10;
			}
			if(e.getKeyCode()== KeyEvent.VK_S)
			{
				shooter1right = false;
				shooter1left = false;
				shooter1down = true;
				shooter1up = false;
				
				if(!(shooter1Y > 540))
					shooter1Y+=10;
			}
			if(e.getKeyCode()== KeyEvent.VK_D)
			{
				shooter1right = true;
				shooter1left = false;
				shooter1down = false;
				shooter1up = false;
				
				if(!(shooter1X > 590))
					shooter1X+=10;
			}
		}
	}
	
	private class Shooter2Listener implements KeyListener
	{
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}		
		public void keyPressed(KeyEvent e) {	
			
			// Shooter 2 shoots
			if(e.getKeyCode()== KeyEvent.VK_M)
			{
				if(!shooter2Shoot)
				{
					if(shooter2up)
					{					
						shooter2Bullet = new Shooter2Bullet(shooter2X + 20, shooter2Y);
					}
					else if(shooter2down)
					{					
						shooter2Bullet = new Shooter2Bullet(shooter2X + 20, shooter2Y + 40);
					}
					else if(shooter2right)
					{				
						shooter2Bullet = new Shooter2Bullet(shooter2X + 40, shooter2Y + 20);
					}
					else if(shooter2left)
					{			
						shooter2Bullet = new Shooter2Bullet(shooter2X, shooter2Y + 20);
					}
					
					shooter2Shoot = true;
				}
			}

			// Shooter 2 navigation
			if(e.getKeyCode()== KeyEvent.VK_UP)
			{
				shooter2right = false;
				shooter2left = false;
				shooter2down = false;
				shooter2up = true;		
				
				if(!(shooter2Y < 10))
					shooter2Y-=10;

			}
			if(e.getKeyCode()== KeyEvent.VK_LEFT)
			{
				shooter2right = false;
				shooter2left = true;
				shooter2down = false;
				shooter2up = false;
				
				if(!(shooter2X < 10))
					shooter2X-=10;
			}
			if(e.getKeyCode()== KeyEvent.VK_DOWN)
			{
				shooter2right = false;
				shooter2left = false;
				shooter2down = true;
				shooter2up = false;
				
				if(!(shooter2Y > 540))
					shooter2Y+=10;
			}
			if(e.getKeyCode()== KeyEvent.VK_RIGHT)
			{
				shooter2right = true;
				shooter2left = false;
				shooter2down = false;
				shooter2up = false;
				
				if(!(shooter2X > 590))
					shooter2X+=10;
			}
			
		}
	}

}
