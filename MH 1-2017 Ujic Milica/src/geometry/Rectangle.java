package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends FillShape implements Moveable,Comparable{
	private Point upperLeft;
	private int width;
	private int height;
	//private boolean selected;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeft, int width, int height, Color color) {
		this(upperLeft, width, height);
		setColor(color);
	}
	
	public String toString() {
		return "Upper left point: " + upperLeft + ", width: " + width + ", height: " + height;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp = (Rectangle)obj;
			return upperLeft.equals(temp.upperLeft) && this.width == temp.width && this.height == temp.height;
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return upperLeft.getX() < x && x < upperLeft.getX() + width && upperLeft.getY() < y && y < upperLeft.getY() + height;
	}
	
	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}
	
	public double area() {
		return width * height;
	}
	
	public double volume() {
		return 2 * width + 2 * height;
	}
	

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(findColor(getColor()));
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() - 2, 4, 4);
			g.drawRect(upperLeft.getX() + width - 2, upperLeft.getY() - 2, 4, 4);
			g.drawRect(upperLeft.getX() + width - 2, upperLeft.getY() + height - 2, 4, 4);
			g.drawRect(upperLeft.getX() - 2, upperLeft.getY() + height - 2, 4, 4);
			
		}
	}

	@Override
	public void moveBy(int ByX, int ByY) {
		// TODO Auto-generated method stub
		upperLeft.moveBy(ByX, ByY);
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		upperLeft.moveTo(x, y);
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Rectangle) {
			return (int)(this.area() - ((Rectangle)o).area());
		}
		return 0;
	}

	@Override
	public void fills(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(findColor(getColorInterior()));
		g.fillRect(upperLeft.getX() + 1, upperLeft.getY() + 1, width -1, height -1);
	}
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	
	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	/*
	 * public boolean isSelected() { return selected; }
	 * 
	 * public void setSelected(boolean selected) { this.selected = selected; }
	 */
	
}
