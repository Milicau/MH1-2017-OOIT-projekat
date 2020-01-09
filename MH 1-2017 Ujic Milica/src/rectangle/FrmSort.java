package rectangle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import geometry.Point;
import geometry.Rectangle;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class FrmSort extends FrmRct{

	private JFrame frmUjicMilicaMh;
	private Stack <Rectangle> rectangles;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	private JList list;
	private JScrollPane scrollPane;
	private int x, y, w, h;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort window = new FrmSort();
					window.frmUjicMilicaMh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmSort() {
		rectangles= new Stack<Rectangle>();
		initialize();
		frmUjicMilicaMh.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUjicMilicaMh = new JFrame();
		frmUjicMilicaMh.setTitle("Ujic Milica MH1-2017");
		frmUjicMilicaMh.setBounds(100, 100, 450, 300);
		frmUjicMilicaMh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * Rectangle r1 = new Rectangle(new Point(20, 30), 15, 20); Rectangle r2 = new
		 * Rectangle(new Point(20, 10), 10, 5);
		 */
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frmUjicMilicaMh.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblRectangles = new JLabel("Rectangles");
		lblRectangles.setFont(new Font("Verdana", Font.BOLD, 11));
		panel.add(lblRectangles);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		frmUjicMilicaMh.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgRct dlg = new DlgRct();
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
						dlm.addElement(r1);
						/*Rectangle r1 = new Rectangle(new Point(Integer.parseInt(dlg.getTxtUpperLeftX().getText().toString()),
							Integer.parseInt(dlg.getTxtUpperLeftY().getText().toString())), Integer.parseInt(dlg.getTxtWidth().getText().toString()),
							Integer.parseInt(dlg.getTxtWidth().getText().toString()));
					dlm.addElement(r1);
					lifo.addFirst(r1);*/
					} catch (NumberFormatException e1){
						JOptionPane.showMessageDialog(null, "Invalid enter", "Error", JOptionPane.ERROR_MESSAGE);
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel_1.add(btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] o = rectangles.toArray();
				Arrays.sort(o);
				rectangles.clear();
				 dlm.clear();
				for(int i = 0; i < o.length; i++) {
					//System.out.println(o);
					rectangles.add((Rectangle)o[i]);
					dlm.addElement((Rectangle)o[i]);
				}
			}
		});
		panel_1.add(btnSort);
		
		scrollPane = new JScrollPane();
		frmUjicMilicaMh.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
	}

}
