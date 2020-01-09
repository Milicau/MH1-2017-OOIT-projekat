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
import geometry.Rectangle;

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

public class DlgChangeRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtW;
	private JTextField txtH;
	private JButton btnEdge, btnFill;
	private Rectangle rect, tmp;
	private boolean i;
	private Color colorEdge, colorFill;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgChangeRectangle dialog = new DlgChangeRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgChangeRectangle() {
		 rect = new Rectangle(new Point(), 0, 0);
		 tmp = new Rectangle();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				btnEdge.setBackground(tmp.getColor());
				btnFill.setBackground(tmp.getColorInterior());
				txtX.setText(""+tmp.getUpperLeft().getX());
				txtY.setText(""+tmp.getUpperLeft().getY());
				txtW.setText(""+tmp.getWidth());
				txtH.setText(""+tmp.getHeight());
				colorEdge = tmp.getColor();
				colorFill = tmp.getColorInterior();
			}
		});
		setTitle("Change Rectangle");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setLocationRelativeTo(null);
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
			txtY.setText("");
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 4;
			gbc_txtY.gridy = 2;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 2;
			gbc_lblWidth.gridy = 3;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtW = new JTextField();
			txtW.setText("");
			GridBagConstraints gbc_txtW = new GridBagConstraints();
			gbc_txtW.insets = new Insets(0, 0, 5, 0);
			gbc_txtW.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtW.gridx = 4;
			gbc_txtW.gridy = 3;
			contentPanel.add(txtW, gbc_txtW);
			txtW.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 2;
			gbc_lblHeight.gridy = 4;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			txtH = new JTextField();
			txtH.setText("");
			GridBagConstraints gbc_txtH = new GridBagConstraints();
			gbc_txtH.insets = new Insets(0, 0, 5, 0);
			gbc_txtH.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtH.gridx = 4;
			gbc_txtH.gridy = 4;
			contentPanel.add(txtH, gbc_txtH);
			txtH.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("color:");
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
					colorEdge = JColorChooser.showDialog(null, "Edge color", colorEdge);
					if(colorEdge == null) {
						colorEdge = tmp.getColor();
					}
					btnEdge.setBackground(colorEdge);
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
					colorFill = JColorChooser.showDialog(null, "Choose color", colorFill);
					if(colorFill == null) {
						colorFill = tmp.getColor();
					}
					btnFill.setBackground(colorFill);
				}
			});
			GridBagConstraints gbc_btnFill = new GridBagConstraints();
			//btnFill.setBackground(Color.WHITE);
			gbc_btnFill.anchor = GridBagConstraints.WEST;
			gbc_btnFill.fill = GridBagConstraints.VERTICAL;
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
							rect.getUpperLeft().setX(Integer.parseInt(txtX.getText()));
							rect.getUpperLeft().setY(Integer.parseInt(txtY.getText()));
							rect.setWidth(Integer.parseInt(txtW.getText()));
							rect.setHeight(Integer.parseInt(txtH.getText()));
							rect.setColor(colorEdge);
							rect.setColorInterior(colorFill);
							
							if(rect.getWidth() <=0 || rect.getHeight() <= 0) {
								throw new Exception("Values must be positive");
							}
							i = true;
							dispose();
						}catch (NumberFormatException a){
							JOptionPane.showMessageDialog(null, "Invalid entry","Error",JOptionPane.ERROR_MESSAGE);
							
						}catch(Exception s) {
							JOptionPane.showMessageDialog(null, s.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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
						rect = null;
						tmp = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public Rectangle getTmp() {
		return tmp;
	}

	public void setTmp(Rectangle tmp) {
		this.tmp = tmp;
	}

	public boolean isI() {
		return i;
	}

	public void setI(boolean i) {
		this.i = i;
	}
	
	

}
