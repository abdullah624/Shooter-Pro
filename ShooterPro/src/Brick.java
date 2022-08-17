
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Brick {
	int solidBricksXPos[] = {50,350,450,550,50,300,350,450,550,150,150,450,550,
						250,50,100,150,550,250,350,450,550,50,250,350,550,
						50,150,250,300,350,550,50,150,250,350,450,550,50,
						250,350,550};
	
	int solidBricksYPos[] = {50,50,50,50,100,100,100,100,100,150,200,200,200,250,
						300,300,300,300,350,350,350,350,400,400,400,400,450,
						450,450,450,450,450,500,500,500,500,500,500,550,550,
						550,550};
	
	int bricksXPos[] = {150,350,150,500,450,300,600,400,350,200,0,200,500};
	
	int bricksYPos[] = {0,0,50,100,150,200,200,250,300,350,400,400,450};
	
	int brickON[] = new int[13];
	
	private ImageIcon solidBrickImage;
	private ImageIcon breakBrickImage;
	
	public Brick() {
		solidBrickImage=new ImageIcon("images/solid_brick.jpg");	
		breakBrickImage=new ImageIcon("images/break_brick.jpg");
		
		for(int i=0; i< brickON.length; i++) {
			brickON[i] = 1;
		}
	}
	
	public void drawSolidBricks(Component c, Graphics g) {
		int solidBricksCount = solidBricksXPos.length;
		for(int i=0; i< solidBricksCount; i++) {
				solidBrickImage.paintIcon(c, g, solidBricksXPos[i], solidBricksYPos[i]);
		}
	}
	
	public void drawBreakBricks(Component c, Graphics g) {
		int breakBricksCouint = bricksXPos.length;
		for(int i=0; i< breakBricksCouint; i++) {
			if(brickON[i]==1) {			
				breakBrickImage.paintIcon(c, g, bricksXPos[i], bricksYPos[i]);
			}
		}
	}
	
//	Check bullet collision
	public boolean checkSolidCollision(int x, int y) {
		boolean collided = false;
		int solidBricksCount = solidBricksXPos.length;
		for(int i=0; i< solidBricksCount; i++) {
			if(new Rectangle(x, y, 10, 10).intersects(new Rectangle(solidBricksXPos[i], solidBricksYPos[i], 50, 50))) {
				
				collided = true;
				break;
			}
		}
		return collided;
	}
	
	public boolean checkBreakCollision(int x, int y) {
		boolean collided = false;
		int breakBricksCouint = brickON.length;
		for(int i=0; i< breakBricksCouint;i++) {		
			if(brickON[i]==1) {
				if(new Rectangle(x, y, 10, 10).intersects(new Rectangle(bricksXPos[i], bricksYPos[i], 50, 50))) {		
					brickON[i] = 0;
					collided = true;
					break;
				}
			}
		}
		
		return collided;
	}
	
//	Check if wall is just front of the player
	public boolean checkWall(int x, int y, String dir) {
		boolean collided = false;
		int solidBricksCount = solidBricksXPos.length;
		int breakBricksCouint = brickON.length;
		if(dir == "up") {
			for(int i=0; i< solidBricksCount; i++) {
				if(Math.abs(solidBricksXPos[i]-x) <=40 && y-solidBricksYPos[i]==50) {
					collided = true;
					return collided;
				}
			}
			
			for(int i=0; i< breakBricksCouint; i++) {
				if(brickON[i] == 1 && Math.abs(bricksXPos[i]-x) <= 40 && y-bricksYPos[i]== 50) {
					collided = true;
					return collided;
				}
			}
		} else if(dir == "down") {
			for(int i=0; i< solidBricksCount; i++) {
				if(Math.abs(solidBricksXPos[i]-x) <= 40 && solidBricksYPos[i]-y==50) {
					collided = true;
					return collided;
				}
			}
			
			for(int i=0; i< breakBricksCouint; i++) {
				if(brickON[i] == 1 && Math.abs(bricksXPos[i]-x) <= 40 && bricksYPos[i]-y== 50) {
					collided = true;
					return collided;
				}
			}
		} else if(dir == "left") {
			for(int i=0; i< solidBricksCount; i++) {
				if(x-solidBricksXPos[i]==50 &&  Math.abs(solidBricksYPos[i]-y) <= 40) {
					collided = true;
					return collided;
				}
			}
			
			for(int i=0; i< breakBricksCouint; i++) {
				if(brickON[i] == 1 && x-bricksXPos[i]==50 && Math.abs(bricksYPos[i]-y) <= 40) {
					collided = true;
					return collided;
				}
			}
		} else if(dir == "right") {
			for(int i=0; i< solidBricksCount; i++) {
				if(solidBricksXPos[i]-x==50 &&  Math.abs(solidBricksYPos[i]-y) <= 40) {
					collided = true;
					return collided;
				}
			}
			
			for(int i=0; i< breakBricksCouint; i++) {
				if(brickON[i] == 1 && bricksXPos[i]-x==50 && Math.abs(bricksYPos[i]-y) <= 40) {
					collided = true;
					return collided;
				}
			}
		}
	
		return collided;
	}
	
}
