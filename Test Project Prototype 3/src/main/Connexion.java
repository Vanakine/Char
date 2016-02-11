package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connexion implements ActionListener {

	private JFrame frmTankConnexion;
	private JTextField textField;
	JButton btnConfirmer = new JButton("Confirmer");
	JButton btnFermer = new JButton("Fermer");
	JButton btnActualiser = new JButton("Actualiser");
	
	/**
	 * Create the application.
	 */
	public Connexion() {
		frmTankConnexion = new JFrame();
		frmTankConnexion.setOpacity(1.0f);
		frmTankConnexion.setResizable(false);
		frmTankConnexion.setTitle("Tank Connexion");
		frmTankConnexion.setLocationRelativeTo(null);
		frmTankConnexion.setBounds(100, 100, 450, 300);

		JPanel panel = new JPanel();
		frmTankConnexion.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[111px][][][][][][]", "[14px]"));

		JLabel lblParamtresConnexion = new JLabel("Param\u00E8tres connexion:");
		lblParamtresConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblParamtresConnexion, "cell 3 0,alignx center,aligny center");
		
		JPanel panel_1 = new JPanel();
		frmTankConnexion.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		panel_1.add(btnConfirmer);
		
		btnFermer.addActionListener(this);
		panel_1.add(btnFermer);
		
		panel_1.add(btnActualiser);
		
		JPanel panel_2 = new JPanel();
		frmTankConnexion.getContentPane().add(panel_2, BorderLayout.CENTER);
		
		JLabel lblAdresseIpDu = new JLabel("Adresse IP du char:");
		panel_2.add(lblAdresseIpDu);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		frmTankConnexion.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnFermer){
			frmTankConnexion.setVisible(false);
		}
	}

}
