package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeliveryApp extends JFrame {

	private JPanel contentPane;
	private DataBackend backend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryApp frame = new DeliveryApp();
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
	public DeliveryApp() {
		backend = new DataBackend();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGhiseu = new JButton("Curier");
		btnGhiseu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CourierFrame(backend).setVisible(true);
				dispose();
			}
		});
		btnGhiseu.setBounds(92, 204, 89, 23);
		contentPane.add(btnGhiseu);
		
		JButton btnCurier = new JButton("Ghiseu");
		btnCurier.setBounds(225, 204, 89, 23);
		contentPane.add(btnCurier);
		btnCurier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GhiseuFrame(backend).setVisible(true);
				dispose();
			}
		});
		
		JButton btnAWB = new JButton("AWB");
		btnAWB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Detalii_colet(backend).setVisible(true);
				dispose();
			}
		});
		btnAWB.setBounds(355, 204, 89, 23);
		contentPane.add(btnAWB);
	}
}