
import java.awt.Graphics;
import java.awt.Color;

public class Shooter2Bullet {
	private double x, y;
	
	public Shooter2Bullet(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void move(String dir) {
		if(dir.equals("right"))
			x += 5;
		else if(dir.equals("left"))
			x -= 5;
		else if(dir.equals("up"))
			y -= 5;
		else
			y +=5;
	}
	
	public void drawBullet(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval((int) x, (int) y, 10, 10);
	}
	
	public int getXPos() {
		return (int)x;
	}
	
	public int getYPos() {
		return (int)y;
	}

}

