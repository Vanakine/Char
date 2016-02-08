import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import option.Option;

import file.Read;

import java.awt.Color;


public class Launcher implements ActionListener {

	private JFrame frmTankLauncher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
				try {
					Launcher window = new Launcher();
					window.frmTankLauncher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher() {		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	JButton btnOption = new JButton("Option");
	JButton btnQuitter = new JButton("Quitter");
	
	private void initialize() {
		
		frmTankLauncher = new JFrame();
		frmTankLauncher.setBackground(Color.LIGHT_GRAY);
		frmTankLauncher.setResizable(false);
		frmTankLauncher.setTitle("Tank Launcher");
		frmTankLauncher.setBounds(100, 100, 450, 300);
		frmTankLauncher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmTankLauncher.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnLancer = new JButton("Lancer");
		btnLancer.setVerticalAlignment(SwingConstants.TOP);
		btnLancer.setHorizontalAlignment(SwingConstants.LEADING);
		panel.add(btnLancer);
		
		//JButton btnOption = new JButton("Option");
		btnOption.addActionListener(this);
		btnOption.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(btnOption);
		
		//JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(this);
		btnQuitter.setVerticalAlignment(SwingConstants.BOTTOM);
		btnQuitter.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(btnQuitter);
		
		JPanel panel_1 = new JPanel();
		frmTankLauncher.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JLabel version = new JLabel("");
		String v = Read.readAll("src\\Version");
		version.setText(v);
		panel_1.add(version);
		
		JProgressBar progressBar = new JProgressBar();
		panel_1.add(progressBar);
		
		JButton btnCheckUpdate = new JButton("Check Update");
		panel_1.add(btnCheckUpdate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnQuitter){
			frmTankLauncher.setVisible(false);
		}
		if(e.getSource() == btnOption){
			new Option();
		}
	}

}
