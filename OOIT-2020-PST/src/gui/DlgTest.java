package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgTest extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtCrvena;
	protected JTextField txtZelena;
	protected JTextField txtPlava;
	protected boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTest dialog = new DlgTest();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTest() {
		setTitle("Unos boje");
		setModal(true);
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblCrvena = new JLabel("Crvena");
			contentPanel.add(lblCrvena);
		}
		{
			txtCrvena = new JTextField();
			contentPanel.add(txtCrvena);
			txtCrvena.setColumns(10);
		}
		{
			JLabel lblZelena = new JLabel("Zelena");
			contentPanel.add(lblZelena);
		}
		{
			txtZelena = new JTextField();
			contentPanel.add(txtZelena);
			txtZelena.setColumns(10);
		}
		{
			JLabel lblPlava = new JLabel("Plava");
			contentPanel.add(lblPlava);
		}
		{
			txtPlava = new JTextField();
			contentPanel.add(txtPlava);
			txtPlava.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOk = true;
						setVisible(false);
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
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
