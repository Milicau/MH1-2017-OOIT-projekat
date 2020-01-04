package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;
	//private boolean selected;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line (Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public Line(Point startPoint, Point endPoint, Color color) {
		this(startPoint, endPoint);
		setColor(color);
	}
	
	public String toString() {
		return startPoint + "==>" + endPoint;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line temp = (Line)obj;
			return startPoint.equals(temp.startPoint) && endPoint.equals(temp.endPoint);
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return (startPoint.distance(x, y) + endPoint.distance(x, y)) - length() < 2;
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	
	/*
	 * public boolean isSelected() { return selected; }
	 * 
	 * 
	 * public void setSelected(boolean selected) { this.selected = selected; }
	 */

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(findColor(getColor()));
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getX() - 2, startPoint.getY() - 2, 4, 4);
			g.drawRect(endPoint.getX() - 2, endPoint.getY() - 2, 4, 4);
		}
	}

	@Override
	public void moveBy(int ByX, int ByY) {
		// TODO Auto-generated method stub
		startPoint.moveBy(ByX, ByY);
		endPoint.moveBy(ByX, ByY);
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Line) {
			return (int)(this.length() - ((Line)o).length());
		}
		return 0;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
