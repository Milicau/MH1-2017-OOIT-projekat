package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	private int innerR;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int r, int innerR) {
		super(center,r);
		this.innerR = innerR;
	}
	
	public Donut(Point center, int r, int innerR, boolean selected) {
		this(center, r, innerR);
		this.selected = selected;
	}
	
	public Donut(Point center, int r, int innerR, Color color) {
		this(center, r, innerR);
		setColor(color);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", inner radius: " + innerR;
	}
	
	

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return super.contains(x, y) && center.distance(x, y) >= innerR;
	}



	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return this.contains(p.getX(), p.getY());
	}



	@Override
	public double area() {
		// TODO Auto-generated method stub
		return super.area() - 2 * innerR * Math.PI;
	}

	public int getInnerR() {
		return innerR;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g);
		g.setColor(findColor(getColor()));
		g.drawOval(center.getX() - innerR, center.getY() -  innerR, 2 * innerR, 2 * innerR);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - innerR - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - innerR - 2, 4, 4);
			g.drawRect(center.getX() + innerR - 2, center.getY(), 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + innerR, 4, 4);
		}
	}

	@Override
	public void fills(Graphics g) {
		// TODO Auto-generated method stub
		//super.fills(g);
		g.setColor(findColor(getColorInterior()));
		g.fillOval(center.getX() - r, center.getY() - r, 2 * r, 2 * r - 2);
		g.setColor(Color.WHITE);
		g.fillOval(center.getX() - innerR, center.getY() - innerR, 2 * innerR, 2 * innerR);//??
	}

	/*
	 * @Override public Color findColor(Color color) { // TODO Auto-generated method
	 * stub return super.findColor(color); }
	 */
	
	
	
	
	

}
