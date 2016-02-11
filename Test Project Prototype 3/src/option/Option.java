package option;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JSlider;

import file.Read;
import file.Write;

public class Option implements ActionListener {
	
	private JFrame frmTankOptions;
	private JTextField textField;
	private JTextField textField_1;
	JCheckBox chckbxVoulezVousJouez = new JCheckBox("Voulez vous jouez en pleine \u00E9cran?");
	JSlider slider = new JSlider();
	JCheckBox chckbxVoulezVousJouez_1 = new JCheckBox("Voulez vous jouez au clavier uniquement?");
	
	/**
	 * Create the application.
	 */

	JButton btnFermer = new JButton("Fermer");
	
	public Option() {
		
		String string = Read.readAtLine("src\\option\\config", 1);
		if (string == null){
			string = "false";
		}
		boolean statut = Boolean.parseBoolean(string);
		
		String valeur = Read.readAtLine("src\\option\\config", 2);
		if(valeur == null){
			valeur = "5";
		}
		int sens = Integer.parseInt(valeur);
		
		String FenX = Read.readAtLine("src\\option\\config", 3);
		if(FenX == null){
			FenX = "800";
		}
		
		String FenY = Read.readAtLine("src\\option\\config", 4);
		if(FenY == null){
			FenY = "600";
		}
		
		String test = Read.readAtLine("src\\option\\config", 5);
		if (test == null){
			test = "false";
		}
		boolean full = Boolean.parseBoolean(test);
		
		frmTankOptions = new JFrame();
		frmTankOptions.setResizable(false);
		frmTankOptions.setTitle("Tank Options");
		frmTankOptions.setBounds(100, 100, 450, 300);
		frmTankOptions.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frmTankOptions.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblOptions = new JLabel("Options");
		panel.add(lblOptions);
		
		JPanel panel_1 = new JPanel();
		frmTankOptions.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		//JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(this);
		panel_1.add(btnFermer);
		
		JPanel panel_2 = new JPanel();
		frmTankOptions.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("", "[67px][187px][187px]", "[216px][][][]"));
		
		JLabel lblTest = new JLabel("Taille fen\u00EAtre:");
		panel_2.add(lblTest, "cell 0 0,alignx left,aligny center");
		
		textField = new JTextField();
		textField.setText(FenX);
		panel_2.add(textField, "cell 1 0,alignx center,aligny center");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText(FenY);
		panel_2.add(textField_1, "flowx,cell 2 0,alignx center,aligny center");
		textField_1.setColumns(10);
		
		chckbxVoulezVousJouez.setSelected(full);
		panel_2.add(chckbxVoulezVousJouez, "cell 0 1");
		
		JLabel lblSensibilit = new JLabel("Sensibilit\u00E9:");
		panel_2.add(lblSensibilit, "cell 0 2");
		
		slider.setMajorTickSpacing(2);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setValue(sens);
		slider.setMaximum(11);
		slider.setMinimum(1);
		panel_2.add(slider, "cell 1 2 2 1");
		
		chckbxVoulezVousJouez_1.setSelected(statut);
		panel_2.add(chckbxVoulezVousJouez_1, "cell 0 3");
		
		frmTankOptions.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean b1 = chckbxVoulezVousJouez.isSelected() /*fullScreen*/, b2 = chckbxVoulezVousJouez_1.isSelected() /*clavier*/;
		int valueSlider = slider.getValue();
		String fenX = textField.getText(), fenY = textField_1.getText();
		int fenXv = Integer.parseInt(fenX), fenYv = Integer.parseInt(fenY);
		
		if(e.getSource() == btnFermer){
			Write.changeOption("src\\option\\config", b2, valueSlider, fenXv, fenYv, b1);
			frmTankOptions.setVisible(false);
		}
	}

}
