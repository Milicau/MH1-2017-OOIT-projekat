package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgChangePoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JButton btnEdge;
	private boolean i; //Indikator (Prihvati ili ponisti)
	private Color color;
	private Point point;
	private Point temp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgChangePoint dialog = new DlgChangePoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgChangePoint() {
		point = new Point();
		temp = new Point();
		
		setModal(true);
		setTitle("Change Point");
		setBounds(100, 100, 372, 202);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 4;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.gridwidth = 4;
			gbc_txtX.insets = new Insets(0, 0, 5, 5);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 6;
			gbc_txtX.gridy = 1;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 4;
			gbc_lblY.gridy = 2;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.gridwidth = 4;
			gbc_txtY.insets = new Insets(0, 0, 5, 5);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 6;
			gbc_txtY.gridy = 2;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblColor.gridx = 4;
			gbc_lblColor.gridy = 3;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnEdge = new JButton("");
			btnEdge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose edge color:", color);
					if(color == null)
						color = temp.getColor();
					btnEdge.setBackground(color);
				}
			});
			GridBagConstraints gbc_btnEdge = new GridBagConstraints();
			btnEdge.setBackground(Color.BLACK);
			gbc_btnEdge.fill = GridBagConstraints.BOTH;
			gbc_btnEdge.insets = new Insets(0, 0, 0, 5);
			gbc_btnEdge.gridx = 6;
			gbc_btnEdge.gridy = 3;
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
							point.setX(Integer.parseInt(txtX.getText()));
							point.setY(Integer.parseInt(txtY.getText()));
							point.setColor(color);
							
							i = true;
							dispose();
						}
						catch (NumberFormatException e1) {
							JOptionPane.showOptionDialog(null, "Invalid entry!", "Error!",
									JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[] {"OK"}, null);
							
							txtX.setText(""+temp.getX());
							txtY.setText(""+temp.getY());
							btnEdge.setBackground(temp.getColor());
							
							i = false;
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
						point = null;
						temp = null;
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


	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void setTemp(Point temp) {
		this.temp = temp;
	}

}
