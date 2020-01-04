package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class FillShape extends Shape{
	private Color colorInterior = Color.WHITE;
	
	public FillShape() {
		
	}
	
	public FillShape(Color colorInterior) {
		this.colorInterior = colorInterior;
	}
	
	public abstract double area();
	public abstract double volume();
	public abstract void fills(Graphics g);

	public Color getColorInterior() {
		return colorInterior;
	}

	public void setColorInterior(Color colorInterior) {
		this.colorInterior = colorInterior;
	}
	
}
