package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Drawing extends JPanel{
	public Drawing() {
		/*
		 * addMouseMotionListener(new MouseMotionAdapter() { public void
		 * mouseMoved(MouseEvent tooltipKoordinate) {
		 * ToolTipManager.sharedInstance().setInitialDelay(0); setToolTipText("(" +
		 * tooltipKoordinate.getX() + "," + tooltipKoordinate.getY() + ")"); } });
		 */
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point point = new Point(e.getX(), e.getY());
				shapes.add(point);
				repaint();
			}
		});
	}
	
	ArrayList<Shape> shapes = new ArrayList<Shape>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}
	
	public void paint(Graphics g) {
		
		/*
		 * Point p1 = new Point(50, 50); p1.draw(g); Line l1 = new Line(new Point(20,
		 * 50), new Point (30, 40)); l1.setSelected(true); g.setColor(Color.pink);
		 * l1.draw(g); Rectangle r1 = new Rectangle(p1, 50, 80); r1.setSelected(true);
		 * r1.draw(g); Circle c1 = new Circle(p1, 5); c1.draw(g); g.setColor(Color.RED);
		 * Donut d1 = new Donut(p1, 50, 20); d1.setSelected(true); d1.draw(g); Circle c
		 * = new Circle(p1, 100); c.draw(g);
		 */
		 
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			Shape temp = it.next();
			temp.draw(g);
		}
	}

}
