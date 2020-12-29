package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JLabel lblCrvena;
	private JLabel lblPlava;
	private JLabel lblZuta;
	private JTextField txtDodajBoju;
	private JPanel pnlCenter;
	private JList lstBoje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlNorth = new JPanel();
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Naslov");
		pnlNorth.add(lblNaslov);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnIspisi = new JButton("Ispisi");
		btnIspisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)");
			}
		});
		pnlSouth.add(btnIspisi);
		
		JButton btnDodajBoju = new JButton("Dodaj boju");
		btnDodajBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlgTest = new DlgTest();
				dlgTest.setVisible(true);
				if (dlgTest.isOk) {
					dlm.addElement(dlgTest.txtCrvena.getText() + " " + dlgTest.txtZelena.getText() + " " + dlgTest.txtPlava.getText());
					pnlCenter.setBackground(new Color(Integer.parseInt(dlgTest.txtCrvena.getText()), Integer.parseInt(dlgTest.txtZelena.getText()), 
							Integer.parseInt(dlgTest.txtPlava.getText())));
				}
			}
		});
		pnlSouth.add(btnDodajBoju);
		
		JButton btnIzmeniBoju = new JButton("Izmeni boju");
		btnIzmeniBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlgTest = new DlgTest();
				try {
					String[] split = dlm.getElementAt(lstBoje.getSelectedIndex()).toString().split(" ");
					dlgTest.txtCrvena.setText(split[0]);
					dlgTest.txtZelena.setText(split[1]);
					dlgTest.txtPlava.setText(split[2]);
					dlgTest.setVisible(true);
					if (dlgTest.isOk) {
						pnlCenter.setBackground(new Color(Integer.parseInt(dlgTest.txtCrvena.getText()), Integer.parseInt(dlgTest.txtZelena.getText()), 
								Integer.parseInt(dlgTest.txtPlava.getText())));
					}
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Morate selektovati adekvatnu boju");
				}
			}
		});
		pnlSouth.add(btnIzmeniBoju);
		
		pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JToggleButton tglbtnCrvena = new JToggleButton("Crvena");
		btnGroup.add(tglbtnCrvena);
		tglbtnCrvena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblCrvena.getText());
				if (tglbtnCrvena.isSelected()) {
					lblCrvena.setForeground(Color.RED);
					lblZuta.setForeground(Color.BLACK);
					lblPlava.setForeground(Color.BLACK);
				}
			}
		});
		GridBagConstraints gbc_tglbtnCrvena = new GridBagConstraints();
		gbc_tglbtnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvena.gridx = 0;
		gbc_tglbtnCrvena.gridy = 0;
		pnlCenter.add(tglbtnCrvena, gbc_tglbtnCrvena);
		
		lblCrvena = new JLabel("Crvena");
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 0;
		pnlCenter.add(lblCrvena, gbc_lblCrvena);
		
		JScrollPane scrlPaneBoje = new JScrollPane();
		GridBagConstraints gbc_scrlPaneBoje = new GridBagConstraints();
		gbc_scrlPaneBoje.gridheight = 3;
		gbc_scrlPaneBoje.gridwidth = 4;
		gbc_scrlPaneBoje.insets = new Insets(0, 0, 5, 0);
		gbc_scrlPaneBoje.fill = GridBagConstraints.BOTH;
		gbc_scrlPaneBoje.gridx = 2;
		gbc_scrlPaneBoje.gridy = 0;
		pnlCenter.add(scrlPaneBoje, gbc_scrlPaneBoje);
		
		lstBoje = new JList();
		lstBoje.setLayoutOrientation(JList.VERTICAL_WRAP);
		scrlPaneBoje.setViewportView(lstBoje);
		lstBoje.setModel(dlm);
		
		JToggleButton tglbtnPlava = new JToggleButton("Plava");
		btnGroup.add(tglbtnPlava);
		tglbtnPlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblPlava.getText());
				if (tglbtnPlava.isSelected()) {
					lblCrvena.setForeground(Color.BLACK);
					lblZuta.setForeground(Color.BLACK);
					lblPlava.setForeground(Color.BLUE);
				}
			}
		});
		GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
		gbc_tglbtnPlava.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava.gridx = 0;
		gbc_tglbtnPlava.gridy = 1;
		pnlCenter.add(tglbtnPlava, gbc_tglbtnPlava);
		
		lblPlava = new JLabel("Plava");
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 1;
		pnlCenter.add(lblPlava, gbc_lblPlava);
		
		JToggleButton tglbtnZuta = new JToggleButton("Zuta");
		btnGroup.add(tglbtnZuta);
		tglbtnZuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblZuta.getText());
				if (tglbtnZuta.isSelected()) {
					lblCrvena.setForeground(Color.BLACK);
					lblZuta.setForeground(Color.YELLOW);
					lblPlava.setForeground(Color.BLACK);
				}
			}
		});
		GridBagConstraints gbc_tglbtnZuta = new GridBagConstraints();
		gbc_tglbtnZuta.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnZuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnZuta.gridx = 0;
		gbc_tglbtnZuta.gridy = 2;
		pnlCenter.add(tglbtnZuta, gbc_tglbtnZuta);
		
		lblZuta = new JLabel("Zuta");
		GridBagConstraints gbc_lblZuta = new GridBagConstraints();
		gbc_lblZuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuta.gridx = 1;
		gbc_lblZuta.gridy = 2;
		pnlCenter.add(lblZuta, gbc_lblZuta);
		
		JLabel lblDodatneBoje = new JLabel("Dodatne boje");
		GridBagConstraints gbc_lblDodatneBoje = new GridBagConstraints();
		gbc_lblDodatneBoje.anchor = GridBagConstraints.EAST;
		gbc_lblDodatneBoje.insets = new Insets(0, 0, 5, 5);
		gbc_lblDodatneBoje.gridx = 0;
		gbc_lblDodatneBoje.gridy = 3;
		pnlCenter.add(lblDodatneBoje, gbc_lblDodatneBoje);
		
		JComboBox<String> cbxBoje = new JComboBox<String>();
		cbxBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(cbxBoje.getSelectedItem().toString());
				switch(cbxBoje.getSelectedItem().toString()) {
				case "Zelena":
					lblDodatneBoje.setForeground(Color.GREEN);
					break;
				case "Narandzasta":
					lblDodatneBoje.setForeground(Color.ORANGE);
					break;
				case "Ljubicasta":
					lblDodatneBoje.setForeground(Color.MAGENTA);
					break;
				}
			}
		});
		cbxBoje.setModel(new DefaultComboBoxModel<String>(new String[] {"Zelena", "Narandzasta", "Ljubicasta"}));
		GridBagConstraints gbc_cbxBoje = new GridBagConstraints();
		gbc_cbxBoje.gridwidth = 2;
		gbc_cbxBoje.insets = new Insets(0, 0, 5, 5);
		gbc_cbxBoje.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxBoje.gridx = 1;
		gbc_cbxBoje.gridy = 3;
		pnlCenter.add(cbxBoje, gbc_cbxBoje);
		
		JLabel lblDodajBoju = new JLabel("Dodaj boju");
		GridBagConstraints gbc_lblDodajBoju = new GridBagConstraints();
		gbc_lblDodajBoju.insets = new Insets(0, 0, 0, 5);
		gbc_lblDodajBoju.gridx = 0;
		gbc_lblDodajBoju.gridy = 4;
		pnlCenter.add(lblDodajBoju, gbc_lblDodajBoju);
		
		txtDodajBoju = new JTextField();
		txtDodajBoju.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtDodajBoju.getText());
					txtDodajBoju.setText("");
				}
			}
		});
		GridBagConstraints gbc_txtDodajBoju = new GridBagConstraints();
		gbc_txtDodajBoju.gridwidth = 5;
		gbc_txtDodajBoju.insets = new Insets(0, 0, 0, 5);
		gbc_txtDodajBoju.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDodajBoju.gridx = 1;
		gbc_txtDodajBoju.gridy = 4;
		pnlCenter.add(txtDodajBoju, gbc_txtDodajBoju);
		txtDodajBoju.setColumns(10);
	}

}
