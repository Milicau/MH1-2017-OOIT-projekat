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
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class FrmSort extends FrmRct{

	private JFrame frmUjicMilicaMh;
	DefaultListModel<Rectangle>dlm = new DefaultListModel<Rectangle>();

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUjicMilicaMh = new JFrame();
		frmUjicMilicaMh.setTitle("Ujic Milica MH1-2017");
		frmUjicMilicaMh.setBounds(100, 100, 450, 300);
		frmUjicMilicaMh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JList list;
		

		Rectangle r1 = new Rectangle(new Point(20, 30), 15, 20);
		Rectangle r2 = new Rectangle(new Point(20, 10), 10, 5);
		
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
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rectangle[] rectangles = {r1, r2};
				for(int i=0; i < rectangles.length; i++)
				dlm.addElement(rectangles[i]);
			}
		});
		panel_1.add(btnShow);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rectangle[] rectangles = {r1, r2};
				Arrays.sort(rectangles);
				for(int i = 0; i < rectangles.length; i++) {
					dlm.addElement(rectangles[i]);
				}
			}
		});
		panel_1.add(btnSort);
		
		list = new JList();
		list.setModel(dlm);
		list.setBackground(SystemColor.inactiveCaptionBorder);
		frmUjicMilicaMh.getContentPane().add(list, BorderLayout.CENTER);
	}

}
