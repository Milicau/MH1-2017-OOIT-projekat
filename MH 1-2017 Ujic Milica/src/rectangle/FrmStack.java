package rectangle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import geometry.Point;
import geometry.Rectangle;


import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class FrmStack {

	private JFrame frmMhUjicMilica;
	private int x, y, w, h;
	private Stack<Rectangle> rectangles;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JList<String> rectangleList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack window = new FrmStack();
					window.frmMhUjicMilica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmStack() {
		rectangles= new Stack<Rectangle>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMhUjicMilica = new JFrame();
		frmMhUjicMilica.setTitle("MH1-2017 Ujic Milica");
		frmMhUjicMilica.setBounds(100, 100, 450, 300);
		frmMhUjicMilica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlSouth = new JPanel();
		frmMhUjicMilica.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnPush = new JButton("Push");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dlg = new DlgStack();
				dlg.setVisible(true);
				if(dlg.isOk == true) {
					try {
						x = Integer.parseInt(dlg.getTxtUpperLeftX().getText().toString());
						y = Integer.parseInt(dlg.getTxtUpperLeftY().getText().toString());
						w = Integer.parseInt(dlg.getTxtWidth().getText().toString());
						h = Integer.parseInt(dlg.getTxtHeight().getText().toString());
						if (x < 0 || y < 0 || w < 0 || h < 0) {
							throw new Exception("You cannot enter negative value");
						}
						Rectangle r1 = new Rectangle(new Point(x, y), w, h);
						rectangles.push(r1);
						dlm.addElement(r1.toString());
					} catch (NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "Invalid enter", "Error", JOptionPane.ERROR_MESSAGE);
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
					}
			}}
		});
		pnlSouth.add(btnPush);
		
		JButton btnPop = new JButton("Pop");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!rectangles.empty()) {
					try {
						
							rectangles.pop();
							dlm.remove(dlm.size()-1);
							
						}
					catch(Exception e2){
						JOptionPane.showMessageDialog(null,
								e2.getMessage(), 
								"Error", 
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else
					JOptionPane.showMessageDialog(null,
							"There is no elements", 
							"Error", 
							JOptionPane.ERROR_MESSAGE);
				
			}
			
		});
		pnlSouth.add(btnPop);
		
		JButton btnPeek = new JButton("Peek");
		btnPeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!rectangles.empty()) {
					try {
						DlgStack dlg = new DlgStack();
						Rectangle temp = rectangles.peek();
						dlg.getTxtUpperLeftX().setText(Integer.toString(temp.getUpperLeft().getX()));
						dlg.getTxtUpperLeftY().setText(Integer.toString(temp.getUpperLeft().getY()));
						dlg.getTxtWidth().setText(Integer.toString(temp.getWidth()));
						dlg.getTxtHeight().setText(Integer.toString(temp.getHeight()));
						dlg.setVisible(true);
						}
					catch(Exception e2){
						JOptionPane.showMessageDialog(null,
								e2.getMessage(), 
								"Error", 
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else
					JOptionPane.showMessageDialog(null,
							"There is no elements", 
							"Error", 
							JOptionPane.ERROR_MESSAGE);
				
			}
		});
		pnlSouth.add(btnPeek);
		
		JScrollPane scrollPane = new JScrollPane();
		frmMhUjicMilica.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		rectangleList = new JList<String>();
		scrollPane.setViewportView(rectangleList);
		rectangleList.setModel(dlm);
	}

}
