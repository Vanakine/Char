package main;
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
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;


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
	
	JButton btnLancer = new JButton("Connexion char");
	JButton btnOption = new JButton("Option");
	JButton btnQuitter = new JButton("Quitter");
	JButton btnCheckUpdate = new JButton("Check Update");
	
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		
		frmTankLauncher = new JFrame();
		frmTankLauncher.setBackground(Color.LIGHT_GRAY);
		frmTankLauncher.setResizable(false);
		frmTankLauncher.setTitle("Tank Launcher");
		frmTankLauncher.setBounds(100, 100, 450, 300);
		frmTankLauncher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTankLauncher.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frmTankLauncher.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[148px][148px][148px]", "[][23px][]"));
		
		btnLancer.addActionListener(this);
		btnOption.addActionListener(this);
		
		btnLancer.setVerticalAlignment(SwingConstants.TOP);
		btnLancer.setHorizontalAlignment(SwingConstants.LEADING);
		panel.add(btnLancer, "cell 1 0,alignx center,growy");
		
		btnOption.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(btnOption, "cell 1 1,alignx center,growy");
		
		//JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(this);
		btnQuitter.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(btnQuitter, "cell 1 2,alignx center,growy");
		
		JPanel panel_1 = new JPanel();
		frmTankLauncher.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JLabel version = new JLabel("");
		String v = Read.readLastLine("src\\Version");
		version.setText(v);
		panel_1.add(version);
		
		JProgressBar progressBar = new JProgressBar();
		panel_1.add(progressBar);
		
		panel_1.add(btnCheckUpdate);
		
		JPanel panel_2 = new JPanel();
		frmTankLauncher.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBienvenueDansLe = new JLabel("Bienvenue dans le Tank Controller sur PC!");
		lblBienvenueDansLe.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblBienvenueDansLe, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();	
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] rest = Read.readAll("src\\text\\updates");
			public int getSize() {
				return rest.length;
			}
			public Object getElementAt(int index) {
				return rest[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblUpdates = new JLabel("Updates :");
		scrollPane.setColumnHeaderView(lblUpdates);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnLancer){
			new Connexion();
		}
		if(e.getSource() == btnOption){
			new Option();
		}
		if(e.getSource() == btnQuitter){
			frmTankLauncher.setVisible(false);
			System.exit(0);
		}
	}

}
