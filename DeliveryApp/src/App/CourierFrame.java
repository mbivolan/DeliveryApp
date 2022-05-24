package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class CourierFrame extends JFrame {

	private JPanel contentPane;
	public boolean livrat;
	private JTextField txtCurier;
	private DataBackend databackend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourierFrame frame = new CourierFrame(new DataBackend());
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
	public CourierFrame(DataBackend backend) {
		
		this.databackend=backend;
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHome = new JButton("Inapoi");
		
		btnHome.setBounds(34, 372, 121, 23);
		contentPane.add(btnHome);
		
		JButton btnDestinatar = new JButton("Apel destinatar");
		
		
		btnDestinatar.setBounds(376, 372, 121, 23);
		contentPane.add(btnDestinatar);
		btnDestinatar.setVisible(false);
		
		JButton btnExpeditor = new JButton("Apel expeditor");
		
		btnExpeditor.setBounds(507, 372, 121, 23);
		contentPane.add(btnExpeditor);
		btnExpeditor.setVisible(false);
		
		JLabel lblCuriercod = new JLabel("Introduceti AWB-ul:");
		lblCuriercod.setBounds(34, 108, 109, 14);
		contentPane.add(lblCuriercod);
		
		txtCurier = new JTextField();
		txtCurier.setBounds(141, 105, 162, 20);
		contentPane.add(txtCurier);
		txtCurier.setColumns(10);
		
		JButton btnCautare = new JButton("Cauta");
		btnCautare.setBounds(330, 104, 121, 23);
		contentPane.add(btnCautare);
		
		JButton btnUpdate = new JButton("Update Traseu");
		btnUpdate.setBounds(215, 160, 121, 23);
		contentPane.add(btnUpdate);
		
		JList list = new JList();
		list.setBounds(104, 176, 1, 1);
		contentPane.add(list);
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new DeliveryApp().setVisible(true);
				dispose();
			}
		});
		
		btnCautare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cod_awb=txtCurier.getText();
				int awb=Integer.parseInt(cod_awb);
				Item item;
				try {
				item=databackend.getItem(awb);}
				catch(NullPointerException nul)
				{
					JOptionPane.showMessageDialog(null, "AWB-ul nu a fost gasit");
					btnDestinatar.setVisible(true);
					btnExpeditor.setVisible(true);
				}
				//System.out.println(item.getExp().getName());
				
				
			}
		});
		btnDestinatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagina_destinatar d = new Pagina_destinatar(new DataBackend());
				new Pagina_destinatar(new DataBackend()).setVisible(true);
				d.numar_secunde=3;
				d.timp();
				Pagina_destinatar.textField_1.setText(txtCurier.getText());
			}
		});
		
		btnExpeditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Pagina_expeditor(new DataBackend()).setVisible(true);
				
			}
		});
		
		
	}
}
