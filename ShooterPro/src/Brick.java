
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Brick {
	int bricksXPos[] = {50,350,450,550,50,300,350,450,550,150,150,450,550,
						250,50,100,150,550,250,350,450,550,50,250,350,550,
						50,150,250,300,350,550,50,150,250,350,450,550,50,
						250,350,550};
	
	int bricksYPos[] = {50,50,50,50,100,100,100,100,100,150,200,200,200,250,
						300,300,300,300,350,350,350,350,400,400,400,400,450,
						450,450,450,450,450,500,500,500,500,500,500,550,550,
						550,550};
	
	int solidBricksXPos[] = {150,350,150,500,450,300,600,400,350,200,0,200,500};
	
	int solidBricksYPos[] = {0,0,50,100,150,200,200,250,300,350,400,400,450};
	
	int brickON[] = new int[42];
	
	private ImageIcon breakBrickImage;
	private ImageIcon solidBrickImage;
	
	public Brick()
	{
		breakBrickImage=new ImageIcon("images/break_brick.jpg");
		solidBrickImage=new ImageIcon("images/solid_brick.jpg");	
		
		for(int i=0; i< brickON.length;i++)
		{
			brickON[i] = 1;
		}
	}
	
	public void draw(Component c, Graphics g)
	{
		for(int i=0; i< brickON.length;i++)
		{
			if(brickON[i]==1)
			{
				breakBrickImage.paintIcon(c, g, bricksXPos[i],bricksYPos[i]);
			}
		}
	}
	
	public void drawSolids(Component c, Graphics g)
	{
		for(int i=0; i< solidBricksXPos.length;i++)
		{			
			solidBrickImage.paintIcon(c, g, solidBricksXPos[i],solidBricksYPos[i]);
		}
	}
	
	
}
