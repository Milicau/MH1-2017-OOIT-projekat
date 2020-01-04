package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	private int x;
	private int y;
	//private boolean selected;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x, y);
		this.selected = selected;
	}
	
	public Point(int x, int y, Color color) {
		this(x, y);
		setColor(color);
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point temp = (Point)obj;
			if(this.x == temp.x && this.y == temp.y) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}
	
	public double distance(int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	
	
	public int getX() {
		return x;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	
	public int getY() {
		return y;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(findColor(getColor()));
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(x - 2, y - 2, 4, 4);
		}
	}

	@Override
	public void moveBy(int ByX, int ByY) {
		// TODO Auto-generated method stub
		this.x = x + ByX;
		this.y = y + ByY;
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Point) {
			return (int)(this.distance(0, 0) - ((Point)o).distance(0, 0));
		}
		return 0;
	}
	
	
	/*
	 * public boolean isSelected() { return selected; }
	 * 
	 * 
	 * public void setSelected(boolean selected) { this.selected = selected; }
	 */

}
