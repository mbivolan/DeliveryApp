package App;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings({ "unused", "serial" })
public class GhiseuFrame extends JFrame {

	private JPanel contentPane;
	private DataBackend backend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GhiseuFrame frame = new GhiseuFrame(new DataBackend());
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GhiseuFrame(DataBackend backend) {
		this.backend = backend;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewPackage = new JButton("Colet Nou");
		btnNewPackage.setBounds(323, 402, 123, 36);
		contentPane.add(btnNewPackage);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		separator.setBounds(341, 626, 192, -530);
		contentPane.add(separator);
		
		JTextPane txtExpName = new JTextPane();
		txtExpName.setBounds(123, 45, 192, 28);
		contentPane.add(txtExpName);
		
		JTextPane txtExpAdr = new JTextPane();
		txtExpAdr.setBounds(123, 83, 192, 28);
		contentPane.add(txtExpAdr);
		
		JTextPane txtExpPhone = new JTextPane();
		txtExpPhone.setBounds(123, 121, 192, 28);
		contentPane.add(txtExpPhone);
		
		JTextPane txtExpMail = new JTextPane();
		txtExpMail.setBounds(123, 159, 192, 28);
		contentPane.add(txtExpMail);
		
		JTextPane txtDestName = new JTextPane();
		txtDestName.setBounds(447, 45, 192, 28);
		contentPane.add(txtDestName);
		
		JTextPane txtDestAdr = new JTextPane();
		txtDestAdr.setBounds(447, 83, 192, 28);
		contentPane.add(txtDestAdr);
		
		JTextPane txtDestPhone = new JTextPane();
		txtDestPhone.setBounds(447, 121, 192, 28);
		contentPane.add(txtDestPhone);
		
		JTextPane txtDestMail = new JTextPane();
		txtDestMail.setBounds(447, 159, 192, 28);
		contentPane.add(txtDestMail);
		
		JTextPane txtPackWeight = new JTextPane();
		txtPackWeight.setBounds(288, 282, 192, 28);
		contentPane.add(txtPackWeight);
		
		JLabel lblNewLabel = new JLabel("Nume si Prenume");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 45, 103, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresa.setBounds(10, 83, 103, 28);
		contentPane.add(lblAdresa);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefon.setBounds(10, 121, 103, 28);
		contentPane.add(lblTelefon);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(10, 159, 103, 28);
		contentPane.add(lblEmail);
		
		JLabel lblExpeditor = new JLabel("Expeditor");
		lblExpeditor.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpeditor.setBounds(162, 7, 103, 28);
		contentPane.add(lblExpeditor);
		
		JLabel lblDestinatar = new JLabel("Destinatar");
		lblDestinatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestinatar.setBounds(490, 7, 103, 28);
		contentPane.add(lblDestinatar);
		
		JLabel lblGreutate = new JLabel("Greutate");
		lblGreutate.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreutate.setBounds(162, 282, 103, 28);
		contentPane.add(lblGreutate);
		
		JLabel lblTipColet = new JLabel("Tip Colet");
		lblTipColet.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipColet.setBounds(162, 320, 103, 28);
		contentPane.add(lblTipColet);
		
		JComboBox comPackType = new JComboBox();
		comPackType.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Fragil", "Pretios", "Periculos"}));
		comPackType.setBounds(288, 320, 192, 28);
		contentPane.add(comPackType);
		
		btnNewPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	Customer dest = new Customer(txtDestName.getText(), txtDestPhone.getText(), txtDestMail.getText());
	        	Customer exp = new Customer(txtExpName.getText(), txtExpPhone.getText(), txtExpMail.getText());

	        	int awb = backend.addNewItem(
	        				new Item(
	        						exp,
        							dest,
        							txtExpAdr.getText(),
        							txtDestAdr.getText(),
        							(String)comPackType.getSelectedItem(),
        							Integer.valueOf(txtPackWeight.getText())
	        					)
	        			);
	        	switchContent(awb);
			}
		});
	}
	
	private void switchContent(int awb) {
		var newPanel = new ConfirmPanel(this, backend, awb);
		setContentPane(newPanel);
		repaint();
		setVisible(true);
	}
}
