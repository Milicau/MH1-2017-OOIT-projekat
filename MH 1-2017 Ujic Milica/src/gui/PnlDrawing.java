package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Drawing;
import geometry.FillShape;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class PnlDrawing extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public ArrayList<Shape> shapes = new ArrayList<Shape>();
	enum Choice {Point,Circle, Line, Donut, Rectangle, Nothing, Selection};
	private Choice chosen = Choice.Nothing;
	private Point temp1;
	private Point temp2;
	private Color colorEdge;
	private Color colorInterior;
	
	public PnlDrawing() {
		setBackground(Color.WHITE);
		
		//POINT
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chosen == Choice.Point) {
					temp1 = new Point(e.getX(), e.getY());
					if(colorEdge != null) {
						temp1.setColor(colorEdge);
					}
						shapes.add(temp1);
					temp1 = null;
				}
			}
		});
		
		
		//LINE
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chosen == Choice.Line) {
					if(temp1 == null) {
							temp1 = new Point(e.getX(), e.getY());
					} else {
								temp2 = new Point(e.getX(), e.getY());
							
							if(!temp1.equals(temp2)) {
								Line templ = new Line (temp1, temp2);
								if(colorEdge != null) {
									templ.setColor(colorEdge);
								}
								shapes.add(templ);
								templ = null;
							}else {
								JOptionPane.showMessageDialog(null, "Error", "The points mustn't overlap",JOptionPane.ERROR_MESSAGE);
							}
							temp1 = null;
							temp2 = null;
						}
					
				}
			}
		});
		
		//RECTANGLE
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chosen == Choice.Rectangle) {
					DlgCreateRectangle r1 = new DlgCreateRectangle();
					r1.setVisible(true);
					
					temp1 = new Point(e.getX(), e.getY());
					if(r1.getWidth()!=0 && r1.getHeight()!=0) {
						Rectangle tempr = new Rectangle(temp1, r1.getW(), r1.getH());
						if(colorEdge != null) {
							tempr.setColor(colorEdge);
						}
						if(colorInterior != null) {
							tempr.setColorInterior(colorInterior);
						}
						shapes.add(tempr);
					}
					temp1 = null;
				}
			}
		});
		
		
		//CIRCLE
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chosen == Choice.Circle) {
					DlgCreateCircle c = new DlgCreateCircle();
					c.setVisible(true);
					temp1 = new Point(e.getX(), e.getY());
					if(c.getR() != 0) {
						Circle tempc = new Circle(temp1, c.getR());
						if(colorEdge != null) {
							tempc.setColor(colorEdge);
						}
						if(colorInterior != null) {
							tempc.setColorInterior(colorInterior);
						}
						shapes.add(tempc);
						tempc = null;
					}
					temp1 = null;
				}
			}
		});
		
		//DONUT
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chosen == Choice.Donut) {
					DlgCreateDonut d = new DlgCreateDonut();
					d.setVisible(true);
					temp1 = new Point(e.getX(), e.getY());
					if(d.getiR()!=0 && d.getR()!=0) {
						Donut tempd = new Donut(temp1, d.getR(), d.getiR());
						if(colorEdge != null) {
							tempd.setColor(colorEdge);
						}
						if(colorInterior != null) {
							tempd.setColorInterior(colorInterior);
						}
						shapes.add(tempd);
						tempd = null;
					}
					temp1 = null;
				}
			}
		});
		

	
		//SELECTION
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chosen == Choice.Selection) {
					if(shapes.isEmpty()) {
						JOptionPane.showOptionDialog(null, "Nothing to select!", "Message",
								JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"OK"}, null);
					}
					else {
						deselect();
						select(e);
					}
						
				}
			}
		});
	}

	
	public static void main(String[] args) {

		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape o : shapes) {
			if(o instanceof FillShape)
				((FillShape)o).fills(g);
			o.draw(g);
		}
		repaint();
	}
	
	public void select(MouseEvent e) {
		int i = 0;
		int temp = -1;
		
		for(Shape o: shapes) {
			if(o.contains(e.getX(), e.getY()))
				temp = i;
			i++;
		}
		
		if(temp >-1)
			shapes.get(temp).setSelected(true);
	}
	public void deselect() {
		for(Shape o: shapes) 
			o.setSelected(false);	
	}
	
	public void delete() {
		int temp = getPosition();
		
		int answer = JOptionPane.showOptionDialog (null, "Are you sure?","Question?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {"OK","Cancel"}, null);
		if(answer == JOptionPane.YES_OPTION){
			shapes.remove(temp);
		}
	}	
	
	public int getPosition() {
		int i = 0;
		
		for(Shape o: shapes) {
			if(o.isSelected())
				return i;
			i++;
		}
		return -1;
	}
	
	//CHANGE
	public void change() {
		int pos = getPosition();
		//POINT
		if(shapes.get(pos) instanceof Point) {
			DlgChangePoint changePoint = new DlgChangePoint();

			changePoint.setTemp((Point)shapes.get(pos));
			
			changePoint.setVisible(true);

			if(changePoint.isI()==true) {
				shapes.set(pos, changePoint.getPoint());
			}
			}
		
		//LINE
		else if(shapes.get(pos) instanceof Line) {
			DlgChangeLine changeLine = new DlgChangeLine();
			
			changeLine.setPom((Line)shapes.get(pos));
			
			changeLine.setVisible(true);
			
			if(changeLine.isI()==true) {
				shapes.set(pos, changeLine.getLinija());
			}
		}
		
		
		//CIRCLE
		else if(shapes.get(pos) instanceof Circle) {
			DlgChangeCircle changeCircle = new DlgChangeCircle();
			
			changeCircle.setTmp((Circle)shapes.get(pos));
			
			changeCircle.setVisible(true);
			
			if(changeCircle.isI()==true) 
				shapes.set(pos, changeCircle.getC());
		}

		//RECTANGLE
		else if(shapes.get(pos) instanceof Rectangle) {
			DlgChangeRectangle changeRectangle = new DlgChangeRectangle();
			
			changeRectangle.setTmp((Rectangle)shapes.get(pos));
			
			changeRectangle.setVisible(true);
			
			if(changeRectangle.isI()==true) 
				shapes.set(pos,changeRectangle.getRect());
		}
		//DONUT
		
		  else if(shapes.get(pos) instanceof Donut) {
			  DlgChangeDonut changeDonut = new DlgChangeDonut();
		  
		  changeDonut.setTmp((Donut)shapes.get(pos));
		  
		  changeDonut.setVisible(true);
		  
		  if(changeDonut.isI()==true) 
			  shapes.set(pos, changeDonut.getDonut()); 
		  }
		 
		
	}
	


	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public Choice getChosen() {
		return chosen;
	}

	public void setChosen(Choice chosen) {
		this.chosen = chosen;
	}

	public Color getColorEdge() {
		return colorEdge;
	}

	public void setColorEdge(Color colorEdge) {
		this.colorEdge = colorEdge;
	}

	public Color getColorInterior() {
		return colorInterior;
	}

	public void setColorInterior(Color colorInterior) {
		this.colorInterior = colorInterior;
	}
	
	
}
	
