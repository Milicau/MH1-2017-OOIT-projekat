package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends FillShape implements Moveable, Comparable{
	protected Point center;
	protected int r;
	//protected boolean selected;
	
	public Circle() {
		
	}
	
	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	public Circle(Point center, int r, boolean selected) {
		this(center, r);
		this.selected = selected;
	}
	
	public Circle(Point center, int r, Color color) {
		this(center, r);
		setColor(color);
	}
	
	public String toString() {
		return "Center: " + center + ", radius: " + r;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle)obj;
			return center.equals(temp.center) && this.r == temp.r;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= r;
	}
	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	public double area() {
		return r * r * Math.PI;
	}
	
	public double volume() {
		return 2 * r * Math.PI;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public int getR() {
		return r;
	}
	
	public void setR(int r) {
		this.r = r;
	}
	
	/*
	 * public boolean isSelected() { return selected; }
	 * 
	 * public void setSelected(boolean selected) { this.selected = selected; }
	 */

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(findColor(getColor()));
		g.drawOval(center.getX() - r, center.getY() - r, 2 * r, r + r);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - r - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + r - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX(), center.getY() - r - 2, 4, 4);
			g.drawRect(center.getX(), center.getY() + r - 2, 4, 4);
		}
	}

	
	public void fills(Graphics g) {
		g.setColor(findColor(getColorInterior()));
		g.fillOval(center.getX() - r, center.getY() - r, 2 * r, 2 * r - 2);
	}
	
	@Override
	public void moveBy(int ByX, int ByY) {
		// TODO Auto-generated method stub
		center.moveBy(ByX, ByY);
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		center.moveTo(x, y);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Circle) {
			return (int)(this.area() - ((Circle)o).area());
		}
		return 0;
	}
	
}
