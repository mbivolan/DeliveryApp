package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CourierFrame extends JFrame {

	private JPanel contentPane;
	public boolean livrat;
	private JTextField txtCurier;
	public static boolean adevar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourierFrame frame = new CourierFrame();
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
	public CourierFrame() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHome = new JButton("Inapoi");
		
		btnHome.setBounds(65, 372, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnDestinatar = new JButton("Apel destinatar");
		
		
		btnDestinatar.setBounds(377, 245, 121, 23);
		contentPane.add(btnDestinatar);
		btnDestinatar.setVisible(false);
		
		JButton btnExpeditor = new JButton("Apel expeditor");
		
		btnExpeditor.setBounds(512, 245, 121, 23);
		contentPane.add(btnExpeditor);
		btnExpeditor.setVisible(false);
		
		JLabel lblCuriercod = new JLabel("Introduceti AWB-ul:");
		lblCuriercod.setBounds(35, 162, 109, 14);
		contentPane.add(lblCuriercod);
		
		txtCurier = new JTextField();
		txtCurier.setBounds(154, 159, 162, 20);
		contentPane.add(txtCurier);
		txtCurier.setColumns(10);
		
		JButton btnCautare = new JButton("Cauta");
		btnCautare.setBounds(326, 158, 89, 23);
		contentPane.add(btnCautare);
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new DeliveryApp().setVisible(true);
				dispose();
			}
		});
		
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnDestinatar.setVisible(true);
				btnExpeditor.setVisible(true);
				
			}
		});
		btnDestinatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagina_destinatar d = new Pagina_destinatar();
				new Pagina_destinatar().setVisible(true);
				d.numar_secunde=10;
				d.timp();
				Pagina_destinatar.textField_1.setText(txtCurier.getText());
			}
		});
		
		btnExpeditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Pagina_expeditor().setVisible(true);
				
			}
		});
		
		
	}
}
