package App;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ConfirmPanel extends JPanel {
	int awb;
	DataBackend backend;
	
	/**
	 * Create the panel.
	 */
	public ConfirmPanel(JFrame frame, DataBackend backend, int awb) {
		this.backend = backend;
		this.awb = awb;
		setBounds(100, 100, 751, 595);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Expeditor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 32, 108, 29);
		add(lblNewLabel);
		
		JLabel lblExpName = new JLabel("NONE");
		lblExpName.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpName.setBounds(141, 71, 108, 29);
		add(lblExpName);
		
		JLabel lblDestName = new JLabel("NONE");
		lblDestName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestName.setBounds(457, 71, 108, 29);
		add(lblDestName);
		
		JLabel lblExpAdr = new JLabel("NONE");
		lblExpAdr.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpAdr.setBounds(141, 110, 108, 29);
		add(lblExpAdr);
		
		JLabel lblDestAdr = new JLabel("NONE");
		lblDestAdr.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestAdr.setBounds(457, 110, 108, 29);
		add(lblDestAdr);
		
		JLabel lblExpPhone = new JLabel("NONE");
		lblExpPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpPhone.setBounds(141, 149, 108, 29);
		add(lblExpPhone);
		
		JLabel lblDestPhone = new JLabel("NONE");
		lblDestPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestPhone.setBounds(457, 149, 108, 29);
		add(lblDestPhone);
		
		JLabel lblExpMail = new JLabel("NONE");
		lblExpMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpMail.setBounds(141, 188, 108, 29);
		add(lblExpMail);
		
		JLabel lblDestMail = new JLabel("NONE");
		lblDestMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestMail.setBounds(457, 188, 108, 29);
		add(lblDestMail);
		
		JLabel lblPackType = new JLabel("NONE");
		lblPackType.setHorizontalAlignment(SwingConstants.CENTER);
		lblPackType.setBounds(10, 248, 731, 29);
		add(lblPackType);
		
		JLabel lblRoad = new JLabel("NONE");
		lblRoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoad.setBounds(10, 337, 731, 29);
		add(lblRoad);
		
		JLabel lblTime = new JLabel("NONE");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(10, 376, 731, 29);
		add(lblTime);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setHorizontalAlignment(SwingConstants.CENTER);
		lblNume.setBounds(23, 71, 108, 29);
		add(lblNume);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresa.setBounds(23, 110, 108, 29);
		add(lblAdresa);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefon.setBounds(23, 149, 108, 29);
		add(lblTelefon);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMail.setBounds(23, 188, 108, 29);
		add(lblMail);
		
		JLabel lblPackWeight = new JLabel("NONE");
		lblPackWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblPackWeight.setBounds(10, 287, 731, 29);
		add(lblPackWeight);
		
		JLabel lblDestinatar = new JLabel("Destinatar");
		lblDestinatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestinatar.setBounds(457, 32, 108, 29);
		add(lblDestinatar);
		
		JButton btnConfirmData = new JButton("Confirma");
		btnConfirmData.setBounds(324, 465, 108, 46);
		add(btnConfirmData);
		btnConfirmData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				var newPanel = new PayPanel(frame, backend, awb);
				frame.setContentPane(newPanel);
				frame.repaint();
				frame.setVisible(true);
				*/
				
				Item item = backend.getItem(awb);
				int sum = item.getRoadPath().getRemainingTime() * 20;
				
				Pagina_plata pag = new Pagina_plata();
				pag.setAwb(awb);
				pag.setVisible(true);
				String sir = String.valueOf(sum);
				Pagina_plata.txtCash2.setText(sir);
				
				frame.dispose();
			}
		});
		
		JLabel lblAWB = new JLabel("None");
		lblAWB.setHorizontalAlignment(SwingConstants.CENTER);
		lblAWB.setBounds(308, 10, 108, 29);
		add(lblAWB);
		
		Item item = backend.getItem(awb);
		
		List<String> path = item.getRoadPath().getNodes();
		
		lblAWB.setText("AWB: " + awb);
		
		lblExpName.setText(item.getExp().getName());
		lblExpAdr.setText(path.get(0));
		lblExpPhone.setText(item.getExp().getPhone());
		lblExpMail.setText(item.getExp().getMail());
		
		lblDestName.setText(item.getDest().getName());
		lblDestAdr.setText(path.get(path.size() - 1));
		lblDestPhone.setText(item.getDest().getPhone());
		lblDestMail.setText(item.getDest().getMail());
		
		lblRoad.setText("Ruta: " + path.stream().collect(Collectors.joining(" -> ")));
		
		String timp = "Timp: " + item.getRoadPath().getRemainingTime();
		if (item.getRoadPath().getRemainingTime() > 1) {
			timp += " zile";
		} else {
			timp += " zi";
		}
		
		lblTime.setText(timp);
		
		lblPackType.setText("Tip: " + item.getPackType());
		lblPackWeight.setText("Greutate: " + item.getPackWeight());
		
		JLabel lblPrice = new JLabel("New label");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(10, 415, 731, 13);
		add(lblPrice);
		
		lblPrice.setText("Pret: " + item.getRoadPath().getRemainingTime() * 20 + " Lei");
		

	}
}
