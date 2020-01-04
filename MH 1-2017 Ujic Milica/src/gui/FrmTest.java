package gui;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import gui.PnlDrawing.Choice;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSeparator;

public class FrmTest {

	private JFrame frmUjicMilicaMh;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	//JButton btnChange, btnDeleete;
	private Color colorE;
	private Color colorI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest window = new FrmTest();
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
	public FrmTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUjicMilicaMh = new JFrame();
		frmUjicMilicaMh.setTitle("Ujic Milica MH1-2017");
		frmUjicMilicaMh.setBounds(100, 100, 587, 485);
		frmUjicMilicaMh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
        PnlDrawing pnlDrawing = new PnlDrawing();
	    frmUjicMilicaMh.getContentPane().add(pnlDrawing, BorderLayout.CENTER);
	    pnlDrawing.setBackground(Color.WHITE); 
	    pnlDrawing.setBorder(new LineBorder(SystemColor.controlShadow)); 
	    pnlDrawing.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		 
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBackground(SystemColor.scrollbar);
		frmUjicMilicaMh.getContentPane().add(pnlLeft, BorderLayout.WEST);
		GridBagLayout gbl_pnlLeft = new GridBagLayout();
		gbl_pnlLeft.columnWidths = new int[]{79, 0};
		gbl_pnlLeft.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlLeft.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlLeft.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlLeft.setLayout(gbl_pnlLeft);
		
		JLabel lblManipilation = new JLabel("Manipilation");
		lblManipilation.setFont(new Font("Verdana", Font.BOLD, 11));
		GridBagConstraints gbc_lblManipilation = new GridBagConstraints();
		gbc_lblManipilation.insets = new Insets(0, 0, 5, 0);
		gbc_lblManipilation.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblManipilation.gridx = 0;
		gbc_lblManipilation.gridy = 0;
		pnlLeft.add(lblManipilation, gbc_lblManipilation);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pnlDrawing.getPosition() != -1) {
					pnlDrawing.change();
				}
				else {
					JOptionPane.showOptionDialog(null, "You must select something!", "Message",
							JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] {"OK"}, null);
				}
			}
		});
		btnChange.setEnabled(false);
		GridBagConstraints gbc_btnChange = new GridBagConstraints();
		gbc_btnChange.insets = new Insets(0, 0, 5, 0);
		gbc_btnChange.fill = GridBagConstraints.BOTH;
		gbc_btnChange.gridx = 0;
		gbc_btnChange.gridy = 2;
		pnlLeft.add(btnChange, gbc_btnChange);
		
		JButton btnDeleete = new JButton("Delete");
		btnDeleete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDeleete.setEnabled(false);
		GridBagConstraints gbc_btnDeleete = new GridBagConstraints();
		gbc_btnDeleete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleete.fill = GridBagConstraints.BOTH;
		gbc_btnDeleete.gridx = 0;
		gbc_btnDeleete.gridy = 3;
		pnlLeft.add(btnDeleete, gbc_btnDeleete);
		
		JToggleButton tglbtnSelection = new JToggleButton("Select");
		tglbtnSelection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnSelection.isSelected()) {
					if(pnlDrawing.getShapes().isEmpty()) {
						btnChange.setEnabled(false);
						btnDeleete.setEnabled(false);
					}else {
						btnChange.setEnabled(true);
						btnChange.setEnabled(true);
					}
					pnlDrawing.setChosen(Choice.Selection);
				}else {
					btnChange.setEnabled(false);
					btnDeleete.setEnabled(false);
					pnlDrawing.setChosen(Choice.Nothing);
					pnlDrawing.deselect();
				}
			}
		});
		tglbtnSelection.setSelected(true);
		buttonGroup.add(tglbtnSelection);
		GridBagConstraints gbc_tglbtnSelection = new GridBagConstraints();
		gbc_tglbtnSelection.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelection.fill = GridBagConstraints.BOTH;
		gbc_tglbtnSelection.gridx = 0;
		gbc_tglbtnSelection.gridy = 1;
		pnlLeft.add(tglbtnSelection, gbc_tglbtnSelection);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.PINK);
		separator_1.setForeground(Color.PINK);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 4;
		pnlLeft.add(separator_1, gbc_separator_1);
		
		
		//Drawing
		JLabel lblDrawing = new JLabel("Drawing");
		lblDrawing.setFont(new Font("Verdana", Font.BOLD, 11));
		GridBagConstraints gbc_lblDrawing = new GridBagConstraints();
		gbc_lblDrawing.insets = new Insets(0, 0, 5, 0);
		gbc_lblDrawing.gridx = 0;
		gbc_lblDrawing.gridy = 5;
		pnlLeft.add(lblDrawing, gbc_lblDrawing);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		buttonGroup.add(tglbtnPoint);
		tglbtnPoint.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnPoint.isSelected()) {
					pnlDrawing.setChosen(Choice.Point);
				}else {
					pnlDrawing.setChosen(Choice.Nothing);
				}
			}
		});
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 6;
		pnlLeft.add(tglbtnPoint, gbc_tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnLine.isSelected()) {
					pnlDrawing.setChosen(Choice.Line);
				}else {
					pnlDrawing.setChosen(Choice.Nothing);
				}
			}
		});
		buttonGroup.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.fill = GridBagConstraints.BOTH;
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnLine.gridx = 0;
		gbc_tglbtnLine.gridy = 7;
		pnlLeft.add(tglbtnLine, gbc_tglbtnLine);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnCircle.isSelected()) {
					pnlDrawing.setChosen(Choice.Circle);
				}else {
					pnlDrawing.setChosen(Choice.Nothing);
				}
			}
		});
		buttonGroup.add(tglbtnCircle);
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnCircle.fill = GridBagConstraints.BOTH;
		gbc_tglbtnCircle.gridx = 0;
		gbc_tglbtnCircle.gridy = 8;
		pnlLeft.add(tglbtnCircle, gbc_tglbtnCircle);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnRectangle.isSelected()) {
					pnlDrawing.setChosen(Choice.Rectangle);
				}else {
					pnlDrawing.setChosen(Choice.Nothing);
				}
			}
		});
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnDonut.isSelected()) {
					pnlDrawing.setChosen(Choice.Donut);
				}else {
					pnlDrawing.setChosen(Choice.Nothing);
				}
			}
		});
		buttonGroup.add(tglbtnDonut);
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.fill = GridBagConstraints.BOTH;
		gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDonut.gridx = 0;
		gbc_tglbtnDonut.gridy = 9;
		pnlLeft.add(tglbtnDonut, gbc_tglbtnDonut);
		buttonGroup.add(tglbtnRectangle);
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnRectangle.gridx = 0;
		gbc_tglbtnRectangle.gridy = 10;
		pnlLeft.add(tglbtnRectangle, gbc_tglbtnRectangle);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.PINK);
		separator.setForeground(Color.PINK);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 11;
		pnlLeft.add(separator, gbc_separator);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Verdana", Font.BOLD, 11));
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.insets = new Insets(0, 0, 5, 0);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 12;
		pnlLeft.add(lblColor, gbc_lblColor);
		
		JButton btnEdge = new JButton("");
		btnEdge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorE = JColorChooser.showDialog(null, "Edge color", colorE);
				if(colorE != null) {
					pnlDrawing.setColorEdge(colorE);
				}
				btnEdge.setBackground(colorE);
			}
		});
		GridBagConstraints gbc_btnEdge = new GridBagConstraints();
		btnEdge.setBackground(Color.BLACK);
		gbc_btnEdge.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdge.anchor = GridBagConstraints.WEST;
		gbc_btnEdge.gridx = 0;
		gbc_btnEdge.gridy = 13;
		pnlLeft.add(btnEdge, gbc_btnEdge);
		
		JButton btnFill = new JButton("");
		btnFill.setBackground(Color.WHITE);
		btnFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorI = JColorChooser.showDialog(null, "Fill color", colorI);
				if(colorI != null) {
					pnlDrawing.setColorInterior(colorI);
				}
				btnFill.setBackground(colorI);
			}
		});
		GridBagConstraints gbc_btnFill = new GridBagConstraints();
		gbc_btnFill.fill = GridBagConstraints.VERTICAL;
		gbc_btnFill.anchor = GridBagConstraints.WEST;
		gbc_btnFill.gridx = 0;
		gbc_btnFill.gridy = 14;
		pnlLeft.add(btnFill, gbc_btnFill);
	}

}