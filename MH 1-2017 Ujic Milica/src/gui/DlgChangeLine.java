package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DlgChangeLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStartX;
	private JTextField txtStartY;
	private JTextField txtEndX;
	private JTextField txtEndY;
	private JButton btnEdge;
	private boolean i;
	private Color boja;
	private Line linija;
	private Line pom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgChangeLine dialog = new DlgChangeLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgChangeLine() {
		linija = new Line(new Point(), new Point());
		pom = new Line();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				btnEdge.setBackground(pom.getColor());
				txtStartX.setText(""+pom.getStartPoint().getX());
				txtStartY.setText(""+pom.getStartPoint().getY());
				txtEndX.setText(""+pom.getEndPoint().getX());
				txtEndY.setText(""+pom.getEndPoint().getY());
				boja = pom.getColor();
			}
		});
		setModal(true);
		setTitle("Change line");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPoint = new JLabel("Start point:");
			GridBagConstraints gbc_lblStartPoint = new GridBagConstraints();
			gbc_lblStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPoint.gridx = 1;
			gbc_lblStartPoint.gridy = 1;
			contentPanel.add(lblStartPoint, gbc_lblStartPoint);
		}
		{
			JLabel lblX = new JLabel("X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 2;
			gbc_lblX.gridy = 2;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtStartX = new JTextField();
			GridBagConstraints gbc_txtStartX = new GridBagConstraints();
			gbc_txtStartX.insets = new Insets(0, 0, 5, 5);
			gbc_txtStartX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartX.gridx = 5;
			gbc_txtStartX.gridy = 2;
			contentPanel.add(txtStartX, gbc_txtStartX);
			txtStartX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 2;
			gbc_lblY.gridy = 3;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtStartY = new JTextField();
			GridBagConstraints gbc_txtStartY = new GridBagConstraints();
			gbc_txtStartY.insets = new Insets(0, 0, 5, 5);
			gbc_txtStartY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartY.gridx = 5;
			gbc_txtStartY.gridy = 3;
			contentPanel.add(txtStartY, gbc_txtStartY);
			txtStartY.setColumns(10);
		}
		{
			JLabel lblEndPoint = new JLabel("End point:");
			GridBagConstraints gbc_lblEndPoint = new GridBagConstraints();
			gbc_lblEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPoint.gridx = 1;
			gbc_lblEndPoint.gridy = 4;
			contentPanel.add(lblEndPoint, gbc_lblEndPoint);
		}
		{
			JLabel lblX_1 = new JLabel("X:");
			GridBagConstraints gbc_lblX_1 = new GridBagConstraints();
			gbc_lblX_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblX_1.gridx = 2;
			gbc_lblX_1.gridy = 5;
			contentPanel.add(lblX_1, gbc_lblX_1);
		}
		{
			txtEndX = new JTextField();
			GridBagConstraints gbc_txtEndX = new GridBagConstraints();
			gbc_txtEndX.insets = new Insets(0, 0, 5, 5);
			gbc_txtEndX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndX.gridx = 5;
			gbc_txtEndX.gridy = 5;
			contentPanel.add(txtEndX, gbc_txtEndX);
			txtEndX.setColumns(10);
		}
		{
			JLabel lblY_1 = new JLabel("Y:");
			GridBagConstraints gbc_lblY_1 = new GridBagConstraints();
			gbc_lblY_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblY_1.gridx = 2;
			gbc_lblY_1.gridy = 6;
			contentPanel.add(lblY_1, gbc_lblY_1);
		}
		{
			txtEndY = new JTextField();
			GridBagConstraints gbc_txtEndY = new GridBagConstraints();
			gbc_txtEndY.insets = new Insets(0, 0, 5, 5);
			gbc_txtEndY.anchor = GridBagConstraints.NORTH;
			gbc_txtEndY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndY.gridx = 5;
			gbc_txtEndY.gridy = 6;
			contentPanel.add(txtEndY, gbc_txtEndY);
			txtEndY.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblColor.gridx = 2;
			gbc_lblColor.gridy = 7;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnEdge = new JButton("");
			btnEdge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boja = JColorChooser.showDialog(null, "Izbirati boju ivice", boja);
					if(boja==null) {
						boja = pom.getColor();
					}
					btnEdge.setBackground(boja);
				}
			});
			GridBagConstraints gbc_btnEdge = new GridBagConstraints();
			btnEdge.setBackground(Color.BLACK);
			gbc_btnEdge.anchor = GridBagConstraints.WEST;
			gbc_btnEdge.fill = GridBagConstraints.VERTICAL;
			gbc_btnEdge.insets = new Insets(0, 0, 0, 5);
			gbc_btnEdge.gridx = 5;
			gbc_btnEdge.gridy = 7;
			contentPanel.add(btnEdge, gbc_btnEdge);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							linija.getStartPoint().setX(Integer.parseInt(txtStartX.getText()));
							linija.getStartPoint().setY(Integer.parseInt(txtStartY.getText()));
							linija.getEndPoint().setX(Integer.parseInt(txtEndX.getText()));
							linija.getEndPoint().setY(Integer.parseInt(txtEndY.getText()));
							linija.setColor(boja);
							
							if(linija.getStartPoint().equals(linija.getEndPoint()))
								throw new Exception("The points mustn't overlap!");
							
							i = true;
							dispose();
						}catch(NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Invalid entry", "Error", JOptionPane.ERROR_MESSAGE);
						}catch(Exception e2) {
							JOptionPane.showMessageDialog(null, "Invalid entry", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						i = false;
						linija = null;
						pom = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtStartX() {
		return txtStartX;
	}

	public void setTxtStartX(JTextField txtStartX) {
		this.txtStartX = txtStartX;
	}

	public JTextField getTxtStartY() {
		return txtStartY;
	}

	public void setTxtStartY(JTextField txtStartY) {
		this.txtStartY = txtStartY;
	}

	public JTextField getTxtEndX() {
		return txtEndX;
	}

	public void setTxtEndX(JTextField txtEndX) {
		this.txtEndX = txtEndX;
	}

	public JTextField getTxtEndY() {
		return txtEndY;
	}

	public void setTxtEndY(JTextField txtEndY) {
		this.txtEndY = txtEndY;
	}

	public boolean isI() {
		return i;
	}

	public void setI(boolean i) {
		this.i = i;
	}

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}

	public Line getLinija() {
		return linija;
	}

	public void setLinija(Line linija) {
		this.linija = linija;
	}

	public Line getPom() {
		return pom;
	}

	public void setPom(Line pom) {
		this.pom = pom;
	}
	
	

}
