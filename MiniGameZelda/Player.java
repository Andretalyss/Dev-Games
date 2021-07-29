package MiniGameZelda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle{
	
	public boolean up, down, rigth, left;
	public int spd = 4;
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		if(rigth) {
			x+=spd;
			
		}
		else if(left) {
			x-=spd;
		}
		
		if(up) {
			y-=spd;
			
		}
		else if(down) {
			y+=spd;
		}
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
		
	}
}
