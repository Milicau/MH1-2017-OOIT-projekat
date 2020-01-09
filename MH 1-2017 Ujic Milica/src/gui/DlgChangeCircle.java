package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dialog.ModalityType;

public class DlgChangeCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCenterX;
	private JTextField txtCenterY;
	private JTextField txtR;
	private JButton btnEdge, btnFill;
	private boolean i;
	private Color colorEdge;
	private Color colorFill;
	private Circle c;
	private Circle tmp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgChangeCircle dialog = new DlgChangeCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgChangeCircle() {
		c = new Circle(new Point(), 0);
		tmp = new Circle();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				btnEdge.setBackground(tmp.getColor());
				btnFill.setBackground(tmp.getColorInterior());
				txtCenterX.setText(""+tmp.getCenter().getX());
				txtCenterY.setText(""+tmp.getCenter().getY());
				txtR.setText(""+tmp.getR());
				colorEdge = tmp.getColor();
				colorFill = tmp.getColorInterior();
			}
		});
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setLocationRelativeTo(null);
		setTitle("Change circle");
		setModal(true);
		setBounds(100, 100, 434, 269);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 2;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtCenterX = new JTextField();
			GridBagConstraints gbc_txtCenterX = new GridBagConstraints();
			gbc_txtCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCenterX.gridx = 4;
			gbc_txtCenterX.gridy = 1;
			contentPanel.add(txtCenterX, gbc_txtCenterX);
			txtCenterX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 2;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtCenterY = new JTextField();
			txtCenterY.setText("");
			GridBagConstraints gbc_txtCenterY = new GridBagConstraints();
			gbc_txtCenterY.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCenterY.gridx = 4;
			gbc_txtCenterY.gridy = 2;
			contentPanel.add(txtCenterY, gbc_txtCenterY);
			txtCenterY.setColumns(10);
		}
		{
			JLabel lblR = new JLabel("r:");
			GridBagConstraints gbc_lblR = new GridBagConstraints();
			gbc_lblR.insets = new Insets(0, 0, 5, 5);
			gbc_lblR.gridx = 2;
			gbc_lblR.gridy = 3;
			contentPanel.add(lblR, gbc_lblR);
		}
		{
			txtR = new JTextField();
			GridBagConstraints gbc_txtR = new GridBagConstraints();
			gbc_txtR.insets = new Insets(0, 0, 5, 0);
			gbc_txtR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtR.gridx = 4;
			gbc_txtR.gridy = 3;
			contentPanel.add(txtR, gbc_txtR);
			txtR.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 2;
			gbc_lblColor.gridy = 4;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnEdge = new JButton("");
			btnEdge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorEdge = JColorChooser.showDialog(null, "Edge color", colorEdge);
					if(colorEdge == null) {
						colorEdge = tmp.getColor();
					}
					btnEdge.setBackground(colorEdge);
				}
			});
			btnEdge.setBackground(Color.BLACK);
			GridBagConstraints gbc_btnEdge = new GridBagConstraints();
			gbc_btnEdge.anchor = GridBagConstraints.WEST;
			gbc_btnEdge.insets = new Insets(0, 0, 5, 0);
			gbc_btnEdge.gridx = 4;
			gbc_btnEdge.gridy = 4;
			contentPanel.add(btnEdge, gbc_btnEdge);
		}
		{
			btnFill = new JButton("");
			btnFill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorFill = JColorChooser.showDialog(null, "Fill color", colorFill);
					if(colorFill == null) {
						colorFill = tmp.getColor();
					}
					btnFill.setBackground(colorFill);
				}
			});
			btnFill.setBackground(Color.BLACK);
			GridBagConstraints gbc_btnFill = new GridBagConstraints();
			gbc_btnFill.fill = GridBagConstraints.VERTICAL;
			gbc_btnFill.anchor = GridBagConstraints.WEST;
			gbc_btnFill.gridx = 4;
			gbc_btnFill.gridy = 5;
			contentPanel.add(btnFill, gbc_btnFill);
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
							c.getCenter().setX(Integer.parseInt(txtCenterX.getText()));
							c.getCenter().setY(Integer.parseInt(txtCenterY.getText()));
							try {
								c.setR(Integer.parseInt(txtR.getText()));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							c.setColor(colorEdge);
							c.setColorInterior(colorFill);
							if(c.getR() <= 0) {
								throw new Exception ("You cannnot enter negative radius!");
							}
						
						  }catch(NumberFormatException e0) { JOptionPane.showMessageDialog(null,
						  "Invalid entry","Error", JOptionPane.ERROR_MESSAGE); }
							catch(Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
						}finally {
							btnEdge.setBackground(tmp.getColor());
							btnFill.setBackground(tmp.getColorInterior());
							txtCenterX.setText(""+tmp.getCenter().getX());
							txtCenterY.setText(""+tmp.getCenter().getY());
							txtR.setText(""+tmp.getR());
						}
						 
						i = true;
						dispose();
						
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
						tmp = null;
						c = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean isI() {
		return i;
	}

	public void setI(boolean i) {
		this.i = i;
	}

	public Circle getC() {
		return c;
	}

	public void setC(Circle c) {
		this.c = c;
	}

	public Circle getTmp() {
		return tmp;
	}

	public void setTmp(Circle tmp) {
		this.tmp = tmp;
	}
	
	

}
