import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class TimerGame extends JPanel implements ActionListener {
	private JFrame obj2 = new JFrame();
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
	
	private boolean levelindicator=false;
	
	private Timer timer;
	private int delay=8;
	private int finish=00;
	
	private Shooter1Listener shooter1Listener;
	private Shooter2Listener shooter2Listener;
	private mouseListener  mouseListener;
	
	private Shooter1Bullet shooter1Bullet = null;
	private Shooter2Bullet shooter2Bullet = null;

	private boolean play = true;
	
	
	
	
	public TimerGame() {		
		br = new Brick();
		shooter1Listener = new Shooter1Listener();
		shooter2Listener = new Shooter2Listener();
		mouseListener= new mouseListener();
        setFocusable(true);
        
        addKeyListener(shooter1Listener);
        addKeyListener(shooter2Listener);
        addMouseListener(mouseListener);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
	}
	
	public void paint(Graphics g) {    		
		// play background
		g.setColor(Color.black);
		g.fillRect(0, 0, 650, 600);
		
		// score panel background
		g.setColor(Color.DARK_GRAY);
		g.fillRect(660, 0, 440, 900);
		
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
			
			
			finish++;
			if(finish>1950)
				{
				if(shooter1lives>shooter2lives)
					shooter2lives=0;
				else
					shooter1lives=0;
				}
			
			// Shooter 1 shooting and scoring
			if(shooter1Bullet != null && shooter1Shoot) {
				if(bulletShootDir1.equals("")) {
					if(shooter1up) {					
						bulletShootDir1 = "up";
					}
					else if(shooter1down) {					
						bulletShootDir1 = "down";
					}
					else if(shooter1right) {				
						bulletShootDir1 = "right";
					}
					else if(shooter1left) {			
						bulletShootDir1 = "left";
					}
				}
				else {
					shooter1Bullet.move(bulletShootDir1);
					shooter1Bullet.drawBullet(g);
				}
				
				
				if(new Rectangle(shooter1Bullet.getXPos(), shooter1Bullet.getYPos(), 10, 10).intersects(new Rectangle(shooter2X, shooter2Y, 50, 50))) {
					shooter1score += 10;
					shooter2lives -= 1;
					shooter1Bullet = null;
					shooter1Shoot = false;
					bulletShootDir1 = "";
				}
				
				if(br.checkSolidCollision(shooter1Bullet.getXPos(), shooter1Bullet.getYPos())) {

					if(shooter1up) {					
						bulletShootDir1 = "down";
					}
					else if(shooter1down) {					
						bulletShootDir1 = "up";
					}
					else if(shooter1right) {				
						bulletShootDir1 = "left";
					}
					else if(shooter1left) {			
						bulletShootDir1 = "right";
					}

					
				}
				else if(br.checkBreakCollision(shooter1Bullet.getXPos(), shooter1Bullet.getYPos())) {
					shooter1score += 5;
					shooter1Bullet = null;
					shooter1Shoot = false;
					bulletShootDir1 = "";
				}
	
				if(shooter1Bullet.getYPos() < 1 || shooter1Bullet.getYPos() > 580 || shooter1Bullet.getXPos() < 1 || shooter1Bullet.getXPos() > 630) {
					shooter1Bullet = null;
					shooter1Shoot = false;
					bulletShootDir1 = "";
				}
			}
			
			// Shooter 2 shooting and scoring
			if(shooter2Bullet != null && shooter2Shoot){
				if(bulletShootDir2.equals("")) {
					if(shooter2up) {					
						bulletShootDir2 = "up";
					}
					else if(shooter2down) {					
						bulletShootDir2 = "down";
					}
					else if(shooter2right) {				
						bulletShootDir2 = "right";
					}
					else if(shooter2left) {			
						bulletShootDir2 = "left";
					}
				}
				else {
					shooter2Bullet.move(bulletShootDir2);
					shooter2Bullet.drawBullet(g);
				}
				
				
				if(new Rectangle(shooter2Bullet.getXPos(), shooter2Bullet.getYPos(), 10, 10).intersects(new Rectangle(shooter1X, shooter1Y, 50, 50))) {
					shooter2score += 10;
					shooter1lives -= 1;
					shooter2Bullet = null;
					shooter2Shoot = false;
					bulletShootDir2 = "";
				}
				
				if(br.checkSolidCollision(shooter2Bullet.getXPos(), shooter2Bullet.getYPos())) {
			
					if(shooter2up) {					
						bulletShootDir2 = "down";
					}
					else if(shooter2down) {					
						bulletShootDir2 = "up";
					}
					else if(shooter2right) {				
						bulletShootDir2 = "left";
					}
					else if(shooter2left) {			
						bulletShootDir2 = "right";
					}
				

				
				}
				else if(br.checkBreakCollision(shooter2Bullet.getXPos(), shooter2Bullet.getYPos())) {
					shooter2score += 5;
					shooter2Bullet = null;
					shooter2Shoot = false;
					bulletShootDir2 = "";
				}
				
				if(shooter2Bullet.getYPos() < 1 || shooter2Bullet.getYPos() > 580 || shooter2Bullet.getXPos() < 1 || shooter2Bullet.getXPos() > 630) {
					shooter2Bullet = null;
					shooter2Shoot = false;
					bulletShootDir2 = "";
				}
			}
		}
		//end of play
		
//	}
		if(levelindicator) {
			play=false;
			levelindicator=false;
			play=true;g.dispose();
			
		}
		
		// Score Panel 		
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD, 20));
		g.drawString("Player 1", 670,30);
		g.drawString("Player 2", 670,150);
		
		g.setFont(new Font("serif",Font.BOLD, 15));
		g.drawString("Score:  "+shooter1score, 675,60);
		g.drawString("Lives:  "+shooter1lives, 675,90);	
		g.drawString("Score:  "+shooter2score, 675,180);
		g.drawString("Lives:  "+shooter2lives, 675,210);
		g.drawString("Remaining time:  "+(32-finish/60), 670,250);

		
		g.setColor(Color.GRAY);
		g.drawRect(680, 320, 50, 30);
		g.fillRect(680,320, 50,30);
		g.setColor(Color.white);
		g.drawString("level1 ", 685,340);
        
		if(shooter1lives == 0) {
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD, 60));
			g.drawString("Game Over", 200,300);
			g.drawString("Player 2 Won!", 180,380);
			play = false;
			g.setColor(Color.white);
			g.setFont(new Font("serif",Font.BOLD, 30));
			g.drawString("(Space to Restart)", 230,430);
		}
		else if(shooter2lives == 0) {
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
	
	private class Shooter1Listener implements KeyListener {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			
			// Reset score panel and restart the game
			if(e.getKeyCode()== KeyEvent.VK_SPACE && (shooter1lives == 0 || shooter2lives == 0)) {
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
				finish = 0;
				repaint();
			}
			
			// Shooter 1 shoots
			if(e.getKeyCode() == KeyEvent.VK_U) {
				if(!shooter1Shoot) {
					if(shooter1up) {					
						shooter1Bullet = new Shooter1Bullet(shooter1X + 20, shooter1Y);
					}
					else if(shooter1down) {					
						shooter1Bullet = new Shooter1Bullet(shooter1X + 20, shooter1Y + 40);
					}
					else if(shooter1right) {				
						shooter1Bullet = new Shooter1Bullet(shooter1X + 40, shooter1Y + 20);
					}
					else if(shooter1left) {			
						shooter1Bullet = new Shooter1Bullet(shooter1X, shooter1Y + 20);
					}
					
					shooter1Shoot = true;
				}
			}

			// Shooter 1 navigation
			if(e.getKeyCode() == KeyEvent.VK_W) {
				if(br.checkWall(shooter1X, shooter1Y, "up")) {
					shooter1right = false;
					shooter1left = false;
					shooter1down = false; 
					shooter1up = true;
				} else{
					shooter1right = false;
					shooter1left = false;
					shooter1down = false; 
					shooter1up = true;		
					
					if(!(shooter1Y < 10))
						shooter1Y-=10;
				}
			}
			
			if(e.getKeyCode()== KeyEvent.VK_A) {
				if(br.checkWall(shooter1X, shooter1Y, "left")) {
					shooter1right = false;
					shooter1left = true;
					shooter1down = false;
					shooter1up = false;
				} else {
					shooter1right = false;
					shooter1left = true;
					shooter1down = false;
					shooter1up = false;
					
					if(!(shooter1X < 10))
						shooter1X-=10;
				}
			}
			
			if(e.getKeyCode()== KeyEvent.VK_S) {
				if(br.checkWall(shooter1X, shooter1Y, "down")) {
					shooter1right = false;
					shooter1left = false;
					shooter1down = true;
					shooter1up = false;
				} else {
					shooter1right = false;
					shooter1left = false;
					shooter1down = true;
					shooter1up = false;
					
					if(!(shooter1Y > 540))
						shooter1Y+=10;
				}
			}
			
			if(e.getKeyCode()== KeyEvent.VK_D) {
				if(br.checkWall(shooter1X, shooter1Y, "right")) {
					shooter1right = true;
					shooter1left = false;
					shooter1down = false;
					shooter1up = false;
				} else {
					shooter1right = true;
					shooter1left = false;
					shooter1down = false;
					shooter1up = false;
					
					if(!(shooter1X > 590))
						shooter1X+=10;
				}
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
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				if(br.checkWall(shooter2X, shooter2Y, "up")) {
					shooter2right = false;
					shooter2left = false;
					shooter2down = false; 
					shooter2up = true;
				} else{
					shooter2right = false;
					shooter2left = false;
					shooter2down = false; 
					shooter2up = true;		
					
					if(!(shooter2Y < 10))
						shooter2Y-=10;
				}
			}
			
			if(e.getKeyCode()== KeyEvent.VK_LEFT) {
				if(br.checkWall(shooter2X, shooter2Y, "left")) {
					shooter2right = false;
					shooter2left = true;
					shooter2down = false;
					shooter2up = false;
				} else {
					shooter2right = false;
					shooter2left = true;
					shooter2down = false;
					shooter2up = false;
					
					if(!(shooter2X < 10))
						shooter2X-=10;
				}
			}
			
			if(e.getKeyCode()== KeyEvent.VK_DOWN) {
				if(br.checkWall(shooter2X, shooter2Y, "down")) {
					shooter2right = false;
					shooter2left = false;
					shooter2down = true;
					shooter2up = false;
				} else {
					shooter2right = false;
					shooter2left = false;
					shooter2down = true;
					shooter2up = false;
					
					if(!(shooter2Y > 540))
						shooter2Y+=10;
				}
			}
			
			if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
				if(br.checkWall(shooter2X, shooter2Y, "right")) {
					shooter2right = true;
					shooter2left = false;
					shooter2down = false;
					shooter2up = false;
				} else {
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
	public class mouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
			if((e.getX()>680&&e.getX()<725)&&(e.getY()>320&&e.getY()<350)) {
				System.out.println(e.getX()+"im  x");
//				JFrame obj2 = new JFrame();
				GamePlay gp =new GamePlay();
				obj2.setBounds(10, 10, 900, 630);
				obj2.setTitle("Shooter Pro ");	
				obj2.setBackground(Color.gray);
				obj2.setResizable(false);
				obj2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj2.add(gp);
				levelindicator=true;
				obj2.setVisible(true);
				
			}
				
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	

}
