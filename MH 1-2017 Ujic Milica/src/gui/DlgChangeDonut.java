package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgChangeDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtIR;
	private JTextField txtOR;
	private Color colorE, colorI;
	private Donut temp, donut;
	private boolean i;
	private JButton btnEdge, btnFill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgChangeDonut dialog = new DlgChangeDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgChangeDonut() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		donut = new Donut(new Point(), 0, 0);
		temp = new Donut();
		setTitle("Change donut");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 4;
			gbc_txtX.gridy = 1;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
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
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 4;
			gbc_txtY.gridy = 2;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Inner radius:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 3;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			txtIR = new JTextField();
			GridBagConstraints gbc_txtIR = new GridBagConstraints();
			gbc_txtIR.insets = new Insets(0, 0, 5, 0);
			gbc_txtIR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtIR.gridx = 4;
			gbc_txtIR.gridy = 3;
			contentPanel.add(txtIR, gbc_txtIR);
			txtIR.setColumns(10);
		}
		{
			JLabel lblOuterRadius = new JLabel("Outer radius:");
			GridBagConstraints gbc_lblOuterRadius = new GridBagConstraints();
			gbc_lblOuterRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblOuterRadius.gridx = 2;
			gbc_lblOuterRadius.gridy = 4;
			contentPanel.add(lblOuterRadius, gbc_lblOuterRadius);
		}
		{
			txtOR = new JTextField();
			GridBagConstraints gbc_txtOR = new GridBagConstraints();
			gbc_txtOR.anchor = GridBagConstraints.NORTH;
			gbc_txtOR.insets = new Insets(0, 0, 5, 0);
			gbc_txtOR.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtOR.gridx = 4;
			gbc_txtOR.gridy = 4;
			contentPanel.add(txtOR, gbc_txtOR);
			txtOR.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 2;
			gbc_lblColor.gridy = 5;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnEdge = new JButton("");
			btnEdge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorE = JColorChooser.showDialog(null, "Edge color", colorE);
					if(colorE == null) {
						colorE = temp.getColor();
					}
					btnEdge.setBackground(colorE);
				}
			});
			GridBagConstraints gbc_btnEdge = new GridBagConstraints();
			//btnEdge.setBackground(Color.BLACK);
			gbc_btnEdge.insets = new Insets(0, 0, 5, 0);
			gbc_btnEdge.anchor = GridBagConstraints.WEST;
			gbc_btnEdge.gridx = 4;
			gbc_btnEdge.gridy = 5;
			contentPanel.add(btnEdge, gbc_btnEdge);
		}
		{
			btnFill = new JButton("");
			btnFill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorI = JColorChooser.showDialog(null, "Fill color", colorI);
					if(colorI == null) {
						colorI = temp.getColor();
					}
					btnFill.setBackground(colorI);
				}
			});
			GridBagConstraints gbc_btnFill = new GridBagConstraints();
			//btnFill.setBackground(Color.WHITE);
			gbc_btnFill.anchor = GridBagConstraints.WEST;
			gbc_btnFill.gridx = 4;
			gbc_btnFill.gridy = 6;
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
							donut.getCenter().setX(Integer.parseInt(txtX.getText()));
							donut.getCenter().setY(Integer.parseInt(txtY.getText()));
							try {
								donut.setInnerR(Integer.parseInt(txtIR.getText()));
								donut.setR(Integer.parseInt(txtOR.getText()));
							} catch (Exception e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							donut.setColor(colorE);
							donut.setColorInterior(colorI);
							
							if(donut.getInnerR()<=0 && donut.getR()<=0)
								throw new Exception("Values must be positive!");
							else if(donut.getR()<=0)
								throw new Exception("Outer radius must be positive!"); 
							else if(donut.getInnerR()<=0)
								throw new Exception("Inner radius must be positive!"); 
							else if(donut.getInnerR()>donut.getR())
								throw new Exception("Inner radius must be smaller then outer radius!");
							else if(donut.getInnerR()==donut.getR())
								throw new Exception("Values must be different!");
							dispose();
						}catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Invalid enter", "Error", JOptionPane.ERROR_MESSAGE);
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}finally {
						btnEdge.setBackground(temp.getColor());
						btnFill.setBackground(temp.getColorInterior());
						txtX.setText(""+temp.getCenter().getX());
						txtY.setText(""+temp.getCenter().getY());
						txtOR.setText(""+temp.getR());
						txtIR.setText(""+temp.getInnerR());
					}
				}});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						i = false;
						donut = null;
						temp = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Color getColorE() {
		return colorE;
	}

	public void setColorE(Color colorE) {
		this.colorE = colorE;
	}

	public Color getColorI() {
		return colorI;
	}

	public void setColorI(Color colorI) {
		this.colorI = colorI;
	}

	public Donut getTemp() {
		return temp;
	}

	public void setTemp(Donut temp) {
		this.temp = temp;
	}

	public Donut getDonut() {
		return donut;
	}

	public void setDonut(Donut donut) {
		this.donut = donut;
	}

	public boolean isI() {
		return i;
	}

	public void setI(boolean i) {
		this.i = i;
	}
	

}
