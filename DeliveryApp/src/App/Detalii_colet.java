package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;

public class Detalii_colet extends JFrame {

	private JPanel contentPane;
	private JTextField txtCautat;
	private DataBackend databackend;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detalii_colet frame = new Detalii_colet(new DataBackend());
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
	public Detalii_colet(DataBackend backend) {
		this.databackend=backend;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTraseu = new JLabel("Traseu ramas");
		lblTraseu.setBounds(96, 99, 527, 14);
		contentPane.add(lblTraseu);
		
		JLabel lblTimp = new JLabel("Timp ramas");
		lblTimp.setBounds(96, 125, 228, 14);
		contentPane.add(lblTimp);
		
		JLabel lblNewLabel_3 = new JLabel("Introduceti AWB:");
		lblNewLabel_3.setBounds(96, 44, 95, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblStatus = new JLabel("Status colet");
		lblStatus.setBounds(96, 150, 228, 14);
		contentPane.add(lblStatus);
		
		txtCautat = new JTextField();
		txtCautat.setBounds(201, 41, 123, 20);
		contentPane.add(txtCautat);
		txtCautat.setColumns(10);
		
		JButton btnCauta = new JButton("Cautare");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtCautat
				
				String cod_awb=txtCautat.getText();
				try {
				int awb=Integer.parseInt(cod_awb);
				
				Item item = null;
				try {
					item=databackend.getItem(awb);
				} catch (NullPointerException nul) {
					
				}
				if (item == null) {
					JOptionPane.showMessageDialog(null, "AWB-ul nu a fost gasit");
				} else {
					
					lblStatus.setText("Status colet: " + item.getStatus());
					List<String> path = item.getRoadPath().getNodes();
					lblTraseu.setText("Ruta: " + path.stream().collect(Collectors.joining(" -> ")));

			        String timp = "Timp: " + item.getRoadPath().getRemainingTime();
			        if (item.getRoadPath().getRemainingTime() > 1) {
			            timp += " zile";
			        } else {
			            timp += " zi";
			        }
			        lblTimp.setText(timp);
					
				}
				
				}
				catch(NumberFormatException exp)
				{
					JOptionPane.showMessageDialog(null,"Introduceti un AWB valid");
				}
			}
		});
		
		btnCauta.setBounds(362, 40, 89, 23);
		contentPane.add(btnCauta);
		
		JButton btnHome = new JButton("Inapoi");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new DeliveryApp().setVisible(true);
				dispose();
				//traseul si timpul le ia din alt json?
				
			}
		});
		btnHome.setBounds(96, 206, 89, 23);
		contentPane.add(btnHome);
		
		
		
		
	}
}

