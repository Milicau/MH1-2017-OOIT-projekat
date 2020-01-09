package rectangle;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import geometry.Point;
import geometry.Rectangle;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class FrmRct {

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
					FrmRct window = new FrmRct();
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
	public FrmRct() {
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
		
		JPanel pnlSouth = new JPanel();
		frmUjicMilicaMh.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		pnlSouth.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing is selected!", 
							"Error", 
							JOptionPane.ERROR_MESSAGE);
				}else {
					DlgRct dlg = new DlgRct();
					Rectangle temp = dlm.elementAt(list.getSelectedIndex());
					dlg.getTxtUpperLeftX().setText(Integer.toString(temp.getUpperLeft().getX()));
					dlg.getTxtUpperLeftY().setText(Integer.toString(temp.getUpperLeft().getY()));
					dlg.getTxtHeight().setText(Integer.toString(temp.getHeight()));
					dlg.getTxtWidth().setText(Integer.toString(temp.getWidth()));
					dlg.setVisible(true);
					if(dlg.isOk) {
						rectangles.pop();
						dlm.remove(dlm.size()-1);
					}
					
				}
			}
		});
		pnlSouth.add(btnRemove);
		
		scrollPane = new JScrollPane();
		frmUjicMilicaMh.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
		
	}

}
