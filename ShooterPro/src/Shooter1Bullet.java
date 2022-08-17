import java.awt.Graphics;
import java.awt.Color;

public class Shooter1Bullet {
	private double x, y;
	private int max=15,count;
	private boolean noshoot=false;
	
	public Shooter1Bullet(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void bulCount(int count) {
		this.count=count;
		if(max<=count)
		{
			noshoot =true;
		}
	}
	
	public void move(String dir) {
		if(noshoot==false) {
		if(dir.equals("right"))
			x += 5;
		else if(dir.equals("left"))
			x -= 5;
		else if(dir.equals("up"))
			y -= 5;
		else
			y +=5;
	}}
	
	public void drawBullet(Graphics g) {
		if(noshoot==false) {
		g.setColor(Color.yellow);
		g.fillOval((int) x, (int) y, 10, 10);
	}}
	
	public int getXPos() {
		return (int)x;
	}
	
	public int getYPos() {
		return (int)y;
	}

}
